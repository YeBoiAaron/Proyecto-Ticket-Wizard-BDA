CREATE DATABASE IF NOT EXISTS reventa_boletos;
USE reventa_boletos;

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    domicilio VARCHAR(200),
    fecha_nacimiento DATE,
    edad INT,
    saldo DECIMAL(10, 2) DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS eventos (
    evento_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    fecha DATE NOT NULL,
    venue VARCHAR(100),
    ciudad VARCHAR(100),
    estado VARCHAR(100),
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS boletos (
    boleto_id INT AUTO_INCREMENT PRIMARY KEY,
    evento_id INT,
    usuario_id INT,
    numero_serie VARCHAR(8) NOT NULL UNIQUE,
    fila VARCHAR(10),
    asiento VARCHAR(10),
    numero_control VARCHAR (16),
    estado ENUM('vendido', 'disponible', 'reservado') DEFAULT 'vendido',
    es_reventa BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (evento_id) REFERENCES eventos(evento_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE TABLE IF NOT EXISTS transacciones (
    transaccion_id INT AUTO_INCREMENT PRIMARY KEY,
    numero_transaccion VARCHAR(50) NOT NULL UNIQUE,
    comprador_id INT,
    vendedor_id INT,
    boleto_id INT,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    monto DECIMAL(10, 2) NOT NULL,
    tipo_transaccion ENUM('compra', 'reventa') NOT NULL,
    comision DECIMAL(10, 2),
    FOREIGN KEY (comprador_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (vendedor_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (boleto_id) REFERENCES boletos(boleto_id)
);

CREATE TABLE IF NOT EXISTS administradores (
	administrador_id INT AUTO_INCREMENT PRIMARY KEY,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS reservas_boletos (
    reserva_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    boleto_id INT,
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    estado ENUM('reservado', 'liberado') DEFAULT 'reservado',
    fecha_expiracion TIMESTAMP AS (DATE_ADD(fecha_reserva, INTERVAL 10 MINUTE)),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (boleto_id) REFERENCES boletos(boleto_id)
);

DELIMITER //
CREATE PROCEDURE transaccion(
    IN comprador_id INT, 
    IN vendedor_id INT, 
    IN id_boleto INT,
    IN monto DECIMAL(10, 2), 
    IN tipo_transaccion ENUM('compra', 'reventa')
)
BEGIN
    DECLARE comision DECIMAL(10, 2);
    DECLARE saldo_comprador DECIMAL(10, 2);
    SELECT saldo 
    INTO saldo_comprador 
    FROM usuarios 
    WHERE id_usuario = comprador_id;
	
    IF tipo_transaccion = 'compra' THEN
        START TRANSACTION;
		IF saldo >= monto THEN
			UPDATE usuarios
			SET saldo = saldo - monto
			WHERE usuario_id = comprador_id;

			SET comision = monto * 0.03;
			UPDATE usuarios
			SET saldo = saldo + (monto - comision)
			WHERE usuario_id = vendedor_id;
        
			UPDATE boletos
			SET usuario_id = comprador_id
			WHERE boleto_id = id_boleto;
        
			UPDATE boletos
			SET numero_serie = SUBSTRING(MD5(RAND()) FROM 1 FOR 8)
			WHERE boleto_id = id_boleto;
        
			UPDATE boletos
			SET estado = 'vendido'
			WHERE boleto_id = id_boleto;

			COMMIT;
		ELSEIF saldo < monto THEN
			INSERT INTO reservas_boletos (usuario_id, boleto_id) 
            VALUES (comprador_id, id_boleto);
        END IF;
	ELSEIF tipo_transaccion = 'reventa' THEN
		START TRANSACTION;
        
        UPDATE boletos
        SET estado = 'disponible'
        WHERE boleto_id = id_boleto;
        
        COMMIT;
    END IF;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER generar_numero_serie
AFTER INSERT ON boletos
FOR EACH ROW
BEGIN
	UPDATE boletos
	SET numero_serie = SUBSTRING(MD5(RAND()) FROM 1 FOR 8)
	WHERE boleto_id = NEW.boleto_id;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER realizar_transaccion
AFTER INSERT ON transacciones
FOR EACH ROW
BEGIN
    CALL transaccion(NEW.comprador_id, NEW.vendedor_id, NEW.boleto_id, NEW.monto, NEW.tipo_transaccion);
END;
//
DELIMITER ;

DELIMITER //
CREATE EVENT IF NOT EXISTS actualizar_reserva
ON SCHEDULE EVERY 1 MINUTE
DO
BEGIN

	UPDATE boletos b
    JOIN reservas_boletos rb ON b.boleto_id = rb.boleto_id
    SET b.estado = 'disponible'
    WHERE b.estado = 'reservado'
	AND TIMESTAMPDIFF(MINUTE, rb.fecha_reserva, NOW()) >= 10;
    
    UPDATE reservas_boletos rb
    JOIN boletos b ON rb.boleto_id = b.boleto_id
    SET rb.estado = 'liberado'
    WHERE rb.estado = 'reservado'
    AND TIMESTAMPDIFF(MINUTE, rb.fecha_reserva, NOW()) >= 10;
END;
//
DELIMITER ;




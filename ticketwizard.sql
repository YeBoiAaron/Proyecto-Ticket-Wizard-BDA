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
    usuario_id INT,
    boleto_id INT,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_limite DATE,
    monto DECIMAL(10, 2) NOT NULL,
    tipo_transaccion ENUM('compra', 'venta') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario),
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
    fecha_expiracion TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (boleto_id) REFERENCES boletos(boleto_id)
);

DELIMITER //
CREATE PROCEDURE transaccion(
	IN id_transaccion INT,
    IN id_usuario INT,
    IN id_boleto INT,
    IN fecha_lim DATE,
    IN monto DECIMAL(10, 2), 
    IN tipo_transaccion ENUM('compra', 'venta')
)
BEGIN
    DECLARE comision DECIMAL(10, 2);
    DECLARE saldo_comprador DECIMAL(10, 2);
	
    IF tipo_transaccion = 'compra' AND TIMESTAMPDIFF(MINUTE, NOW(), fecha_lim) > 0 THEN
		SELECT saldo 
		INTO saldo_comprador 
		FROM usuarios 
		WHERE id_usuario = id_usuario;
        START TRANSACTION;
		IF saldo_comprador >= monto THEN
			UPDATE usuarios
			SET saldo = saldo - monto
			WHERE id_usuario = id_usuario;

			SET comision = ROUND(monto * 0.03, 2);
            UPDATE usuarios
            JOIN boletos ON usuarios.id_usuario = boletos.usuario_id
            SET saldo = saldo + (monto - comision)
            WHERE boletos.boleto_id = id_boleto;
            
			UPDATE boletos
			SET usuario_id = id_usuario
			WHERE boleto_id = id_boleto;
        
			UPDATE boletos
			SET numero_serie = SUBSTRING(MD5(RAND()) FROM 1 FOR 8)
			WHERE boleto_id = id_boleto;
        
			UPDATE boletos
			SET estado = 'vendido'
			WHERE boleto_id = id_boleto;

			COMMIT;
		ELSEIF saldo_comprador < monto THEN
			IF NOT EXISTS (
				SELECT 1 
				FROM reservas_boletos 
				WHERE usuario_id = id_usuario 
				AND boleto_id = id_boleto 
				AND estado = 'reservado'
			) THEN
				INSERT INTO reservas_boletos (usuario_id, boleto_id) 
				VALUES (usuario_id, id_boleto);
			END IF;
        END IF;
	ELSEIF tipo_transaccion = 'venta' THEN
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
    CALL transaccion(NEW.transaccion_id, NEW.usuario_id, NEW.boleto_id, NEW.fecha_limite, NEW.monto, NEW.tipo_transaccion);
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER iniciar_reserva
AFTER INSERT ON reservas_boletos
FOR EACH ROW
BEGIN
	UPDATE reservas_boletos
    SET fecha_expiracion =(DATE_ADD(NEW.fecha_reserva, INTERVAL 10 MINUTE))
    WHERE reserva_id = NEW.reserva_id;
END;
//
DELIMITER;

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
END;
//
DELIMITER ;




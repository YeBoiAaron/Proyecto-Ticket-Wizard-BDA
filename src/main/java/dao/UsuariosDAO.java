/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IUsuariosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Conexion;
import objetos.Usuario;

/**
 *
 * @author Aaron
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public void RegistrarUsuario(Usuario u) {
    try (Connection connection = Conexion.obtenerConexion(); 
         PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Usuario (correo, contrasena, nombre_completo, fecha_nacimiento, domicilio) VALUES (?, ?, ?, ?, ?)")) {
        
        // Establecer los valores de los atributos del usuario en el PreparedStatement
        statement.setString(1, u.getCorreo());
        statement.setString(2, u.getContraseña());
        statement.setString(3, u.getNombre_completo());

        // Convertir la fecha de nacimiento de java.util.Date a java.sql.Date
        java.util.Date utilDate = u.getFecha_nacimiento();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        // Establecer la fecha en el PreparedStatement
        statement.setDate(4, sqlDate);

        statement.setString(5, u.getDomicilio());

        // Ejecutar la consulta para insertar el registro
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        // Opcional: Lanza una excepción personalizada o maneja de otra manera la excepción.
    }
}

    
    
}

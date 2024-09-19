/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class Conexion implements IConexionDB {

    private String cadena_conexion = "jdbc:mysql://127.0.0.1:3306/reventa_boletos?";
    private String usuario = "root";
    private String contra = "imperial";
    
    @Override
    public Connection crearConexion() {
        try {
            Connection c = DriverManager.getConnection(cadena_conexion, usuario, contra);
            
            return c;
        } catch(SQLException e) {
            System.out.println("Hubo un error de conexion");
        }
        
        return null;
    }
    
}

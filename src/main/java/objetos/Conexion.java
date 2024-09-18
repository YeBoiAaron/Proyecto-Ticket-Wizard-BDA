/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jesus
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "imperial";

    //"Imperial99" jdbc:mysql://127.0.0.1:3306/?user=root;
    /**
     * Conexion a BD
     *
     * @return
     * @throws SQLException
     */
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
    public static Connection obtenerConexion() throws SQLException {
    Connection conexion = null;
    // Registrar el controlador JDBC
    //Class.forName("com.mysql.cj.jdbc.Driver");
    // Establecer la conexión a la base de datos
    conexion = DriverManager.getConnection(URL, USER, PASSWORD);
    System.out.println("Conexion exitosa a la base de datos.");

    PreparedStatement statement = conexion.prepareStatement("USE reventa_boletos;");
    statement.execute(); // Ejecutar la instrucción USE para seleccionar la base de datos

    return conexion;
}
    
}

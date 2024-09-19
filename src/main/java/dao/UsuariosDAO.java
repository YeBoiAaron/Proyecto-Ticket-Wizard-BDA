/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import BOs.UsuarioBO;
import interfaces.IConexionDB;
import interfaces.IUsuariosDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import objetos.Usuario;

/**
 *
 */
public class UsuariosDAO implements IUsuariosDAO {

    private IConexionDB conexion;
    
    public UsuariosDAO() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean registrarUsuario(UsuarioBO usuario) {
        try {
            Connection connection = conexion.crearConexion();
            String insertar = "INSERT INTO usuarios (correo_electronico,contraseña,nombre_completo,fecha_nacimiento,domicilio) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
            
            // Establecer los valores de los atributos del usuario en el PreparedStatement
            statement.setString(1, usuario.getCorreo());
            statement.setString(2, usuario.getContrasena());
            statement.setString(3, usuario.getNombre_completo());

            // Convertir la fecha de nacimiento de java.util.Date a java.sql.Date
            java.util.Date utilDate = usuario.getFecha_nacimiento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Establecer la fecha en el PreparedStatement
            statement.setDate(4, sqlDate);
            //statement.setInt(5, usuario.getEdad());
            statement.setString(5, usuario.getDomicilio());
            //statement.setFloat(7, usuario.getSaldo());
            
            // Ejecutar la consulta para insertar el registro
            statement.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        try {
            Connection connection = conexion.crearConexion();
            String actualizar = "UPDATE usuarios SET correo_electronico = ?,contraseña = ?,nombre_completo = ?,fecha_nacimiento = ?,edad = ?,domicilio = ?,saldo = ? WHERE id_usuario = ?";
            PreparedStatement statement = connection.prepareStatement(actualizar, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getCorreo());
            statement.setString(2, usuario.getContrasena());
            statement.setString(3, usuario.getNombre_completo());
            statement.setDate(4, (Date) usuario.getFecha_nacimiento());
            statement.setInt(5, usuario.getEdad());
            statement.setString(6, usuario.getDomicilio());
            statement.setFloat(7, usuario.getSaldo());
            statement.setInt(8, usuario.getId_usuario());
            
            statement.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UsuarioBO consultarUsuario(int id_usuario) {
        try {
            Connection connection = conexion.crearConexion();
            String buscarProducto = "SELECT * FROM usuarios WHERE id_usuario = ?";
            PreparedStatement statement = connection.prepareStatement(buscarProducto, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_usuario);
            
            ResultSet resultado = statement.executeQuery();
            
            if(resultado.next()) {
                UsuarioBO u = new UsuarioBO();
                u.setId_usuario(resultado.getInt("id_usuario"));
                u.setCorreo(resultado.getString("correo_electronico"));
                u.setContrasena(resultado.getString("contraseña"));
                u.setFecha_nacimiento(resultado.getDate("fecha_nacimiento"));
                //u.setEdad(resultado.getInt("edad"));
                u.setDomicilio(resultado.getString("domicilio"));
                //u.setSaldo(resultado.getFloat("saldo"));
                
                return u;
            }else {
                return null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario consultarUsuario(String correo, String contrasena) {
        try {
            Connection connection = conexion.crearConexion();
            String buscarProducto = "SELECT * FROM usuarios WHERE correo_electronico = ? AND contraseña";
            PreparedStatement statement = connection.prepareStatement(buscarProducto, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            
            ResultSet resultado = statement.executeQuery();
            
            if(resultado.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(resultado.getInt("id_usuario"));
                u.setCorreo(resultado.getString("correo_electronico"));
                u.setContrasena(resultado.getString("contraseña"));
                u.setFecha_nacimiento(resultado.getDate("fecha_nacimiento"));
                u.setEdad(resultado.getInt("edad"));
                u.setDomicilio(resultado.getString("domicilio"));
                u.setSaldo(resultado.getFloat("saldo"));
                
                return u;
            }else {
                return null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

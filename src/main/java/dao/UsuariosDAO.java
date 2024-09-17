/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
    
    public UsuariosDAO(IConexionDB conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public boolean registrarUsuario(Usuario usuario) {
        try {
            Connection c = conexion.crearConexion();
            String insertar = "INSERT INTO usuarios (correo_electronico,contrasena,nombre_completo,fecha_nacimiento,edad,domicilio,saldo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement i = c.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
            
            // Establecer los valores de los atributos del usuario en el PreparedStatement
            i.setString(1, usuario.getCorreo());
            i.setString(2, usuario.getContrasena());
            i.setString(3, usuario.getNombre_completo());

            // Convertir la fecha de nacimiento de java.util.Date a java.sql.Date
            java.util.Date utilDate = usuario.getFecha_nacimiento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Establecer la fecha en el PreparedStatement
            i.setDate(4, sqlDate);
            i.setInt(5, usuario.getEdad());
            i.setString(6, usuario.getDomicilio());
            i.setFloat(7, usuario.getSaldo());
            
            // Ejecutar la consulta para insertar el registro
            i.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        try {
            Connection c = conexion.crearConexion();
            String actualizar = "UPDATE usuarios SET correo_electronico = ?,contrasena = ?,nombre_completo = ?,fecha_nacimiento = ?,edad = ?,domicilio = ?,saldo = ? WHERE id_usuario = ?";
            PreparedStatement a = c.prepareStatement(actualizar, Statement.RETURN_GENERATED_KEYS);
            a.setString(1, usuario.getCorreo());
            a.setString(2, usuario.getContrasena());
            a.setString(3, usuario.getNombre_completo());
            a.setDate(4, (Date) usuario.getFecha_nacimiento());
            a.setInt(5, usuario.getEdad());
            a.setString(6, usuario.getDomicilio());
            a.setFloat(7, usuario.getSaldo());
            a.setInt(8, usuario.getId_usuario());
            
            a.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario consultarUsuario(int id_usuario) {
        try {
            Connection c = conexion.crearConexion();
            String buscarProducto = "SELECT * FROM usuarios WHERE id_usuario = ?";
            PreparedStatement b = c.prepareStatement(buscarProducto);
            b.setInt(1, id_usuario);
            
            ResultSet resultado = b.executeQuery();
            
            if(resultado.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(resultado.getInt("id_usuario"));
                u.setCorreo(resultado.getString("correo_electronico"));
                u.setContrasena(resultado.getString("contrasena"));
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

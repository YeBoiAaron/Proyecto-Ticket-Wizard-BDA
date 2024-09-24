/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import BOs.EventoBO;
import interfaces.IConexionDB;
import interfaces.IEventosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import objetos.Evento;

/**
 *
 * @author Aaron
 */
public class EventosDAO implements IEventosDAO{
    private IConexionDB conexion;
    
    public EventosDAO() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean agregarEvento(EventoBO evento) {
        try {
            Connection connection = conexion.crearConexion();
            String insertar = "INSERT INTO eventos (nombre,fecha,venue,ciudad,estado,descripcion) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, evento.getNombre());
            
            java.util.Date utilDate = evento.getFecha();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            statement.setDate(2, sqlDate);
            statement.setString(3, evento.getVenue());
            statement.setString(4, evento.getCiudad());
            statement.setString(5, evento.getEstado());
            statement.setString(6, evento.getDescripcion());
            statement.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarEvento(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Evento consultarEvento(int idEvento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

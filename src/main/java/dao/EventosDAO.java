/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import BOs.EventoBO;
import DTOs.EventoDTO;
import interfaces.IConexionDB;
import interfaces.IEventosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import objetos.Evento;

/**
 *
 * @author Aaron
 */
public class EventosDAO implements IEventosDAO{
    private IConexionDB conexion;
    
    public EventosDAO(IConexionDB conexion) {
        this.conexion = conexion;
    }

    @Override
    public Evento agregarEvento(EventoDTO evento) {
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
            
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas == 0) {
                return null;
            }

            int idEvento = 0;
            ResultSet resultado = statement.getGeneratedKeys();
            if (resultado.next()) {
                idEvento = (resultado.getInt(1));
            }
            
            return this.consultarEvento(evento.getId_evento());
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Evento actualizarEvento(EventoDTO evento) {
        try {
            Connection connection = conexion.crearConexion();
            String actualizar = "UPDATE eventos SET nombre = ?,fecha = ?,venue = ?,ciudad = ?,estado = ?,descripcion = ? WHERE evento_id = ?";
            PreparedStatement statement = connection.prepareStatement(actualizar, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, evento.getNombre());
            
            java.util.Date utilDate = evento.getFecha();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            statement.setDate(2, sqlDate);
            statement.setString(3, evento.getVenue());
            statement.setString(4, evento.getCiudad());
            statement.setString(5, evento.getEstado());
            statement.setString(6, evento.getDescripcion());
            statement.setInt(7, evento.getId_evento());
            
            statement.executeUpdate();
            
            return this.consultarEvento(evento.getId_evento());
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Evento consultarEvento(int idEvento) {
        try {
            Connection connection = conexion.crearConexion();
            String buscarEvento = "SELECT * FROM eventos WHERE evento_id = ?";
            PreparedStatement statement = connection.prepareStatement(buscarEvento, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idEvento);
            
            ResultSet resultado = statement.executeQuery();
            
            if(resultado.next()) {
                Evento evento = new Evento();
                evento.setId_evento(resultado.getInt("evento_id"));
                evento.setNombre(resultado.getString("nombre"));
                evento.setFecha(resultado.getDate("fecha"));
                evento.setVenue(resultado.getString("venue"));
                evento.setCiudad(resultado.getString("ciudad"));
                evento.setEstado(resultado.getString("estado"));
                evento.setDescripcion(resultado.getString("descripcion"));
                
                return evento;
            }else {
                return null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Evento> consultarEventos() {
        try {
            List<Evento> consulta = new ArrayList<Evento>();
            Connection connection = conexion.crearConexion();
            String buscarEventos = "SELECT * FROM eventos";
            PreparedStatement statement = connection.prepareStatement(buscarEventos);
            
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()) {
                Evento evento = new Evento();
                evento.setId_evento(resultado.getInt("evento_id"));
                evento.setNombre(resultado.getString("nombre"));
                evento.setFecha(resultado.getDate("fecha"));
                evento.setVenue(resultado.getString("venue"));
                evento.setCiudad(resultado.getString("ciudad"));
                evento.setEstado(resultado.getString("estado"));
                evento.setDescripcion(resultado.getString("descripcion"));
                consulta.add(evento);
            }
            
            return consulta;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}

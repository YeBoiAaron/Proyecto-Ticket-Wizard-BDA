/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dtos.BoletoDTO;
import interfaces.IBoletosDAO;
import interfaces.IConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetos.Boleto;

/**
 *
 * @author Aaron
 */
public class BoletosDAO implements IBoletosDAO{
    private IConexionDB conexion;

    public BoletosDAO(IConexionDB conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Boleto agregarBoleto(BoletoDTO boleto) {
        try {
            Connection connection = conexion.crearConexion();
            String insertar = "INSERT INTO boletos (evento_id,usuario_id,numero_serie,precio,fila,asiento) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, boleto.getId_evento());
            statement.setInt(2, boleto.getId_usuario());
            statement.setString(3, boleto.getNumero_serie());
            statement.setFloat(4, boleto.getPrecio());
            statement.setString(5, boleto.getFila());
            statement.setString(6, boleto.getAsiento());
            
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas == 0) {
                return null;
            }

            int idBoleto = 0;
            ResultSet resultado = statement.getGeneratedKeys();
            if (resultado.next()) {
                idBoleto = (resultado.getInt(1));
            }
            
            return this.consultarBoletoId(idBoleto);
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boleto actualizarBoleto(BoletoDTO boleto) {
        try {
            Connection connection = conexion.crearConexion();
            String actualizar = "UPDATE boletos SET evento_id = ?,usuario_id = ?,numero_serie = ?,precio = ?,fila = ?,asiento = ? WHERE boleto_id = ?";
            PreparedStatement statement = connection.prepareStatement(actualizar, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, boleto.getId_evento());
            statement.setInt(2, boleto.getId_usuario());
            statement.setString(3, boleto.getNumero_serie());
            statement.setFloat(4, boleto.getPrecio());
            statement.setString(5, boleto.getFila());
            statement.setString(6, boleto.getAsiento());
            
            statement.executeUpdate();
            
            return this.consultarBoletoId(boleto.getId_evento());
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boleto consultarBoletoId(int idBoleto) {
        try {
            Connection connection = conexion.crearConexion();
            String buscarBoleto = "SELECT * FROM boletos WHERE boleto_id = ?";
            PreparedStatement statement = connection.prepareStatement(buscarBoleto, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idBoleto);
            
            ResultSet resultado = statement.executeQuery();
            
            if(resultado.next()) {
                Boleto boleto = new Boleto();
                boleto.setId_boleto(resultado.getInt("boleto_id"));
                boleto.setId_evento(resultado.getInt("evento_id"));
                boleto.setId_usuario(resultado.getInt("usuario_id"));
                boleto.setNumero_serie(resultado.getString("numero_serie"));
                boleto.setPrecio(resultado.getFloat("precio_original"));
                boleto.setFila(resultado.getString("fila"));
                boleto.setAsiento(resultado.getString("asiento"));
                boleto.setNumero_control(resultado.getString("numero_control"));
                boleto.setEstado(resultado.getString("estado"));
                boleto.setEs_reventa(resultado.getBoolean("es_reventa"));
                
                return boleto;
            }else {
                return null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Boleto> consultarBoletosUsuario(int idUsuario) {
        try {
            List<Boleto> consulta = new ArrayList<Boleto>();
            Connection connection = conexion.crearConexion();
            String buscarBoletos = "SELECT * FROM eventos WHERE usuario_id = ?";
            PreparedStatement statement = connection.prepareStatement(buscarBoletos, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idUsuario);
            
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()) {
                Boleto boleto = new Boleto();
                boleto.setId_boleto(resultado.getInt("boleto_id"));
                boleto.setId_evento(resultado.getInt("evento_id"));
                boleto.setId_usuario(resultado.getInt("usuario_id"));
                boleto.setNumero_serie(resultado.getString("numero_serie"));
                boleto.setPrecio(resultado.getFloat("precio_original"));
                boleto.setFila(resultado.getString("fila"));
                boleto.setAsiento(resultado.getString("asiento"));
                boleto.setNumero_control(resultado.getString("numero_control"));
                boleto.setEstado(resultado.getString("estado"));
                boleto.setEs_reventa(resultado.getBoolean("es_reventa"));
                consulta.add(boleto);
            }
            
            return consulta;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}

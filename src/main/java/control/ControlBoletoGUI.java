/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.EventoDTO;
import bos.BoletoBO;
import dao.BoletosDAO;
import interfaces.IBoletoBO;
import interfaces.IBoletosDAO;
import interfaces.IConexionDB;
import interfaces.IEventoBO;
import interfaces.IEventosDAO;
import java.util.ArrayList;
import java.util.List;
import objetos.Evento;

/**
 *
 * @author Aaron
 */
public class ControlBoletoGUI {
    private IBoletoBO boletos;
    private IEventoBO eventos;
    private IEventosDAO eventosDAO;
    private IBoletosDAO boletosDAO;
    
    public ControlBoletoGUI(IConexionDB conexion) {
        this.boletosDAO = new BoletosDAO(conexion);
        this.boletos = new BoletoBO(boletosDAO);
    }
    
    public int cantidadTotalBoletos(int idUsuario){
        return boletos.consultarBoletosUsuario(idUsuario).size();
    }
    
    public List<EventoDTO> obtenerEventos(int idUsuario) {
        List<EventoDTO> eventos = new ArrayList<EventoDTO>();
        for (int i = 0; i < boletos.consultarBoletosUsuario(idUsuario).size(); i++) {
            EventoDTO evento = this.eventos.consultarEvento(boletos.consultarBoletosUsuario(idUsuario).get(i).getId_evento());
            eventos.add(evento);
        }
        return eventos;
    }
    
    public String descripcionBoleto(int index, int idUsuario) {
        index++;
        return "<html>Fecha: " + eventos.consultarEvento(boletos.consultarBoletosUsuario(idUsuario).get(index).getId_evento()).getFecha().toString() + 
                "<br/>" + eventos.consultarEvento(boletos.consultarBoletosUsuario(idUsuario).get(index).getId_evento()).getVenue() + 
                ", " + eventos.consultarEvento(boletos.consultarBoletosUsuario(idUsuario).get(index).getId_evento()).getCiudad() + 
                ", " + eventos.consultarEvento(boletos.consultarBoletosUsuario(idUsuario).get(index).getId_evento()).getEstado() + 
                "<br/>" + eventos.consultarEvento(boletos.consultarBoletosUsuario(idUsuario).get(index).getId_evento()).getDescripcion() + 
                "<br/>" + boletos.consultarBoletosUsuario(idUsuario).get(index).getFila() +
                "/" + boletos.consultarBoletosUsuario(idUsuario).get(index).getAsiento() +
                "<html/>";
    }
    
    public void venderBoleto() {
        
    }
}

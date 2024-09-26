/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import interfaces.IEventoBO;
import BOs.EventoBO;
import dao.EventosDAO;
import interfaces.IConexionDB;
import interfaces.IEventosDAO;

/**
 *
 * @author Aaron
 */
public class ControlEventoGUI {
    private IEventoBO eventos;
    private IEventosDAO eventosDAO;
    
    public ControlEventoGUI(IConexionDB conexion) {
        this.eventosDAO = new EventosDAO(conexion);
        this.eventos = new EventoBO(eventosDAO);
    }
    
    public int cantidadTotalEventos() {
        return eventos.consultarEventos().size();
    }
    
    public String descripcionEvento(int index) {
        index++;
        return "<html>Fecha: " + eventos.consultarEvento(index).getFecha().toString() + 
                "<br/>" + eventos.consultarEvento(index).getVenue() + 
                ", " + eventos.consultarEvento(index).getCiudad() + 
                ", " + eventos.consultarEvento(index).getEstado() + 
                "<br/>" + eventos.consultarEvento(index).getDescripcion() + "<html/>";
    }
}

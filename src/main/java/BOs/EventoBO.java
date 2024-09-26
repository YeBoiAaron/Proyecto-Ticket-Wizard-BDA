/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOs.EventoDTO;
import interfaces.IEventoBO;
import interfaces.IEventosDAO;

/**
 *
 * @author Aaron
 */
public class EventoBO implements IEventoBO{
    
    private IEventosDAO eventosDAO;
    
    public EventoBO(IEventosDAO eventosDAO) {
        this.eventosDAO = eventosDAO;
    }

    @Override
    public void agregarEvento(EventoDTO evento) {
        eventosDAO.agregarEvento(evento);
    }

    @Override
    public void actualizarEvento(EventoDTO evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EventoDTO consultarEvento(int idEvento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOs.EventoDTO;
import interfaces.IEventoBO;
import interfaces.IEventosDAO;
import java.util.ArrayList;
import java.util.List;
import objetos.Evento;

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
        eventosDAO.actualizarEvento(evento);
    }

    @Override
    public EventoDTO consultarEvento(int idEvento) {
        Evento evento = eventosDAO.consultarEvento(idEvento);
        return convertirEventoDTO(evento);
    }

    @Override
    public List<EventoDTO> consultarEventos() {
        List<EventoDTO> consulta = new ArrayList<EventoDTO>();
        if(!eventosDAO.consultarEventos().isEmpty()) {
            for (int i = 0; i < eventosDAO.consultarEventos().size(); i++) {
                consulta.add(convertirEventoDTO(eventosDAO.consultarEventos().get(i)));
            }
            return consulta;
        }
        return null;
    }
    
    public EventoDTO convertirEventoDTO(Evento evento) {
        EventoDTO eventoDTO = new EventoDTO(evento.getId_evento(), evento.getNombre(), evento.getFecha(), evento.getVenue(), evento.getCiudad(), evento.getEstado(), evento.getDescripcion());
        return eventoDTO;
    }
}

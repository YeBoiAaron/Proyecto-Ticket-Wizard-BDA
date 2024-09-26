/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.EventoDTO;
import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IEventoBO {
    
    public void agregarEvento(EventoDTO evento);
    
    public void actualizarEvento(EventoDTO evento);
    
    public EventoDTO consultarEvento(int idEvento);
    
    public List<EventoDTO> consultarEventos();
}

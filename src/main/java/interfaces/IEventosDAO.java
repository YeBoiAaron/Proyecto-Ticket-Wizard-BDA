/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.EventoDTO;
import java.util.List;
import objetos.Evento;

/**
 *
 * @author Aaron
 */
public interface IEventosDAO {
    public Evento agregarEvento(EventoDTO evento);
    
    public Evento actualizarEvento(EventoDTO evento);
    
    public Evento consultarEvento(int idEvento);
    
    public List<Evento> consultarEventos();
}

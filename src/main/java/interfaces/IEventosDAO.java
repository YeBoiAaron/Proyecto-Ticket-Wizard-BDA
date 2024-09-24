/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import BOs.EventoBO;
import objetos.Evento;

/**
 *
 * @author Aaron
 */
public interface IEventosDAO {
    public boolean agregarEvento(EventoBO evento);
    
    public boolean actualizarEvento(Evento evento);
    
    public Evento consultarEvento(int idEvento);
    
}

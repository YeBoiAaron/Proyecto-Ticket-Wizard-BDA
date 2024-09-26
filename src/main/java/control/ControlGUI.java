/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.UsuarioBO;
import DTOs.UsuarioDTO;
import GUIs.CuentaUsuario;
import GUIs.VistaEventos;
import dao.UsuariosDAO;
import interfaces.IUsuariosDAO;
import javax.swing.JFrame;

/**
 *
 * @author Aaron
 */
public class ControlGUI {
    
    public ControlGUI() {
        
    }
    
    public void abrirVentanaBoletos(JFrame frame) {
        
    }
    
    public void abrirVentanaEventos(JFrame frame) {
        VistaEventos eventos = new VistaEventos();
        eventos.setVisible(true);
        frame.dispose();
    }
    
    public void abrirVentanaUsuario(JFrame frame) {
        CuentaUsuario usuario = new CuentaUsuario();
        usuario.setVisible(true);
        frame.dispose();
    }
}

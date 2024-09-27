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
import guis.VistaBoletos;
import interfaces.IUsuariosDAO;
import javax.swing.JFrame;
import objetos.Usuario;

/**
 *
 * @author Aaron
 */
public class ControlGUI {
    private Usuario usuario = new Usuario();
    
    public ControlGUI() {
        
    }
    
    public void abrirVentanaBoletos(JFrame frame) {
        VistaBoletos boletos = new VistaBoletos();
        boletos.setVisible(true);
        frame.dispose();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}

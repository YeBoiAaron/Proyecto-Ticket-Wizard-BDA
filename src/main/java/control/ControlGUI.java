/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.UsuarioBO;
import DTOs.UsuarioDTO;
import dao.UsuariosDAO;
import interfaces.IUsuariosDAO;

/**
 *
 * @author Aaron
 */
public class ControlGUI {
    private IUsuariosDAO usuariosDAO;
    
    private UsuarioBO usuario;
    
    public ControlGUI() {
        
        usuariosDAO = new UsuariosDAO();
    }
    
    public boolean iniciarSesion(String correo, String contrasena) {
        if(usuariosDAO.consultarUsuario(correo, contrasena) != null) {
            //this.usuario = usuariosDAO.consultarUsuario(correo, contrasena);
            return true;
        } else return false;
    }
    
    public boolean registrarUsuario(UsuarioDTO usuario) {
        UsuarioBO usuarioTemp;
        
        usuarioTemp = new UsuarioBO(usuario.getCorreo(), usuario.getContrasena(), usuario.getNombre_completo(), usuario.getFecha_nacimiento(), usuario.getDomicilio());
        this.usuario = usuarioTemp;
        return usuariosDAO.registrarUsuario(usuarioTemp);
    }
}

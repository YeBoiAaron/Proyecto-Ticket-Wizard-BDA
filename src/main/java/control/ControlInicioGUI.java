/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.UsuarioBO;
import DTOs.UsuarioDTO;
import dao.UsuariosDAO;
import interfaces.IUsuariosDAO;
import objetos.Usuario;

/**
 *
 * @author Aaron
 */
public class ControlInicioGUI {
    private IUsuariosDAO usuariosDAO;
    
    public ControlInicioGUI() {
        usuariosDAO = new UsuariosDAO();
    }
    
    public boolean iniciarSesion(String correo, String contrasena) {
        if(usuariosDAO.consultarUsuario(correo, contrasena) != null) {
            //this.usuario = usuariosDAO.consultarUsuario(correo, contrasena);
            return true;
        } else return false;
    }
    
    public Usuario registrarUsuario(UsuarioDTO usuario) {
        UsuarioBO usuarioTemp;
        usuarioTemp = new UsuarioBO(usuario.getCorreo(), usuario.getContrasena(), usuario.getNombre_completo(), usuario.getFecha_nacimiento(), usuario.getDomicilio());
        usuariosDAO.registrarUsuario(usuarioTemp);
        return new Usuario(usuario.getCorreo(), usuario.getContrasena(), usuario.getNombre_completo(), usuario.getFecha_nacimiento(), usuario.getDomicilio());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.toedter.calendar.JDateChooser;
import dao.UsuariosDAO;
import interfaces.IConexionDB;
import interfaces.IUsuariosDAO;
import java.awt.Component;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import objetos.Conexion;
import objetos.Usuario;

/**
 *
 * @author Aaron
 */
public class ControlGUI {
    private IUsuariosDAO usuariosDAO;
    
    private Usuario usuario;
    
    public ControlGUI() {
        
        usuariosDAO = new UsuariosDAO();
    }
    
    public boolean iniciarSesion(String correo, String contrasena) {
        if(usuariosDAO.consultarUsuario(correo, contrasena) != null) {
            this.usuario = usuariosDAO.consultarUsuario(correo, contrasena);
            return true;
        } else return false;
    }
    
    public boolean registrarUsuario(Usuario usuario) {
        Usuario usuarioTemp;
        
        usuarioTemp = new Usuario(usuario.getCorreo(), usuario.getContrasena(), usuario.getNombre_completo(), usuario.getFecha_nacimiento(), usuario.getDomicilio());
        this.usuario = usuarioTemp;
        return usuariosDAO.registrarUsuario(usuarioTemp);
    }
}

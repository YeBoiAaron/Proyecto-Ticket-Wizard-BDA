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
    private IConexionDB conexion;
    private Usuario usuario;
    
    public ControlGUI() {
        conexion = (IConexionDB) new Conexion();
        usuariosDAO = new UsuariosDAO(conexion);
    }
    
    public boolean iniciarSesion(JFrame frame) {
        Component[] component = frame.getComponents();
        String correo = new String();
        String contrasena = new String();

        for (int i = 0; i < component.length; i++) {
            if (component[i].getName().equals("tfCorreo")) {
                correo = ((JTextField)component[i]).getText();
            } else if (component[i].getName().equals("tfContrasena")) {
                contrasena = ((JTextField)component[i]).getText();
            }
        }
        
        if(usuariosDAO.consultarUsuario(correo, contrasena) != null) {
            this.usuario = usuariosDAO.consultarUsuario(correo, contrasena);
            return true;
        } else return false;
    }
    
    public boolean registrarUsuario(JFrame frame) {
        Component[] component = frame.getComponents();
        String correo = new String();
        String contrasena = new String();
        String nombre = new String();
        Date fechaNac = new Date();
        String domicilio = new String();
        Usuario usuarioTemp;
        
        for (int i = 0; i < component.length; i++) {
            switch (component[i].getName()) {
                case "tfCorreo":
                    correo = ((JTextField)component[i]).getText();
                    break;
                case "tfContra":
                    contrasena = ((JTextField)component[i]).getText();
                    break;
                case "tfNombreCompleto":
                    nombre = ((JTextField)component[i]).getText();
                    break;
                case "dcFechaNac":
                    fechaNac = ((JDateChooser)component[i]).getDate();
                    break;
                case "tfDomicilio":
                    domicilio = ((JTextField)component[i]).getText();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        usuarioTemp = new Usuario(correo, contrasena, nombre, fechaNac, domicilio);
        this.usuario = usuarioTemp;
        return usuariosDAO.registrarUsuario(usuarioTemp);
    }
}

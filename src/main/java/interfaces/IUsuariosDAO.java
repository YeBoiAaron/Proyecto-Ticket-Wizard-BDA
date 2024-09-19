/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import BOs.UsuarioBO;
import objetos.Usuario;

/**
 *
 */
public interface IUsuariosDAO {
    
    public boolean registrarUsuario(UsuarioBO usuario);
    
    public boolean actualizarUsuario(Usuario usuario);
    
    public UsuarioBO consultarUsuario(int id_usuario);
    
    public Usuario consultarUsuario(String correo, String contrasena);
}

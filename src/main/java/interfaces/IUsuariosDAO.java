/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import objetos.Usuario;

/**
 *
 */
public interface IUsuariosDAO {
    
    public boolean registrarUsuario(Usuario usuario);
    
    public boolean actualizarUsuario(Usuario usuario);
    
    public Usuario consultarUsuario(int id_usuario);
    
    public Usuario consultarUsuario(String correo, String contrasena);
}

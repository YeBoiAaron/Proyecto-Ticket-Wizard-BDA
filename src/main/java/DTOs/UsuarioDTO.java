/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;

/**
 *
 * @author jesus
 */
public class UsuarioDTO {
    private int id_usuario;
    private String correo;
    private String contrasena;
    private String nombre_completo;
    private Date fecha_nacimiento;
    private String domicilio;

    // Constructor vacío
    public UsuarioDTO() {
    }

    // Constructor completo
    public UsuarioDTO(int id_usuario, String correo, String contrasena, String nombre_completo, Date fecha_nacimiento, String domicilio) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
    }

    // Constructor sin ID para registros nuevos
    public UsuarioDTO(String correo, String contrasena, String nombre_completo, Date fecha_nacimiento, String domicilio) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
    }

    // Getters y Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id_usuario=" + id_usuario + ", correo=" + correo + ", nombre_completo=" + nombre_completo + ", fecha_nacimiento=" + fecha_nacimiento + ", domicilio=" + domicilio + '}';
    }

   
    
}

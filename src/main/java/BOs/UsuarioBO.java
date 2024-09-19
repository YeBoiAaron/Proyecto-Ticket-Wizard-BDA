/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author jesus
 */
public class UsuarioBO {
     private int id_usuario;
    private String correo;
    private String contrasena;
    private String nombre_completo;
    private Date fecha_nacimiento;
    private String domicilio;

    // Constructor vacío
    public UsuarioBO() {
    }

    // Constructor completo
    public UsuarioBO(int id_usuario, String correo, String contrasena, String nombre_completo, Date fecha_nacimiento, String domicilio) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
    }
    //Contructor sin id
    public UsuarioBO(String correo, String contrasena, String nombre_completo, Date fecha_nacimiento, String domicilio) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
    }


    // Métodos de acceso (Getters y Setters)
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

    

    // Método de negocio: Validación del correo
    public boolean esCorreoValido() {
        // Simple validación: revisar que contenga "@" y "."
        return this.correo != null && this.correo.contains("@") && this.correo.contains(".");
    }

    // Método de negocio: Validar si la contraseña es segura (ejemplo simple)
    public boolean esContrasenaSegura() {
        // Ejemplo básico de validación de seguridad (8 caracteres mínimo)
        return this.contrasena != null && this.contrasena.length() >= 8;
    }

    @Override
    public String toString() {
        return "UsuarioBO{" + "id_usuario=" + id_usuario + ", correo=" + correo + ", nombre_completo=" + nombre_completo + ", fecha_nacimiento=" + fecha_nacimiento + ", domicilio=" + domicilio + '}';
    }

  
    
}

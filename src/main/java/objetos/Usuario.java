/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class Usuario {
    private String id_usuario;
    private String correo;
    private String contraseña;
    private String nombre_completo;
    private Date fecha_nacimiento;
    private String domicilio;
    private float saldo;

    public Usuario() {
    }

    public Usuario(String id_usuario, String correo, String contraseña, String nombre_completo, Date fecha_nacimiento, String domicilio, float saldo) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
        this.saldo = saldo;
    }

    public Usuario(String correo, String contraseña, String nombre_completo, Date fecha_nacimiento, String domicilio) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
    }
    

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", correo=" + correo + ", nombre_completo=" + nombre_completo + ", fecha_nacimiento=" + fecha_nacimiento + ", domicilio=" + domicilio + ", saldo=" + saldo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id_usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id_usuario, other.id_usuario);
    }
    
}
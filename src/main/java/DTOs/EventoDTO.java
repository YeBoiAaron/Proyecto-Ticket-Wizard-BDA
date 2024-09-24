/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;

/**
 *
 * @author Aaron
 */
public class EventoDTO {
    private int id_evento;
    private String nombre;
    private Date fecha;
    private String venue;
    private String ciudad;
    private String estado;
    private String descripcion;

    public EventoDTO() {
    }

    public EventoDTO(int id_evento, String nombre, Date fecha, String venue, String ciudad, String estado, String descripcion) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.venue = venue;
        this.ciudad = ciudad;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EventoDTO{" + "id_evento=" + id_evento + ", nombre=" + nombre + ", fecha=" + fecha + ", venue=" + venue + ", ciudad=" + ciudad + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }
    
}

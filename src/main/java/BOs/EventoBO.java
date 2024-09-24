/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import java.util.Date;

/**
 *
 * @author Aaron
 */
public class EventoBO {
    private int eventoId;
    private String nombre;
    private Date fecha;
    private String venue;
    private String ciudad;
    private String estado;
    private String descripcion;

    // Constructor vacío
    public EventoBO() {}

    // Constructor con todos los campos
    public EventoBO (int eventoId, String nombre, Date fecha, String venue, String ciudad, String estado, String descripcion) {
        this.eventoId = eventoId;
        this.nombre = nombre;
        this.fecha = fecha;
        this.venue = venue;
        this.ciudad = ciudad;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
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
        return "EventoBO{" + "eventoId=" + eventoId + ", nombre=" + nombre + ", fecha=" + fecha + ", venue=" + venue + ", ciudad=" + ciudad + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }
    
}

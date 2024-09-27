/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class Boleto {
    private int id_boleto;
    private int id_evento;
    private int id_usuario;
    private String numero_serie;
    private float precio;
    private String fila;
    private String asiento;
    private String numero_control;
    private String estado;
    private boolean es_reventa;

    public Boleto() {
    }

    public Boleto(int id_boleto, int id_evento, int id_usuario, String numero_serie, float precio_original, String fila, String asiento, String numero_control, String estado, boolean es_reventa) {
        this.id_boleto = id_boleto;
        this.id_evento = id_evento;
        this.id_usuario = id_usuario;
        this.numero_serie = numero_serie;
        this.precio = precio_original;
        this.fila = fila;
        this.asiento = asiento;
        this.numero_control = numero_control;
        this.estado = estado;
        this.es_reventa = es_reventa;
    }

    public int getId_boleto() {
        return id_boleto;
    }

    public void setId_boleto(int id_boleto) {
        this.id_boleto = id_boleto;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getNumero_control() {
        return numero_control;
    }

    public void setNumero_control(String numero_control) {
        this.numero_control = numero_control;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEs_reventa() {
        return es_reventa;
    }

    public void setEs_reventa(boolean es_reventa) {
        this.es_reventa = es_reventa;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.numero_serie);
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
        final Boleto other = (Boleto) obj;
        return this.id_boleto == other.id_boleto;
    }
    
}

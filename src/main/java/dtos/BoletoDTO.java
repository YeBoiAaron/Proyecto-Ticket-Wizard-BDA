/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Aaron
 */
public class BoletoDTO {
    private int id_boleto;
    private int id_evento;
    private int id_usuario;
    private String numero_serie;
    private float precio;
    private String fila;
    private String asiento;
    private boolean es_reventa;

    public BoletoDTO() {
    }

    public BoletoDTO(int id_boleto, int id_evento, int id_usuario, String numero_serie, float precio, String fila, String asiento, boolean es_reventa) {
        this.id_boleto = id_boleto;
        this.id_evento = id_evento;
        this.id_usuario = id_usuario;
        this.numero_serie = numero_serie;
        this.precio = precio;
        this.fila = fila;
        this.asiento = asiento;
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

    public boolean isEs_reventa() {
        return es_reventa;
    }

    public void setEs_reventa(boolean es_reventa) {
        this.es_reventa = es_reventa;
    }

    @Override
    public String toString() {
        return "BoletoDTO{" + "id_boleto=" + id_boleto + ", id_evento=" + id_evento + ", id_usuario=" + id_usuario + ", numero_serie=" + numero_serie + ", precio_original=" + precio + ", fila=" + fila + ", asiento=" + asiento + ", es_reventa=" + es_reventa + '}';
    }
    
}

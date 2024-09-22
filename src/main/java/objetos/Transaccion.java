/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Date;

/**
 *
 * @author Aaron
 */
public class Transaccion {
    private int id_transaccion;
    private String numero_transaccion;
    private Usuario usuario;
    private Boleto boleto;
    private Date fecha_hora;
    private Date fecha_limite;
    private float monto;
    private String tipo_transaccion;

    public Transaccion() {
    }

    public Transaccion(int id_transaccion, String numero_transaccion, Usuario usuario, Boleto boleto, Date fecha_hora, float monto) {
        this.id_transaccion = id_transaccion;
        this.numero_transaccion = numero_transaccion;
        this.usuario = usuario;
        this.boleto = boleto;
        this.fecha_hora = fecha_hora;
        this.monto = monto;
        this.tipo_transaccion = "compra";
    }

    public Transaccion(int id_transaccion, String numero_transaccion, Usuario usuario, Boleto boleto, Date fecha_hora, Date fecha_limite, float monto) {
        this.id_transaccion = id_transaccion;
        this.numero_transaccion = numero_transaccion;
        this.usuario = usuario;
        this.boleto = boleto;
        this.fecha_hora = fecha_hora;
        this.fecha_limite = fecha_limite;
        this.monto = monto;
        this.tipo_transaccion = "venta";
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getNumero_transaccion() {
        return numero_transaccion;
    }

    public void setNumero_transaccion(String numero_transaccion) {
        this.numero_transaccion = numero_transaccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id_transaccion=" + id_transaccion + ", numero_transaccion=" + numero_transaccion + ", usuario=" + usuario + ", boleto=" + boleto + ", fecha_hora=" + fecha_hora + ", fecha_limite=" + fecha_limite + ", monto=" + monto + ", tipo_transaccion=" + tipo_transaccion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_transaccion;
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
        final Transaccion other = (Transaccion) obj;
        return this.id_transaccion == other.id_transaccion;
    }
    
}

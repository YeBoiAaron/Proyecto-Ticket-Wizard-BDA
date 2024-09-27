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
    private int id_comprador;
    private int id_vendedor;
    private Boleto boleto;
    private Date fecha_hora;
    private Date fecha_limite;
    private float monto;

    public Transaccion() {
    }

    public Transaccion(int id_transaccion, String numero_transaccion, int id_comprador, int id_vendedor, Boleto boleto, Date fecha_hora, Date fecha_limite, float monto) {
        this.id_transaccion = id_transaccion;
        this.numero_transaccion = numero_transaccion;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.boleto = boleto;
        this.fecha_hora = fecha_hora;
        this.fecha_limite = fecha_limite;
        this.monto = monto;
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

    public int getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_transaccion;
        return hash;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id_transaccion=" + id_transaccion + ", numero_transaccion=" + numero_transaccion + ", id_comprador=" + id_comprador + ", id_vendedor=" + id_vendedor + ", boleto=" + boleto + ", fecha_hora=" + fecha_hora + ", fecha_limite=" + fecha_limite + ", monto=" + monto + '}';
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

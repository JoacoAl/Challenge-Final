package com.example.challengefinal.growshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private  long id;

    private TipoDePago tipoDePago;

    private double monto;

    private LocalDateTime fechaDePago;


    @OneToOne(mappedBy = "pago", fetch = FetchType.EAGER)
    private Orden ordenDeCompra ;

    public Pago() {
    }

    public Pago(TipoDePago tipoDePago,double monto, LocalDateTime fechaDePago ) {
        this.tipoDePago = tipoDePago;
        this.monto = monto;
        this.fechaDePago = fechaDePago;

    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(LocalDateTime fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public TipoDePago getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(TipoDePago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public Orden getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(Orden ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }
}

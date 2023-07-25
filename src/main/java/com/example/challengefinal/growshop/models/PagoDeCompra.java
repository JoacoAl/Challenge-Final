package com.example.challengefinal.growshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class PagoDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private  long id;

    private double monto;

    private LocalDateTime fechaDePago;

    private TipoDePago tipoDePago;

    @OneToOne(mappedBy = "pagoDeCompra", fetch = FetchType.EAGER)
    private OrdenDeCompra ordenDeCompra ;

    public PagoDeCompra() {
    }

    public PagoDeCompra(double monto, LocalDateTime fechaDePago, TipoDePago tipoDePago) {
        this.monto = monto;
        this.fechaDePago = fechaDePago;
        this.tipoDePago = tipoDePago;
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

}

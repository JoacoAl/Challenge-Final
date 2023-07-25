package com.example.challengefinal.growshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrdenDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private  long id;

    private String numeroDeOrden;

    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "pagoDeCompra_id")
    private PagoDeCompra pagoDeCompra;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(String numeroDeOrden, LocalDateTime fecha) {
        this.numeroDeOrden = numeroDeOrden;
        this.fecha = fecha;
    }

    public String getNumeroDeOrden() {
        return numeroDeOrden;
    }

    public void setNumeroDeOrden(String numeroDeOrden) {
        this.numeroDeOrden = numeroDeOrden;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PagoDeCompra getPagoDeCompra() {
        return pagoDeCompra;
    }

    public void setPagoDeCompra(PagoDeCompra pagoDeCompra) {
        this.pagoDeCompra = pagoDeCompra;
    }
}

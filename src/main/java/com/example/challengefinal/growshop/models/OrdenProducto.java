package com.example.challengefinal.growshop.models;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.hateoas.server.ExposesResourceFor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrdenProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double montoTotal;

    private int cantidadDeProductos;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordenDeCompra_id")
    private OrdenDeCompra ordenDeCompra;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;


    public OrdenProducto() {
    }

    public OrdenProducto(double montoTotal, int cantidadDeProductos) {
        this.montoTotal = montoTotal;
        this.cantidadDeProductos = cantidadDeProductos;
    }


    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public OrdenDeCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProductos(Producto producto) {
        this.producto = producto;
    }
}

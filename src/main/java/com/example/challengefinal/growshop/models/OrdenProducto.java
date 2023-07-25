package com.example.challengefinal.growshop.models;

import javax.persistence.*;

@Entity
public class OrdenProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double montoTotal;

    private int cantidadDeProductos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordenDeCompra_id")
    private Orden orden;
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

    public Orden getOrdenDeCompra() {
        return orden;
    }

    public void setOrdenDeCompra(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProductos(Producto producto) {
        this.producto = producto;
    }
}

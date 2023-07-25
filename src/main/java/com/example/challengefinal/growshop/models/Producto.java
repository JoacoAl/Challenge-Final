package com.example.challengefinal.growshop.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private  long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private String tipoDeCategoria;

    private long cantidad;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio, String tipoDeCategoria, long cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoDeCategoria = tipoDeCategoria;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoDeCategoria() {
        return tipoDeCategoria;
    }

    public void setTipoDeCategoria(String tipoDeCategoria) {
        this.tipoDeCategoria = tipoDeCategoria;
    }
}

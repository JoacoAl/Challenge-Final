package com.example.challengefinal.growshop.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private Set<OrdenProducto> ordenProductos = new HashSet<>();

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio, String tipoDeCategoria, long cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoDeCategoria = tipoDeCategoria;
        this.cantidad = cantidad;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Set<OrdenProducto> getOrdenProductos() {
        return ordenProductos;
    }

    public void setOrdenProductos(Set<OrdenProducto> ordenProductos) {
        this.ordenProductos = ordenProductos;
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

    public void añadirOrdenProducto(OrdenProducto ordenProducto){
        ordenProducto.setProductos(this);
        ordenProductos.add(ordenProducto);
    }
}

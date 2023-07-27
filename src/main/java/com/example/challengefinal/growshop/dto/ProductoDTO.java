package com.example.challengefinal.growshop.dto;

import com.example.challengefinal.growshop.models.Categoria;
import com.example.challengefinal.growshop.models.Producto;

public class ProductoDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private Categoria categoria;

    private long cantidad;

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.categoria = producto.getCategoria();
        this.cantidad = producto.getCantidad();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public long getCantidad() {
        return cantidad;
    }
}

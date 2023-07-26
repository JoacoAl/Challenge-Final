package com.example.challengefinal.growshop.dto;

import com.example.challengefinal.growshop.models.OrdenProducto;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

public class OrdenProductoDTO {


    private long id;

    private double montoTotal;

    private int cantidadDeProductos;

    private String nombre;



    public OrdenProductoDTO(OrdenProducto ordenProducto){
        this.id = ordenProducto.getId();
        this.montoTotal = ordenProducto.getMontoTotal();
        this.cantidadDeProductos = ordenProducto.getCantidadDeProductos();
        this.nombre = ordenProducto.getNombre();
    }

    public long getId() {
        return id;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public String getNombre() {
        return nombre;
    }


}

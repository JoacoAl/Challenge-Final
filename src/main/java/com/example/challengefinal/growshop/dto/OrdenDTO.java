package com.example.challengefinal.growshop.dto;

import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Orden;
import com.example.challengefinal.growshop.models.OrdenProducto;
import com.example.challengefinal.growshop.models.Pago;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class OrdenDTO {

    private Long id;

    private String numeroDeOrden;

    private LocalDateTime fecha;

    private Cliente cliente;

    private Pago pago;

    private Set<OrdenProducto> ordenProductos;


    public OrdenDTO(Orden orden) {
        this.id = orden.getId();
        this.numeroDeOrden = orden.getNumeroDeOrden();
        this.fecha = orden.getFecha();
        this.cliente = orden.getCliente();
        this.pago = orden.getPago();
        this.ordenProductos = orden.getOrdenProductos();
    }

    public String getNumeroDeOrden() {
        return numeroDeOrden;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pago getPago() {
        return pago;
    }

    public Set<OrdenProducto> getOrdenProductos() {
        return ordenProductos;
    }
}

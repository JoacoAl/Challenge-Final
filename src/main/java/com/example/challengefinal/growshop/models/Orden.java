package com.example.challengefinal.growshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private long id;

    private String numeroDeOrden;

    private LocalDateTime fecha;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    @OneToMany(mappedBy = "orden", fetch = FetchType.EAGER)
    private Set<OrdenProducto> ordenProductos = new HashSet<>();

    public Orden() {
    }

    public Orden(String numeroDeOrden, LocalDateTime fecha) {
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

    public void añadirPago(Pago pago) {
        pago.setOrdenDeCompra(this);
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Set<OrdenProducto> getOrdenProductos() {
        return ordenProductos;
    }

    public void setOrdenProductos(Set<OrdenProducto> ordenProductos) {
        this.ordenProductos = ordenProductos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void añadirOrdenProducto(OrdenProducto ordenProducto) {
        ordenProducto.setOrdenDeCompra(this);
        ordenProductos.add(ordenProducto);
    }
}

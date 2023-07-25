package com.example.challengefinal.growshop.dto;

import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Orden;

import java.util.Set;

public class ClienteDTO {


    private Long id;
    private String nombre, apellido, email;

    private Set<Orden> ordenSet;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.email = cliente.getApellido();
        this.ordenSet = cliente.getOrdenesDeCompra();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Set<Orden> getOrdenSet() {
        return ordenSet;
    }
}

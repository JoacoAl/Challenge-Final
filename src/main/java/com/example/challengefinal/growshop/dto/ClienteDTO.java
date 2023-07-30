package com.example.challengefinal.growshop.dto;

import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Orden;

import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO {


    private Long id;
    private  String nombre, apellido, email, direccion, contraseña, telefono;

    private int edad;

    private Set<OrdenDTO> ordenSet;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.email = cliente.getEmail();
        this.ordenSet = cliente.getOrdenesDeCompra().stream().map(orden -> new OrdenDTO(orden)).collect(Collectors.toSet());
        this.telefono = cliente.getTelefono();
        this.edad = cliente.getEdad();
        this.direccion = cliente.getDireccion();
        this.contraseña = cliente.getContraseña();
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

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public Set<OrdenDTO> getOrdenSet() {
       return ordenSet;
    }
}

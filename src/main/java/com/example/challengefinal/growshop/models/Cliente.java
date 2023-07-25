package com.example.challengefinal.growshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.DatagramSocket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private  String nombre, apellido, email, direccion, contraseña, telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<OrdenDeCompra> ordenesDeCompra;


    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String direccion, String telefono, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<OrdenDeCompra> getOrdenesDeCompra() {
        return ordenesDeCompra;
    }

    public void setOrdenesDeCompra(List<OrdenDeCompra> ordenesDeCompra) {
        this.ordenesDeCompra = ordenesDeCompra;
    }
}

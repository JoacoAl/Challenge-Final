package com.example.challengefinal.growshop.controladores;


import com.example.challengefinal.growshop.Repositorios.ClienteRepositorio;
import com.example.challengefinal.growshop.dto.ClienteDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.servicios.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClienteControlador {

    @Autowired
    private ServicioCliente servicioCliente;

    @GetMapping("/clientes")
    public List<ClienteDTO> traerClientesDTO(){
        return servicioCliente.traerClientesDTO();
    }
    @GetMapping("/clientes/{id}")
    public  ClienteDTO traerClientePorId(@PathVariable Long id){
          return servicioCliente.traerClientePorId(id);
    }
}

package com.example.challengefinal.growshop.controladores;


import com.example.challengefinal.growshop.Repositorios.ClienteRepositorio;
import com.example.challengefinal.growshop.dto.ClienteDTO;
import com.example.challengefinal.growshop.models.Cliente;
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
    ClienteRepositorio clienteRepositorio;

    @GetMapping("/clientes")
    public List<ClienteDTO> traerClientesDTO(){
        return clienteRepositorio.findAll().stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    @GetMapping("/clientes/{id}")
    public  ClienteDTO traerClientePorId(@PathVariable Long id){
          Cliente cliente = clienteRepositorio.findById(id).orElse(null);
          ClienteDTO clienteDTO = new ClienteDTO(cliente);
          return clienteDTO;

    }
}

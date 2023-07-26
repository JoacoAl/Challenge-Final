package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.OrdenRepositorio;
import com.example.challengefinal.growshop.dto.OrdenDTO;
import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.models.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrdenControlador {

    @Autowired
    OrdenRepositorio ordenRepositorio;

    @GetMapping("/ordenes")
    public Set<OrdenDTO> traerOrdenesDTO(){
        return ordenRepositorio.findAll().stream().map(orden -> new OrdenDTO(orden)).collect(Collectors.toSet());
    }

    @GetMapping("/ordenes/{id}")
    public OrdenDTO traerOrdenDTO(@PathVariable Long id){
        Orden orden = ordenRepositorio.findById(id).orElse(null);
        OrdenDTO ordenDTO = new OrdenDTO(orden);
        return ordenDTO;
    }

}

package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.OrdenRepositorio;
import com.example.challengefinal.growshop.dto.OrdenDTO;
import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.models.Orden;
import com.example.challengefinal.growshop.servicios.ServicioOrden;
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
    private ServicioOrden servicioOrden;

    @GetMapping("/ordenes")
    public Set<OrdenDTO> traerOrdenesDTO(){
        return servicioOrden.traerOrdenesDTO();
    }

    @GetMapping("/ordenes/{id}")
    public OrdenDTO traerOrdenDTO(@PathVariable Long id){
        return servicioOrden.traerOrdenDTO(id);
    }

}

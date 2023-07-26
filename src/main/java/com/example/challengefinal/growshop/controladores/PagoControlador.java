package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.PagoRepositorio;
import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.models.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PagoControlador {
    @Autowired
    PagoRepositorio pagoRepositorio;

    @GetMapping("/pagos")
    public Set<PagoDTO> traerPagosDTO(){
        return pagoRepositorio.findAll().stream().map(pago -> new PagoDTO(pago)).collect(Collectors.toSet());
    }

    @GetMapping("/pagos/{id}")
    public PagoDTO traerPagoDTO(@PathVariable Long id){
        Pago pago = pagoRepositorio.findById(id).orElse(null);
        PagoDTO pagoDTO = new PagoDTO(pago);
        return pagoDTO;
    }

}

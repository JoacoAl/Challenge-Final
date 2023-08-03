package com.example.challengefinal.growshop.servicios.Implement;

import com.example.challengefinal.growshop.Repositorios.PagoRepositorio;
import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.models.Pago;
import com.example.challengefinal.growshop.servicios.ServicioPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class ServicioPagoImplement implements ServicioPago {

    @Autowired
    private PagoRepositorio pagoRepositorio;
    @Override
    public Set<PagoDTO> traerPagosDTO() {
        return pagoRepositorio.findAll().stream().map(pago -> new PagoDTO(pago)).collect(Collectors.toSet());
    }

    @Override
    public PagoDTO traerPagoDTO(Long id) {
        Pago pago = pagoRepositorio.findById(id).orElse(null);
        PagoDTO pagoDTO = new PagoDTO(pago);
        return pagoDTO;
    }
}

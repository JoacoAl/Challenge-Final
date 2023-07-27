package com.example.challengefinal.growshop.servicios;

import com.example.challengefinal.growshop.dto.PagoDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

public interface ServicioPago {

    Set<PagoDTO> traerPagosDTO();
    PagoDTO traerPagoDTO(@PathVariable Long id);
}

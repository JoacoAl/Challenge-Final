package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.PagoRepositorio;
import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.models.Pago;
import com.example.challengefinal.growshop.servicios.ServicioPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mercadopago.*;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PagoControlador {
    @Autowired
    private ServicioPago servicioPago;

    @Value("${mercadoPago.accessToken}")
    private String accessToken;

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(accessToken);
    }


    @GetMapping("/pagos")
    public Set<PagoDTO> traerPagosDTO(){
        return servicioPago.traerPagosDTO();
    }

    @GetMapping("/pagos/{id}")
    public PagoDTO traerPagoDTO(@PathVariable Long id){
        return servicioPago.traerPagoDTO(id);
    }
}



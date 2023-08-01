package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.OrdenRepositorio;
import com.example.challengefinal.growshop.dto.OrdenDTO;
import com.example.challengefinal.growshop.dto.OrdenProductoDTO;
import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Orden;
import com.example.challengefinal.growshop.models.OrdenProducto;
import com.example.challengefinal.growshop.servicios.ServicioCliente;
import com.example.challengefinal.growshop.servicios.ServicioFacturacion;
import com.example.challengefinal.growshop.servicios.ServicioOrden;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrdenControlador {

    @Autowired
    private ServicioOrden servicioOrden;
    @Autowired
    private ServicioCliente servicioCliente;
    @Autowired
    private ServicioFacturacion servicioFacturacion;

    @GetMapping("/ordenes")
    public Set<OrdenDTO> traerOrdenesDTO(){
        return servicioOrden.traerOrdenesDTO();
    }

    @GetMapping("/ordenes/{id}")
    public OrdenDTO traerOrdenDTO(@PathVariable Long id){
        return servicioOrden.traerOrdenDTO(id);
    }


}

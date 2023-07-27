package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.ProductoRepositorio;
import com.example.challengefinal.growshop.dto.ProductoDTO;
import com.example.challengefinal.growshop.models.Producto;
import com.example.challengefinal.growshop.servicios.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoControlador {

    @Autowired
    private ServicioProducto servicioProducto;
    @GetMapping("/productos")
    public List<ProductoDTO> traerProductosDTO(){
        return servicioProducto.traerProductosDTO();
    }

    @GetMapping("/productos/{id}")
    public ProductoDTO traerProductoDTO(@PathVariable Long id){
        return servicioProducto.traerProductoDTO(id);
    }
}

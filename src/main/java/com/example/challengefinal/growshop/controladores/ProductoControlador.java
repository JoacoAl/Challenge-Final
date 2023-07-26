package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.ProductoRepositorio;
import com.example.challengefinal.growshop.dto.ProductoDTO;
import com.example.challengefinal.growshop.models.Producto;
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
    ProductoRepositorio productoRepositorio;

    @GetMapping("/productos")
    public List<ProductoDTO> traerProductosDTO(){
        return productoRepositorio.findAll().stream().map(producto -> new ProductoDTO(producto)).collect(Collectors.toList());
    }

    @GetMapping("/productos/{id}")
    public ProductoDTO traerProductoDTO(@PathVariable Long id){
        Producto producto = productoRepositorio.findById(id).orElse(null);
        ProductoDTO productoDTO = new ProductoDTO(producto);
        return productoDTO;

    }
}

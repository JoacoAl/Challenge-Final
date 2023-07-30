package com.example.challengefinal.growshop.servicios.Implement;

import com.example.challengefinal.growshop.Repositorios.ProductoRepositorio;
import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.dto.ProductoDTO;
import com.example.challengefinal.growshop.models.Producto;
import com.example.challengefinal.growshop.servicios.ServicioPago;
import com.example.challengefinal.growshop.servicios.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioProductoImplement implements ServicioProducto {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Override
    public List<ProductoDTO> traerProductosDTO() {
        return productoRepositorio.findAll().stream().map(producto -> new ProductoDTO(producto)).collect(Collectors.toList());
    }

    @Override
    public ProductoDTO traerProductoDTO(Long id) {
        Producto producto = productoRepositorio.findById(id).orElse(null);
        ProductoDTO productoDTO = new ProductoDTO(producto);
        return productoDTO;
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void borrar(long id) {
        productoRepositorio.deleteById(id);
    }
}

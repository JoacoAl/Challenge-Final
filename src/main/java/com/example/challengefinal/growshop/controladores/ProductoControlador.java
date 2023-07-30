package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.ProductoRepositorio;
import com.example.challengefinal.growshop.dto.CrearProductoDTO;
import com.example.challengefinal.growshop.dto.ProductoDTO;
import com.example.challengefinal.growshop.models.Producto;
import com.example.challengefinal.growshop.servicios.ServicioOrden;
import com.example.challengefinal.growshop.servicios.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.*;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoControlador {

    @Autowired
    private ServicioProducto servicioProducto;
    @Autowired
    private ServicioOrden servicioOrden;

    @GetMapping("/productos")
    public List<ProductoDTO> traerProductosDTO(){
        return servicioProducto.traerProductosDTO();
    }

    @GetMapping("/productos/{id}")
    public ProductoDTO traerProductoDTO(@PathVariable Long id){
        return servicioProducto.traerProductoDTO(id);
    }

    @PostMapping("/productos/agregar")
    public ResponseEntity<Object> crearProductoNuevo(@RequestBody CrearProductoDTO productoDTO) {


        List<ProductoDTO> productos = servicioProducto.traerProductosDTO();

        if (productoDTO.getDescripcion().isBlank()) {
            return new ResponseEntity<>("Defina una descripcion del producto", HttpStatus.BAD_REQUEST);
        }
        if (productoDTO.getPrecio() <= 0) {
            return new ResponseEntity<>("Defina un precio para el producto", HttpStatus.BAD_REQUEST);
        }
        if (productos.stream().anyMatch(productoDTO1 -> productoDTO1.getNombre().equals(productoDTO.getNombre()))) {
            return new ResponseEntity<>("No puedes tener dos productos distintos con el mismo nombre", HttpStatus.FORBIDDEN);
        } else {
            Producto nuevoProducto = new Producto(productoDTO.getNombre(), productoDTO.getDescripcion(), productoDTO.getPrecio(), productoDTO.getCategoria(), productoDTO.getCantidad(), productoDTO.getImg());
            servicioProducto.guardar(nuevoProducto);
            return new ResponseEntity<>("Producto añadido", HttpStatus.CREATED);
        }
    }
    
}

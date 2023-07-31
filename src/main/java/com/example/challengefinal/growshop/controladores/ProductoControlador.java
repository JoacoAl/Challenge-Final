package com.example.challengefinal.growshop.controladores;

import ch.qos.logback.core.net.server.Client;
import com.example.challengefinal.growshop.dto.ProductoDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Producto;
import com.example.challengefinal.growshop.servicios.ServicioCliente;
import com.example.challengefinal.growshop.servicios.ServicioProducto;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoControlador {

    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private ServicioCliente servicioCliente;

    @GetMapping("/productos")
    public List<ProductoDTO> traerProductosDTO() {
        return servicioProducto.traerProductosDTO();
    }

    @GetMapping("/productos/activos")
    public List<ProductoDTO> traerProductosDTOactivos() {
        return servicioProducto.traerProductosDTO().stream().filter(productoDTO -> productoDTO.isActivo()).collect(Collectors.toList());
    }


    @GetMapping("/productos/{id}")
    public ProductoDTO traerProductoDTO(@PathVariable Long id) {
        return servicioProducto.traerProductoDTO(id);
    }

    @PostMapping("/productos/borrar")
    public ResponseEntity<Object> borrarProductos(@RequestParam Long id, Authentication authentication) {

        if (authentication.getName() == null) {
            return new ResponseEntity<>("No estas autenticado", HttpStatus.FORBIDDEN);
        }

        if (id == null) {
            return new ResponseEntity<>("Los data es invalida", HttpStatus.FORBIDDEN);

        }

        Producto producto = servicioProducto.traerProductoPorId(id);

        if (producto == null) {
            return new ResponseEntity<>("No se encontro ningun producto con ese nombre", HttpStatus.FORBIDDEN);
        }
        producto.setActivo(false);
        servicioProducto.save(producto);

        return new ResponseEntity<>("El producto fue borrado exitosamente", HttpStatus.ACCEPTED);

    }

    @PostMapping("/productos/agregar")
    public ResponseEntity<Object> crearProductoNuevo(@RequestBody ProductoDTO productoDTO, Authentication authentication) {
//        Cliente admin = servicioCliente.traerClientePorEmail(authentication.getName());
//
//        if (admin == null) {
//            return new ResponseEntity<>("No estas autenticado", HttpStatus.FORBIDDEN);
//        }

        List<ProductoDTO> productos = servicioProducto.traerProductosDTO();
        if (productoDTO.getCantidad() <= 0) {
            return new ResponseEntity<>("Asigne una cantidad de stock", HttpStatus.BAD_REQUEST);
        }
        if (productoDTO.getDescripcion().isBlank()) {
            return new ResponseEntity<>("Defina una descripcion del producto", HttpStatus.BAD_REQUEST);
        }
        if (productoDTO.getPrecio() <= 0) {
            return new ResponseEntity<>("Defina un precio para el producto", HttpStatus.BAD_REQUEST);
        }
        if (productos.stream().anyMatch(productoDTO1 -> productoDTO1.getNombre().equals(productoDTO.getNombre()))) {
            return new ResponseEntity<>("No puedes tener dos productos distintos con el mismo nombre", HttpStatus.FORBIDDEN);
        } else {

            Producto nuevoProducto = new Producto(productoDTO.getNombre(),productoDTO.getMarca(), productoDTO.getDescripcion(), productoDTO.getPrecio(), productoDTO.getCategoria(), productoDTO.getSubCategoria(), productoDTO.getImagen(), productoDTO.getCantidad(), true, "ARS");

            servicioProducto.save(nuevoProducto);
            return new ResponseEntity<>("Producto añadido", HttpStatus.CREATED);
        }
    }

    @PostMapping("/productos/modificar")
    public ResponseEntity<Object> modificarProducto(@RequestParam ProductoDTO productoDTO, Authentication authentication) {

        Cliente admin = servicioCliente.traerClientePorEmail(authentication.getName());

        if (admin == null) {
            return new ResponseEntity<>("No estas autenticado", HttpStatus.BAD_REQUEST);
        }

        if (productoDTO.getNombre() == null) {
            return new ResponseEntity<>("El producto no existe", HttpStatus.BAD_REQUEST);
        }
        if (productoDTO.getCantidad() <= 0) {
            return new ResponseEntity<>("Asigne una cantidad de stock", HttpStatus.BAD_REQUEST);
        }
        if (productoDTO.getDescripcion().isBlank()) {
            return new ResponseEntity<>("Defina una descripcion del producto", HttpStatus.BAD_REQUEST);
        }
        if (productoDTO.getPrecio() <= 0) {
            return new ResponseEntity<>("Defina un precio para el producto", HttpStatus.BAD_REQUEST);
        }
        if (productoDTO.getCategoria() == null) {
            return new ResponseEntity<>("Defina una categoria para el producto", HttpStatus.BAD_REQUEST);
        }

        Producto producto = servicioProducto.traerProductoPorId(productoDTO.getId());

        if (producto == null) {
            return new ResponseEntity<>("No se encontro el producto que se quiere modificar", HttpStatus.BAD_REQUEST);
        }

        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCantidad(productoDTO.getCantidad());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setPrecio(productoDTO.getPrecio());

        servicioProducto.save(producto);

        return new ResponseEntity<>("El producto fue modificado correctamente", HttpStatus.OK);

    }
}



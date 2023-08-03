package com.example.challengefinal.growshop.servicios;

import com.example.challengefinal.growshop.dto.PagoDTO;
import com.example.challengefinal.growshop.dto.ProductoDTO;
import com.example.challengefinal.growshop.models.Producto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface ServicioProducto {

    List<ProductoDTO> traerProductosDTO();
    List<Producto> traerProductos();
    ProductoDTO traerProductoDTO(@PathVariable Long id);

    Producto traerProductoPorId(Long id);


    void save(Producto producto);

}

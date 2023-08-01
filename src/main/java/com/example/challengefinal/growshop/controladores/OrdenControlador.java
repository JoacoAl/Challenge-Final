package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.OrdenProductoRepositorio;
import com.example.challengefinal.growshop.dto.OrdenDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Orden;
import com.example.challengefinal.growshop.models.OrdenProducto;
import com.example.challengefinal.growshop.models.Producto;
import com.example.challengefinal.growshop.servicios.ServicioCliente;
import com.example.challengefinal.growshop.servicios.ServicioFacturacion;
import com.example.challengefinal.growshop.servicios.ServicioOrden;
import com.example.challengefinal.growshop.servicios.ServicioProducto;
import com.example.challengefinal.growshop.utils.NumeroOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class OrdenControlador {

    @Autowired
    private ServicioOrden servicioOrden;
    @Autowired
    private OrdenProductoRepositorio ordenProductoRepositorio;
    @Autowired
    private ServicioProducto servicioProducto;
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

    @PostMapping("/ordenes/crear-orden")
    public ResponseEntity<Object> crearOrden(@RequestBody Set<OrdenProducto> productosCarrito, Authentication authentication){
        Cliente cliente = servicioCliente.traerClientePorEmail(authentication.getName());
        List<Producto> productos = servicioProducto.traerProductos();
        double totalCompra = 0;
        for (OrdenProducto producto : productosCarrito) {
            totalCompra += producto.getPrecioUnitario() * producto.getCantidadDeProductos();
        }
        String numeroDeOrden = NumeroOrden.getRandomNum();
        Orden orden = new Orden();
        do {
            orden.setNumeroDeOrden(numeroDeOrden);
        } while (servicioOrden.traerOrdenPorNumero(numeroDeOrden) != null);
        orden.setFecha(LocalDateTime.now());
        orden.setCliente(cliente);
        orden.setMontoTotal(totalCompra);

        for (OrdenProducto producto : productosCarrito) {
            producto.setOrden(orden);
            productos.forEach(producto1 -> producto1.añadirOrdenProducto(producto));
        }
        servicioOrden.save(orden);

        return new ResponseEntity<>("Orden generada con éxito", HttpStatus.OK);
    }



}

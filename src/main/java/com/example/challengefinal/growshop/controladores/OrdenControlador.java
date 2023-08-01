package com.example.challengefinal.growshop.controladores;

import com.example.challengefinal.growshop.Repositorios.OrdenProductoRepositorio;
import com.example.challengefinal.growshop.dto.OrdenDTO;
import com.example.challengefinal.growshop.dto.OrdenInfoDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Orden;
import com.example.challengefinal.growshop.models.OrdenProducto;
import com.example.challengefinal.growshop.models.Producto;
import com.example.challengefinal.growshop.servicios.*;
import com.example.challengefinal.growshop.servicios.email.EmailServicio;
import com.example.challengefinal.growshop.utils.NumeroOrden;
import com.itextpdf.text.DocumentException;
import com.mercadopago.MercadoPagoConfig;
import com.sanctionco.jmail.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.challengefinal.growshop.pdfs.PdfGenerador;
import javax.annotation.PostConstruct;
import java.io.IOException;
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
    @Autowired
    private ServicioOrdenProducto servicioOrdenProducto;
    @Autowired
    private EmailServicio emailServicio;
    @Value("${mercadoPago.accessToken}")
    private String accessToken;

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(accessToken);
    }

    @GetMapping("/ordenes")
    public Set<OrdenDTO> traerOrdenesDTO(){
        return servicioOrden.traerOrdenesDTO();
    }

    @GetMapping("/ordenes/{id}")
    public OrdenDTO traerOrdenDTO(@PathVariable Long id){
        return servicioOrden.traerOrdenDTO(id);
    }

    @PostMapping("/crear/orden")
    public ResponseEntity<Object> crearOrden(@RequestBody Set<OrdenInfoDTO> productosCarrito, Authentication authentication) throws DocumentException, IOException {
        Cliente cliente = servicioCliente.traerClientePorEmail(authentication.getName());

        double totalCompra = 0;
        for (OrdenInfoDTO producto : productosCarrito) {
            totalCompra += producto.getTotal() * producto.getTotalProductos();
        }

        String numeroDeOrden = NumeroOrden.getRandomNum();
        Orden orden = new Orden();
        do {
            orden.setNumeroDeOrden(numeroDeOrden);
        } while (servicioOrden.traerOrdenPorNumero(numeroDeOrden) != null);

        orden.setFecha(LocalDateTime.now());
        orden.setCliente(cliente);
        orden.setMontoTotal(totalCompra);

        servicioOrden.save(orden);

        for (OrdenInfoDTO producto : productosCarrito) {
            // Crear un nuevo objeto OrdenProducto para cada producto en la orden
            OrdenProducto ordenProducto = new OrdenProducto();
            ordenProducto.setPrecioUnitario(producto.getTotal());
            ordenProducto.setCantidadDeProductos(producto.getTotalProductos());
            ordenProducto.setNombre(producto.getNombre());
            // Asociar el objeto OrdenProducto con la orden y el producto correspondiente
            Producto productoEntity = servicioProducto.traerProductoPorId(producto.getId());
            ordenProducto.setOrden(orden);
            ordenProducto.setProducto(productoEntity);
            // Guardar el objeto OrdenProducto en la base de datos
            servicioOrdenProducto.save(ordenProducto);
        }

        return new ResponseEntity<>("Orden generada con éxito", HttpStatus.OK);
    }

}

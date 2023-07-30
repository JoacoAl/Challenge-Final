package com.example.challengefinal.growshop;

import com.example.challengefinal.growshop.Repositorios.*;
import com.example.challengefinal.growshop.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class GrowshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrowshopApplication.class, args);
    }

    @Autowired
    PasswordEncoder codificadorDeContraseña;

    @Bean
    public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, ProductoRepositorio productoRepositorio, OrdenRepositorio ordenRepositorio, PagoRepositorio pagoRepositorio, OrdenProductoRepositorio ordenProductoRepositorio) {
        return (args) -> {


            Cliente clientePrueba = new Cliente("Joaquin", "Altamonte", "joaquin.altamonte@gmail.com", "ABC 123", "123456789", codificadorDeContraseña.encode("1234"), 18);
            Cliente clientePrueba2 = new Cliente("Eduardo", "Oriolani", "eduoriolani@gmail.com", "CBA 123", "111111111", codificadorDeContraseña.encode("1234"), 26);
            Cliente clientePrueba3 = new Cliente("Nicolas", "Gonzales", "nicogonzales@gmail.com", "BBB 111", "222222222", codificadorDeContraseña.encode("1234"), 19);
            Cliente clienteAdmin = new Cliente("Admin", "Admin", "admin-gozogrowshop@gmail.com", "CCC 333", "333333333", codificadorDeContraseña.encode("1234"), 19);


            Producto producto1 = new Producto("Encendedor", "Encendedor de plastico BIC", 250, Categoria.ACCESORIOS, 40, "");
            Producto producto2 = new Producto("Pica", "Picador rolling circus", 330, Categoria.ACCESORIOS, 6, "");
            Producto producto3 = new Producto("Liyo", "Liyos de celulosa", 125, Categoria.ACCESORIOS, 20, "");

            Producto producto4 = new Producto("Encendedor", "Encendedor de plastico BIC", 250, Categoria.ACCESORIOS, 40, "");
            Producto producto5 = new Producto("Pica", "Picador rolling circus", 330, Categoria.ACCESORIOS, 6, "");
            Producto producto6 = new Producto("Liyo", "Liyos de celulosa", 125, Categoria.ACCESORIOS, 20, "");

            clienteRepositorio.save(clientePrueba);
            clienteRepositorio.save(clientePrueba2);
            clienteRepositorio.save(clientePrueba3);
            clienteRepositorio.save(clienteAdmin);

            productoRepositorio.save(producto1);
            productoRepositorio.save(producto2);
            productoRepositorio.save(producto3);
            productoRepositorio.save(producto4);
            productoRepositorio.save(producto5);
            productoRepositorio.save(producto6);


            Orden orden = new Orden("acz123456789", LocalDateTime.now());
            Orden orden2 = new Orden("bca3333311", LocalDateTime.now());

            ordenRepositorio.save(orden);
            ordenRepositorio.save(orden2);


            clientePrueba.añadirOrdenes(orden);
            clientePrueba2.añadirOrdenes(orden2);
            clienteRepositorio.save(clientePrueba);
            clienteRepositorio.save(clientePrueba2);


            Pago pago = new Pago(TipoDePago.CREDITO, 2000, LocalDateTime.now());
            Pago pago2 = new Pago(TipoDePago.DEBITO, 5000, LocalDateTime.now());

            pagoRepositorio.save(pago);
            pagoRepositorio.save(pago2);

            orden.setPago(pago);
            orden2.setPago(pago2);
            ordenRepositorio.save(orden);
            ordenRepositorio.save(orden2);

            OrdenProducto ordenProducto = new OrdenProducto(750, 3, producto1.getNombre());
            OrdenProducto ordenProducto2 = new OrdenProducto(660, 2, producto2.getNombre());
            ordenProductoRepositorio.save(ordenProducto);
            ordenProductoRepositorio.save(ordenProducto2);


            producto1.añadirOrdenProducto(ordenProducto);
            orden.añadirOrdenProducto(ordenProducto);

            producto2.añadirOrdenProducto(ordenProducto2);
            orden2.añadirOrdenProducto(ordenProducto2);

            productoRepositorio.save(producto1);
            productoRepositorio.save(producto2);


            ordenRepositorio.save(orden);
            ordenRepositorio.save(orden2);


            ordenProductoRepositorio.save(ordenProducto);
            ordenProductoRepositorio.save(ordenProducto2);


        };

    }
}

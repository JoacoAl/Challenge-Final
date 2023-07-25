package com.example.challengefinal.growshop;

import com.example.challengefinal.growshop.Repositorios.*;
import com.example.challengefinal.growshop.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GrowshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowshopApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, ProductoRepositorio productoRepositorio, OrdenRepositorio ordenRepositorio, PagoRepositorio pagoRepositorio, OrdenProductoRepositorio ordenProductoRepositorio) {
		return (args) -> {


			Cliente clientePrueba = new Cliente("Joaquin", "Altamonte", "joaquin.altamonte@gmail.com", "ABC 123", "123456789", "1234");

			Producto producto1 = new Producto("Encendedor", "Encendedor de plastico BIC", 250, "Variado", 40);

			clienteRepositorio.save(clientePrueba);
			productoRepositorio.save(producto1);

			Orden orden = new Orden("acz123456789", LocalDateTime.now());
			ordenRepositorio.save(orden);

			clientePrueba.añadirOrdenes(orden);
			clienteRepositorio.save(clientePrueba);


			Pago pago = new Pago(TipoDePago.CREDITO, 2000, LocalDateTime.now());
			pagoRepositorio.save(pago);

			orden.setPagoDeCompra(pago);
			ordenRepositorio.save(orden);

			OrdenProducto ordenProducto = new OrdenProducto(2500, 20);
			ordenProductoRepositorio.save(ordenProducto);

			producto1.añadirOrdenProducto(ordenProducto);
			orden.añadirOrdenProducto(ordenProducto);

			productoRepositorio.save(producto1);

			ordenRepositorio.save(orden);

			ordenProductoRepositorio.save(ordenProducto);












		};

	}
}

package com.example.challengefinal.growshop;

import com.example.challengefinal.growshop.Repositorios.ClienteRepositorio;
import com.example.challengefinal.growshop.Repositorios.ProductoRepositorio;
import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.models.Producto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrowshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowshopApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, ProductoRepositorio productoRepositorio) {
		return (args) -> {


			Cliente clientePrueba = new Cliente("Joaquin", "Altamonte", "joaquin.altamonte@gmail.com", "ABC 123", "123456789", "1234");

			Producto producto1 = new Producto("Encendedor", "Encendedor de plastico BIC", 250, "Variado", 40);

			clienteRepositorio.save(clientePrueba);
			productoRepositorio.save(producto1);

		};

	}
}

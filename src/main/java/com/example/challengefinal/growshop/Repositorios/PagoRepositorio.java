package com.example.challengefinal.growshop.Repositorios;

import com.example.challengefinal.growshop.models.Pago;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PagoRepositorio extends JpaRepository<Pago, Long> {
}

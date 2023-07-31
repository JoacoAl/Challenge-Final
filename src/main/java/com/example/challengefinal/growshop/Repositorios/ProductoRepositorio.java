package com.example.challengefinal.growshop.Repositorios;

import com.example.challengefinal.growshop.models.Producto;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}

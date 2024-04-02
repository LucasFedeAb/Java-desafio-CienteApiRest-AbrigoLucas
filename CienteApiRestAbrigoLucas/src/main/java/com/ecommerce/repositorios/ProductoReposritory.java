package com.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.modelos.Producto;

@Repository
public interface ProductoReposritory extends JpaRepository<Producto, Integer>{

}

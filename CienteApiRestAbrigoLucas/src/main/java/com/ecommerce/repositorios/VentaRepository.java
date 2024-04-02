package com.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.modelos.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

}

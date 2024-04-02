package com.ecommerce.modelos;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table( name = "ventas")
public class Venta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaVenta;

    private double montoTotalVenta;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Producto producto;

    public Venta() {
    }

    public Venta(double montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public void setMontoTotalVenta(double montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @PrePersist
    public void prePersist() {
        this.fechaVenta = new Date();
    }

}

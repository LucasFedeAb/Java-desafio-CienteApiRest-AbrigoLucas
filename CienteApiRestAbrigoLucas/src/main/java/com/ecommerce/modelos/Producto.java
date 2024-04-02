package com.ecommerce.modelos;


import java.util.ArrayList;
import java.util.List;

import com.ecommerce.clasesabstractas.EntidadBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "productos")
public class Producto extends EntidadBase {
	
	@Column(name = "nombre")
	private String name;
	@Column(name = "descripcion")
	private String description;
	@Column(name = "precio")
    private double price;
	@Column(name = "stock")
    private int stock;
	

	@OneToMany(mappedBy = "producto")
    private List<Venta> ventas = new ArrayList<>();
	
	//Constructor
	
	public Producto() {
		super();
	}
	
	
	public Producto(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

	
	//Getters y Setters


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
	
}

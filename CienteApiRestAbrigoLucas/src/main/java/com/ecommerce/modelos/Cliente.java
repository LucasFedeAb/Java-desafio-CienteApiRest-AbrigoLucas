package com.ecommerce.modelos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.clasesabstractas.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "clientes")
public class Cliente extends Persona {
		
		
		@Id
		@Column(unique = true)
		private Integer id;
	  	@Column(name = "Telefono")
	  	private Integer phone;
	  	@Column(name = "direccion")
		private String address;
	  	private LocalDate birthDate;
	  	
	  	@OneToMany(mappedBy = "cliente")
	    private List<Venta> ventas = new ArrayList<>();
	  	
	  	
		// Constructor
	  	
	  	public Cliente () {
	    	super();
	    }
	  	

		public Cliente (Integer dni, String name, String lastName, String email, Integer phone, String address, LocalDate birthDate) {
	    	super(dni, name, lastName, email);
	    	this.id = dni;
	        this.phone = phone;
	        this.address = address;
	        this.birthDate = birthDate;
	    }
	    


		public List<Venta> getVentas() {
	        return ventas;
	    }

	    public void setVentas(List<Venta> ventas) {
	        this.ventas = ventas;
	    }
	    
	    public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}
	    
		public Integer getPhone() {
			return phone;
		}

		public void setPhone(Integer phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		} 
		
		public LocalDate getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}
		
		// Método para calcular la edad
	    public int getAge() {
	        return Period.between(this.birthDate, LocalDate.now()).getYears();
	    }
	 
}

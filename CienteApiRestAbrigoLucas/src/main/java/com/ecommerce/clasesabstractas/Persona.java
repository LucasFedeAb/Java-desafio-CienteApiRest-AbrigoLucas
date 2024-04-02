package com.ecommerce.clasesabstractas;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona {
	
	@Column(name = "dni")
    private Integer dni;
	
	@Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    public Persona () {
    	super();
    }    
    
    public Persona(Integer dni, String name, String lastName, String email) {
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
    
    //Getters y Setters


	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}

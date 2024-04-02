package com.ecommerce.clasesabstractas;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public abstract class EntidadBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha creacion")
    private Date creationDate;

    @Column(name = "Creado por")
    private String createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha actualizacion")
    private Date dateUpdate;

    @Column(name = "Actualizado por")
    private String updatedBy;
    
    public EntidadBase () {
    	super();
    }
    // Getters y Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
    
}

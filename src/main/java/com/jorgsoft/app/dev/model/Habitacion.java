package com.jorgsoft.app.dev.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "habitaciones")
@Entity
public class Habitacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="codigo")
	private String codigo;
	
	@OneToMany(mappedBy="habitacion",fetch=FetchType.EAGER)
	@JsonIgnoreProperties(value="habitacion",allowSetters = true)
	private Set<Ingreso> ingresos;
	
	
	public Habitacion() {}
	
	public Habitacion(int id, String codigo) {
		super();
		this.id = id;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}

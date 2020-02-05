package com.jorgsoft.app.dev.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombres")
	private String nombres;
	
	private String apellidos;
	
	private String cedula;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_nacimiento")
	private Date fecha_nac;
	
	@OneToMany(mappedBy="paciente",fetch=FetchType.EAGER)
	@JsonIgnoreProperties(value="paciente")
	private Set<Ingreso> ingresos;
	
	
	public Paciente() {}
	
	public Paciente(int id, String nombres, String apellidos, String cedula, Date fecha_nac) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.fecha_nac = fecha_nac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Set<Ingreso> getIngresos() {
		return ingresos;
	}

	public void setIngresos(Set<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	
}

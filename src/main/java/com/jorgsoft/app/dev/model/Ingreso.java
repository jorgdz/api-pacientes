package com.jorgsoft.app.dev.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ingresos")
public class Ingreso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	@JsonIgnoreProperties("ingresos")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="habitacion_id")
	@JsonIgnoreProperties("ingresos")
	private Habitacion habitacion;

	public Ingreso () {}

	public Ingreso(int id, Paciente paciente, Habitacion habitacion) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.habitacion = habitacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
		
}

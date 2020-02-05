package com.jorgsoft.app.dev.model;

import java.io.Serializable;

public class IngresoHabitacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String habitacion;
	
	private Long pacientes;
	
	public IngresoHabitacion(int id, String habitacion, Long pacientes) {
		super();
		this.id = id;
		this.habitacion = habitacion;
		this.pacientes = pacientes;
	}

	public IngresoHabitacion() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public Long getPacientes() {
		return pacientes;
	}

	public void setPacientes(Long pacientes) {
		this.pacientes = pacientes;
	}

}

package com.jorgsoft.app.dev.service;

import java.util.List;

import com.jorgsoft.app.dev.model.Ingreso;
import com.jorgsoft.app.dev.model.IngresoHabitacion;

public interface IngresoService {
	
	List<Ingreso> findAll();
	
	Ingreso findById(int id);
	
	void save (Ingreso ingreso);
	
	List<IngresoHabitacion> findIngresoHabitacion();
	
	void delete (int id);
}

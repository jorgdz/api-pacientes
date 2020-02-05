package com.jorgsoft.app.dev.service;

import java.util.List;

import com.jorgsoft.app.dev.model.Habitacion;

public interface HabitacionService {
	
	List<Habitacion> findAll();
	
	Habitacion findById(int id);
	
	void save(Habitacion habitacion);
	
}

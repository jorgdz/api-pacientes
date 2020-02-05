package com.jorgsoft.app.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgsoft.app.dev.model.Habitacion;
import com.jorgsoft.app.dev.repo.HabitacionRepo;

@Service
public class HabitacionServiceImpl implements HabitacionService{
	
	@Autowired
	private HabitacionRepo repoHabitacion;
	
	@Override
	public List<Habitacion> findAll() {
		return this.repoHabitacion.findAll();
	}

	@Override
	public Habitacion findById(int id) {
		Optional<Habitacion> optional= this.repoHabitacion.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public void save(Habitacion habitacion) {
		this.repoHabitacion.save(habitacion);
	}

}

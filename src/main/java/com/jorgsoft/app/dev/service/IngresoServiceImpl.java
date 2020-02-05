package com.jorgsoft.app.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgsoft.app.dev.model.Ingreso;
import com.jorgsoft.app.dev.model.IngresoHabitacion;
import com.jorgsoft.app.dev.repo.IngresoRepo;

@Service 
public class IngresoServiceImpl implements IngresoService{

	@Autowired
	private IngresoRepo repoIngreso;
	
	@Override
	public List<Ingreso> findAll() {
		return this.repoIngreso.findAll();
	}

	@Override
	public Ingreso findById(int id) {
		Optional<Ingreso> ingreso = this.repoIngreso.findById(id);
		return (ingreso.isPresent() ? ingreso.get() :  null);
	}

	@Override
	public void save(Ingreso ingreso) {
		this.repoIngreso.save(ingreso);
	}

	@Override
	public List<IngresoHabitacion> findIngresoHabitacion() {
		return this.repoIngreso.findIngresoHabitacion();
	}

	@Override
	public void delete(int id) {
		this.repoIngreso.deleteById(id);
	}

}

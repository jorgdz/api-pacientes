package com.jorgsoft.app.dev.service;

import java.util.List;

import com.jorgsoft.app.dev.model.Paciente;

public interface PacienteService {
	
	List<Paciente> findAll();
	
	Paciente findById(int id);
	
	void save(Paciente paciente);
	
	void delete(int id);
}

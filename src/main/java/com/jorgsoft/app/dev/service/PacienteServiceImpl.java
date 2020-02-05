package com.jorgsoft.app.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgsoft.app.dev.model.Paciente;
import com.jorgsoft.app.dev.repo.PacienteRepo;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepo repoPaciente;
	
	@Override
	public List<Paciente> findAll() {
		return this.repoPaciente.findAllOrdered();
	}

	@Override
	public Paciente findById(int id) {
		Optional<Paciente> paciente = this.repoPaciente.findById(id);
		if(paciente.isPresent())
		{
			return paciente.get();
		}
		return null;
	}

	@Override
	public void save(Paciente paciente) {
		this.repoPaciente.save(paciente);
	}

	@Override
	public void delete(int id) {
		this.repoPaciente.deleteById(id);
	}

}

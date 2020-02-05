package com.jorgsoft.app.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorgsoft.app.dev.GetResponse;
import com.jorgsoft.app.dev.model.Paciente;
import com.jorgsoft.app.dev.service.PacienteService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api")
public class PacienteController {
	
	@Autowired
	private PacienteService servicePaciente;
	
	@GetMapping(value = "/pacientes", produces = "application/json")
	public List<Paciente> getAll ()
	{
		return this.servicePaciente.findAll();
	}
	
	@GetMapping(value="/pacientes/{id}", produces = "application/json")
	public Paciente findById (@PathVariable("id") int id) 
	{
		return this.servicePaciente.findById(id);
	}
	
	@PostMapping(value = "/pacientes", produces = "application/json")
	public ResponseEntity<?> store (@RequestBody Paciente paciente)
	{
		System.out.println("Fecha de nacimiento del paciente: " + paciente.getFecha_nac());
		this.servicePaciente.save(paciente);
		 
		return new ResponseEntity<>(new GetResponse("Se ha agregado un nuevo paciente !!"), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/pacientes/{id}", produces = "application/json")
	public ResponseEntity<?> destroy (@PathVariable("id") int id)
	{
		if(id <= 0)
			return new ResponseEntity<>(new GetResponse("El id no puede ser menor o igual a cero"), HttpStatus.CONFLICT); 
		
		this.servicePaciente.delete(id);
		return new ResponseEntity<>(new GetResponse("Paciente eliminado !!"), HttpStatus.OK);
	}
}

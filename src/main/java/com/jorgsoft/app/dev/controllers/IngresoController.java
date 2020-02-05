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
import com.jorgsoft.app.dev.model.Ingreso;
import com.jorgsoft.app.dev.model.IngresoHabitacion;
import com.jorgsoft.app.dev.model.Paciente;
import com.jorgsoft.app.dev.service.IngresoService;
import com.jorgsoft.app.dev.service.PacienteService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping(value="/api")
public class IngresoController {

	@Autowired
	private IngresoService serviceIngreso;
	
	@Autowired
	private PacienteService servicePaciente;
	
	@GetMapping(value="/ingresos", produces = "application/json")
	public List<Ingreso> getAll ()
	{
		return serviceIngreso.findAll();
	}
	
	@GetMapping(value="/ingresos/{id}", produces = "application/json")
	public ResponseEntity<?> findById (@PathVariable("id") int id)
	{
		Ingreso ingreso = this.serviceIngreso.findById(id);
		if(ingreso == null)
		{
			return new ResponseEntity<>(new GetResponse("Recurso no encontrado !!"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Ingreso>(ingreso, HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/ingresos-habitacion", produces = "application/json")
	public List<IngresoHabitacion> getIngresoHabitacion ()
	{
		return this.serviceIngreso.findIngresoHabitacion();
	}
	
	@PostMapping(value = "/ingresos", produces = "application/json")
	public ResponseEntity<?> store (@RequestBody Ingreso ingreso)
	{
		if (ingreso.getPaciente() == null) {
			return new ResponseEntity<>(new GetResponse("No ha seleccionado un paciente para ingresar !!"), HttpStatus.CONFLICT);
		}
		
		if (ingreso.getHabitacion() == null) {
			return new ResponseEntity<>(new GetResponse("Debe seleccionar una habitación !!"), HttpStatus.CONFLICT);
		}
		
		Paciente paciente = this.servicePaciente.findById(ingreso.getPaciente().getId());
		
		this.serviceIngreso.save(ingreso);
		
		return new ResponseEntity<>(new GetResponse("Se ha ingresado al paciente " + paciente.getNombres() + " " + paciente.getApellidos()), HttpStatus.CREATED); 
	}
	
	public boolean validateNumber (String n)
	{
		boolean valid = false;
		try 
		{
			Integer.parseInt(n);
			valid = true;
		} 
		catch (NumberFormatException e) 
		{
			valid = false;
		}
		
		return valid;
	}
	
	@DeleteMapping(value="/ingresos/{id}", produces = "application/json")
	public ResponseEntity<?> destroy (@PathVariable("id") String id)
	{
		if(id.equals(null) || id.equals(""))
		{
			return new ResponseEntity<>(new GetResponse("Se requiere el id del ingreso para eliminar !!"), HttpStatus.CONFLICT);
		}
		
		if(!this.validateNumber(id))
		{
			return new ResponseEntity<>(new GetResponse("El id debe ser numérico !!"), HttpStatus.CONFLICT);
		}
		
		int idIngreso = Integer.parseInt(id);
		
		if(this.serviceIngreso.findById(idIngreso) == null)
		{
			return new ResponseEntity<>(new GetResponse("Ingreso no encontrado !!"), HttpStatus.NOT_FOUND);
		}
		
		this.serviceIngreso.delete(idIngreso);
		return new ResponseEntity<>(new GetResponse("Ingreso eliminado !!"), HttpStatus.OK);
	}
}

package com.jorgsoft.app.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorgsoft.app.dev.model.Habitacion;
import com.jorgsoft.app.dev.service.HabitacionService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api")
public class HabitacionController {
	
	@Autowired
	private HabitacionService serviceHabitacion;
	
	@GetMapping(value="/habitaciones", produces = "application/json")
	public List<Habitacion> getAll ()
	{
		return serviceHabitacion.findAll();
	}
}

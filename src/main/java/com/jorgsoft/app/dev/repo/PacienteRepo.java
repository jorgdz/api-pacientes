package com.jorgsoft.app.dev.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jorgsoft.app.dev.model.Paciente;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {
	
	@Query("SELECT p FROM Paciente p ORDER BY p.id DESC")
	List<Paciente> findAllOrdered(); 
}

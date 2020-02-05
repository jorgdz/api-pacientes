package com.jorgsoft.app.dev.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jorgsoft.app.dev.model.Ingreso;
import com.jorgsoft.app.dev.model.IngresoHabitacion;

@Repository
public interface IngresoRepo extends JpaRepository<Ingreso, Integer>{
	
	@Query("SELECT new com.jorgsoft.app.dev.model.IngresoHabitacion(i.habitacion.id, i.habitacion.codigo as habitacion, COUNT(i.paciente) as pacientes) FROM Ingreso i GROUP BY (i.habitacion.id, i.habitacion.codigo) ORDER BY i.habitacion.id ASC")
	List<IngresoHabitacion> findIngresoHabitacion();
}

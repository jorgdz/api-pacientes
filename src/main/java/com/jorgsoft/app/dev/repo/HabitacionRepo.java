package com.jorgsoft.app.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgsoft.app.dev.model.Habitacion;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion, Integer>{

}

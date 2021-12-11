package com.vacunautas.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	public Optional<Persona> findBynombreUsuario(String nombreUsuario);
	
}

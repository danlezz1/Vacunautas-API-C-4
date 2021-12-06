package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{

}

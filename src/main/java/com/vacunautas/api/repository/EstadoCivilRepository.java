package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.EstadoCivil;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long>{

}

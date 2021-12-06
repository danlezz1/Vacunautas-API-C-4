package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.EstadoVacunacion;

@Repository
public interface EstadoVacunacionRepository extends JpaRepository<EstadoVacunacion, Long>{

}

package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Institucion;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Long>{

}

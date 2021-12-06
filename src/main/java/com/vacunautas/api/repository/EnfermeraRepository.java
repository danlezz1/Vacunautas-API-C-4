package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Enfermera;

@Repository
public interface EnfermeraRepository extends JpaRepository<Enfermera, Long>{

}

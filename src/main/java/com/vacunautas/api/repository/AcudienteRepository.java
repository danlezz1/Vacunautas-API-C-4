package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Acudiente;

@Repository
public interface AcudienteRepository extends JpaRepository<Acudiente, Long>{

}

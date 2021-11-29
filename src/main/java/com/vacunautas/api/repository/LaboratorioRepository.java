package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Laboratorio;

@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long>{

}

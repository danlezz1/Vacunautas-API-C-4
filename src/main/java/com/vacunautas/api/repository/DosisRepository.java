package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Dosis;

@Repository
public interface DosisRepository extends JpaRepository<Dosis, Long>{

}

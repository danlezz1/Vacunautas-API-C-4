package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.Edad;

@Repository
public interface EdadRepository extends JpaRepository<Edad, Long>{

}

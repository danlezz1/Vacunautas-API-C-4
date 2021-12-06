package com.vacunautas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunautas.api.entity.ViaAplicacion;

@Repository
public interface ViaAplicacionRepository extends JpaRepository<ViaAplicacion, Long>{

}

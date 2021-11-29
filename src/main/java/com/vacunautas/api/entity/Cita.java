package com.vacunautas.api.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "citas")
public class Cita {
	
	@Id
	@Column(name = "idCita", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;
	
	@Column(name = "fecha_cita")
	private LocalDate fecha_cita;
	
	@Column(name = "hora_aplicacion")
	private LocalTime hora_aplicacion;
	
	@Column(name = "fecha_aplicacion")
	private LocalDate fecha_aplicacion;
	
	@Column(name = "comentarios", length = 300)
	private String comentarios;

}
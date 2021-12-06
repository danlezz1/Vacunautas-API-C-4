package com.vacunautas.api.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "id_cita", nullable = false)
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
	
	//Relación con la tabla niños
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_niño", nullable = false, updatable = true, referencedColumnName = "id_niño")
	private Niño niño;
	
	//Relación con la tabla enfermeras
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_enfermera", nullable = false, updatable = true, referencedColumnName = "id_enfermera")
	private Enfermera enfermera;
	
	//Relación con la tabla vacunas
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vacuna", nullable = false, updatable = true, referencedColumnName = "id_vacuna")
	private Vacuna vacuna;
	
	//Relación con la tabla estados vacunación
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estado_vacunacion", nullable = false, updatable = true, referencedColumnName = "id_estado_vacunacion")
	private EstadoVacunacion estadoVacunacion;

}
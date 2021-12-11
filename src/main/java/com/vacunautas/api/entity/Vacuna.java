package com.vacunautas.api.entity;

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
@Table(name = "vacunas")
public class Vacuna {
	
	@Id
	@Column(name = "id_vacuna", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVacuna;
	
	@Column(name = "nombre_vacuna", nullable = false, length = 100)
	private String nombreVacuna;
	
	//Relación con la tabla dosis
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dosis", nullable = false, updatable = true, referencedColumnName = "id_dosis")
	private Dosis dosis;
	
	//Relación con la tabla edades
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_edad", nullable = false, updatable = true, referencedColumnName = "id_edad")
	private Edad edad;
	
	//Relación con la tabla vías aplicación
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_via", nullable = false, updatable = true, referencedColumnName = "id_via")
	private ViaAplicacion viaAplicacion;
	
}

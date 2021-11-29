package com.vacunautas.api.entity;

import javax.persistence.CascadeType;
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
@Table(name = "rel_vacunas_vias_aplicacion")
public class RelVacunaViaAplicacion {

	@Id
	@Column(name = "idRel_Vac_Vias", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRel_Vac_Vias;

	//Relación con la tabla vacunas
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "idVacuna", nullable = false, updatable = false, referencedColumnName = "idVacuna")
	private Vacuna vacuna;

	//Relación con la tabla vias de aplicación
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "idVia", nullable = false, updatable = false, referencedColumnName = "idVia")
	private ViaAplicacion via_aplicacion;

}
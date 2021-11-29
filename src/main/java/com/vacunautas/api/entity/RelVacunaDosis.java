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
@Table(name = "rel_vacunas_dosis")
public class RelVacunaDosis {
	
	@Id
	@Column(name = "idRel_Vac_Dosis", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRel_Vac_Dosis;
	
	//relación con la tabla vacunas
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "idVacuna", nullable = false, updatable = false, referencedColumnName = "idVacuna")
	private Vacuna vacuna;
	
	//relación con la tabla dosis
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "idDosis", nullable = false, updatable = false, referencedColumnName = "idDosis")
	private Dosis dosis;

}
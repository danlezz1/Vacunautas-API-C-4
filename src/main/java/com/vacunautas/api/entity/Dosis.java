package com.vacunautas.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "dosis")
public class Dosis {

	@Id
	@Column(name = "idDosis", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDosis;

	@Column(name = "nombre_dosis", nullable = false, length = 25)
	private String nombre_dosis;

	//Relación con la tabla intermedia vacunas_dosis
	@OneToMany(mappedBy = "dosis", cascade = CascadeType.ALL)
	private List<RelVacunaDosis> rel_vacuna_dosis;
}
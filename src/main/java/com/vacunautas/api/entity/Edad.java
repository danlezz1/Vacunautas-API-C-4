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
@Table(name = "edades")
public class Edad {

	@Id
	@Column(name = "idEdad", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEdad;

	@Column(name = "edad", nullable = false, length = 20)
	private String edad;

	//Relación con la tabla intermedia vacunas_edades
	@OneToMany(mappedBy = "edad", cascade = CascadeType.ALL)
	private List<RelVacunaEdad> rel_vacuna_edad;
}

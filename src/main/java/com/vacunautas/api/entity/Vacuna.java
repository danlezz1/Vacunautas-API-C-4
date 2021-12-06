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
@Table(name = "vacunas")
public class Vacuna {
	
	@Id
	@Column(name = "id_vacuna", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVacuna;
	
	@Column(name = "nombre_vacuna", nullable = false, length = 100)
	private String nombre_vacuna;
	
	//Relación con la tabla intermedia vacunas_laboratorios
	//@OneToMany(mappedBy = "vacuna", cascade = CascadeType.ALL)
	//private List<RelVacunaLaboratorio> rel_vacuna_laboratorio; //new ArrayList<RelVacunaLaboratorio>();
	
	//Relación con la tabla intermedia vacunas_dosis
	//@OneToMany(mappedBy = "vacuna", cascade = CascadeType.ALL)
	//private List<RelVacunaDosis> rel_vacuna_dosis;
	
	//Relación con la tabla intermedia vacunas_vias_de_aplicación
	//@OneToMany(mappedBy = "vacuna", cascade = CascadeType.ALL)
	//private List<RelVacunaViaAplicacion> rel_vacuna_vias_aplicacion;
	
	//Relación con la tabla intermedia vacunas_edades
	//@OneToMany(mappedBy = "vacuna", cascade = CascadeType.ALL)
	//private List<RelVacunaEdad> rel_vacuna_edad;
}

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
@Table(name = "vias_aplicacion")
public class ViaAplicacion {

	@Id
	@Column(name = "id_via", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVia;

	@Column(name = "nombre_via", nullable = false, length = 45)
	private String nombre_via;

	//Relación con la tabla intermedia vacunas_vias_de_aplicación
	//@OneToMany(mappedBy = "via_aplicacion", cascade = CascadeType.ALL)
	//private List<RelVacunaViaAplicacion> rel_vacuna_vias_aplicacion;
}

package com.vacunautas.api.entity;

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
@Table(name = "estado_civil")
public class EstadoCivil {
	
	@Id
	@Column(name = "id_estado_civil", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoCivil;
	
	@Column(name = "descripcion", nullable = false, length = 30)
	private String descripcion;

}
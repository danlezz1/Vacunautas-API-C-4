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
@Table(name = "laboratorios")
public class Laboratorio {
	
	@Id
	@Column(name = "id_laboratorio", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLaboratorio;
	
	@Column(name = "nombre_lab", nullable = false, length = 20)
	private String nombre_lab;
	
}

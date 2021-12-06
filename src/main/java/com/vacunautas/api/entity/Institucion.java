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
@Table(name = "instituciones")
public class Institucion {
		
	@Id
	@Column(name = "id_institucion", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInstitucion;
	
	@Column(name = "nombre_institucion", nullable = false, length = 45)
	private String nombre_institucion;

}
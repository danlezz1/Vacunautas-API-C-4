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
@Table(name = "edades")
public class Edad {

	@Id
	@Column(name = "id_edad", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEdad;

	@Column(name = "edad", nullable = false, length = 20)
	private String edad;
	
}

package com.vacunautas.api.entity;

import java.time.LocalDate;

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
@Table(name = "niños")
public class Niño {
	
	@Id
	@Column(name = "id_niño", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNiño;
	
	@Column(name = "identificacion", nullable = false, length = 30)
	private String identificacion;
	
	@Column(name = "primer_nombre", nullable = false, length = 20)
	private String primer_nombre;
	
	@Column(name = "segundo_nombre", length = 20)
	private String segundo_nombre;
	
	@Column(name = "primer_apellido", nullable = false, length = 20)
	private String primer_apellido;
	
	@Column(name = "segundo_apellido", length = 20)
	private String segundo_apellido;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate fecha_nacimiento;
	
	@Column(name = "genero", nullable = false, length = 2)
	private String genero;

}

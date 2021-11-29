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
@Table(name = "acudientes")
public class Acudiente {
	
	@Id
	@Column(name = "idAcudiente", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAcudiente;
	
	@Column(name = "identificacion", nullable = false, length = 30)
	private String identificacion;
	
	@Column(name = "primer_nombre", nullable = false, length = 20)
	private String primer_nombre;
	
	@Column(name = "segundo_nombre", length = 20)
	private String segundo_nombre;
	
	@Column(name = "primer_apellido", length = 20)
	private String primer_apellido;
	
	@Column(name = "segundo_apellido", length = 20)
	private String segundo_apellido;
	
	@Column(name = "telefono", length = 20)
	private String telefono;
	
	@Column(name = "celular", nullable = false, length = 20)
	private String celular;
	
	@Column(name = "direccion", length = 45)
	private String direccion;
	
	@Column(name = "email", length = 45)
	private String email;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate fecha_nacimiento;
	
	@Column(name = "genero", length = 2)
	private String genero;
	
	@Column(name = "estrato")
	private int estrato;

}
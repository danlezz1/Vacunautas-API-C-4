package com.vacunautas.api.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "personas")
public class Persona {

	@Id
	@Column(name = "id_persona", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;

	//Relación con la tabla estado civil
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estado_civil", nullable = false, updatable = true, referencedColumnName = "id_estado_civil")
	private EstadoCivil estadoCivil;
	
	//Relación con la tabla perfiles
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil", nullable = false, updatable = true, referencedColumnName = "id_perfil")
	private Perfil perfil;

	@Column(name = "identificacion", nullable = false, length = 30)
	private String identificacion;

	@Column(name = "primer_nombre", nullable = false, length = 20)
	private String primerNombre;

	@Column(name = "segundo_nombre", length = 20)
	private String segundoNombre;

	@Column(name = "primer_apellido", nullable = false, length = 20)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 20)
	private String segundoApellido;

	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate fechaNacimiento;

	@Column(name = "genero", nullable = false, length = 2)
	private String genero;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "direccion", nullable = false, length = 45)
	private String direccion;

	@Column(name = "estrato")
	private int estrato;

	@Column(name = "email", length = 45)
	private String email;

	@Column(name = "nombre_usuario", nullable = false, length = 100)
	private String nombreUsuario;

	@Column(name = "clave", nullable = false, length = 200)
	private String clave;

}

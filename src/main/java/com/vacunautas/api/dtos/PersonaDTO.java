package com.vacunautas.api.dtos;

import java.time.LocalDate;

import com.vacunautas.api.entity.EstadoCivil;
import com.vacunautas.api.entity.Perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
	
	private Long idPersona;
	private EstadoCivil estadoCivil;
	private Perfil perfil;
	private String identificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private LocalDate fechaNacimiento;
	private String genero;
	private String telefono;
	private String direccion;
	private int estrato;
	private String email;
	private String nombreUsuario;
	private String clave;

}

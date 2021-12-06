package com.vacunautas.api.dtos;

import java.time.LocalDate;

import com.vacunautas.api.entity.EstadoCivil;

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
public class AcudienteDTO {
	
	private Long idAcudiente;
	private EstadoCivil estadoCivil;
	private String identificacion;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String telefono;
	private String celular;
	private String direccion;
	private String email;
	private LocalDate fecha_nacimiento;
	private String genero;
	private int estrato;
	
}

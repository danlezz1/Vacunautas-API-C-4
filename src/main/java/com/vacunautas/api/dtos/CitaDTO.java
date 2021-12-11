package com.vacunautas.api.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.vacunautas.api.entity.EstadoVacunacion;
import com.vacunautas.api.entity.Niño;
import com.vacunautas.api.entity.Persona;
import com.vacunautas.api.entity.Vacuna;

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
public class CitaDTO {
	
	private Long idCita;
	private LocalDate fecha_cita;
	private LocalTime hora_aplicacion;
	private LocalDate fecha_aplicacion;
	private String comentarios;
	private Niño niño;
	private Persona enfermera;
	private Vacuna vacuna;
	private EstadoVacunacion estadoVacunacion;

}

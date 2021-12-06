package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.CitaDTO;
import com.vacunautas.api.entity.Cita;

public class CitaConverter extends AbstractConverter<Cita, CitaDTO>{

	@Override
	public CitaDTO fromEntity(Cita entity) {
		return CitaDTO.builder()
				.idCita(entity.getIdCita())
				.fecha_cita(entity.getFecha_cita())
				.hora_aplicacion(entity.getHora_aplicacion())
				.fecha_aplicacion(entity.getFecha_aplicacion())
				.comentarios(entity.getComentarios())
				.niño(entity.getNiño())
				.enfermera(entity.getEnfermera())
				.vacuna(entity.getVacuna())
				.estadoVacunacion(entity.getEstadoVacunacion())
				.build();
	}

	@Override
	public Cita fromDTO(CitaDTO dto) {
		return Cita.builder()
				.idCita(dto.getIdCita())
				.fecha_cita(dto.getFecha_cita())
				.hora_aplicacion(dto.getHora_aplicacion())
				.fecha_aplicacion(dto.getFecha_aplicacion())
				.comentarios(dto.getComentarios())
				.niño(dto.getNiño())
				.enfermera(dto.getEnfermera())
				.vacuna(dto.getVacuna())
				.estadoVacunacion(dto.getEstadoVacunacion())
				.build();
	}

}

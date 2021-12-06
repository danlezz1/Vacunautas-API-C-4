package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.EstadoVacunacionDTO;
import com.vacunautas.api.entity.EstadoVacunacion;

public class EstadoVacunacionConverter extends AbstractConverter<EstadoVacunacion, EstadoVacunacionDTO>{

	@Override
	public EstadoVacunacionDTO fromEntity(EstadoVacunacion entity) {
		return EstadoVacunacionDTO.builder()
				.idEstadoVacunacion(entity.getIdEstadoVacunacion())
				.estado(entity.getEstado())
				.build();
	}

	@Override
	public EstadoVacunacion fromDTO(EstadoVacunacionDTO dto) {
		return EstadoVacunacion.builder()
				.idEstadoVacunacion(dto.getIdEstadoVacunacion())
				.estado(dto.getEstado())
				.build();
	}

}

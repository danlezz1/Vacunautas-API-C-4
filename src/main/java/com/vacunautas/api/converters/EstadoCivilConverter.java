package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.EstadoCivilDTO;
import com.vacunautas.api.entity.EstadoCivil;

public class EstadoCivilConverter extends AbstractConverter<EstadoCivil, EstadoCivilDTO>{

	@Override
	public EstadoCivilDTO fromEntity(EstadoCivil entity) {
		return EstadoCivilDTO.builder()
				.idEstadoCivil(entity.getIdEstadoCivil())
				.descripcion(entity.getDescripcion())
				.build();
	}

	@Override
	public EstadoCivil fromDTO(EstadoCivilDTO dto) {
		return EstadoCivil.builder()
				.idEstadoCivil(dto.getIdEstadoCivil())
				.descripcion(dto.getDescripcion())
				.build();
	}

}

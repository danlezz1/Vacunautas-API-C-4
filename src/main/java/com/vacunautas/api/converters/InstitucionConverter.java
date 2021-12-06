package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.InstitucionDTO;
import com.vacunautas.api.entity.Institucion;

public class InstitucionConverter extends AbstractConverter<Institucion, InstitucionDTO>{

	@Override
	public InstitucionDTO fromEntity(Institucion entity) {
		return InstitucionDTO.builder()
				.idInstitucion(entity.getIdInstitucion())
				.nombre_institucion(entity.getNombre_institucion())
				.build();
	}

	@Override
	public Institucion fromDTO(InstitucionDTO dto) {
		return Institucion.builder()
				.idInstitucion(dto.getIdInstitucion())
				.nombre_institucion(dto.getNombre_institucion())
				.build();
	}

}

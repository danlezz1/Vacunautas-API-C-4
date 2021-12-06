package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.EdadDTO;
import com.vacunautas.api.entity.Edad;

public class EdadConverter extends AbstractConverter<Edad, EdadDTO>{

	@Override
	public EdadDTO fromEntity(Edad entity) {
		return EdadDTO.builder()
				.idEdad(entity.getIdEdad())
				.edad(entity.getEdad())
				.build();
	}

	@Override
	public Edad fromDTO(EdadDTO dto) {
		return Edad.builder()
				.idEdad(dto.getIdEdad())
				.edad(dto.getEdad())
				.build();
	}

}

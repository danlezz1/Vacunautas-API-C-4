package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.DosisDTO;
import com.vacunautas.api.entity.Dosis;

public class DosisConverter extends AbstractConverter<Dosis, DosisDTO>{

	@Override
	public DosisDTO fromEntity(Dosis entity) {
		return DosisDTO.builder()
				.idDosis(entity.getIdDosis())
				.nombre_dosis(entity.getNombre_dosis())
				.build();
	}

	@Override
	public Dosis fromDTO(DosisDTO dto) {
		return Dosis.builder()
				.idDosis(dto.getIdDosis())
				.nombre_dosis(dto.getNombre_dosis())
				.build();
	}

}

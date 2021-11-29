package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.VacunaDTO;
import com.vacunautas.api.entity.Vacuna;

public class VacunaConverter extends AbstractConverter<Vacuna, VacunaDTO> {

	@Override
	public VacunaDTO fromEntity(Vacuna entity) {
		return VacunaDTO.builder()
				.idVacuna(entity.getIdVacuna())
				.nombre_vacuna(entity.getNombre_vacuna())
				.build();
	}

	@Override
	public Vacuna fromDTO(VacunaDTO dto) {
		return Vacuna.builder()
				.idVacuna(dto.getIdVacuna())
				.nombre_vacuna(dto.getNombre_vacuna())
				.build();
	}

}

package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.VacunaDTO;
import com.vacunautas.api.entity.Vacuna;

public class VacunaConverter extends AbstractConverter<Vacuna, VacunaDTO> {

	@Override
	public VacunaDTO fromEntity(Vacuna entity) {
		return VacunaDTO.builder()
				.idVacuna(entity.getIdVacuna())
				.nombreVacuna(entity.getNombreVacuna())
				.dosis(entity.getDosis())
				.edad(entity.getEdad())
				.viaAplicacion(entity.getViaAplicacion())
				.build();
	}

	@Override
	public Vacuna fromDTO(VacunaDTO dto) {
		return Vacuna.builder()
				.idVacuna(dto.getIdVacuna())
				.nombreVacuna(dto.getNombreVacuna())
				.dosis(dto.getDosis())
				.edad(dto.getEdad())
				.viaAplicacion(dto.getViaAplicacion())
				.build();
	}

}

package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.LaboratorioDTO;
import com.vacunautas.api.entity.Laboratorio;

public class LaboratorioConverter extends AbstractConverter<Laboratorio, LaboratorioDTO>{

	@Override
	public LaboratorioDTO fromEntity(Laboratorio entity) {
		return LaboratorioDTO.builder()
				.idLaboratorio(entity.getIdLaboratorio())
				.nombre_lab(entity.getNombre_lab())
				.build();
	}

	@Override
	public Laboratorio fromDTO(LaboratorioDTO dto) {
		return Laboratorio.builder()
				.idLaboratorio(dto.getIdLaboratorio())
				.nombre_lab(dto.getNombre_lab())
				.build();
	}

}

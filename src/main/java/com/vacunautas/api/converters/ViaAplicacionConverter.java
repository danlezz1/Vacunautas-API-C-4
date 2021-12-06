package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.ViaAplicacionDTO;
import com.vacunautas.api.entity.ViaAplicacion;

public class ViaAplicacionConverter extends AbstractConverter<ViaAplicacion, ViaAplicacionDTO>{

	@Override
	public ViaAplicacionDTO fromEntity(ViaAplicacion entity) {
		return ViaAplicacionDTO.builder()
				.idVia(entity.getIdVia())
				.nombre_via(entity.getNombre_via())
				.build();
	}

	@Override
	public ViaAplicacion fromDTO(ViaAplicacionDTO dto) {
		return ViaAplicacion.builder()
				.idVia(dto.getIdVia())
				.nombre_via(dto.getNombre_via())
				.build();
	}

}

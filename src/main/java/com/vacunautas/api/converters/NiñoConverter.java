package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.NiñoDTO;
import com.vacunautas.api.entity.Niño;

public class NiñoConverter extends AbstractConverter<Niño, NiñoDTO>{

	@Override
	public NiñoDTO fromEntity(Niño entity) {
		return NiñoDTO.builder()
				.idNiño(entity.getIdNiño())
				.identificacion(entity.getIdentificacion())
				.primer_nombre(entity.getPrimer_nombre())
				.segundo_nombre(entity.getSegundo_nombre())
				.primer_apellido(entity.getPrimer_apellido())
				.segundo_apellido(entity.getSegundo_apellido())
				.fecha_nacimiento(entity.getFecha_nacimiento())
				.genero(entity.getGenero())
				.build();
	}

	@Override
	public Niño fromDTO(NiñoDTO dto) {
		return Niño.builder()
				.idNiño(dto.getIdNiño())
				.identificacion(dto.getIdentificacion())
				.primer_nombre(dto.getPrimer_nombre())
				.segundo_nombre(dto.getSegundo_nombre())
				.primer_apellido(dto.getPrimer_apellido())
				.segundo_apellido(dto.getSegundo_apellido())
				.fecha_nacimiento(dto.getFecha_nacimiento())
				.genero(dto.getGenero())
				.build();
	}

}

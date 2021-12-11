package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.PerfilDTO;
import com.vacunautas.api.entity.Perfil;

public class PerfilConverter extends AbstractConverter<Perfil, PerfilDTO>{

	@Override
	public PerfilDTO fromEntity(Perfil entity) {
		return PerfilDTO.builder()
				.idPerfil(entity.getIdPerfil())
				.nombrePerfil(entity.getNombrePerfil())
				.build();
	}

	@Override
	public Perfil fromDTO(PerfilDTO dto) {
		return Perfil.builder()
				.idPerfil(dto.getIdPerfil())
				.nombrePerfil(dto.getNombrePerfil())
				.build();
	}

}

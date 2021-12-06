package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.EnfermeraDTO;
import com.vacunautas.api.entity.Enfermera;

public class EnfermeraConverter extends AbstractConverter<Enfermera, EnfermeraDTO>{

	@Override
	public EnfermeraDTO fromEntity(Enfermera entity) {
		return EnfermeraDTO.builder()
				.idEnfermera(entity.getIdEnfermera())
				.estadoCivil(entity.getEstadoCivil())
				.institucion(entity.getInstitucion())
				.identificacion(entity.getIdentificacion())
				.primer_nombre(entity.getPrimer_nombre())
				.segundo_nombre(entity.getSegundo_nombre())
				.primer_apellido(entity.getPrimer_apellido())
				.segundo_apellido(entity.getSegundo_apellido())
				.telefono(entity.getTelefono())
				.celular(entity.getCelular())
				.direccion(entity.getDireccion())
				.email(entity.getEmail())
				.fecha_nacimiento(entity.getFecha_nacimiento())
				.genero(entity.getGenero())
				.estrato(entity.getEstrato())
				.titulo(entity.getTitulo())
				.build();
	}

	@Override
	public Enfermera fromDTO(EnfermeraDTO dto) {
		return Enfermera.builder()
				.idEnfermera(dto.getIdEnfermera())
				.estadoCivil(dto.getEstadoCivil())
				.institucion(dto.getInstitucion())
				.identificacion(dto.getIdentificacion())
				.primer_nombre(dto.getPrimer_nombre())
				.segundo_nombre(dto.getSegundo_nombre())
				.primer_apellido(dto.getPrimer_apellido())
				.segundo_apellido(dto.getSegundo_apellido())
				.telefono(dto.getTelefono())
				.celular(dto.getCelular())
				.direccion(dto.getDireccion())
				.email(dto.getEmail())
				.fecha_nacimiento(dto.getFecha_nacimiento())
				.genero(dto.getGenero())
				.estrato(dto.getEstrato())
				.titulo(dto.getTitulo())
				.build();
	}

}

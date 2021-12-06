package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.AcudienteDTO;
import com.vacunautas.api.entity.Acudiente;

public class AcudienteConverter extends AbstractConverter<Acudiente, AcudienteDTO>{

	@Override
	public AcudienteDTO fromEntity(Acudiente entity) {
		return AcudienteDTO.builder()
				.idAcudiente(entity.getIdAcudiente())
				.estadoCivil(entity.getEstadoCivil())
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
				.build();
	}

	@Override
	public Acudiente fromDTO(AcudienteDTO dto) {
		return Acudiente.builder()
				.idAcudiente(dto.getIdAcudiente())
				.estadoCivil(dto.getEstadoCivil())
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
				.build();
	}

}

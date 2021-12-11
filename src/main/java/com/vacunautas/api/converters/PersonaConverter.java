package com.vacunautas.api.converters;

import com.vacunautas.api.dtos.PersonaDTO;
import com.vacunautas.api.entity.Persona;

public class PersonaConverter extends AbstractConverter<Persona, PersonaDTO>{

	@Override
	public PersonaDTO fromEntity(Persona entity) {
		return PersonaDTO.builder()
				.idPersona(entity.getIdPersona())
				.estadoCivil(entity.getEstadoCivil())
				.perfil(entity.getPerfil())
				.identificacion(entity.getIdentificacion())
				.primerNombre(entity.getPrimerNombre())
				.segundoNombre(entity.getSegundoNombre())
				.primerApellido(entity.getPrimerApellido())
				.segundoApellido(entity.getSegundoApellido())
				.fechaNacimiento(entity.getFechaNacimiento())
				.genero(entity.getGenero())
				.telefono(entity.getTelefono())
				.direccion(entity.getDireccion())
				.estrato(entity.getEstrato())
				.email(entity.getEmail())
				.nombreUsuario(entity.getNombreUsuario())
				.clave(entity.getClave())
				.build();
	}

	@Override
	public Persona fromDTO(PersonaDTO dto) {
		return Persona.builder()
				.idPersona(dto.getIdPersona())
				.estadoCivil(dto.getEstadoCivil())
				.perfil(dto.getPerfil())
				.identificacion(dto.getIdentificacion())
				.primerNombre(dto.getPrimerNombre())
				.segundoNombre(dto.getSegundoNombre())
				.primerApellido(dto.getPrimerApellido())
				.segundoApellido(dto.getSegundoApellido())
				.fechaNacimiento(dto.getFechaNacimiento())
				.genero(dto.getGenero())
				.telefono(dto.getTelefono())
				.direccion(dto.getDireccion())
				.estrato(dto.getEstrato())
				.email(dto.getEmail())
				.nombreUsuario(dto.getNombreUsuario())
				.clave(dto.getClave())
				.build();
	}

}

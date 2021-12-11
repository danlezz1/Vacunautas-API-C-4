package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Persona;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class PersonaValidator {
	
	public static void comprobar(Persona persona) {
		if(persona.getEstadoCivil() == null) {
			throw new ValidateServiceException("El estado civil de la persona es obligatorio.");
		}
		
		if(persona.getPerfil() == null) {
			throw new ValidateServiceException("El perfil de la persona es obligatorio.");
		}
		
		if(persona.getIdentificacion() == null || persona.getIdentificacion().trim().isEmpty()) {
			throw new ValidateServiceException("El número de identificación de la persona es obligatorio.");
		}
		
		if(persona.getPrimerNombre() == null || persona.getPrimerNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El primer nombre de la persona es obligatorio.");
		}
		
		if(persona.getPrimerApellido() == null || persona.getPrimerApellido().trim().isEmpty()) {
			throw new ValidateServiceException("El primer apellido de la persona es obligatorio.");
		}
		
		if(persona.getFechaNacimiento() == null) {
			throw new ValidateServiceException("La fecha de nacimiento de la persona es obligatoria.");
		}
		
		if(persona.getGenero() == null || persona.getGenero().trim().isEmpty()) {
			throw new ValidateServiceException("El género de la persona es obligatorio.");
		}
		
		if(persona.getDireccion() == null || persona.getDireccion().trim().isEmpty()) {
			throw new ValidateServiceException("La dirección de la persona es obligatoria.");
		}
		
		if(persona.getNombreUsuario() == null || persona.getNombreUsuario().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre de usuario es obligatorio.");
		}
		
		if(persona.getClave() == null || persona.getClave().trim().isEmpty()) {
			throw new ValidateServiceException("La clave o contraseña es obligatoria.");
		}
		
		if(persona.getIdentificacion().length() > 30) {
			throw new ValidateServiceException("El número de identificación excede la cantidad de "
					+ "caracteres permitida, utilice máximo 30 caracteres.");
		}
		
		if(persona.getPrimerNombre().length() > 20) {
			throw new ValidateServiceException("El primer nombre de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(persona.getSegundoNombre().length() > 20) {
			throw new ValidateServiceException("El segundo nombre de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(persona.getPrimerApellido().length() > 20) {
			throw new ValidateServiceException("El primer apellido de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(persona.getSegundoApellido().length() > 20) {
			throw new ValidateServiceException("El segundo apellido de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(persona.getGenero().length() > 2) {
			throw new ValidateServiceException("El género de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 2 caracteres (M - masculino, F - Femenino).");
		}
		
		if(persona.getTelefono().length() >20) {
			throw new ValidateServiceException("El número de teléfono de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(persona.getDireccion().length() > 45) {
			throw new ValidateServiceException("La dirección de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 45 caracteres.");
		}
		
		if(persona.getEmail().length() > 45) {
			throw new ValidateServiceException("El email de la persona excede la cantidad de "
					+ "caracteres permitida, utilice máximo 45 caracteres.");
		}
		
		if(persona.getNombreUsuario().length() > 100) {
			throw new ValidateServiceException("El nombre de usuario excede la cantidad de "
					+ "caracteres permitida, utilice máximo 100 caracteres.");
		}
		
		if(persona.getClave().length() > 200) {
			throw new ValidateServiceException("La clave o contraseña excede la cantidad de "
					+ "caracteres permitida, utilice máximo 200 caracteres.");
		}
		
	}

}

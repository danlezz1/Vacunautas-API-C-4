package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Enfermera;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class EnfermeraValidator {
	
	public static void comprobar(Enfermera enfermera) {
		if(enfermera.getEstadoCivil() == null) {
			throw new ValidateServiceException("El estado civil del enfermer@ es obligatorio.");
		}
		
		if(enfermera.getInstitucion() == null) {
			throw new ValidateServiceException("La institución a la que pertenece el enfermer@ es obligatoria.");
		}
		
		if(enfermera.getIdentificacion() == null || enfermera.getIdentificacion().trim().isEmpty()) {
			throw new ValidateServiceException("El número de identificación del enfermer@ es obligatorio.");	
		}
		
		if(enfermera.getPrimer_nombre() == null || enfermera.getPrimer_nombre().trim().isEmpty()) {
			throw new ValidateServiceException("El primer nombre del enfermer@ es obligatorio.");	
		}
		
		if(enfermera.getCelular() == null || enfermera.getCelular().trim().isEmpty()) {
			throw new ValidateServiceException("El número de celular del enfermer@ es obligatorio.");	
		}
		
		if(enfermera.getFecha_nacimiento() == null) {
			throw new ValidateServiceException("La fecha de nacimiento del enfermer@ es obligatoria.");	
		}
		
		if(enfermera.getTitulo() == null || enfermera.getTitulo().trim().isEmpty()) {
			throw new ValidateServiceException("El título del enfermer@ es obligatoria.");
		}
		
		if(enfermera.getIdentificacion().length() > 30) {
			throw new ValidateServiceException("El número de identificación del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 30 caracteres.");
		}
		
		if(enfermera.getPrimer_nombre().length() > 20) {
			throw new ValidateServiceException("El primer nombre del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(enfermera.getSegundo_nombre().length() > 20) {
			throw new ValidateServiceException("El segundo nombre del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(enfermera.getPrimer_apellido().length() > 20) {
			throw new ValidateServiceException("El primer apellido del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(enfermera.getSegundo_apellido().length() > 20) {
			throw new ValidateServiceException("El segundo apellido del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(enfermera.getTelefono().length() > 20) {
			throw new ValidateServiceException("El número de teléfono del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(enfermera.getCelular().length() > 20) {
			throw new ValidateServiceException("El número de celular del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(enfermera.getDireccion().length() > 45) {
			throw new ValidateServiceException("La dirección del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 45 caracteres.");
		}
		
		if(enfermera.getEmail().length() > 45) {
			throw new ValidateServiceException("El email del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 45 caracteres.");
		}
		
		if(enfermera.getGenero().length() > 2) {
			throw new ValidateServiceException("El género del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 2 caracteres (M - masculino, F - Femenino).");
		}
		
		if(enfermera.getTitulo().length() > 70) {
			throw new ValidateServiceException("El título del enfermer@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 70 caracteres.");
		}
		
	}

}

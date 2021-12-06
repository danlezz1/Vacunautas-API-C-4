package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Niño;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class NiñoValidator {
	
	public static void comprobar(Niño niño) {
		if(niño.getIdentificacion() == null || niño.getIdentificacion().trim().isEmpty()) {
			throw new ValidateServiceException("El número de identificación del niñ@ es obligatorio.");
		}
		
		if(niño.getPrimer_nombre() == null || niño.getPrimer_nombre().trim().isEmpty()) {
			throw new ValidateServiceException("El primer nombre del niñ@ es obligatorio.");
		}
		
		if(niño.getPrimer_apellido() == null || niño.getPrimer_apellido().trim().isEmpty()) {
			throw new ValidateServiceException("El primer apellido del niñ@ es obligatorio.");
		}
		
		if(niño.getFecha_nacimiento() == null) {
			throw new ValidateServiceException("La fecha de nacimiento del niñ@ es obligatoria.");
		}
		
		if(niño.getGenero() == null || niño.getGenero().trim().isEmpty()) {
			throw new ValidateServiceException("El género del niñ@ es obligatorio.");
		}
		
		if(niño.getIdentificacion().length() > 30) {
			throw new ValidateServiceException("El número de identificación del niñ@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 30 caracteres.");
		}
		
		if(niño.getPrimer_nombre().length() > 20) {
			throw new ValidateServiceException("El primer nombre del niñ@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(niño.getSegundo_nombre().length() > 20) {
			throw new ValidateServiceException("El segundo nombre del niñ@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(niño.getPrimer_apellido().length() > 20) {
			throw new ValidateServiceException("El primer apellido del niño@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(niño.getSegundo_apellido().length() > 20) {
			throw new ValidateServiceException("El segundo apellido del niño@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(niño.getGenero().length() > 2) {
			throw new ValidateServiceException("El género del niñ@ excede la cantidad de "
					+ "caracteres permitida, utilice máximo 2 caracteres (M - masculino, F - Femenino).");
		}
	}

}

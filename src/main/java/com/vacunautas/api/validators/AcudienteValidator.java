package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Acudiente;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class AcudienteValidator {
	
	public static void comprobar(Acudiente acudiente) {
		if(acudiente.getEstadoCivil() == null) {
			throw new ValidateServiceException("El estado civil del acudiente es obligatorio.");
		}
		
		if(acudiente.getIdentificacion() == null || acudiente.getIdentificacion().trim().isEmpty()) {
			throw new ValidateServiceException("El número de identificación del acudiente es obligatorio.");	
		}
		
		if(acudiente.getPrimer_nombre() == null || acudiente.getPrimer_nombre().trim().isEmpty()) {
			throw new ValidateServiceException("El primer nombre del acudiente es obligatorio.");	
		}
		
		if(acudiente.getCelular() == null || acudiente.getCelular().trim().isEmpty()) {
			throw new ValidateServiceException("El número de celular del acudiente es obligatorio.");	
		}
		
		if(acudiente.getFecha_nacimiento() == null) {
			throw new ValidateServiceException("La fecha de nacimiento del acudiente es obligatoria.");	
		}
		
		if(acudiente.getIdentificacion().length() > 30) {
			throw new ValidateServiceException("El número de identificación del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 30 caracteres.");
		}
		
		if(acudiente.getPrimer_nombre().length() > 20) {
			throw new ValidateServiceException("El primer nombre del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(acudiente.getSegundo_nombre().length() > 20) {
			throw new ValidateServiceException("El segundo nombre del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(acudiente.getPrimer_apellido().length() > 20) {
			throw new ValidateServiceException("El primer apellido del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(acudiente.getSegundo_apellido().length() > 20) {
			throw new ValidateServiceException("El segundo apellido del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(acudiente.getTelefono().length() > 20) {
			throw new ValidateServiceException("El número de teléfono del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(acudiente.getCelular().length() > 20) {
			throw new ValidateServiceException("El número de celular del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(acudiente.getDireccion().length() > 45) {
			throw new ValidateServiceException("La dirección del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 45 caracteres.");
		}
		
		if(acudiente.getEmail().length() > 45) {
			throw new ValidateServiceException("El email del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 45 caracteres.");
		}
		
		if(acudiente.getGenero().length() > 2) {
			throw new ValidateServiceException("El género del acudiente excede la cantidad de "
					+ "caracteres permitida, utilice máximo 2 caracteres (M - masculino, F - Femenino).");
		}
		
	}

}

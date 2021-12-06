package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Edad;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class EdadValidator {
	
	public static void comprobar(Edad edad) {
		if(edad.getEdad() == null || edad.getEdad().trim().isEmpty()) {
			throw new ValidateServiceException("La edad es obligatoria.");
		}
		
		if(edad.getEdad().length() > 20) {
			throw new ValidateServiceException("La descripción de la edad excede la cantidad de caracteres "
					+ "permitida, utilice máximo 20 caracteres.");
		}
		
	}

}

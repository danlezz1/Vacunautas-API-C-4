package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Institucion;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class InstitucionValidator {
	
	public static void comprobar(Institucion institucion) {
		if(institucion.getNombre_institucion() == null || institucion.getNombre_institucion().trim().isEmpty()) {
			throw new ValidateServiceException("La institución es obligatoria.");
		}
		
		if(institucion.getNombre_institucion().length() > 45) {
			throw new ValidateServiceException("El nombre de la institución excede la cantidad de caracteres "
					+ "permitida, utilice máximo 45 caracteres.");
		}
	}

}

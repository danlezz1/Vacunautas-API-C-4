package com.vacunautas.api.validators;

import com.vacunautas.api.entity.EstadoCivil;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class EstadoCivilValidator {
	
	public static void comprobar(EstadoCivil estadoCivil) {
		if(estadoCivil.getDescripcion() == null || estadoCivil.getDescripcion().trim().isEmpty()) {
			throw new ValidateServiceException("La descripción del estado civil es obligatoria.");
		}
		
		if(estadoCivil.getDescripcion().length() > 30) {
			throw new ValidateServiceException("La descripción del estado civil excede la cantidad de caracteres "
					+ "permitida, utilice máximo 30 caracteres.");
		}
		
	}

}

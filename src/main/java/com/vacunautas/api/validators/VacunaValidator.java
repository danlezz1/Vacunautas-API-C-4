package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Vacuna;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class VacunaValidator {
	
	public static void comprobar(Vacuna vacuna) {
		if(vacuna.getNombre_vacuna() == null || vacuna.getNombre_vacuna().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre de la vacuna es obligatorio.");				
		}
		
		if(vacuna.getNombre_vacuna().length() > 100) {
			throw new ValidateServiceException("El nombre de la vacuna excede la cantidad de caracteres "
					+ "permitida, utilice máximo 100 caracteres.");
		}

	}

}

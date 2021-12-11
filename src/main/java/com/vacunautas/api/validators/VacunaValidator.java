package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Vacuna;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class VacunaValidator {
	
	public static void comprobar(Vacuna vacuna) {
		if(vacuna.getDosis() == null) {
			throw new ValidateServiceException("La dosis de aplicación de la vacuna es obligatoria.");
		}
		
		if(vacuna.getEdad() == null) {
			throw new ValidateServiceException("La edad de aplicación de la vacuna es obligatoria.");
		}
		
		if(vacuna.getViaAplicacion() == null) {
			throw new ValidateServiceException("La vía de aplicación de la vacuna es obligatoria.");
		}
		
		if(vacuna.getNombreVacuna() == null || vacuna.getNombreVacuna().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre de la vacuna es obligatorio.");				
		}
		
		if(vacuna.getNombreVacuna().length() > 100) {
			throw new ValidateServiceException("El nombre de la vacuna excede la cantidad de caracteres "
					+ "permitida, utilice máximo 100 caracteres.");
		}

	}

}

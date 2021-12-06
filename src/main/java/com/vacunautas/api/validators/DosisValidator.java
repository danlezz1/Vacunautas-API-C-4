package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Dosis;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class DosisValidator {
	
	public static void comprobar(Dosis dosis) {
		if(dosis.getNombre_dosis() == null || dosis.getNombre_dosis().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre de la dosis es obligatorio.");
		}
		
		if(dosis.getNombre_dosis().length() > 25){
			throw new ValidateServiceException("El nombre de la dosis excede la cantidad de caracteres "
					+ "permitida, utilice máximo 25 caracteres.");
		}
		
	}

}

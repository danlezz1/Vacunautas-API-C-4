package com.vacunautas.api.validators;

import com.vacunautas.api.entity.ViaAplicacion;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class ViaAplicacionValidator {
	
	public static void comprobar(ViaAplicacion via) {
		if(via.getNombre_via() == null || via.getNombre_via().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre de la vía de aplicación es obligatorio.");
		}
		
		if(via.getNombre_via().length() > 45) {
			throw new ValidateServiceException("El nombre de la vía de aplicación excede la cantidad "
					+ "de caracteres permitida, utilice máximo 45 caracteres.");
		}
	}

}

package com.vacunautas.api.validators;

import com.vacunautas.api.entity.EstadoVacunacion;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class EstadoVacunacionValidator {
	
	public static void comprobar(EstadoVacunacion estadoVacunacion) {
		if(estadoVacunacion.getEstado() == null || estadoVacunacion.getEstado().trim().isEmpty()) {
			throw new ValidateServiceException("El estado de vacunación es obligatoria.");
		}
		
		if(estadoVacunacion.getEstado().length() > 20) {
			throw new ValidateServiceException("La descripción del estado de vacunación excede "
					+ "la cantidad de caracteres permitida, utilice máximo 20 caracteres.");
		}
		
	}

}

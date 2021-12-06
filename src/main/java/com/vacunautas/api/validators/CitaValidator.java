package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Cita;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class CitaValidator {
	
	public static void comprobar(Cita cita) {
		if(cita.getNiño() == null) {
			throw new ValidateServiceException("Debe indicar el niñ@ que asistirá a la cita.");
		}
		
		if(cita.getEnfermera() == null) {
			throw new ValidateServiceException("Debe indicar el enfermer@ que asistirá a la cita.");
		}
		
		if(cita.getVacuna() == null) {
			throw new ValidateServiceException("Debe indicar la vacuna que aplicará en la cita.");
		}
		
		if(cita.getEstadoVacunacion() == null) {
			throw new ValidateServiceException("Debe indicar el estado de la vacuna (APLICADA"
					+ " - NO APLICADA - SIN APLICAR - PROGRAMDA).");
		}
		
		if(cita.getComentarios().length() > 300) {
			throw new ValidateServiceException("El comentario excede la cantidad de "
					+ "caracteres permitida, utilice máximo 300 caracteres.");
		}
		
	}

}

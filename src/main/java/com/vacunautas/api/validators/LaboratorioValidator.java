package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Laboratorio;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class LaboratorioValidator {
	
	public static void comprobar(Laboratorio laboratorio) {
		if(laboratorio.getNombre_lab() == null || laboratorio.getNombre_lab().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre del laboratorio es obligatorio.");				
		}
		
		if(laboratorio.getNombre_lab().length() > 20) {
			throw new ValidateServiceException("El nombre del laboratorio excede la cantidad de caracteres "
					+ "permitida, utilice máximo 20 caracteres.");
		}

	}

}

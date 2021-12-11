package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Perfil;
import com.vacunautas.api.exceptions.ValidateServiceException;

public class PerfilValidator {
	
	public static void comprobar(Perfil perfil) {
		if(perfil.getNombrePerfil() == null || perfil.getNombrePerfil().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre del perfil es obligatoria.");
		}
		
		if(perfil.getNombrePerfil().length() > 100) {
			throw new ValidateServiceException("El nombre del perfil excede la cantidad de caracteres "
					+ "permitida, utilice máximo 100 caracteres.");
		}
		
	}

}

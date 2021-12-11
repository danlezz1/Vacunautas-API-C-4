package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Perfil;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.PerfilRepository;
import com.vacunautas.api.validators.PerfilValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	//Listar todos los perfiles
	public List<Perfil> findAll() {
		try {
			return perfilRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar perfil por ID
	public Perfil findById(Long id) {
		try {
			Perfil perfil = perfilRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El perfil no existe..."));
			return perfil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear perfil
	@Transactional
	public Perfil create(Perfil perfil) {
		try {
			PerfilValidator.comprobar(perfil);
			Perfil newPerfil = perfilRepository.save(perfil);
			return newPerfil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar perfil
	@Transactional
	public Perfil update(Perfil perfil) {
		try {
			PerfilValidator.comprobar(perfil);

			Perfil existePerfil = perfilRepository.findById(perfil.getIdPerfil())
					.orElseThrow(() -> new NotDataFoundException("El perfil no existe..."));

			existePerfil.setNombrePerfil(perfil.getNombrePerfil());

			perfilRepository.save(existePerfil);
			return existePerfil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar perfil
	@Transactional
	public Perfil delete(Long id) {
		try {
			Perfil existePerfil = perfilRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El perfil no existe..."));

			perfilRepository.delete(existePerfil);

			return existePerfil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

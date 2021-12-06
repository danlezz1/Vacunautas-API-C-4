package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Institucion;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.InstitucionRepository;
import com.vacunautas.api.validators.InstitucionValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InstitucionService {

	@Autowired
	private InstitucionRepository institucionRepository;

	//Listar todos las instituciones
	public List<Institucion> findAll() {
		try {
			return institucionRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar institución por ID
	public Institucion findById(Long id) {
		try {
			Institucion institucion = institucionRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La institución no existe..."));
			return institucion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear institución
	@Transactional
	public Institucion create(Institucion institucion) {
		try {
			InstitucionValidator.comprobar(institucion);
			Institucion newInstitucion = institucionRepository.save(institucion);
			return newInstitucion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar institución
	@Transactional
	public Institucion update(Institucion institucion) {
		try {
			InstitucionValidator.comprobar(institucion);

			Institucion existeInstitucion = institucionRepository.findById(institucion.getIdInstitucion())
					.orElseThrow(() -> new NotDataFoundException("La institución no existe..."));

			existeInstitucion.setNombre_institucion(institucion.getNombre_institucion());

			institucionRepository.save(existeInstitucion);
			return existeInstitucion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar institución
	@Transactional
	public Institucion delete(Long id) {
		try {
			Institucion existeInstitucion = institucionRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La institución no existe..."));

			institucionRepository.delete(existeInstitucion);

			return existeInstitucion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

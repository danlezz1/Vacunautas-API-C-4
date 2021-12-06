package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.EstadoCivil;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.EstadoCivilRepository;
import com.vacunautas.api.validators.EstadoCivilValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstadoCivilService {

	@Autowired
	private EstadoCivilRepository estadoCivilRepository;

	//Listar todos los estados civiles
	public List<EstadoCivil> findAll() {
		try {
			return estadoCivilRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar estado civil por ID
	public EstadoCivil findById(Long id) {
		try {
			EstadoCivil estadoCivil = estadoCivilRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El estado civil no existe..."));
			return estadoCivil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear estado civil
	@Transactional
	public EstadoCivil create(EstadoCivil estadoCivil) {
		try {
			EstadoCivilValidator.comprobar(estadoCivil);
			EstadoCivil newEstadoCivil = estadoCivilRepository.save(estadoCivil);
			return newEstadoCivil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar estado civil
	@Transactional
	public EstadoCivil update(EstadoCivil estadoCivil) {
		try {
			EstadoCivilValidator.comprobar(estadoCivil);

			EstadoCivil existeEstadoCivil = estadoCivilRepository.findById(estadoCivil.getIdEstadoCivil())
					.orElseThrow(() -> new NotDataFoundException("El estado civil no existe..."));

			existeEstadoCivil.setDescripcion(estadoCivil.getDescripcion());
			
			estadoCivilRepository.save(existeEstadoCivil);
			return existeEstadoCivil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar estado civil
	@Transactional
	public EstadoCivil delete(Long id) {
		try {
			EstadoCivil existeEstadoCivil = estadoCivilRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El estado civil no existe..."));

			estadoCivilRepository.delete(existeEstadoCivil);

			return existeEstadoCivil;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.EstadoVacunacion;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.EstadoVacunacionRepository;
import com.vacunautas.api.validators.EstadoVacunacionValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstadoVacunacionService {

	@Autowired
	private EstadoVacunacionRepository estadoVacunacionRepository;

	//Listar todos los estados de vacunación
	public List<EstadoVacunacion> findAll() {
		try {
			return estadoVacunacionRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar estado de vacunación por ID
	public EstadoVacunacion findById(Long id) {
		try {
			EstadoVacunacion estadoVacunacion = estadoVacunacionRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El estado de vacunación no existe..."));
			return estadoVacunacion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear estado de vacunación
	@Transactional
	public EstadoVacunacion create(EstadoVacunacion estadoVacunacion) {
		try {
			EstadoVacunacionValidator.comprobar(estadoVacunacion);
			EstadoVacunacion newEstadoVacunacion = estadoVacunacionRepository.save(estadoVacunacion);
			return newEstadoVacunacion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar estado de vacunación
	@Transactional
	public EstadoVacunacion update(EstadoVacunacion estadoVacunacion) {
		try {
			EstadoVacunacionValidator.comprobar(estadoVacunacion);

			EstadoVacunacion existeEstadoVacunacion = estadoVacunacionRepository.findById(estadoVacunacion.getIdEstadoVacunacion())
					.orElseThrow(() -> new NotDataFoundException("El estado de vacunación no existe..."));

			existeEstadoVacunacion.setEstado(estadoVacunacion.getEstado());
			
			estadoVacunacionRepository.save(existeEstadoVacunacion);
			return existeEstadoVacunacion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar estado de vacunación
	@Transactional
	public EstadoVacunacion delete(Long id) {
		try {
			EstadoVacunacion existeEstadoVacunacion = estadoVacunacionRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El estado de vacunación no existe..."));

			estadoVacunacionRepository.delete(existeEstadoVacunacion);

			return existeEstadoVacunacion;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Edad;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.EdadRepository;
import com.vacunautas.api.validators.EdadValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EdadService {

	@Autowired
	private EdadRepository edadRepository;

	//Listar todas las edades
	public List<Edad> findAll() {
		try {
			return edadRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar edad por ID
	public Edad findById(Long id) {
		try {
			Edad edad = edadRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La edad no existe..."));
			return edad;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear edad
	@Transactional
	public Edad create(Edad edad) {
		try {
			EdadValidator.comprobar(edad);
			Edad newEdad = edadRepository.save(edad);
			return newEdad;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar edad
	@Transactional
	public Edad update(Edad edad) {
		try {
			EdadValidator.comprobar(edad);

			Edad existeEdad = edadRepository.findById(edad.getIdEdad())
					.orElseThrow(() -> new NotDataFoundException("La edad no existe..."));

			existeEdad.setEdad(edad.getEdad());
			
			edadRepository.save(existeEdad);
			return existeEdad;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar edad
	@Transactional
	public Edad delete(Long id) {
		try {
			Edad existeEdad = edadRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La edad no existe..."));

			edadRepository.delete(existeEdad);

			return existeEdad;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

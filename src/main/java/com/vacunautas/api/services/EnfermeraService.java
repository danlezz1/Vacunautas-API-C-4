package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Enfermera;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.EnfermeraRepository;
import com.vacunautas.api.validators.EnfermeraValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnfermeraService {

	@Autowired
	private EnfermeraRepository enfermeraRepository;

	//Listar todas las enfermeras
	public List<Enfermera> findAll() {
		try {
			return enfermeraRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar enfermera por ID
	public Enfermera findById(Long id) {
		try {
			Enfermera enfermera = enfermeraRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El enfermer@ no existe..."));
			return enfermera;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear enfermera
	@Transactional
	public Enfermera create(Enfermera enfermera) {
		try {
			EnfermeraValidator.comprobar(enfermera);
			Enfermera newEnfermera = enfermeraRepository.save(enfermera);
			return newEnfermera;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar enfermera
	@Transactional
	public Enfermera update(Enfermera enfermera) {
		try {
			EnfermeraValidator.comprobar(enfermera);

			Enfermera existeEnfermera = enfermeraRepository.findById(enfermera.getIdEnfermera())
					.orElseThrow(() -> new NotDataFoundException("El enfermer@ no existe..."));

			existeEnfermera.setEstadoCivil(enfermera.getEstadoCivil());
			existeEnfermera.setInstitucion(enfermera.getInstitucion());
			existeEnfermera.setIdentificacion(enfermera.getIdentificacion());
			existeEnfermera.setPrimer_nombre(enfermera.getPrimer_nombre());
			existeEnfermera.setSegundo_nombre(enfermera.getSegundo_nombre());
			existeEnfermera.setPrimer_apellido(enfermera.getPrimer_apellido());
			existeEnfermera.setSegundo_apellido(enfermera.getSegundo_apellido());
			existeEnfermera.setTelefono(enfermera.getTelefono());
			existeEnfermera.setCelular(enfermera.getCelular());
			existeEnfermera.setDireccion(enfermera.getDireccion());
			existeEnfermera.setEmail(enfermera.getEmail());
			existeEnfermera.setFecha_nacimiento(enfermera.getFecha_nacimiento());
			existeEnfermera.setGenero(enfermera.getGenero());
			existeEnfermera.setEstrato(enfermera.getEstrato());
			existeEnfermera.setTitulo(enfermera.getTitulo());

			enfermeraRepository.save(existeEnfermera);
			return existeEnfermera;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar enfermera
	@Transactional
	public Enfermera delete(Long id) {
		try {
			Enfermera existeEnfermera = enfermeraRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El enfermer@ no existe..."));

			enfermeraRepository.delete(existeEnfermera);

			return existeEnfermera;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

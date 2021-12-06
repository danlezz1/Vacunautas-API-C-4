package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Acudiente;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.AcudienteRepository;
import com.vacunautas.api.validators.AcudienteValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AcudienteService {

	@Autowired
	private AcudienteRepository acudienteRepository;

	//Listar todos los acudientes
	public List<Acudiente> findAll() {
		try {
			return acudienteRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar acudiente por ID
	public Acudiente findById(Long id) {
		try {
			Acudiente acudiente = acudienteRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El acudiente no existe..."));
			return acudiente;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear acudiente
	@Transactional
	public Acudiente create(Acudiente acudiente) {
		try {
			AcudienteValidator.comprobar(acudiente);
			Acudiente newAcudiente = acudienteRepository.save(acudiente);
			return newAcudiente;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar acudiente
	@Transactional
	public Acudiente update(Acudiente acudiente) {
		try {
			AcudienteValidator.comprobar(acudiente);

			Acudiente existeAcudiente = acudienteRepository.findById(acudiente.getIdAcudiente())
					.orElseThrow(() -> new NotDataFoundException("El acudiente no existe..."));

			existeAcudiente.setEstadoCivil(acudiente.getEstadoCivil());
			existeAcudiente.setIdentificacion(acudiente.getIdentificacion());
			existeAcudiente.setPrimer_nombre(acudiente.getPrimer_nombre());
			existeAcudiente.setSegundo_nombre(acudiente.getSegundo_nombre());
			existeAcudiente.setPrimer_apellido(acudiente.getPrimer_apellido());
			existeAcudiente.setSegundo_apellido(acudiente.getSegundo_apellido());
			existeAcudiente.setTelefono(acudiente.getTelefono());
			existeAcudiente.setCelular(acudiente.getCelular());
			existeAcudiente.setDireccion(acudiente.getDireccion());
			existeAcudiente.setEmail(acudiente.getEmail());
			existeAcudiente.setFecha_nacimiento(acudiente.getFecha_nacimiento());
			existeAcudiente.setGenero(acudiente.getGenero());
			existeAcudiente.setEstrato(acudiente.getEstrato());
			
			acudienteRepository.save(existeAcudiente);
			return existeAcudiente;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar acudiente
	@Transactional
	public Acudiente delete(Long id) {
		try {
			Acudiente existeAcudiente = acudienteRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El acudiente no existe..."));

			acudienteRepository.delete(existeAcudiente);

			return existeAcudiente;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

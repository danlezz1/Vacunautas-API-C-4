package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Cita;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.CitaRepository;
import com.vacunautas.api.validators.CitaValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CitaService {

	@Autowired
	private CitaRepository citaRepository;

	//Listar todas las citas
	public List<Cita> findAll() {
		try {
			return citaRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar cita por ID
	public Cita findById(Long id) {
		try {
			Cita cita = citaRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La cita buscada no existe..."));
			return cita;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear cita
	@Transactional
	public Cita create(Cita cita) {
		try {
			CitaValidator.comprobar(cita);
			Cita newCita = citaRepository.save(cita);
			return newCita;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar cita
	@Transactional
	public Cita update(Cita cita) {
		try {
			CitaValidator.comprobar(cita);

			Cita existeCita = citaRepository.findById(cita.getIdCita())
					.orElseThrow(() -> new NotDataFoundException("La cita buscada no existe..."));

			existeCita.setFecha_cita(cita.getFecha_cita());
			existeCita.setHora_aplicacion(cita.getHora_aplicacion());
			existeCita.setFecha_aplicacion(cita.getFecha_aplicacion());
			existeCita.setComentarios(cita.getComentarios());
			existeCita.setNiño(cita.getNiño());
			existeCita.setEnfermera(cita.getEnfermera());
			existeCita.setVacuna(cita.getVacuna());
			existeCita.setEstadoVacunacion(cita.getEstadoVacunacion());

			citaRepository.save(existeCita);
			return existeCita;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar cita
	@Transactional
	public Cita delete(Long id) {
		try {
			Cita existeCita = citaRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La cita buscada no existe..."));

			citaRepository.delete(existeCita);

			return existeCita;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

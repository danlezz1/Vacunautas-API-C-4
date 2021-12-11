package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Vacuna;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.VacunaRepository;
import com.vacunautas.api.validators.VacunaValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VacunaService {

	@Autowired
	private VacunaRepository vacunaRepository;

	//Listar todas las vacunas
	public List<Vacuna> findAll() {
		try {
			return vacunaRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar vacuna por ID
	public Vacuna findById(Long id) {
		try {
			Vacuna vacuna = vacunaRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La vacuna no existe..."));
			return vacuna;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear vacuna
	@Transactional
	public Vacuna create(Vacuna vacuna) {
		try {
			VacunaValidator.comprobar(vacuna);
			Vacuna newVacuna = vacunaRepository.save(vacuna);
			return newVacuna;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar vacuna
	@Transactional
	public Vacuna update(Vacuna vacuna) {
		try {
			VacunaValidator.comprobar(vacuna);

			Vacuna existeVacuna = vacunaRepository.findById(vacuna.getIdVacuna())
					.orElseThrow(() -> new NotDataFoundException("La vacuna no existe..."));

			existeVacuna.setNombreVacuna(vacuna.getNombreVacuna());
			existeVacuna.setDosis(vacuna.getDosis());
			existeVacuna.setEdad(vacuna.getEdad());
			existeVacuna.setViaAplicacion(vacuna.getViaAplicacion());
			
			vacunaRepository.save(existeVacuna);
			return existeVacuna;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar vacuna
	@Transactional
	public Vacuna delete(Long id) {
		try {
			Vacuna existeVacuna = vacunaRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La vacuna no existe..."));

			vacunaRepository.delete(existeVacuna);

			return existeVacuna;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

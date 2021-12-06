package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Laboratorio;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.LaboratorioRepository;
import com.vacunautas.api.validators.LaboratorioValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	//Listar todos los laboratorios
	public List<Laboratorio> findAll() {
		try {
			return laboratorioRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar laboratorio por ID
	public Laboratorio findById(Long id) {
		try {
			Laboratorio laboratorio = laboratorioRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El laboratorio no existe..."));
			return laboratorio;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear laboratorio
	@Transactional
	public Laboratorio create(Laboratorio laboratorio) {
		try {
			LaboratorioValidator.comprobar(laboratorio);
			Laboratorio newLaboratorio = laboratorioRepository.save(laboratorio);
			return newLaboratorio;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar laboratorio
	@Transactional
	public Laboratorio update(Laboratorio laboratorio) {
		try {
			LaboratorioValidator.comprobar(laboratorio);

			Laboratorio existeLaboratorio = laboratorioRepository.findById(laboratorio.getIdLaboratorio())
					.orElseThrow(() -> new NotDataFoundException("El laboratorio no existe..."));

			existeLaboratorio.setNombre_lab(laboratorio.getNombre_lab());
			
			laboratorioRepository.save(existeLaboratorio);
			return existeLaboratorio;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar laboratorio
	@Transactional
	public Laboratorio delete(Long id) {
		try {
			Laboratorio existeLaboratorio = laboratorioRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El laboratorio no existe..."));

			laboratorioRepository.delete(existeLaboratorio);

			return existeLaboratorio;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

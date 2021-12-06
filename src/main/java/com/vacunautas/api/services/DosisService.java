package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Dosis;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.DosisRepository;
import com.vacunautas.api.validators.DosisValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DosisService {

	@Autowired
	private DosisRepository dosisRepository;

	//Listar todos las dosis
	public List<Dosis> findAll() {
		try {
			return dosisRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar dosis por ID
	public Dosis findById(Long id) {
		try {
			Dosis dosis = dosisRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La dosis no existe..."));
			return dosis;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear dosis
	@Transactional
	public Dosis create(Dosis dosis) {
		try {
			DosisValidator.comprobar(dosis);
			Dosis newDosis = dosisRepository.save(dosis);
			return newDosis;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar dosis
	@Transactional
	public Dosis update(Dosis dosis) {
		try {
			DosisValidator.comprobar(dosis);

			Dosis existeDosis = dosisRepository.findById(dosis.getIdDosis())
					.orElseThrow(() -> new NotDataFoundException("La dosis no existe..."));

			existeDosis.setNombre_dosis(dosis.getNombre_dosis());
			dosisRepository.save(existeDosis);
			
			return existeDosis;
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
	public Dosis delete(Long id) {
		try {
			Dosis existeDosis = dosisRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La dosis no existe..."));

			dosisRepository.delete(existeDosis);

			return existeDosis;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

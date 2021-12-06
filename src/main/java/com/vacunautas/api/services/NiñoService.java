package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.Niño;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.NiñoRepository;
import com.vacunautas.api.validators.NiñoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NiñoService {

	@Autowired
	private NiñoRepository niñoRepository;

	//Listar todos los niños
	public List<Niño> findAll() {
		try {
			return niñoRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar niño por ID
	public Niño findById(Long id) {
		try {
			Niño niño = niñoRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El niñ@ no existe..."));
			return niño;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear niño
	@Transactional
	public Niño create(Niño niño) {
		try {
			NiñoValidator.comprobar(niño);
			Niño newNiño = niñoRepository.save(niño);
			return newNiño;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar niño
	@Transactional
	public Niño update(Niño niño) {
		try {
			NiñoValidator.comprobar(niño);

			Niño existeNiño = niñoRepository.findById(niño.getIdNiño())
					.orElseThrow(() -> new NotDataFoundException("El niñ@ no existe..."));

			existeNiño.setIdentificacion(niño.getIdentificacion());
			existeNiño.setPrimer_nombre(niño.getPrimer_nombre());
			existeNiño.setSegundo_nombre(niño.getSegundo_nombre());
			existeNiño.setPrimer_apellido(niño.getPrimer_apellido());
			existeNiño.setSegundo_apellido(niño.getSegundo_apellido());;
			existeNiño.setFecha_nacimiento(niño.getFecha_nacimiento());
			existeNiño.setGenero(niño.getGenero());

			niñoRepository.save(existeNiño);
			return existeNiño;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar niño
	@Transactional
	public Niño delete(Long id) {
		try {
			Niño existeNiño = niñoRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("El niñ@ no existe..."));

			niñoRepository.delete(existeNiño);

			return existeNiño;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

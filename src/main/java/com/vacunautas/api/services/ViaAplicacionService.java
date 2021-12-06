package com.vacunautas.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.entity.ViaAplicacion;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.ViaAplicacionRepository;
import com.vacunautas.api.validators.ViaAplicacionValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ViaAplicacionService {

	@Autowired
	ViaAplicacionRepository viaAplicacionRepository;

	//Listar todas las vías de aplicación
	public List<ViaAplicacion> findAll() {
		try {
			return viaAplicacionRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar vía de aplicación por ID
	public ViaAplicacion findById(Long id) {
		try {
			ViaAplicacion via = viaAplicacionRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La vía de aplicación no existe..."));
			return via;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear vía de aplicación
	@Transactional
	public ViaAplicacion create(ViaAplicacion via) {
		try {
			ViaAplicacionValidator.comprobar(via);
			ViaAplicacion newVia = viaAplicacionRepository.save(via);
			return newVia;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar vía de aplicación
	@Transactional
	public ViaAplicacion update(ViaAplicacion via) {
		try {
			ViaAplicacionValidator.comprobar(via);

			ViaAplicacion existeVia = viaAplicacionRepository.findById(via.getIdVia())
					.orElseThrow(() -> new NotDataFoundException("La vía de aplicación no existe..."));

			existeVia.setNombre_via(via.getNombre_via());

			viaAplicacionRepository.save(existeVia);
			return existeVia;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar vía de aplicación
	@Transactional
	public ViaAplicacion delete(Long id) {
		try {
			ViaAplicacion existeVia = viaAplicacionRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La vía de aplicación no existe..."));

			viaAplicacionRepository.delete(existeVia);

			return existeVia;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}

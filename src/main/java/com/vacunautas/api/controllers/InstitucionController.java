package com.vacunautas.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vacunautas.api.converters.InstitucionConverter;
import com.vacunautas.api.dtos.InstitucionDTO;
import com.vacunautas.api.entity.Institucion;
import com.vacunautas.api.services.InstitucionService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class InstitucionController {
	
	@Autowired
	private InstitucionService institucionService;
	private InstitucionConverter converter = new InstitucionConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/instituciones")
	public ResponseEntity<WrapperResponse<List<InstitucionDTO>>> findAll() {
		List<Institucion> arregloInstituciones = institucionService.findAll();
		List<InstitucionDTO> arragloInstitucionesDto = converter.fromEntity(arregloInstituciones);
		return new WrapperResponse<>(true, "listado de instituciones encontrado de manera exitosa", arragloInstitucionesDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/instituciones/{id}")
	public ResponseEntity<WrapperResponse<InstitucionDTO>> findById(@PathVariable("id") Long id) {
		Institucion objInstitucion = institucionService.findById(id);
		InstitucionDTO institucionDto = converter.fromEntity(objInstitucion);
		return new WrapperResponse<>(true, "institución encontrada de manera exitosa", institucionDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/instituciones")
	public ResponseEntity<WrapperResponse<InstitucionDTO>> create(@RequestBody InstitucionDTO institucion) {
		Institucion nuevaInstitucion = institucionService.create(converter.fromDTO(institucion));
		InstitucionDTO institucionDto = converter.fromEntity(nuevaInstitucion);
		return new WrapperResponse<>(true, "institución creada de manera exitosa", institucionDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/instituciones")
	public ResponseEntity<WrapperResponse<InstitucionDTO>> update(@RequestBody InstitucionDTO institucion) {
		Institucion existeInstitucion = institucionService.update(converter.fromDTO(institucion));
		InstitucionDTO institucionDto = converter.fromEntity(existeInstitucion);
		return new WrapperResponse<>(true, "institución actualizada de manera exitosa", institucionDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/instituciones/{id}")
	public ResponseEntity<WrapperResponse<InstitucionDTO>> delete(@PathVariable("id") Long id) {
		Institucion institucionEliminada = institucionService.delete(id);
		InstitucionDTO institucionDto = converter.fromEntity(institucionEliminada);
		return new WrapperResponse<>(true, "institución eliminada de manera exitosa", institucionDto)
				.createResponse(HttpStatus.OK);
	}

}

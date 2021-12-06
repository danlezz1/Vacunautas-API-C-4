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

import com.vacunautas.api.converters.EdadConverter;
import com.vacunautas.api.dtos.EdadDTO;
import com.vacunautas.api.entity.Edad;
import com.vacunautas.api.services.EdadService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class EdadController {

	@Autowired
	private EdadService edadService;
	private EdadConverter converter = new EdadConverter();

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/edades")
	public ResponseEntity<WrapperResponse<List<EdadDTO>>> findAll() {
		List<Edad> arregloEdades = edadService.findAll();
		List<EdadDTO> arragloEdadesDto = converter.fromEntity(arregloEdades);
		return new WrapperResponse<>(true, "listado de edades encontrado de manera exitosa", arragloEdadesDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/edades/{id}")
	public ResponseEntity<WrapperResponse<EdadDTO>> findById(@PathVariable("id") Long id) {
		Edad objEdad = edadService.findById(id);
		EdadDTO edadDto = converter.fromEntity(objEdad);
		return new WrapperResponse<>(true, "edad encontrada de manera exitosa", edadDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/edades")
	public ResponseEntity<WrapperResponse<EdadDTO>> create(@RequestBody EdadDTO edad) {
		Edad nuevaEdad = edadService.create(converter.fromDTO(edad));
		EdadDTO edadDto = converter.fromEntity(nuevaEdad);
		return new WrapperResponse<>(true, "edad creada de manera exitosa", edadDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/edades")
	public ResponseEntity<WrapperResponse<EdadDTO>> update(@RequestBody EdadDTO edad) {
		Edad existeEdad = edadService.update(converter.fromDTO(edad));
		EdadDTO edadDto = converter.fromEntity(existeEdad);
		return new WrapperResponse<>(true, "edad actualizada de manera exitosa", edadDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/edades/{id}")
	public ResponseEntity<WrapperResponse<EdadDTO>> delete(@PathVariable("id") Long id) {
		Edad edadEliminada = edadService.delete(id);
		EdadDTO edadDto = converter.fromEntity(edadEliminada);
		return new WrapperResponse<>(true, "edad eliminada de manera exitosa", edadDto)
				.createResponse(HttpStatus.OK);
	}

}

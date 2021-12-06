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

import com.vacunautas.api.converters.EstadoCivilConverter;
import com.vacunautas.api.dtos.EstadoCivilDTO;
import com.vacunautas.api.entity.EstadoCivil;
import com.vacunautas.api.services.EstadoCivilService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class EstadoCivilController {
	
	@Autowired
	private EstadoCivilService estadoCivilService;
	private EstadoCivilConverter converter = new EstadoCivilConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/estadocivil")
	public ResponseEntity<WrapperResponse<List<EstadoCivilDTO>>> findAll() {
		List<EstadoCivil> arregloEstadoCivil = estadoCivilService.findAll();
		List<EstadoCivilDTO> arragloEstadoCivilDto = converter.fromEntity(arregloEstadoCivil);
		return new WrapperResponse<>(true, "listado de etados civiles encontrado de manera exitosa", arragloEstadoCivilDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/estadocivil/{id}")
	public ResponseEntity<WrapperResponse<EstadoCivilDTO>> findById(@PathVariable("id") Long id) {
		EstadoCivil objEstadoCivil = estadoCivilService.findById(id);
		EstadoCivilDTO estadoCivilDto = converter.fromEntity(objEstadoCivil);
		return new WrapperResponse<>(true, "estado civil encontrado de manera exitosa", estadoCivilDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/estadocivil")
	public ResponseEntity<WrapperResponse<EstadoCivilDTO>> create(@RequestBody EstadoCivilDTO estadoCivil) {
		EstadoCivil nuevoEstadoCivil = estadoCivilService.create(converter.fromDTO(estadoCivil));
		EstadoCivilDTO estadoCivilDto = converter.fromEntity(nuevoEstadoCivil);
		return new WrapperResponse<>(true, "estado civil creado de manera exitosa", estadoCivilDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/estadocivil")
	public ResponseEntity<WrapperResponse<EstadoCivilDTO>> update(@RequestBody EstadoCivilDTO estadoCivil) {
		EstadoCivil existeEstadoCivil = estadoCivilService.update(converter.fromDTO(estadoCivil));
		EstadoCivilDTO estadoCivilDto = converter.fromEntity(existeEstadoCivil);
		return new WrapperResponse<>(true, "estado civil actualizado de manera exitosa", estadoCivilDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/estadocivil/{id}")
	public ResponseEntity<WrapperResponse<EstadoCivilDTO>> delete(@PathVariable("id") Long id) {
		EstadoCivil estadoCivilEliminado = estadoCivilService.delete(id);
		EstadoCivilDTO estadoCivilDto = converter.fromEntity(estadoCivilEliminado);
		return new WrapperResponse<>(true, "estado civil eliminado de manera exitosa", estadoCivilDto)
				.createResponse(HttpStatus.OK);
	}

}

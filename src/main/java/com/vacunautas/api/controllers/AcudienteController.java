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

import com.vacunautas.api.converters.AcudienteConverter;
import com.vacunautas.api.dtos.AcudienteDTO;
import com.vacunautas.api.entity.Acudiente;
import com.vacunautas.api.services.AcudienteService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class AcudienteController {

	@Autowired
	private AcudienteService acudienteService;
	private AcudienteConverter converter = new AcudienteConverter();

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/acudientes")
	public ResponseEntity<WrapperResponse<List<AcudienteDTO>>> findAll() {
		List<Acudiente> arregloAcudientes = acudienteService.findAll();
		List<AcudienteDTO> arragloAcudientesDto = converter.fromEntity(arregloAcudientes);
		return new WrapperResponse<>(true, "listado de acudientes encontrado de manera exitosa",
				arragloAcudientesDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/acudientes/{id}")
	public ResponseEntity<WrapperResponse<AcudienteDTO>> findById(@PathVariable("id") Long id) {
		Acudiente objAcudiente = acudienteService.findById(id);
		AcudienteDTO acudienteDto = converter.fromEntity(objAcudiente);
		return new WrapperResponse<>(true, "acudiente encontrado de manera exitosa", acudienteDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/acudientes")
	public ResponseEntity<WrapperResponse<AcudienteDTO>> create(@RequestBody AcudienteDTO acudiente) {
		Acudiente nuevoAcudiente = acudienteService.create(converter.fromDTO(acudiente));
		AcudienteDTO acudienteDto = converter.fromEntity(nuevoAcudiente);
		return new WrapperResponse<>(true, "acudiente creado de manera exitosa", acudienteDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/acudientes")
	public ResponseEntity<WrapperResponse<AcudienteDTO>> update(@RequestBody AcudienteDTO acudiente) {
		Acudiente existeAcudiente = acudienteService.update(converter.fromDTO(acudiente));
		AcudienteDTO acudienteDto = converter.fromEntity(existeAcudiente);
		return new WrapperResponse<>(true, "acudiente actualizado de manera exitosa", acudienteDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/acudientes/{id}")
	public ResponseEntity<WrapperResponse<AcudienteDTO>> delete(@PathVariable("id") Long id) {
		Acudiente acudienteEliminado = acudienteService.delete(id);
		AcudienteDTO acudienteDto = converter.fromEntity(acudienteEliminado);
		return new WrapperResponse<>(true, "acudiente eliminado de manera exitosa", acudienteDto)
				.createResponse(HttpStatus.OK);
	}

}

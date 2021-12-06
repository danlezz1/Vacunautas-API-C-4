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

import com.vacunautas.api.converters.DosisConverter;
import com.vacunautas.api.dtos.DosisDTO;
import com.vacunautas.api.entity.Dosis;
import com.vacunautas.api.services.DosisService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class DosisController {

	@Autowired
	private DosisService dosisService;
	private DosisConverter converter = new DosisConverter();

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/dosis")
	public ResponseEntity<WrapperResponse<List<DosisDTO>>> findAll() {
		List<Dosis> arregloDosis = dosisService.findAll();
		List<DosisDTO> arragloDosisDto = converter.fromEntity(arregloDosis);
		return new WrapperResponse<>(true, "listado de dosis encontrado de manera exitosa",
				arragloDosisDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/dosis/{id}")
	public ResponseEntity<WrapperResponse<DosisDTO>> findById(@PathVariable("id") Long id) {
		Dosis objDosis = dosisService.findById(id);
		DosisDTO dosisDto = converter.fromEntity(objDosis);
		return new WrapperResponse<>(true, "dosis encontrada de manera exitosa", dosisDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/dosis")
	public ResponseEntity<WrapperResponse<DosisDTO>> create(@RequestBody DosisDTO dosis) {
		Dosis nuevaDosis = dosisService.create(converter.fromDTO(dosis));
		DosisDTO dosisDto = converter.fromEntity(nuevaDosis);
		return new WrapperResponse<>(true, "dosis creada de manera exitosa", dosisDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/dosis")
	public ResponseEntity<WrapperResponse<DosisDTO>> update(@RequestBody DosisDTO dosis) {
		Dosis existeDosis = dosisService.update(converter.fromDTO(dosis));
		DosisDTO dosisDto = converter.fromEntity(existeDosis);
		return new WrapperResponse<>(true, "dosis actualizada de manera exitosa", dosisDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/dosis/{id}")
	public ResponseEntity<WrapperResponse<DosisDTO>> delete(@PathVariable("id") Long id) {
		Dosis dosisEliminada = dosisService.delete(id);
		DosisDTO dosisDto = converter.fromEntity(dosisEliminada);
		return new WrapperResponse<>(true, "dosis eliminada de manera exitosa", dosisDto)
				.createResponse(HttpStatus.OK);
	}

}

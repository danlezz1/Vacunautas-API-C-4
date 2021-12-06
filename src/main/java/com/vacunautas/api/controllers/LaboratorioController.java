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

import com.vacunautas.api.converters.LaboratorioConverter;
import com.vacunautas.api.dtos.LaboratorioDTO;
import com.vacunautas.api.entity.Laboratorio;
import com.vacunautas.api.services.LaboratorioService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class LaboratorioController {

	@Autowired
	private LaboratorioService laboratorioService;
	private LaboratorioConverter converter = new LaboratorioConverter();

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/laboratorios")
	public ResponseEntity<WrapperResponse<List<LaboratorioDTO>>> findAll() {
		List<Laboratorio> arregloLaboratorios = laboratorioService.findAll();
		List<LaboratorioDTO> arragloLaboratoriosDto = converter.fromEntity(arregloLaboratorios);
		return new WrapperResponse<>(true, "listado de laboratorios encontrado de manera exitosa",
				arragloLaboratoriosDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/laboratorios/{id}")
	public ResponseEntity<WrapperResponse<LaboratorioDTO>> findById(@PathVariable("id") Long id) {
		Laboratorio objLaboratorio = laboratorioService.findById(id);
		LaboratorioDTO laboratorioDto = converter.fromEntity(objLaboratorio);
		return new WrapperResponse<>(true, "laboratorio encontrado de manera exitosa", laboratorioDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/laboratorios")
	public ResponseEntity<WrapperResponse<LaboratorioDTO>> create(@RequestBody LaboratorioDTO laboratorio) {
		Laboratorio nuevoLaboratorio = laboratorioService.create(converter.fromDTO(laboratorio));
		LaboratorioDTO laboratorioDto = converter.fromEntity(nuevoLaboratorio);
		return new WrapperResponse<>(true, "laboratorio creado de manera exitosa", laboratorioDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/laboratorios")
	public ResponseEntity<WrapperResponse<LaboratorioDTO>> update(@RequestBody LaboratorioDTO laboratorio) {
		Laboratorio existeLaboratorio = laboratorioService.update(converter.fromDTO(laboratorio));
		LaboratorioDTO laboratorioDto = converter.fromEntity(existeLaboratorio);
		return new WrapperResponse<>(true, "laboratorio actualizado de manera exitosa", laboratorioDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/laboratorios/{id}")
	public ResponseEntity<WrapperResponse<LaboratorioDTO>> delete(@PathVariable("id") Long id) {
		Laboratorio laboratorioEliminado = laboratorioService.delete(id);
		LaboratorioDTO laboratorioDto = converter.fromEntity(laboratorioEliminado);
		return new WrapperResponse<>(true, "laboratorio eliminado de manera exitosa", laboratorioDto)
				.createResponse(HttpStatus.OK);
	}

}

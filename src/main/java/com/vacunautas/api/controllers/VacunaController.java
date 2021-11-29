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

import com.vacunautas.api.converters.VacunaConverter;
import com.vacunautas.api.dtos.VacunaDTO;
import com.vacunautas.api.entity.Vacuna;
import com.vacunautas.api.services.VacunaService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class VacunaController {
	
	@Autowired
	private VacunaService vacunaService;
	private VacunaConverter converter = new VacunaConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/vacunas")
	public ResponseEntity<WrapperResponse<List<VacunaDTO>>> findAll() {
		List<Vacuna> arregloVacunas = vacunaService.findAll();
		List<VacunaDTO> arragloVacunasDto = converter.fromEntity(arregloVacunas);
		return new WrapperResponse<>(true, "listado de vacunas encontrado de manera exitosa", arragloVacunasDto)
				.createResponse(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/vacunas/{id}")
	public ResponseEntity<WrapperResponse<VacunaDTO>> findById(@PathVariable("id") Long id) {
		Vacuna objVacuna = vacunaService.findById(id);		
		VacunaDTO vacunaDto = converter.fromEntity(objVacuna);
		return new WrapperResponse<>(true, "vacuna encontrada de manera exitosa", vacunaDto).createResponse(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/vacunas")
	public ResponseEntity<WrapperResponse<VacunaDTO>> create(@RequestBody VacunaDTO vacuna) {
		Vacuna nuevaVacuna = vacunaService.create(converter.fromDTO(vacuna));
		VacunaDTO vacunaDto = converter.fromEntity(nuevaVacuna);
		return new WrapperResponse<>(true, "vacuna creada de manera exitosa", vacunaDto).createResponse(HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/vacunas")
	public ResponseEntity<WrapperResponse<VacunaDTO>> update(@RequestBody VacunaDTO vacuna) {
		Vacuna existeVacuna = vacunaService.update(converter.fromDTO(vacuna));
		VacunaDTO vacunaDto = converter.fromEntity(existeVacuna);
		return new WrapperResponse<>(true, "vacuna actualizada de manera exitosa", vacunaDto).createResponse(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/vacunas/{id}")
	public ResponseEntity<WrapperResponse<VacunaDTO>> delete(@PathVariable("id") Long id) {
		Vacuna vacunaEliminada = vacunaService.delete(id);
		VacunaDTO vacunaDto = converter.fromEntity(vacunaEliminada);
		return new WrapperResponse<>(true, "vacuna eliminada de manera exitosa", vacunaDto).createResponse(HttpStatus.OK);
	}
	
}

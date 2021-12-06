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

import com.vacunautas.api.converters.CitaConverter;
import com.vacunautas.api.dtos.CitaDTO;
import com.vacunautas.api.entity.Cita;
import com.vacunautas.api.services.CitaService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	private CitaConverter converter = new CitaConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/citas")
	public ResponseEntity<WrapperResponse<List<CitaDTO>>> findAll() {
		List<Cita> arregloCitas = citaService.findAll();
		List<CitaDTO> arregloCitasDto = converter.fromEntity(arregloCitas);
		return new WrapperResponse<>(true, "listado de citas encontrado de manera exitosa",
				arregloCitasDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/citas/{id}")
	public ResponseEntity<WrapperResponse<CitaDTO>> findById(@PathVariable("id") Long id) {
		Cita objCita = citaService.findById(id);
		CitaDTO citaDto = converter.fromEntity(objCita);
		return new WrapperResponse<>(true, "cita encontrada de manera exitosa", citaDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/citas")
	public ResponseEntity<WrapperResponse<CitaDTO>> create(@RequestBody CitaDTO cita) {
		Cita nuevaCita = citaService.create(converter.fromDTO(cita));
		CitaDTO citaDto = converter.fromEntity(nuevaCita);
		return new WrapperResponse<>(true, "cita agendada de manera exitosa", citaDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/citas")
	public ResponseEntity<WrapperResponse<CitaDTO>> update(@RequestBody CitaDTO cita) {
		Cita existeCita = citaService.update(converter.fromDTO(cita));
		CitaDTO citaDto = converter.fromEntity(existeCita);
		return new WrapperResponse<>(true, "cita actualizada de manera exitosa", citaDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/citas/{id}")
	public ResponseEntity<WrapperResponse<CitaDTO>> delete(@PathVariable("id") Long id) {
		Cita citaEliminada = citaService.delete(id);
		CitaDTO citaDto = converter.fromEntity(citaEliminada);
		return new WrapperResponse<>(true, "cita eliminada de manera exitosa", citaDto)
				.createResponse(HttpStatus.OK);
	}

}

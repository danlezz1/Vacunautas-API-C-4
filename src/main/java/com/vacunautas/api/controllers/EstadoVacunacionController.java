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

import com.vacunautas.api.converters.EstadoVacunacionConverter;
import com.vacunautas.api.dtos.EstadoVacunacionDTO;
import com.vacunautas.api.entity.EstadoVacunacion;
import com.vacunautas.api.services.EstadoVacunacionService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class EstadoVacunacionController {
	
	@Autowired
	private EstadoVacunacionService estadoVacunacionService;
	private EstadoVacunacionConverter converter = new EstadoVacunacionConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/estadovacunacion")
	public ResponseEntity<WrapperResponse<List<EstadoVacunacionDTO>>> findAll() {
		List<EstadoVacunacion> arregloEstadoVacunacion = estadoVacunacionService.findAll();
		List<EstadoVacunacionDTO> arragloLEstadoVacunacionDto = converter.fromEntity(arregloEstadoVacunacion);
		return new WrapperResponse<>(true, "listado de estados de vacunación encontrado de manera exitosa",
				arragloLEstadoVacunacionDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/estadovacunacion/{id}")
	public ResponseEntity<WrapperResponse<EstadoVacunacionDTO>> findById(@PathVariable("id") Long id) {
		EstadoVacunacion objEstadoVacunacion = estadoVacunacionService.findById(id);
		EstadoVacunacionDTO estadoVacunacionDto = converter.fromEntity(objEstadoVacunacion);
		return new WrapperResponse<>(true, "estado de vacunación encontrado de manera exitosa", estadoVacunacionDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/estadovacunacion")
	public ResponseEntity<WrapperResponse<EstadoVacunacionDTO>> create(@RequestBody EstadoVacunacionDTO estadoVacunacion) {
		EstadoVacunacion nuevoEstadoVacunacion = estadoVacunacionService
				.create(converter.fromDTO(estadoVacunacion));
		EstadoVacunacionDTO estadoVacunacionDto = converter.fromEntity(nuevoEstadoVacunacion);
		return new WrapperResponse<>(true, "estado de vacunación creado de manera exitosa", estadoVacunacionDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/estadovacunacion")
	public ResponseEntity<WrapperResponse<EstadoVacunacionDTO>> update(@RequestBody EstadoVacunacionDTO estadoVacunacion) {
		EstadoVacunacion existeStadoVacunacion = estadoVacunacionService
				.update(converter.fromDTO(estadoVacunacion));
		EstadoVacunacionDTO estadoVacunacionDto = converter.fromEntity(existeStadoVacunacion);
		return new WrapperResponse<>(true, "estado de vacunación actualizado de manera exitosa", estadoVacunacionDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/estadovacunacion/{id}")
	public ResponseEntity<WrapperResponse<EstadoVacunacionDTO>> delete(@PathVariable("id") Long id) {
		EstadoVacunacion estadoVacunacionEliminado = estadoVacunacionService.delete(id);
		EstadoVacunacionDTO estadoVacunacionDto = converter.fromEntity(estadoVacunacionEliminado);
		return new WrapperResponse<>(true, "estado de vacunación eliminado de manera exitosa", estadoVacunacionDto)
				.createResponse(HttpStatus.OK);
	}

}

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

import com.vacunautas.api.converters.EnfermeraConverter;
import com.vacunautas.api.dtos.EnfermeraDTO;
import com.vacunautas.api.entity.Enfermera;
import com.vacunautas.api.services.EnfermeraService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class EnfermeraController {
	
	@Autowired
	private EnfermeraService enfermeraService;
	private EnfermeraConverter converter = new EnfermeraConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/enfermeras")
	public ResponseEntity<WrapperResponse<List<EnfermeraDTO>>> findAll() {
		List<Enfermera> arregloEnfermeras = enfermeraService.findAll();
		List<EnfermeraDTO> arragloEnfermerasDto = converter.fromEntity(arregloEnfermeras);
		return new WrapperResponse<>(true, "listado de enfermer@s encontrado de manera exitosa",
				arragloEnfermerasDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/enfermeras/{id}")
	public ResponseEntity<WrapperResponse<EnfermeraDTO>> findById(@PathVariable("id") Long id) {
		Enfermera objEnfermera = enfermeraService.findById(id);
		EnfermeraDTO enfermeraDto = converter.fromEntity(objEnfermera);
		return new WrapperResponse<>(true, "enfermer@ encontrad@ de manera exitosa", enfermeraDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/enfermeras")
	public ResponseEntity<WrapperResponse<EnfermeraDTO>> create(@RequestBody EnfermeraDTO enfermera) {
		Enfermera nuevaEnfermera = enfermeraService.create(converter.fromDTO(enfermera));
		EnfermeraDTO enfermeraDto = converter.fromEntity(nuevaEnfermera);
		return new WrapperResponse<>(true, "enfermer@ cread@ de manera exitosa", enfermeraDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/enfermeras")
	public ResponseEntity<WrapperResponse<EnfermeraDTO>> update(@RequestBody EnfermeraDTO enfermera) {
		Enfermera existeEnfermera = enfermeraService.update(converter.fromDTO(enfermera));
		EnfermeraDTO enfermeraDto = converter.fromEntity(existeEnfermera);
		return new WrapperResponse<>(true, "enfermer@ actualizad@ de manera exitosa", enfermeraDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/enfermeras/{id}")
	public ResponseEntity<WrapperResponse<EnfermeraDTO>> delete(@PathVariable("id") Long id) {
		Enfermera enfermeraEliminada = enfermeraService.delete(id);
		EnfermeraDTO enfermeraDto = converter.fromEntity(enfermeraEliminada);
		return new WrapperResponse<>(true, "enfermer@ eliminad@ de manera exitosa", enfermeraDto)
				.createResponse(HttpStatus.OK);
	}

}

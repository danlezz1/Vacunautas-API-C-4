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

import com.vacunautas.api.converters.ViaAplicacionConverter;
import com.vacunautas.api.dtos.ViaAplicacionDTO;
import com.vacunautas.api.entity.ViaAplicacion;
import com.vacunautas.api.services.ViaAplicacionService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class ViaAplicacionController {
	
	@Autowired
	private ViaAplicacionService viaService;
	private ViaAplicacionConverter converter = new ViaAplicacionConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/viasaplicacion")
	public ResponseEntity<WrapperResponse<List<ViaAplicacionDTO>>> findAll() {
		List<ViaAplicacion> arregloVias = viaService.findAll();
		List<ViaAplicacionDTO> arragloViasDto = converter.fromEntity(arregloVias);
		return new WrapperResponse<>(true, "listado de vías de aplicación encontrado de manera exitosa", arragloViasDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/viasaplicacion/{id}")
	public ResponseEntity<WrapperResponse<ViaAplicacionDTO>> findById(@PathVariable("id") Long id) {
		ViaAplicacion objVia = viaService.findById(id);
		ViaAplicacionDTO viaDto = converter.fromEntity(objVia);
		return new WrapperResponse<>(true, "vía de aplicación encontrada de manera exitosa", viaDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/viasaplicacion")
	public ResponseEntity<WrapperResponse<ViaAplicacionDTO>> create(@RequestBody ViaAplicacionDTO via) {
		ViaAplicacion nuevaVia = viaService.create(converter.fromDTO(via));
		ViaAplicacionDTO viaDto = converter.fromEntity(nuevaVia);
		return new WrapperResponse<>(true, "vía de aplicación creada de manera exitosa", viaDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/viasaplicacion")
	public ResponseEntity<WrapperResponse<ViaAplicacionDTO>> update(@RequestBody ViaAplicacionDTO via) {
		ViaAplicacion existeVia = viaService.update(converter.fromDTO(via));
		ViaAplicacionDTO viaDto = converter.fromEntity(existeVia);
		return new WrapperResponse<>(true, "vía de aplicación actualizada de manera exitosa", viaDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/viasaplicacion/{id}")
	public ResponseEntity<WrapperResponse<ViaAplicacionDTO>> delete(@PathVariable("id") Long id) {
		ViaAplicacion viaEliminada = viaService.delete(id);
		ViaAplicacionDTO viaDto = converter.fromEntity(viaEliminada);
		return new WrapperResponse<>(true, "vía de aplicación eliminada de manera exitosa", viaDto)
				.createResponse(HttpStatus.OK);
	}

}

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

import com.vacunautas.api.converters.NiñoConverter;
import com.vacunautas.api.dtos.NiñoDTO;
import com.vacunautas.api.entity.Niño;
import com.vacunautas.api.services.NiñoService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class NiñoController {
	
	@Autowired
	private NiñoService niñoService;
	private NiñoConverter converter = new NiñoConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/niños")
	public ResponseEntity<WrapperResponse<List<NiñoDTO>>> findAll() {
		List<Niño> arregloNiños = niñoService.findAll();
		List<NiñoDTO> arragloNiñosDto = converter.fromEntity(arregloNiños);
		return new WrapperResponse<>(true, "listado de niñ@s encontrado de manera exitosa",
				arragloNiñosDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/niños/{id}")
	public ResponseEntity<WrapperResponse<NiñoDTO>> findById(@PathVariable("id") Long id) {
		Niño objNiño = niñoService.findById(id);
		NiñoDTO niñoDto = converter.fromEntity(objNiño);
		return new WrapperResponse<>(true, "niñ@ encontrad@ de manera exitosa", niñoDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/niños")
	public ResponseEntity<WrapperResponse<NiñoDTO>> create(@RequestBody NiñoDTO niño) {
		Niño nuevoNiño = niñoService.create(converter.fromDTO(niño));
		NiñoDTO niñoDto = converter.fromEntity(nuevoNiño);
		return new WrapperResponse<>(true, "niñ@ cread@ de manera exitosa", niñoDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/niños")
	public ResponseEntity<WrapperResponse<NiñoDTO>> update(@RequestBody NiñoDTO niño) {
		Niño existeNiño = niñoService.update(converter.fromDTO(niño));
		NiñoDTO niñoDto = converter.fromEntity(existeNiño);
		return new WrapperResponse<>(true, "niño@ actualizad@ de manera exitosa", niñoDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/niños/{id}")
	public ResponseEntity<WrapperResponse<NiñoDTO>> delete(@PathVariable("id") Long id) {
		Niño niñoEliminado = niñoService.delete(id);
		NiñoDTO niñoDto = converter.fromEntity(niñoEliminado);
		return new WrapperResponse<>(true, "niñ@ eliminad@ de manera exitosa", niñoDto)
				.createResponse(HttpStatus.OK);
	}

}

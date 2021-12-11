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

import com.vacunautas.api.converters.PersonaConverter;
import com.vacunautas.api.dtos.LoginRequestDTO;
import com.vacunautas.api.dtos.LoginResponseDTO;
import com.vacunautas.api.dtos.PersonaDTO;
import com.vacunautas.api.entity.Persona;
import com.vacunautas.api.services.PersonaService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	private PersonaConverter converter = new PersonaConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/personas")
	public ResponseEntity<WrapperResponse<List<PersonaDTO>>> findAll() {
		List<Persona> arregloPersonas = personaService.findAll();
		List<PersonaDTO> arregloPersonasDto = converter.fromEntity(arregloPersonas);
		return new WrapperResponse<>(true, "listado de personas encontrado de manera exitosa",
				arregloPersonasDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/personas/{id}")
	public ResponseEntity<WrapperResponse<PersonaDTO>> findById(@PathVariable("id") Long id) {
		Persona objPersona = personaService.findById(id);
		PersonaDTO personaDto = converter.fromEntity(objPersona);
		return new WrapperResponse<>(true, "persona encontrada de manera exitosa", personaDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/personas")
	public ResponseEntity<WrapperResponse<PersonaDTO>> create(@RequestBody PersonaDTO persona) {
		Persona nuevaPersona = personaService.create(converter.fromDTO(persona));
		PersonaDTO personaDto = converter.fromEntity(nuevaPersona);
		return new WrapperResponse<>(true, "persona creada de manera exitosa", personaDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/personas")
	public ResponseEntity<WrapperResponse<PersonaDTO>> update(@RequestBody PersonaDTO persona) {
		Persona existePersona = personaService.update(converter.fromDTO(persona));
		PersonaDTO personaDto = converter.fromEntity(existePersona);
		return new WrapperResponse<>(true, "persona actualizada de manera exitosa", personaDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/personas/{id}")
	public ResponseEntity<WrapperResponse<PersonaDTO>> delete(@PathVariable("id") Long id) {
		Persona personaEliminada = personaService.delete(id);
		PersonaDTO personaDto = converter.fromEntity(personaEliminada);
		return new WrapperResponse<>(true, "persona eliminada de manera exitosa", personaDto)
				.createResponse(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/signUp")
	public ResponseEntity<WrapperResponse<PersonaDTO>> signUp(@RequestBody PersonaDTO persona) {
		Persona nuevaPersona = personaService.signUp(converter.fromDTO(persona));
		PersonaDTO personaDto = converter.fromEntity(nuevaPersona);
		return new WrapperResponse<>(true, "usuario registrado de manera exitosa", personaDto)
				.createResponse(HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/login")
	public ResponseEntity<WrapperResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request) {
		LoginResponseDTO response = personaService.login(request);
		return new WrapperResponse<>(true, "sesión iniciada de manera exitosa", response)
				.createResponse(HttpStatus.OK);
	}
}

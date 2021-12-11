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

import com.vacunautas.api.converters.PerfilConverter;
import com.vacunautas.api.dtos.PerfilDTO;
import com.vacunautas.api.entity.Perfil;
import com.vacunautas.api.services.PerfilService;
import com.vacunautas.api.utils.WrapperResponse;

@RestController
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	private PerfilConverter converter = new PerfilConverter();
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/perfiles")
	public ResponseEntity<WrapperResponse<List<PerfilDTO>>> findAll() {
		List<Perfil> arregloPerfiles = perfilService.findAll();
		List<PerfilDTO> arregloPerfilesDto = converter.fromEntity(arregloPerfiles);
		return new WrapperResponse<>(true, "listado de perfiles encontrado de manera exitosa",
				arregloPerfilesDto).createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/perfiles/{id}")
	public ResponseEntity<WrapperResponse<PerfilDTO>> findById(@PathVariable("id") Long id) {
		Perfil objPerfil = perfilService.findById(id);
		PerfilDTO perfilDto = converter.fromEntity(objPerfil);
		return new WrapperResponse<>(true, "perfil encontrado de manera exitosa", perfilDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/perfiles")
	public ResponseEntity<WrapperResponse<PerfilDTO>> create(@RequestBody PerfilDTO perfil) {
		Perfil nuevoPerfil = perfilService.create(converter.fromDTO(perfil));
		PerfilDTO perfilDto = converter.fromEntity(nuevoPerfil);
		return new WrapperResponse<>(true, "perfil creado de manera exitosa", perfilDto)
				.createResponse(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/perfiles")
	public ResponseEntity<WrapperResponse<PerfilDTO>> update(@RequestBody PerfilDTO perfil) {
		Perfil existePerfil = perfilService.update(converter.fromDTO(perfil));
		PerfilDTO perfilDto = converter.fromEntity(existePerfil);
		return new WrapperResponse<>(true, "perfil actualizado de manera exitosa", perfilDto)
				.createResponse(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/perfiles/{id}")
	public ResponseEntity<WrapperResponse<PerfilDTO>> delete(@PathVariable("id") Long id) {
		Perfil perfilEliminado = perfilService.delete(id);
		PerfilDTO perfilDto = converter.fromEntity(perfilEliminado);
		return new WrapperResponse<>(true, "perfil eliminado de manera exitosa", perfilDto)
				.createResponse(HttpStatus.OK);
	}

}

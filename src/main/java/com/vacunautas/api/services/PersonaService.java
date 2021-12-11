package com.vacunautas.api.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunautas.api.converters.PersonaConverter;
import com.vacunautas.api.dtos.LoginRequestDTO;
import com.vacunautas.api.dtos.LoginResponseDTO;
import com.vacunautas.api.entity.Persona;
import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.repository.PersonaRepository;
import com.vacunautas.api.validators.PersonaValidator;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonaService {
	
	@Value("${jwt.clave}")
	private String jwtSecretKey;

	@Autowired
	private PersonaRepository personaRepository;
	
	private PersonaConverter converter = new PersonaConverter();

	//Listar todas las personas
	public List<Persona> findAll() {
		try {
			return personaRepository.findAll();
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Buscar persona por ID
	public Persona findById(Long id) {
		try {
			Persona persona = personaRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La persona no está registrada..."));
			return persona;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Crear persona
	@Transactional
	public Persona create(Persona persona) {
		try {
			Persona existeUsuario = personaRepository.findBynombreUsuario(persona.getNombreUsuario())
					.orElse(null);
			
			if(existeUsuario != null) {
				throw new ValidateServiceException("El nombre de usuario ya existe.");
			}
			
			PersonaValidator.comprobar(persona);
			Persona newPersona = personaRepository.save(persona);
			return newPersona;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Actualizar persona
	@Transactional
	public Persona update(Persona persona) {
		try {
			PersonaValidator.comprobar(persona);

			Persona existePersona = personaRepository.findById(persona.getIdPersona())
					.orElseThrow(() -> new NotDataFoundException("La persona no está registrada..."));

			existePersona.setEstadoCivil(persona.getEstadoCivil());
			existePersona.setPerfil(persona.getPerfil());
			existePersona.setIdentificacion(persona.getIdentificacion());
			existePersona.setPrimerNombre(persona.getPrimerNombre());
			existePersona.setSegundoNombre(persona.getSegundoNombre());
			existePersona.setPrimerApellido(persona.getPrimerApellido());
			existePersona.setSegundoApellido(persona.getSegundoApellido());
			existePersona.setFechaNacimiento(persona.getFechaNacimiento());
			existePersona.setGenero(persona.getGenero());
			existePersona.setTelefono(persona.getTelefono());
			existePersona.setDireccion(persona.getDireccion());
			existePersona.setEstrato(persona.getEstrato());
			existePersona.setEmail(persona.getEmail());
			existePersona.setNombreUsuario(persona.getNombreUsuario());
			existePersona.setClave(persona.getClave());

			personaRepository.save(existePersona);
			return existePersona;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Eliminar persona
	@Transactional
	public Persona delete(Long id) {
		try {
			Persona existePersona = personaRepository.findById(id)
					.orElseThrow(() -> new NotDataFoundException("La persona no está registrada..."));

			personaRepository.delete(existePersona);

			return existePersona;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	//Registrar usuario
	@Transactional
	public Persona signUp(Persona persona) {
		try {
			Persona existeUsuario = personaRepository.findBynombreUsuario(persona.getNombreUsuario())
					.orElse(null);
			
			if(existeUsuario != null) {
				throw new ValidateServiceException("El nombre de usuario ya existe.");
			}
			
			PersonaValidator.comprobar(persona);
			Persona newPersona = personaRepository.save(persona);
			return newPersona;
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	//Loguear Usuario
	public LoginResponseDTO login(LoginRequestDTO request) {
		
		try {
			
			//Validar que exista el usuario en la base de datos
			Persona usuario = personaRepository.findBynombreUsuario(request.getNombreUsuario())
					.orElseThrow(() -> new ValidateServiceException("Nombre de usuario o contraseña incorrecta."));
			//Validar que la contraseña sea correcta
			if(!usuario.getClave().equals(request.getClave())) {
				throw new ValidateServiceException("Nombre de usuario o contraseña incorrecta.");
			}
			//Generación de token para el usuario
			String token = createToken(usuario);
			
			return new LoginResponseDTO(converter.fromEntity(usuario), token);
		
		} catch (ValidateServiceException | NotDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	//Crear token
	public String createToken(Persona usuario) {
		Date horaActual = new Date();
		Date horaExpiracion = new Date(horaActual.getTime() + (1000 * 60 * 60));
		
		return Jwts.builder()
				.setSubject(usuario.getNombreUsuario())
				.setIssuedAt(horaActual)
				.setExpiration(horaExpiracion)
				.signWith(SignatureAlgorithm.HS512, jwtSecretKey).compact();
		
	}
	
	//Validar token
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
			return true;
		} catch (UnsupportedJwtException e) {
			log.error("El formato del JWT no coincide con el esperado por la aplicación.");
		} catch (MalformedJwtException e) {
			log.error("El JWT no fue construido de manera correcta y debe ser rechazado.");
		} catch (SignatureException e) {
			log.error("Se produjo un error al generar una nueva firma o al verificar la firma existente del JWT.");
		} catch (ExpiredJwtException e) {
			log.error("El JWT ha expirado, debe loguearse nuevamente en la aplicación.");
		}
		return false;
	}
	
	//Extraer el usuario del token
	public String getJwtNombreUsuario(String jwt) {
		try {
			return Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(jwt).getBody().getSubject();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ValidateServiceException("Token inválido.");
		}
	}

}

package com.vacunautas.api.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vacunautas.api.entity.Persona;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.repository.PersonaRepository;
import com.vacunautas.api.services.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private PersonaService usuarioService;
	
	@Autowired
	private PersonaRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String jwt = getJwtFromRequest(request);
			
			//Validar que el Jwt sea un token
			if(StringUtils.hasText(jwt) && usuarioService.validateToken(jwt)) {
				String nombreUsuario = usuarioService.getJwtNombreUsuario(jwt);
				
				//Verificar que el usuario exista en la base de datos
				Persona usuario = usuarioRepository.findBynombreUsuario(nombreUsuario)
						.orElseThrow(() -> new NotDataFoundException("No existe el usuario."));
				
				//Llamar al listado de autorizaciones del usuario
				UsuarioPrincipal principal = UsuarioPrincipal.create(usuario);
				
				//Clase de Spring boot que se encarga de la autenticación
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
				
				//Inyectar la autenticación al usuario
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
			}
			
		} catch (Exception e) {
			log.error("Error al autenticar al usuario");
		}
		
		//Ejecutar el filtro de las peticiones
		filterChain.doFilter(request, response);
		
	}
	
	//Obtener el token del usuario
	public String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

}

package com.vacunautas.api.dtos;

import com.vacunautas.api.entity.Dosis;
import com.vacunautas.api.entity.Edad;
import com.vacunautas.api.entity.ViaAplicacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacunaDTO {
	
	private Long idVacuna;
	private String nombreVacuna;
	private Dosis dosis;
	private Edad edad;
	private ViaAplicacion viaAplicacion;
	
}

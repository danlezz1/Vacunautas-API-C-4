package com.vacunautas.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "rel_niños_acudientes")
public class RelNiñoAcudiente {
	
	@Id
	@Column(name= "id_rel_niño_acudiente", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRelNiñoAcudiente;
	
	@Column(name = "parentezco", nullable = false, length = 30)
	private String parentezco;
	
	//relación con la tabla niños
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_niño", nullable = false, updatable = false, referencedColumnName = "id_niño")
	private Niño niño;
	
	//relación con la tabla acudientes
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_acudiente", nullable = false, updatable = false, referencedColumnName = "id_acudiente")
	private Acudiente acudiente;
}

package com.BackendPrueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_persona")
public class PersonaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Size(min=3,message = "{nombre.size}")
	@Column(name="nombre", nullable = false, length = 70)
	private String nombre;
	
	@NotEmpty
	@Size(min = 7,max=12, message = "{telefono.size}")
	@Column(name="telefono", nullable = false,length = 12)
	private String telefono;
	
	@NotEmpty
	@Size(min = 8, max=12, message = "{identificacion.size}")
	@Column(name="identificacion", nullable = false, unique = true, length = 12)
	private String identificacion;
	
}

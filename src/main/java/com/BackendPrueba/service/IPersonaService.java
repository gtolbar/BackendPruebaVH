package com.BackendPrueba.service;


import java.util.List;

import com.BackendPrueba.models.PersonaModel;

public interface IPersonaService extends ICRUD<PersonaModel, Integer> {
	
	List<PersonaModel> buscarIdentificacion(String indentifiacion);
}

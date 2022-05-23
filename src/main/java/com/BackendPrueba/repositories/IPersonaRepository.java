package com.BackendPrueba.repositories;

import java.util.List;

import com.BackendPrueba.models.PersonaModel;

public interface IPersonaRepository extends IGenericRepository<PersonaModel, Integer> {
	
	List<PersonaModel> findByIdentificacion(String identificacion);

}

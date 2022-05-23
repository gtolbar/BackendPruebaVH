package com.BackendPrueba.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendPrueba.models.PersonaModel;
import com.BackendPrueba.repositories.IGenericRepository;
import com.BackendPrueba.repositories.IPersonaRepository;
import com.BackendPrueba.service.IPersonaService;

@Service
public class PersonaServiceImpl extends CRUDImpl<PersonaModel, Integer> implements IPersonaService{
	
	@Autowired
	private IPersonaRepository repo;
	
	@Override
	protected IGenericRepository<PersonaModel, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<PersonaModel> buscarIdentificacion(String indentifiacion) {
		// TODO Auto-generated method stub
		return repo.findByIdentificacion(indentifiacion);
	}

}

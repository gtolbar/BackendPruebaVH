package com.BackendPrueba.service.implement;

import java.util.List;

import com.BackendPrueba.repositories.IGenericRepository;
import com.BackendPrueba.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID>{
	
	protected abstract IGenericRepository<T, ID> getRepo();
	
	@Override
	public T registrar(T t) throws Exception{
		return getRepo().save(t);
	}

	@Override
	public T actualizar(T t) throws Exception{
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception{
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception{
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception{
		getRepo().deleteById(id);
	}	

}

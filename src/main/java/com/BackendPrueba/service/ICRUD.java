package com.BackendPrueba.service;

import java.util.List;

public interface ICRUD<T,ID> {
	
	List<T> listar() throws Exception;
	T listarPorId(ID id) throws Exception;
	T registrar(T t) throws Exception;
	T actualizar(T t) throws Exception;
	void eliminar(ID id) throws Exception;

}

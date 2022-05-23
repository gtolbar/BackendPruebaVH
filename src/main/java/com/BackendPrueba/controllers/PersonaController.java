package com.BackendPrueba.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendPrueba.exception.ModeloNotFoundException;
import com.BackendPrueba.models.PersonaModel;
import com.BackendPrueba.service.IPersonaService;

@RestController
@RequestMapping("users")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<PersonaModel>> listar() throws Exception{
		List<PersonaModel> lista = service.listar(); 
		return new ResponseEntity<List<PersonaModel>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonaModel> listarPorId(@PathVariable("id") Integer id) throws Exception{
		PersonaModel obj = service.listarPorId(id); 
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<PersonaModel>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PersonaModel> registrar(@Valid @RequestBody PersonaModel p) throws Exception{
		PersonaModel obj = service.registrar(p); 
		return new ResponseEntity<PersonaModel>(obj,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<PersonaModel> actualizar(@Valid @RequestBody PersonaModel p) throws Exception{
		PersonaModel obj = service.actualizar(p); 
		return new ResponseEntity<PersonaModel>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		PersonaModel obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/identificacion/{iden}")
	public ResponseEntity<List<PersonaModel>> bucarIdentificacion(@PathVariable("iden") String iden) throws Exception{
		List<PersonaModel> lista = service.buscarIdentificacion(iden);
		if(lista.toString()=="[]") {
			return new ResponseEntity<List<PersonaModel>>(lista,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PersonaModel>>(lista,HttpStatus.OK);
	}
	
}

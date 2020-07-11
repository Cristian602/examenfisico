package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.RegistroInsumos;
import com.example.demo.Repositorio.RegistroInsumosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping ("/api/registroinsumos")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class RegistroInsumosControlador {
	@Autowired
	RegistroInsumosRepositorio registroinsumosRepo;
	
	@GetMapping
	public Iterable<RegistroInsumos> getAll() {
		return registroinsumosRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public RegistroInsumos getById(@PathVariable(value="id") Integer id) {
		return registroinsumosRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"RegistroInsumos no encontrado");
			});
	}
	
	@PostMapping
	public RegistroInsumos guardar(@RequestBody RegistroInsumos registroinsumos) {
		return registroinsumosRepo.save(registroinsumos);
	}
	
	@PutMapping
	public RegistroInsumos update(@RequestBody RegistroInsumos registroinsumos) {
		return registroinsumosRepo.save(registroinsumos);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (registroinsumosRepo.findById(id).isPresent()) {
			registroinsumosRepo.delete(registroinsumosRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RegistroInsumos no encontrado");
		}
	}
	
}
package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.Insumos;

import com.example.demo.Repositorio.InsumosRepositorio;

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
@RequestMapping ("/api/insumos")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class InsumosControlador {
	@Autowired
	InsumosRepositorio insumosRepo;
	
	@GetMapping
	public Iterable<Insumos> getAll() {
		return insumosRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public Insumos getById(@PathVariable(value="id") Integer id) {
		return insumosRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Insumo no encontrado");
			});
	}
	
	@PostMapping
	public Insumos guardar(@RequestBody Insumos insumos) {
		return insumosRepo.save(insumos);
	}
	
	@PutMapping
	public Insumos update(@RequestBody Insumos insumos) {
		return insumosRepo.save(insumos);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (insumosRepo.findById(id).isPresent()) {
			insumosRepo.delete(insumosRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insumo no encontrado");
		}
	}
	
}
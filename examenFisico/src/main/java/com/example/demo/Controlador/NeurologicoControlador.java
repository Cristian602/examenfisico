package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.Neurologico;
import com.example.demo.Repositorio.NeurologicoRepositorio;

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
@RequestMapping ("/api/neurologico")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class NeurologicoControlador {
	@Autowired
	NeurologicoRepositorio neurologicoRepo;
	
	@GetMapping
	public Iterable<Neurologico> getAll() {
		return neurologicoRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public Neurologico getById(@PathVariable(value="id") Integer id) {
		return neurologicoRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Neurologico no encontrado");
			});
	}
	
	@PostMapping
	public Neurologico guardar(@RequestBody Neurologico neurologico) {
		return neurologicoRepo.save(neurologico);
	}
	
	@PutMapping
	public Neurologico update(@RequestBody Neurologico neurologico) {
		return neurologicoRepo.save(neurologico);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (neurologicoRepo.findById(id).isPresent()) {
			neurologicoRepo.delete(neurologicoRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Neurologico no encontrado");
		}
	}
	
}
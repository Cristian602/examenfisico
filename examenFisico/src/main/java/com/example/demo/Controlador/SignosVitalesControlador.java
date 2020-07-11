package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.SignosVitales;
import com.example.demo.Repositorio.SignosVitalesRepositorio;

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
@RequestMapping ("/api/signosvitales")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class SignosVitalesControlador {
	@Autowired
	SignosVitalesRepositorio vitalesRepo;
	
	@GetMapping
	public Iterable<SignosVitales> getAll() {
		return vitalesRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public SignosVitales getById(@PathVariable(value="id") Integer id) {
		return vitalesRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Signos vitales no encontrados");
			});
	}
	
	@PostMapping
	public SignosVitales guardar(@RequestBody SignosVitales signosvitales) {
		return vitalesRepo.save(signosvitales);
	}
	
	@PutMapping
	public SignosVitales update(@RequestBody SignosVitales signosvitales) {
		return vitalesRepo.save(signosvitales);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (vitalesRepo.findById(id).isPresent()) {
			vitalesRepo.delete(vitalesRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Signos vitales no encontrado");
		}
	}
	
}
package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.Examen;
import com.example.demo.Repositorio.ExamenRepositorio;

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
@RequestMapping ("/api/examen")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ExamenControlador{
	@Autowired
	ExamenRepositorio examenRepo;
	
	@GetMapping
	public Iterable<Examen> getAll() {
		return examenRepo.findAll();
	}
	
	
	@GetMapping ("/{id}")
	public Examen getById(@PathVariable(value="id") Integer id) {
		return examenRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Examen no encontrado");
			});
	}
	
	@PostMapping
	public Examen guardar(@RequestBody Examen examen) {
		return examenRepo.save(examen);
	}
	
	@PutMapping
	public Examen update(@RequestBody Examen examen) {
		return examenRepo.save(examen);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (examenRepo.findById(id).isPresent()) {
			examenRepo.delete(examenRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Examen no encontrado");
		}
	}
	
}
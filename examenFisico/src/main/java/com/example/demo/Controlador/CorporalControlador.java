package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.Corporal;
import com.example.demo.Repositorio.CorporalRepositorio;

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
@RequestMapping ("/api/corporal")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CorporalControlador {
	@Autowired
	CorporalRepositorio corporalRepo;
	
	@GetMapping
	public Iterable<Corporal> getAll() {
		return corporalRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public Corporal getById(@PathVariable(value="id") Integer id) {
		return corporalRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Corporal no encontrado");
			});
	}
	
	@PostMapping
	public Corporal guardar(@RequestBody Corporal corporal) {
		return corporalRepo.save(corporal);
	}
	
	@PutMapping
	public Corporal update(@RequestBody Corporal corporal) {
		return corporalRepo.save(corporal);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (corporalRepo.findById(id).isPresent()) {
			corporalRepo.delete(corporalRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Corporal no encontrado");
		}
	}
	
}

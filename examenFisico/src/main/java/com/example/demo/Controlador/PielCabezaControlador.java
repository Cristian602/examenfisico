package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.PielCabeza;
import com.example.demo.Repositorio.PielCabezaRepositorio;

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
@RequestMapping ("/api/pielcabeza")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PielCabezaControlador {
	@Autowired
	PielCabezaRepositorio pielcabezaRepo;
	
	@GetMapping
	public Iterable<PielCabeza> getAll() {
		return pielcabezaRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public PielCabeza getById(@PathVariable(value="id") Integer id) {
		return pielcabezaRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PielCabeza no encontrado");
			});
	}
	
	@PostMapping
	public PielCabeza guardar(@RequestBody PielCabeza pielcabeza) {
		return pielcabezaRepo.save(pielcabeza);
	}
	
	@PutMapping
	public PielCabeza update(@RequestBody PielCabeza pielcabeza) {
		return pielcabezaRepo.save(pielcabeza);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (pielcabezaRepo.findById(id).isPresent()) {
			pielcabezaRepo.delete(pielcabezaRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PielCabeza no encontrado");
		}
	}
	
}
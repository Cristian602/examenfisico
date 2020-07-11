package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.Examen_Medico;
import com.example.demo.Repositorio.Examen_MedicoRepositorio;

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
@RequestMapping ("/api/examen_medico")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class Examen_MedicoControlador {
	@Autowired
	Examen_MedicoRepositorio examenmedicoRepo;
	
	@GetMapping
	public Iterable<Examen_Medico> getAll() {
		return examenmedicoRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public Examen_Medico getById(@PathVariable(value="id") Integer id) {
		return examenmedicoRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Examen_Medico no encontrado");
			});
	}
	
	@PostMapping
	public Examen_Medico guardar(@RequestBody Examen_Medico examen_medico) {
		return examenmedicoRepo.save(examen_medico);
	}
	
	@PutMapping
	public Examen_Medico update(@RequestBody Examen_Medico examen_medico) {
		return examenmedicoRepo.save(examen_medico);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (examenmedicoRepo.findById(id).isPresent()) {
			examenmedicoRepo.delete(examenmedicoRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Examen_Medico no encontrado");
		}
	}
	
}

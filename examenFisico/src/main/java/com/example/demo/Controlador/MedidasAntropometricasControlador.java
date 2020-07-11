package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.MedidasAntropometricas;
import com.example.demo.Repositorio.MedidasAntropometricasRepositorio;

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
@RequestMapping ("/api/antropometricas")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class MedidasAntropometricasControlador {
	@Autowired
	MedidasAntropometricasRepositorio antropometricasRepo;
	
	@GetMapping
	public Iterable<MedidasAntropometricas> getAll() {
		return antropometricasRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public MedidasAntropometricas getById(@PathVariable(value="id") Integer id) {
		return antropometricasRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"MedidasAntropometricas no encontrado");
			});
	}
	
	@PostMapping
	public MedidasAntropometricas guardar(@RequestBody MedidasAntropometricas antropometricas) {
		return antropometricasRepo.save(antropometricas);
	}
	
	@PutMapping
	public MedidasAntropometricas update(@RequestBody MedidasAntropometricas antropometricas) {
		return antropometricasRepo.save(antropometricas);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (antropometricasRepo.findById(id).isPresent()) {
			antropometricasRepo.delete(antropometricasRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "MedidasAntropometricas no encontrado");
		}
	}
	
}
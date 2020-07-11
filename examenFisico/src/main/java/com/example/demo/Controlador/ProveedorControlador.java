package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.Proveedor;

import com.example.demo.Repositorio.ProveedorRepositorio;

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
@RequestMapping ("/api/proveedor")
@CrossOrigin (origins="*",methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProveedorControlador {
	@Autowired
	ProveedorRepositorio proveedorRepo;
	
	@GetMapping
	public Iterable<Proveedor> getAll() {
		return proveedorRepo.findAll();
	}
	
	@GetMapping ("/{id}")
	public Proveedor getById(@PathVariable(value="id") Integer id) {
		return proveedorRepo.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Proveedor no encontrado");
			});
	}
	
	@PostMapping
	public Proveedor guardar(@RequestBody Proveedor proveedor) {
		return proveedorRepo.save(proveedor);
	}
	
	@PutMapping
	public Proveedor update(@RequestBody Proveedor proveedor) {
		return proveedorRepo.save(proveedor);
	}
	
	@DeleteMapping ("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if (proveedorRepo.findById(id).isPresent()) {
			proveedorRepo.delete(proveedorRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Proveedor no encontrado");
		}
	}
	
}

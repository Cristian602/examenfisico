package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Modelo.Examen;

@Controller
public class ControladorGeneral {
	@Autowired
	ExamenControlador examenControlador;
	
	@GetMapping({"/", "/index"})
	public String index(Model modelo) {
		modelo.addAttribute("examForm", new Examen());
		modelo.addAttribute("examList", examenControlador.getAll());
		return "index";
	}
	
	
	
	@GetMapping("/acerca")
	public String acercaDe() {
		return "acerca";
	}
}

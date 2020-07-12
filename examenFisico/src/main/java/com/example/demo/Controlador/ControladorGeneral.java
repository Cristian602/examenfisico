package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Modelo.Examen;

@Controller
public class ControladorGeneral {
	@Autowired
	ExamenControlador examenControlador;

	@GetMapping({ "/", "/index" })
	public String index(Model modelo) {
		modelo.addAttribute("examForm", new Examen());
		modelo.addAttribute("examList", examenControlador.getAll());
		return "index";
	}
	
	@GetMapping("/ucuenca")
	public String logoU() {
		return "ucuenca";
	}
	
	@PostMapping({ "/", "/index" })
	public String createExam(@ModelAttribute("examForm") Examen examen, BindingResult result, ModelMap modelo) {
		if (result.hasErrors()) {
			modelo.addAttribute("examForm", examen);
		} else {
			try {
				examenControlador.guardar(examen);
			} catch (Exception e) {
				modelo.addAttribute("erroMessege", e.getMessage());
			}
		}
		return "registro";
	}

	@GetMapping("/acerca")
	public String acercaDe() {
		return "acerca";
	}
}

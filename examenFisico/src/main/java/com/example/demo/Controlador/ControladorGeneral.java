package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Modelo.Examen;
import com.example.demo.Modelo.SignosVitales;

@Controller
public class ControladorGeneral {
	@Autowired
	ExamenControlador examenControlador;
	@Autowired
	SignosVitalesControlador signosVitalesControlador;

	@GetMapping("/ucuenca")
	public String logoU() {
		return "ucuenca";
	}

	@GetMapping({ "/", "/index" })
	public String index(Model modelo) {
		modelo.addAttribute("examForm", new Examen());
		modelo.addAttribute("examList", examenControlador.getAll());
		return "index";
	}

	@PostMapping({ "/", "/index" })
	public String createExam(@ModelAttribute("examForm") Examen examen, BindingResult result, ModelMap modelo) {
		if (result.hasErrors()) {
			modelo.addAttribute("examForm", examen);
		} else {
			try {
				examenControlador.guardar(examen);
			} catch (Exception e) {
				modelo.addAttribute("erroMessage", e.getMessage());
			}
		}
		return "redirect:/signosVitales/" + examen.getId();
	}

	@GetMapping("/signosVitales/{id}")
	public String cargarDatosExamGeneral(Model modelo, @PathVariable(name = "id") Integer id) throws Exception {
		Examen examen = examenControlador.getById(id);
		modelo.addAttribute("examVit", new SignosVitales());
		modelo.addAttribute("examForm", examen);
		return "signosVitales";
	}

	// agregado recientemente
	@PostMapping("/signosVitales/{id}")
	public String createVitales(@ModelAttribute("examVit") SignosVitales signosVitales, BindingResult result,
			ModelMap modelput, @PathVariable(name = "id") Integer id, Model modelget) {
		Examen examen = examenControlador.getById(id);
		modelget.addAttribute("examForm", examen);
		modelput.addAttribute("examForm", examen);
		if (result.hasErrors()) {
			modelput.addAttribute("examVit", signosVitales);
		} else {
			try {
				signosVitalesControlador.guardar(signosVitales);
			} catch (Exception e) {
				modelput.addAttribute("erroMessage", e.getMessage());
			}
		}
		return "redirect:/signosVitales/" + examen.getId();
	}

	@GetMapping("/acerca")
	public String acercaDe() {
		return "acerca";
	}
}

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

import com.example.demo.Modelo.Corporal;
import com.example.demo.Modelo.Examen;
import com.example.demo.Modelo.MedidasAntropometricas;
import com.example.demo.Modelo.Neurologico;
import com.example.demo.Modelo.PielCabeza;
import com.example.demo.Modelo.SignosVitales;

@Controller
public class ControladorGeneral {
	@Autowired
	ExamenControlador examenControlador;
	@Autowired
	SignosVitalesControlador signosVitalesControlador;
	@Autowired
	CorporalControlador corporalControlador;
	@Autowired
	InsumosControlador insumosControlador;
	@Autowired
	MedidasAntropometricasControlador medidasAntropometricasControlador;
	@Autowired
	NeurologicoControlador neurologicoControlador;
	@Autowired
	PielCabezaControlador pielCabezaControlador;
	@Autowired
	ProveedorControlador proveedorControlador;
	@Autowired
	RegistroInsumosControlador registroInsumosControlador;

	// Reconocimiento de la imagen (escudo de la universidad).
	@GetMapping("/ucuenca")
	public String logoU() {
		return "ucuenca";
	}

	// Metodo para acceder al elemento "acerca de"
	@GetMapping("/acerca")
	public String acercaDe() {
		return "acerca";
	}
	
	@GetMapping("/proveedores")
	public String uiProveedores() {
		return "proovedor";
	}
	
	@GetMapping("/insumos")
	public String uiRegistrarInsumo() {
		return "insumos";
	}
	
	@GetMapping("/peticionInsumo")
	public String uiConsumo() {
		return "consumo";
	}

	// Metodos para la pagina principal (registro de un examen toma de datos)
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

	// Metodo para generar vista de signos vitales y subir un nuevo examen
	@GetMapping("/signosVitales/{id}")
	public String cargarDatosExamGeneral(Model modelo, @PathVariable(name = "id") Integer id) throws Exception {
		Examen examen = examenControlador.getById(id);
		modelo.addAttribute("examVit", new SignosVitales());
		modelo.addAttribute("examForm", examen);
		return "signosVitales";
	}

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
		return "redirect:/medidas/" + examen.getId();
	}
	
	// Metodo para generar vista de examen MedidasAntropometricas y subir un nuevo examen
	@GetMapping("/medidas/{id}")
	public String cEAntropometricas(Model modelo, @PathVariable(name = "id") Integer id) throws Exception {
		Examen examen = examenControlador.getById(id);
		modelo.addAttribute("examSub", new MedidasAntropometricas());
		modelo.addAttribute("examForm", examen);
		return "antropometricas";
	}

	@PostMapping("/medidas/{id}")
	public String createMedidas(@ModelAttribute("examSub") MedidasAntropometricas exaEspecific, BindingResult result,
			ModelMap modelput, @PathVariable(name = "id") Integer id, Model modelget) {
		Examen examen = examenControlador.getById(id);
		modelget.addAttribute("examForm", examen);
		modelput.addAttribute("examForm", examen);
		if (result.hasErrors()) {
			modelput.addAttribute("examSub", exaEspecific);
		} else {
			try {
				medidasAntropometricasControlador.guardar(exaEspecific);
			} catch (Exception e) {
				modelput.addAttribute("erroMessage", e.getMessage());
			}
		}
		return "redirect:/corporal/" + examen.getId();
	}

	// Metodo para generar vista de examen corporal y subir un nuevo examen
	@GetMapping("/corporal/{id}")
	public String cECoropral(Model modelo, @PathVariable(name = "id") Integer id) throws Exception {
		Examen examen = examenControlador.getById(id);
		modelo.addAttribute("examSub", new Corporal());
		modelo.addAttribute("examForm", examen);
		return "corporal";
	}

	@PostMapping("/corporal/{id}")
	public String createCorporal(@ModelAttribute("examSub") Corporal exaEspecific, BindingResult result,
			ModelMap modelput, @PathVariable(name = "id") Integer id, Model modelget) {
		Examen examen = examenControlador.getById(id);
		modelget.addAttribute("examForm", examen);
		modelput.addAttribute("examForm", examen);
		if (result.hasErrors()) {
			modelput.addAttribute("examSub", exaEspecific);
		} else {
			try {
				corporalControlador.guardar(exaEspecific);
			} catch (Exception e) {
				modelput.addAttribute("erroMessage", e.getMessage());
			}
		}
		return "redirect:/neurologico/" + examen.getId();
	}

	// Metodo para generar vista de examen neurologico y subir un nuevo examen
	@GetMapping("/neurologico/{id}")
	public String cENeurologico(Model modelo, @PathVariable(name = "id") Integer id) throws Exception {
		Examen examen = examenControlador.getById(id);
		modelo.addAttribute("examSub", new Neurologico());
		modelo.addAttribute("examForm", examen);
		return "neurologico";
	}

	@PostMapping("/neurologico/{id}")
	public String createNeurologico(@ModelAttribute("examSub") Neurologico exaEspecific, BindingResult result,
			ModelMap modelput, @PathVariable(name = "id") Integer id, Model modelget) {
		Examen examen = examenControlador.getById(id);
		modelget.addAttribute("examForm", examen);
		modelput.addAttribute("examForm", examen);
		if (result.hasErrors()) {
			modelput.addAttribute("examSub", exaEspecific);
		} else {
			try {
				neurologicoControlador.guardar(exaEspecific);
			} catch (Exception e) {
				modelput.addAttribute("erroMessage", e.getMessage());
			}
		}
		return "redirect:/piel/" + examen.getId();
	}

	// Metodo para generar vista de examen PielCabeza y subir un nuevo examen
	@GetMapping("/piel/{id}")
	public String cEPielCabeza(Model modelo, @PathVariable(name = "id") Integer id) throws Exception {
		Examen examen = examenControlador.getById(id);
		modelo.addAttribute("examSub", new PielCabeza());
		modelo.addAttribute("examForm", examen);
		return "piel";
	}

	@PostMapping("/piel/{id}")
	public String createPielCabeza(@ModelAttribute("examSub") PielCabeza exaEspecific, BindingResult result,
			ModelMap modelput, @PathVariable(name = "id") Integer id, Model modelget) {
		Examen examen = examenControlador.getById(id);
		modelget.addAttribute("examForm", examen);
		modelput.addAttribute("examForm", examen);
		if (result.hasErrors()) {
			modelput.addAttribute("examSub", exaEspecific);
		} else {
			try {
				pielCabezaControlador.guardar(exaEspecific);
			} catch (Exception e) {
				modelput.addAttribute("erroMessage", e.getMessage());
			}
		}
		return "redirect:/index";
	}
}
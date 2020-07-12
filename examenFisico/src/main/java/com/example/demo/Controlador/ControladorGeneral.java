package com.example.demo.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorGeneral {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/index")
	public String indexs() {
		return "index";
	}
	@GetMapping("/acerca")
	public String acercaDe() {
		return "acerca";
	}
}

package br.com.alura.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oferta")
public class OfertaController {

	
	@GetMapping
	public String getFormularioParaOferta() {
		return "oferta/home";
	}
	
}

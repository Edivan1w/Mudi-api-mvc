package br.com.alura.mvc.controller;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.model.Pedido;

@Controller
public class HomeController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		String query = "select p from Pedido p";
		List<Pedido> pedidos = entityManager.createQuery(query, Pedido.class).getResultList();
		
		
		
		model.addAttribute("pedidos", pedidos);
		return"home";
	}

}

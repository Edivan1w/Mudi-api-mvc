package br.com.alura.mvc.controller;


import java.security.Principal;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.model.StatusPedido;
import br.com.alura.mvc.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping                    //vai acessar os dados do usuário logado.
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findAllByStatus(StatusPedido.APROVADO);
		model.addAttribute("pedidos", pedidos);
		return"home";
	}
	
}

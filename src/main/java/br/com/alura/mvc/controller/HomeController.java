package br.com.alura.mvc.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String home(Model model) {
		
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 2, sort);
		
		List<Pedido> pedidos = pedidoRepository.findAllByStatus(StatusPedido.APROVADO, paginacao);
		model.addAttribute("pedidos", pedidos);
		return"home";
	}
	
}

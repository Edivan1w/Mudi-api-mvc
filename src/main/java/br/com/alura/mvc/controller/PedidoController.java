package br.com.alura.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.model.User;
import br.com.alura.mvc.repository.PedidoRepository;
import br.com.alura.mvc.repository.Userrepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private Userrepository userrepository;

	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido novoPedido){
		return "pedido/formulario";
	}
	
	
	@PostMapping("novo")
	public String novoPedido(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userrepository.findByUsername(userName);
		Pedido pedido = requisicao.toPedido();
		pedido.setUser(user);
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
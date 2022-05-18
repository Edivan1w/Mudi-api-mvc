package br.com.alura.mvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.model.Pedido;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Apple iPhone 13 Pro (256 GB) - Dourado");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51y+xXlXPrL._AC_SX679_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Apple-iPhone-13-Pro-256-GB/dp/B09L1NQ9R1?ref_=Oct_DLandingS_D_880408ea_60&smid=A122ZHUG7SODV0&th=1");
		pedido.setDescricao("Tela Super Retina XDR de 6,1 polegadas com ProMotion para uma sensação mais rápida e responsiva");
		
		List<Pedido>pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		return"home";
	}

}

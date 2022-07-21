package br.com.alura.mvc.api;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.model.StatusPedido;
import br.com.alura.mvc.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class Pedidosrest {

	private final PedidoRepository pedidoRepository;

	public Pedidosrest(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@GetMapping("/aguardando")
	public List<Pedido> findAll(){
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 2, sort);
		
		return pedidoRepository.findAllByStatus(StatusPedido.AGUARDANDO, paginacao);
	}

}

package br.com.alura.mvc.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUser(@Param("username") String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username") String username);

	@Cacheable("pedidos")
	List<Pedido> findAllByStatus(StatusPedido aprovado, Pageable paginacao);

	
	
}

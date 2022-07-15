package br.com.alura.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mvc.model.User;

public interface Userrepository extends JpaRepository<User, String> {
	
	User findByUsername(String username);
	
	

}

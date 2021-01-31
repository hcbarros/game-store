package br.com.supera.game.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.supera.game.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
		
	List<Product> findAllByOrderByPrice();
	
	List<Product> findAllByOrderByScore();
	
	List<Product> findAllByOrderByName();
}
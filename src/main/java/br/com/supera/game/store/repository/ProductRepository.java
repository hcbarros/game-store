package br.com.supera.game.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.supera.game.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
		
	@Query(value = "select * from product order by price", nativeQuery = true)
	public List<Product> findAllOrderByPrice();

	@Query(value = "select * from product order by score", nativeQuery = true)
	public List<Product> findAllOrderByScore();
	
	@Query(value = "select * from product order by name", nativeQuery = true)
	public List<Product> findAllOrderByName();
}
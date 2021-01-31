package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.supera.game.store.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
}
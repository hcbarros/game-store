package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import br.com.supera.game.store.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Transactional
	@Modifying
	@Query("delete from cart c where c.total = 0")
	void deleteEmptyCart();
}
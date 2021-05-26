package br.com.supera.game.store.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.CartRepository;
import br.com.supera.game.store.repository.ProductRepository;


@Service
public class GameStoreService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public Cart updateCart(Long id, Product p) {
		
		Cart c = cartRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException());
		
		c = c.addProduct(p);
		return cartRepository.save(c);
	}
	
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}
	
	
	public Cart getCart(Long cartId) {
		return cartRepository
				.findById(cartId)
				.orElseThrow(() -> new EntityNotFoundException());
	}
			
	public Cart getProductsByPrice(Long cartId) {
		
		List<Product> l = productRepository.findAllByOrderByPrice();
		return getCart(cartId).replaceProducts(l);
	}
	
	public Cart getProductsByScore(Long cartId) {
		
		List<Product> l = productRepository.findAllByOrderByScore();
		return getCart(cartId).replaceProducts(l);
	}
	
	public Cart getProductsByName(Long cartId) {
		
		List<Product> l = productRepository.findAllByOrderByName();
		return getCart(cartId).replaceProducts(l);
	}	

			
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public Integer deleteEmptyCart() {
		return cartRepository.deleteEmptyCart();
	}
	
}

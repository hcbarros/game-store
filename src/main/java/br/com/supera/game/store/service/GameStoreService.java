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
	
	
	public Cart replaceProducts(Long id, List<Product> list) {
		
		Cart c = cartRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException());
		
		c = c.replaceProducts(list);
		return cartRepository.save(c);
	}
	
	
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}
	
	public List<Cart> getCartsEmpty() {
		return cartRepository.getCartsEmpty();
	}
	
	public Cart getCart(Long cartId) {
		return cartRepository
				.findById(cartId)
				.orElseThrow(() -> new EntityNotFoundException());
	}
			
	
	public Cart getProductsByPrice(Long cartId) {
		
		 Cart c = getCart(cartId);
		 List<Product> list = c.getProducts();
		 list.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
		 return c.replaceProducts(list);
	}
	
	
	public Cart getProductsByScore(Long cartId) {
		
		 Cart c = getCart(cartId);
		 List<Product> list = c.getProducts();
		 list.sort((p1, p2) -> p1.getScore().compareTo(p2.getScore()));
		 return c.replaceProducts(list);
	}
	
	
	public Cart getProductsByName(Long cartId) {
		
		 Cart c = getCart(cartId);
		 List<Product> list = c.getProducts();
		 list.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		 return c.replaceProducts(list);
	}	
	
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public void deleteProducts(List<Product> list) {
		productRepository.deleteAll(list);
	}
	
}

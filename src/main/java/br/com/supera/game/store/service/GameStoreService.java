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
	
	
	public Cart save(Product product) {
		
		boolean isNull = product.getId() == null;
		product = productRepository.save(product);
		if(!isNull) return getCart();
		Cart c = getCart().addProduct(product);
		return cartRepository.save(c);
	}
	
	public Cart modify(Long id, Product product) {
		
		Product p = getProduct(id);
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		p.setScore(product.getScore());
		p.setImage(product.getImage());
				
		return save(p);
	}	
	
	public Cart getCart() {
		return cartRepository
				.findById(1L)
				.orElseThrow(() -> new EntityNotFoundException());
	}
			
	public Cart getProductsByPrice() {
		
		List<Product> l = productRepository.findAllByOrderByPrice();
		return getCart().replaceProducts(l);
	}
	
	public Cart getProductsByScore() {
		
		List<Product> l = productRepository.findAllByOrderByScore();
		return getCart().replaceProducts(l);
	}
	
	public Cart getProductsByName() {
		
		List<Product> l = productRepository.findAllByOrderByName();
		return getCart().replaceProducts(l);
	}	
	
	public Product getProduct(Long id) {
		return productRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}
			
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
}

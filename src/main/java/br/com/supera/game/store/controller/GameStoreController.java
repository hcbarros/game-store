package br.com.supera.game.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.service.GameStoreService;


@RestController
@Validated
@RequestMapping("/games")
public class GameStoreController {

	@Autowired
	private GameStoreService service;
	
	
	@GetMapping(value = "/{id}")
	public Cart getCart(@PathVariable Long id) {
		return service.getCart(id);
	}
	
	@GetMapping(value = "/allCarts")
	public List<Cart> getAllCarts() {
		return service.getAllCarts();
	}
	
	@GetMapping(value = "/cartsEmpty")
	public List<Cart> getCartsEmpty() {
		return service.getCartsEmpty();
	}
	
	@GetMapping(value = "/orderByPrice/{cartId}")
    public Cart getProductsByPrice(@PathVariable Long cartId){		
        return service.getProductsByPrice(cartId);
    }
	
	@GetMapping(value = "/orderByScore/{cartId}")
    public Cart getProductsByScore(@PathVariable Long cartId){		
        return service.getProductsByScore(cartId);
    }
	
	@GetMapping(value = "/orderByName/{cartId}")
    public Cart getProductsByName(@PathVariable Long cartId){		
        return service.getProductsByName(cartId);
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cart saveCart(@RequestBody @Valid Cart cart) {
		return service.saveCart(cart);
	}
	
	@PutMapping(value = "{id}")
	public Cart updateCart(@PathVariable Long id, 
						   @RequestBody @Valid Product p) {
		return service.updateCart(id, p);
	}
	
	@PutMapping(value = "/replaceProducts/{id}")	
	public Cart replaceProducts(@PathVariable Long id, 
					@RequestBody @Valid List<Product> list) {
		return service.replaceProducts(id, list);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
	}
	
}



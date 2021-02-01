package br.com.supera.game.store.controller;

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
	
	@GetMapping(value = "{id}")
	public Product getOne(@PathVariable Long id) {
		return service.getProduct(id);		
	}
	
	@GetMapping
	public Cart getAll() {
		return service.getCart();
	}
	
	@GetMapping(value = "/orderByPrice")
    public Cart getProductsByPrice(){		
        return service.getProductsByPrice();
    }
	
	@GetMapping(value = "/orderByScore")
    public Cart getProductsByScore(){		
        return service.getProductsByScore();
    }
	
	@GetMapping(value = "/orderByName")
    public Cart getProductsByName(){		
        return service.getProductsByName();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cart save(@RequestBody @Valid Product product) {
		return service.save(product);
	}
	
	@PutMapping(value = "{id}")
	public Cart modify(@PathVariable Long id, @RequestBody Product product) {
		return service.modify(id, product);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}



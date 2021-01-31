package br.com.supera.game.store.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.service.StoreGameService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@Validated
@RequestMapping("/games")
public class StoreGameController {

	@Autowired
	private StoreGameService productService;
	
	@GetMapping(value = "{id}")
	public Product getOne(@PathVariable Long id) {
		return productService.getProduct(id);		
	}
	
	@GetMapping
	public Cart getAll() {
		return productService.getCart();
	}
	
	@GetMapping(value = "/orderByPrice")
    public Cart getProductsByPrice(){		
        return productService.getProductsByPrice();
    }
	
	@GetMapping(value = "/orderByScore")
    public Cart getProductsByScore(){		
        return productService.getProductsByScore();
    }
	
	@GetMapping(value = "/orderByName")
    public Cart getProductsByName(){		
        return productService.getProductsByName();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cart save(@RequestBody @Valid Product product) {
		return productService.save(product);
	}
	
	@PutMapping(value = "{id}")
	public Cart modify(@PathVariable Long id, @RequestBody Product product) {
		return productService.modify(id, product);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}
	
}



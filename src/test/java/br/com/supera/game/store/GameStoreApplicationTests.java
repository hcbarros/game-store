package br.com.supera.game.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.service.GameStoreService;

@SpringBootTest
class GameStoreApplicationTests {
	
	@Autowired
	private GameStoreService gameStoreService;

	@Test
	public void ShouldContainNineProducts() {
	
		List<Product> list = gameStoreService.getCart().getProducts();
		
	}

}

package br.com.supera.game.store.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import br.com.supera.game.store.repository.CartRepository;
import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;

public class DataLoader {
	
	@Autowired
	private CartRepository cartRepository;

	@Bean
	CommandLineRunner baseLoad() {
		 
		return args -> {
			
			List<Product> list = new ArrayList<>();
			
			Product p1 = new Product(
					"Super Mario Odyssey", 
					new BigDecimal("197.88"), 
					100, 
					"super-mario-odyssey.png"
			);
			Product p2 = new Product(
					"Call Of Duty Infinite Warfare", 
					new BigDecimal("49.99"), 
					80, 
					"call-of-duty-infinite-warfare.png"
			);
			Product p3 = new Product(
					"The Witcher III Wild Hunt", 
					new BigDecimal("119.5"), 
					250, 
					"the-witcher-iii-wild-hunt.png"
			);
			Product p4 = new Product(
					"Call Of Duty WWII", 
					new BigDecimal("249.99"), 
					205, 
					"call-of-duty-wwii.png"
			);
			Product p5 = new Product(
					"Mortal Kombat XL", 
					new BigDecimal("69.99"), 
					150, 
					"mortal-kombat-xl.png"
			);
			Product p6 = new Product(
					"Shards of Darkness", 
					new BigDecimal("71.94"), 
					400, 
					"shards-of-darkness.png"
			);
			Product p7 = new Product(
					"Terra Média: Sombras de Mordor", 
					new BigDecimal("79.99"), 
					50, 
					"terra-media-sombras-de-mordor.png"
			);
			Product p8 = new Product(
					"FIFA 18", 
					new BigDecimal("195.39"), 
					325, 
					"fifa-18.png"
			);
			Product p9 = new Product(
					"Horizon Zero Dawn", 
					new BigDecimal("115.8"), 
					290, 
					"horizon-zero-dawn.png"
			);
						
			list.add(p1); list.add(p2); list.add(p3); list.add(p4); list.add(p5); 
			list.add(p6); list.add(p7); list.add(p8); list.add(p9); 

			Cart cart = new Cart(new BigDecimal("0"));
			cart.setProducts(list);
			
			cartRepository.save(cart);			
		};
	}

}

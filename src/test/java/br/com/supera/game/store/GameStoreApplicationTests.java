package br.com.supera.game.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GameStoreApplicationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	@Order(1)
	public void mainTest() {
	    GameStoreApplication.main(new String[] {});
	}
	
	@Test
	@Order(2)
	public void shouldContainStringNameSuperMario() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/games/2",
				String.class)).contains("Super Mario Odyssey");
	}
	
	@Test
	@Order(3)
	public void shouldOrderByScore() throws Exception {
		Cart cart = this.restTemplate.
				  getForEntity("http://localhost:" + port + "/games/orderByScore", Cart.class).getBody();
		
		List<Product> list = getCart().getProducts().stream()
									  .sorted(Comparator.comparing(Product::getScore))
									  .collect(Collectors.toList());
		
		for(int i = 0; i < 9; i++)
		assertEquals(list.get(i).getId(), cart.getProducts().get(i).getId());	
	}
	
	@Test
	@Order(4)
	public void shouldOrderByName() throws Exception {
		
		Cart cart = this.restTemplate.
				  getForEntity("http://localhost:" + port + "/games/orderByName", Cart.class).getBody();
		
		List<Product> list = getCart().getProducts().stream()
									  .sorted(Comparator.comparing(Product::getName))
									  .collect(Collectors.toList());
		
		for(int i = 0; i < 9; i++)
		assertEquals(list.get(i).getId(), cart.getProducts().get(i).getId());		
	}
	
	@Test
	@Order(5)
	public void shouldOrderByPrice() throws Exception {
		
		Cart cart = this.restTemplate.
				  getForEntity("http://localhost:" + port + "/games/orderByPrice", Cart.class).getBody();
		
		List<Product> list = getCart().getProducts().stream()
									  .sorted(Comparator.comparing(Product::getPrice))
									  .collect(Collectors.toList());
		
		for(int i = 0; i < 9; i++)
		assertEquals(list.get(i).getId(), cart.getProducts().get(i).getId());		
	}
	
	@Test
	@Order(6)
    public void shouldReturnInternalServerErrorWhenGetObjectNotFound() {
				
		ResponseEntity<Product> resp = this.restTemplate
				.getForEntity("http://localhost:" + port + "/games/20", Product.class);
		assertEquals(resp.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);		  		
	}
	
	@Test
	@Order(7)
    public void shouldInsertInCartWhenPostProduct() {
				
		Product product = new Product("NewName", null, 0, "image");
		
		Cart inicialCart = getCart();		
		Cart cart = this.restTemplate
				.postForEntity("http://localhost:" + port + "/games", product, Cart.class).getBody();
		
		assertNotEquals(inicialCart.getProducts().size(), cart.getProducts().size());
	}
	
	@Test
	@Order(8)
    public void shouldUpdateWhenPutProduct() {
				
		Product product = getProduct(5);
		String originalName = product.getName();
		
		product.setName("modifiedName");
		
		this.restTemplate
				.put("http://localhost:" + port + "/games/5", product);
		
		Product modifiedProduct = getProduct(5);
		assertNotEquals(modifiedProduct.getName(), originalName);
	}
	
	@Test
	@Order(9)
    public void shouldDeleteProduct() {
				
		Cart inicialCart = getCart();
		
		this.restTemplate
				.delete("http://localhost:" + port + "/games/6");
		
		Cart modifiedCart = getCart();
		assertNotEquals(inicialCart.getProducts().size(), modifiedCart.getProducts().size());
	}
	
	
	private Product getProduct(int n) {
		
		return this.restTemplate
				.getForEntity("http://localhost:" + port + "/games/"+n, Product.class)
				.getBody();		 
	}
	
	private Cart getCart() {
		
		return this.restTemplate
				.getForEntity("http://localhost:" + port + "/games", Cart.class)
				.getBody();		 
	}
	
}

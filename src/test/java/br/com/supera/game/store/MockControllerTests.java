package br.com.supera.game.store;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.supera.game.store.controller.GameStoreController;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.service.GameStoreService;


@WebMvcTest(controllers = GameStoreController.class)
class MockControllerTests {
	
	@MockBean
	private GameStoreService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	public void shouldProductToBeCreated() throws Exception {
	
		Product productRequest = new Product("Game 1",BigDecimal.ZERO, 0, "image"); 
		
		String product = objectMapper.writeValueAsString(productRequest);
		
		mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/games/")
				.contentType("application/json")
				.content(product))
			.andExpect(MockMvcResultMatchers.status().isCreated());	
	}
	
	@Test
	public void shouldProductToBeModified() throws Exception {
	
		Product productRequest = new Product("Game 1",BigDecimal.ZERO, 0, "image");
		
		String product = objectMapper.writeValueAsString(productRequest);
		
		mvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/games/3")
				.contentType("application/json")
				.content(product))
			.andExpect(MockMvcResultMatchers.status().isOk());	
	}
	
	@Test
	public void shouldProductToBeDeleted() throws Exception {
					
		mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/games/3")
				.contentType("application/json")
				.accept("application/json"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());	
	}
		
	@Test
	public void shouldThrownExceptionWhenTryCreateProductWithoutName() throws Exception {
	
		Product productRequest = new Product(null, BigDecimal.ZERO, 0, "image"); 
		
		String product = objectMapper.writeValueAsString(productRequest);
		
		mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/games/")
				.contentType("application/json")
				.content(product))
				.andExpect(result -> 
					assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());	
	}
	
}

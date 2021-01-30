package br.com.supera.game.store.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {

   @Id
   @GeneratedValue
   private Long id;

   private String name;

   private BigDecimal price;

   private Integer score;

   private String image;

   @ManyToMany
   @JoinTable(name = "product_cart",
   joinColumns = @JoinColumn(name = "product_id"),
   inverseJoinColumns = @JoinColumn(name = "cart_id"))
   private Cart cart;
      
   public Product() {
	   
   }
   
   public Product(String name, BigDecimal price, Integer score, String image) {
		super();
		this.name = name;
		this.price = price;
		this.score = score;
		this.image = image;
   }
   
   
   public Long getId() {
	   return id;
   }

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}

}

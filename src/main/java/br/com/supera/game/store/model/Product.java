package br.com.supera.game.store.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

   @Id
   @GeneratedValue
   public Long id;

   public String name;

   public BigDecimal price;

   public short score;

   public String image;
   
   
   public Product() {
	   
   }
   
   public Product(String name, BigDecimal price, short score, String image) {
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
	
	public short getScore() {
		return score;
	}
	
	public void setScore(short score) {
		this.score = score;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}

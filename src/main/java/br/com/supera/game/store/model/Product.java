package br.com.supera.game.store.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "product")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank(message = "Field name is required")
   private String name;

   private BigDecimal price;

   private Integer score;

   private String image;

  
   public Product() {	   
	   this.price = BigDecimal.ZERO;
	   this.score = 0;
   }
   
   public Product(String name, BigDecimal price, Integer score, String image) {
		super();
		this.name = name;
		this.price = price == null ? BigDecimal.ZERO : price;
		this.score = score == null ? 0 : score;
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

}

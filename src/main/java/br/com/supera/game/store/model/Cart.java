package br.com.supera.game.store.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	private Long id;
	
	private BigDecimal frete;
	
	private BigDecimal subTotal;
	
	private BigDecimal total;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cart_id")
	private List<Product> products;
	
	public Cart() {
		
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getFrete() {
		
		return getSubTotal().compareTo(BigDecimal.valueOf(250)) > 0 
				? BigDecimal.ZERO : BigDecimal.valueOf(products.size()*10);
	}

	public void setFrete(BigDecimal frete) {
		
		this.frete = frete;
	}
			
	public BigDecimal getSubTotal() {
		return products.stream().map(x -> x.getPrice())
				 .reduce(BigDecimal.ZERO,BigDecimal::add);
	}
	
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	
	public BigDecimal getTotal() {
		return getSubTotal().add(getFrete());
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Cart addProduct(Product p) {
		products.add(p);
		return this;
	}
	
	public Cart replaceProducts(List<Product> l) {
		setProducts(l);
		return this;
	}
	
}

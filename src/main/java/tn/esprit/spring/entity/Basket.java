package tn.esprit.spring.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Basket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	@OneToOne 
	@JoinColumn(name= "id")
	private Client client ;
	@OneToMany(mappedBy = "basket")
	private Collection<Product> products;
	private double priceOfAllProducts ; 
	
	public Basket() {
		
	}
	
	public double getPriceOfAllProducts() {
		return priceOfAllProducts; 
	}
	
	public void setpriceOfAllProducts(double priceOfAllProducts) {
		this.priceOfAllProducts = priceOfAllProducts; 
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	public Basket(Long id, Client client, Collection<Product> products,double currentPriceOfAllProducts) {
		super();
		this.id = id;
		this.client = client;
		this.products = products;
		this.priceOfAllProducts = currentPriceOfAllProducts;
	} 

}

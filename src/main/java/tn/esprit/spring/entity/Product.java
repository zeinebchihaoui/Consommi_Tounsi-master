package tn.esprit.spring.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String reference;
	private String PhotoUrl;

	public String getPhotoUrl() {
		return PhotoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		PhotoUrl = photoUrl;
	}

	private double price;
	private int stock;
	private String name_product;
	@ManyToOne
	@Nullable
	private Category category;
	@ManyToOne
	@Nullable
	@JsonProperty(access = Access.WRITE_ONLY)
	private Basket basket;
	@ManyToMany
	@JoinTable(name = "commande", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "id_commande"))
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Commandes> orders;

	public Product() {
	}

	public Product(Long productId, String reference, double price, int stock, String name_product, Category category,
			Basket basket, Collection<Commandes> orders) {
		super();
		this.productId = productId;
		this.reference = reference;
		this.price = price;
		this.stock = stock;
		this.name_product = name_product;
		this.category = category;
		this.basket = basket;
		this.orders = orders;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Collection<Commandes> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Commandes> orders) {
		this.orders = orders;
	}

}
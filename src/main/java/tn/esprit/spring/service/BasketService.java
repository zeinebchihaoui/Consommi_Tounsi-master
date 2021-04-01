package tn.esprit.spring.service;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.BasketRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entity.Basket;
import tn.esprit.spring.entity.Product;


@Service
public class BasketService {

	@Autowired
	private BasketRepository basketRepository; 
	@Autowired
	private ProductRepository productRepository ; 
	
	
	public Basket addProduct(Long basketId, Product product) {  
		Basket basket = findBasketById(basketId);
		checkProduct(product,basket);
		product.setBasket(basket);
		productRepository.save(product);
		basket.getProducts().add(product);
		computeNewPriceOfAllProducts(basket,product.getPrice(),'+');
		return basketRepository.save(basket); 
		
	}

	private void checkProduct(final Product product, Basket basket) {
		if (product == null ) 
			throw new IllegalArgumentException("product must no be null");
		Product productInsideBasket = basket.getProducts()
				.stream()
			//	.filter(e -> e.getProductId().equals(product.getProductId()))
				.findFirst()
				.orElse(null); 
		if (productInsideBasket != null) 
			throw new IllegalArgumentException("product with id " + product.getProductId() + "already exist in the basket, please provide a product with different ID");
	}
	
	
	public Basket removeProduct(Long basketId, Product product) {
		Basket basket = findBasketById(basketId);
		if (!productExistInBasket(basket,product)) {
			throw new RuntimeException("Product you want to remove does not exist in the basket with id " + basket.getId());
		}
		if ( basket == null || basket.getProducts().isEmpty()) {
			throw new RuntimeException("Basket with id " +  basket.getId() + " is empty ");
		}
		product.setBasket(null);
		productRepository.save(product) ;
		//basket.getProducts().removeIf(p -> p.getProductId().equals(product.getProductId()));
		computeNewPriceOfAllProducts(basket, product.getPrice(), '-');
		basketRepository.save(basket);
		return basket ;
	} 
	

	private boolean productExistInBasket(Basket basket, Product product) {
		Collection<Long> productsIds = basket.getProducts()
				.stream()
				.map(Product::getProductId)
				.collect(Collectors.toList()); 
		return productsIds.contains(product.getProductId()) ? true : false ;   
	}

	private void computeNewPriceOfAllProducts(Basket basket, double productPrice, char op) {
		if (op == '+') 
			doAddProductPriceToBasketCurrentPrice(basket,productPrice);
		else if (op == '-')
			doRemoveProductPriceFromBasketCurrentPrice(basket,productPrice);
	}
	
	
	private void doRemoveProductPriceFromBasketCurrentPrice(Basket basket, double productPrice) {
		double currentPriceOfAllProducts = basket.getPriceOfAllProducts(); 
		basket.setpriceOfAllProducts(currentPriceOfAllProducts-productPrice);
	}

	private void doAddProductPriceToBasketCurrentPrice(Basket basket, double productPrice) {
		double currentPriceOfAllProducts = basket.getPriceOfAllProducts(); 
		basket.setpriceOfAllProducts(currentPriceOfAllProducts+productPrice);
	}





	private Basket findBasketById(Long basketId) {
		return basketRepository.findById(basketId)
				.orElseThrow(() -> new RuntimeException("Basket with id "+ basketId + " does not exist"));
	}
	
	
}

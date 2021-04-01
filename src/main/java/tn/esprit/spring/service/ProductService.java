
package tn.esprit.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CategoryRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Product;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository; 
	@Autowired
	private CategoryRepository categoryRepository ;

	public void saveProduct(Product product) {
		if (!product.getReference().matches("\\d+")) {
			throw new IllegalArgumentException("Product reference must contains only digits");
		}
		if (!product.getReference().startsWith("619")) {
			throw new IllegalArgumentException("The input product is not Tunisian product");
		}
		productRepository.save(product);
		
		
	}

	public Collection<Product> findByCategory(Long id) {
		Category category = categoryRepository.findById(id)
				.orElse(null);
		if (category != null) {
			 return category.getProducts() ;
		} else {
			throw new RuntimeException("Category with id "+id + " does not exist");
		}
	}

}

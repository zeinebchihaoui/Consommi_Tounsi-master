package tn.esprit.spring.Control;

import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.BasketRepository;
import tn.esprit.spring.entity.Basket;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.BasketService;

@RestController
@RequestMapping("/baskets")
public class BasketController {

	@Autowired
	private BasketService basketService ;
	@Autowired
	private BasketRepository basketrepository; 
	
	@GetMapping("/seach/all")
	public ResponseEntity<Collection<Basket>> getAllBaskets() {
		Collection<Basket> baskets = basketrepository.findAll(); 
		return new ResponseEntity<Collection<Basket>>(baskets,OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Basket> saveBasket(@RequestBody Basket basket) {
		basketrepository.save(basket); 
		return new ResponseEntity<Basket>(basket,OK);
	}
	
	
	@PostMapping("/addProduct/{basketId}")
	public ResponseEntity<Basket> addProduct(@PathVariable("basketId") Long basketId
			,@RequestBody Product product) {
	 	Basket basket = basketService.addProduct(basketId, product);
	 	return new ResponseEntity<Basket>(basket,OK);
	}
	
	@DeleteMapping("/removeProduct/{basketId}")
	public ResponseEntity<Basket> removeProduct(@PathVariable("basketId") Long basketId
			,@RequestBody Product product) {
		Basket basket = basketService.removeProduct(basketId,product);
		return new ResponseEntity<Basket>(basket, OK); 
	}
	
	
}

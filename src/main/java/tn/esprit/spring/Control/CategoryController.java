package tn.esprit.spring.Control;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.CategoryRepository;
import tn.esprit.spring.entity.Category;



@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository ;
	
	
	@PutMapping
	public Category updateCategory (@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	@GetMapping("/search/{id}")
	public Category findById (@PathVariable("id") Long id) {
		return categoryRepository.findById(id).get(); 
	}
	
	@GetMapping("/search/all")
	public Collection<Category> findAll() {
		 return categoryRepository.findAll() ;
	}
	
	@PostMapping("/saveCategory")
	public Category saveCategory (@RequestBody Category category) {
		return categoryRepository.save(category) ;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Category> removeAllCategories(@PathVariable("id") Long id) {
		Category catFromDatabase = categoryRepository.findById(id)
				.orElse(null);
		if (catFromDatabase != null) {
			categoryRepository.deleteById(catFromDatabase.getId());
			return new ResponseEntity<Category>(catFromDatabase,HttpStatus.OK); 
		} else {
			throw new RuntimeException("Category does not exist in databse");
		}
	}
	
	
}

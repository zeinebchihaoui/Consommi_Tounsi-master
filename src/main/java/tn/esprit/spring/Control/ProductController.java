package tn.esprit.spring.Control;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService ; 
	@Autowired
	private ProductRepository ProductRepository ; 
	
	@GetMapping("/find/{ref}")
	public Product findById(@PathVariable("ref") Long ref ) {
		return ProductRepository.findById(ref).get() ;
	}
	
	@GetMapping("/search/all")
	public  Collection<Product> findAll () {
		return ProductRepository.findAll();
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct (@RequestParam("file") @Nullable MultipartFile file ,@RequestBody Product product) {
		if(file==null) {
            product.setPhotoUrl("defaultPic.jpg");
            productService.saveProduct(product);
        }else {
            try { 
                File f = new File("C:\\upload\\" +"image" + product.getName_product()+file.getOriginalFilename());
                file.transferTo(f);
                product.setPhotoUrl("image"+product.getName_product()+file.getOriginalFilename());
                productService.saveProduct(product);
            } catch (IllegalStateException e) {
           e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return  new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deleteById/{ref}")
	public Product deleteProductById(@PathVariable("ref") Long ref) {
		Product product = ProductRepository.findById(ref)
				.orElse(null); 
		if (product != null) {
			ProductRepository.deleteById(ref);
			return product;  
		} else {
			throw new RuntimeException("Product does not exist");
		}
	}
	
	
	  @PostMapping("/file")
	    @ResponseBody
	    public Product  uploddimg (@RequestParam("file") @Nullable MultipartFile file , @RequestParam("product") Long idprod ) {
		  Optional<Product> product =ProductRepository.findById(idprod);
	     Product p1 = product.get();
		  if(file==null) {
	            p1.setPhotoUrl("defaultPic.jpg");
	            ProductRepository.save(p1);
	        }else {
	            try { 
	                File f = new File("C:\\upload\\" +"image" + idprod+file.getOriginalFilename());
	                file.transferTo(f);
	                p1.setPhotoUrl("image"+idprod+file.getOriginalFilename());
	                ProductRepository.save(p1);
	            } catch (IllegalStateException e) {
               e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        return(p1);
	    }
	
	  @GetMapping("/findByCategory/{id}")
		public ResponseEntity<Collection<Product>> findByCategory (@PathVariable("id") Long id) {
			Collection<Product> products = 
					productService.findByCategory(id); 
			return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
		}

}

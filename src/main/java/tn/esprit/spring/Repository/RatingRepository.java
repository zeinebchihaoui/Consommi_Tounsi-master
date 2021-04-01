package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Rating;


public interface RatingRepository  extends CrudRepository <Rating,Integer>{
	
	//@Query("select rating from rating where idpub=28")
	//public int sumrating();
}

package tn.esprit.spring.Repository;import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Basket;

public interface BasketRepository  extends JpaRepository<Basket, Long>{
	
	

}

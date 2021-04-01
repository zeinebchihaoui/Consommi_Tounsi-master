package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository <Order, Integer> {

}

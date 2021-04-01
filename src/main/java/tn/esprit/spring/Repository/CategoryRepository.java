package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}

package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Delivery_Man;

@Repository
public interface Delivery_ManRepository extends CrudRepository<Delivery_Man, Integer> {

	@Query(value = "SELECT * FROM Delivery_Man ", nativeQuery = true)
	public List<String> findAllDelivery_Mans();

	@Query(value = "SELECT id_deliv_man FROM Delivery_Man WHERE etat = 1", nativeQuery = true)
	public List<String> GetLivreurDispo();

	@Query(value = "SELECT id_deliv_man FROM Delivery_Man WHERE etat = 0", nativeQuery = true)
	public List<String> GetLivreurNotDispo();

	@Query(value = "SELECT id_deliv_man,name_deliv_man,charget_liv FROM Delivery_Man WHERE charget_liv = (SELECT MAX(charget_liv) FROM Delivery_Man)", nativeQuery = true)
	public int BestLivreur();

	@Query(value = "SELECT * FROM Delivery_Man", nativeQuery = true)
	public List<Delivery_Man> GetLivreur();

}
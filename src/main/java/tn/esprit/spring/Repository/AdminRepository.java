package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Administrator;

@Repository
public interface AdminRepository extends CrudRepository<Administrator, Integer> {
	public Administrator findByUsername(String username);

	@Query(value = "SELECT c.name_client, c.adress_client , c.city_client , c.email_client  FROM client c WHERE username = :username", nativeQuery = true)
	public List<String> findClientbyUsername(@Param("username") String username);

	@Query(value = "UPDATE client SET actived= 0 WHERE username=:username ", nativeQuery = true)
	public List<String> Block(@Param("username") String username);

	@Query(value = "SELECT id_deliv_man FROM delivery_man ORDER BY charget_liv DESC LIMIT 2", nativeQuery = true)
	public List<Long> Top10nbLivreur();

	@Query(value = "SELECT name_product FROM Product WHERE stock = 0", nativeQuery = true)
	public List<String> ProductOutOfStock();

}
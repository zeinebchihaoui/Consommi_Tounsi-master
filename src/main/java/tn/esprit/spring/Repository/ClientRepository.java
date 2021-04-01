package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Delivery_Man;

public interface ClientRepository extends CrudRepository<Client, Integer> {

	public Client findByUsername(String username);

	@Query(value = "SELECT c.username , o.date_order  FROM client c join orders o on c.id_client=o.id_client", nativeQuery = true)
	public List<String> findClientOrder();

	@Query(value = "SELECT * FROM Client", nativeQuery = true)
	public List<Client> GetClient();
	
	@Query("SELECT e FROM Client e WHERE e.email_client=:email")
	public Client getPassword(@Param("email") String email);
}

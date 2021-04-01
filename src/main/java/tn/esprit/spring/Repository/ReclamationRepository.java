package tn.esprit.spring.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository <Reclamation, Integer>{

	@Query(value = "SELECT * FROM Reclamation WHERE id_client=? ", nativeQuery = true)
	public List<String> afficherlesReclamation(int id_client);
	
	@Query(value = "SELECT * FROM Reclamation ", nativeQuery = true)
	public List<String> findAllupdateReclamation();
	
}

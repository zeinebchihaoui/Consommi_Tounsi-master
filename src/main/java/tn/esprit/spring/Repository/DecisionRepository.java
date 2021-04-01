package tn.esprit.spring.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Decision;

@Repository
public interface DecisionRepository extends CrudRepository <Decision, Integer>{

	@Query(value = "SELECT * FROM Decision WHERE id_recl=? ", nativeQuery = true)
	public List<String> afficherlesDecisions(int id_recl);

}

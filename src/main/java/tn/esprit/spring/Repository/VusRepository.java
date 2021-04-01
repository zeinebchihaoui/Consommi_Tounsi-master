package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Vus;


public interface VusRepository extends CrudRepository <Vus,Integer> {

	
	@Query("SELECT COUNT(nb_vus) FROM Vus v where idpub= :idpub")
	public long getNombreVusbypub(@Param("idpub")int idpub);
	
	
	
	@Query(value="SELECT c.name_client,p.subject,p.contents FROM vus v ,publication p,client c where v.idpub=p.idpub and v.id_client=c.id_client GROUP BY v.idpub ORDER by COUNT(nb_vus) DESC LIMIT 3", nativeQuery =true) //limit 3 
	public List<String> troisTopViews();
}

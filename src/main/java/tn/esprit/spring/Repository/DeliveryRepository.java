package tn.esprit.spring.Repository;

import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository <Delivery, Integer>{

	@Query(value = "SELECT * FROM Delivery WHERE id_deliv_man=? ", nativeQuery = true)
	public List<String> afficherleslivraison(int id_deliv_man);
	
	@Modifying
    @Transactional
	@Query(value="Delete  from Delivery  where DATEDIFF(CURRENT_TIMESTAMP , delivery.date_fin  )>=0 ",nativeQuery=true)
    public void deleteDileveryAuto();
	
	@Query(value = "SELECT * FROM Delivery ", nativeQuery = true)
	public List<String> findAllDeliverys();
    @Transactional
    //@Query(value="SELECT id_deliv_man FROM Delivery WHERE delivery.date_debut::date=:datet AND delivery.date_fin::date=:datee ",nativeQuery=true)
	@Query(value="SELECT id_deliv_man FROM Delivery WHERE  DATEDIFF(:datet, delivery.date_debut  )=0 AND DATEDIFF(:datee, delivery.date_fin )=0",nativeQuery=true)
	public List<String> afficherDispo(@Param(value = "datet") Timestamp datet,@Param(value = "datee") Timestamp datee);
}

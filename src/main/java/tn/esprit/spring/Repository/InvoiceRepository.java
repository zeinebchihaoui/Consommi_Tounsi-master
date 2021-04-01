package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Factures;

@Repository
public interface InvoiceRepository  extends CrudRepository <Factures,Integer> {

	@Query(value = "SELECT * FROM Factures WHERE order_id_order=?1", nativeQuery = true)
    public List<Factures> getAllfactures_by_Commande( int id);
}

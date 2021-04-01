package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.InvoiceRepository;
import tn.esprit.spring.entity.Factures;


@Service
public class FacturesService implements InvoiceServiceImp{

	@Autowired
	 InvoiceRepository invrep;

	//private static final Logger L=LogManager.getLogger(publicationServiceImpl.class);
	

	public Factures addInvoice(Factures inv) {
		
		return invrep.save(inv);
	}

	public Factures updateInvoice(Factures inv) {
		
		return invrep.save(inv);
	}
     
	
		

	public List<Factures> findall() {
		List<Factures> invoice = new ArrayList<Factures>();  
		invoice = (List<Factures>) invrep.findAll();
		return invoice;
	}

	
	public void deleteinvoice(int idInvoice) {
		invrep.deleteById(idInvoice);
		
	}


	public List<Factures> getAllfactures_by_Commande(int id) {
		return invrep.getAllfactures_by_Commande(id);
	}


	

	

}

package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Factures;


public interface InvoiceServiceImp {

	List<Factures> findall();

	void deleteinvoice(int idInvoice);

	
	public Factures addInvoice(Factures invoice);
	
	public Factures updateInvoice(Factures invoice);

	
	public List<Factures> getAllfactures_by_Commande(int id);
	
}

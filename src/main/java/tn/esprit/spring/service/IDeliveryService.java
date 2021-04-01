package tn.esprit.spring.service;

import java.sql.Timestamp;
import java.util.List;
import tn.esprit.spring.entity.Delivery;

public interface IDeliveryService {
	public Delivery saveDelivery(Delivery delivery,int id_deliv_man,int id_ord);
	public Delivery updateDelivery(Delivery delivery);
	public List<String> findAllDeliverys();
	public void deleteDelivery(int id_deliv);
	public float CalculerFraisLivraison(String location , String poids , String moyenT);
	public Delivery searchDeliveryById(int id_deliv);
	public void affecterLivraisonALivreur(int id_deliv_man , int id_deliv);
	public List<String> afficherleslivraison(int id_deliv_man);
	public void deleteDileveryAuto() ;
	public List<String> afficherDispo(Timestamp datet,Timestamp datee);
}

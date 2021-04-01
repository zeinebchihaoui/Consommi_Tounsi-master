package tn.esprit.spring.service;

import java.sql.Timestamp;
import java.util.List;
import tn.esprit.spring.entity.Delivery_Man;

public interface IDelivery_ManService {
	
	public Delivery_Man saveDelivery_Man(Delivery_Man delivery_man);
	public void updateDelivery_Man(int id_deliv_man) ;
	public List<String> findAllDelivery_Mans();
	public void deleteDelivery_Man(int id_deliv_man);
	public Delivery_Man searchDelivery_ManById(int id_deliv_man);
	public int BestLivreur();	
	public List<String> Disponibilité();
	public List<String> NoDisponibilité();
	public void Prime();
	public void ChargeDeTravail(int id_deliv_man );
	public void mettreAjourLivreurBydispo(int id_deliv_man, boolean etat) ;

}

package tn.esprit.spring.service;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.DeliveryRepository;
import tn.esprit.spring.Repository.Delivery_ManRepository;
import tn.esprit.spring.Repository.OrderRepository;
import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.entity.Delivery_Man;
import tn.esprit.spring.entity.Order;

@Service
public class DeliveryService implements IDeliveryService{
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	public DeliveryService  (JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Autowired
	private DeliveryRepository DeliveryRepo;
	
	@Autowired
	private Delivery_ManRepository Delivery_ManRepo; 

	@Autowired
	private OrderRepository ordRepo; 
	
	public Delivery saveDelivery(Delivery delivery,int id_deliv_man,int id_ord) {
		Delivery_Man dv=Delivery_ManRepo.findById(id_deliv_man).get();
		Order ord=ordRepo.findById(id_ord).get();
		delivery.setDelivery_man(dv);
		delivery.setOrder(ord);
		return DeliveryRepo.save(delivery);
	}

	
	public Delivery updateDelivery(Delivery delivery) {
		return DeliveryRepo.save(delivery);
	}

	
	public List<String> findAllDeliverys() {
		return  DeliveryRepo.findAllDeliverys();
	}

	public void deleteDelivery(int id_deliv) {
		DeliveryRepo.deleteById(id_deliv);
	}
	

	public List<String> afficherleslivraison(int id_deliv_man) {
		return DeliveryRepo.afficherleslivraison(id_deliv_man);
	}
	
	public Delivery searchDeliveryById(int id_deliv){
		return 	DeliveryRepo.findById((id_deliv)).orElse(null);
	}
	
	public float CalculerFraisLivraison(String location , String poids , String moyenT) {
		
		float Distance = 0 ;
		float Poids = 0 ;
		float fraisDistance = 0 ;
		float fraisPoids = 0 ;
		float fraisMoyenT = 0 ;

		if (Distance > 100) {
			fraisDistance = (float) ((Distance * 0.1) + 3);
		} else {
			fraisDistance = (float) (Distance * 0.1);
		}
		
		if (Poids > 20) {
			fraisPoids = (float) ((Poids * 0.1) + 2);
		} else {
			fraisPoids = (float) (Poids * 0.1);
		}
		
		if ((Poids < 5)&(Distance < 5)) {
			moyenT = "Motor";
			fraisMoyenT = (float) 2;
		} else {
			moyenT = "Voiture";
			fraisMoyenT = (float) 4;
		}
		
		return (float) (fraisPoids + fraisDistance + fraisMoyenT) ;
	}
	
	
	public void affecterLivraisonALivreur( int id_deliv_man , int id_deliv) {
		
		Delivery_Man livreurManagedEntity = Delivery_ManRepo.findById(id_deliv_man).get();
		Delivery livraisonManagedEntity = DeliveryRepo.findById(id_deliv).get();

		System.out.println("sending email ...");

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("chihaoui.zeineb@gmail.com");
		simpleMailMessage.setTo(livreurManagedEntity.getEmail_deliv_man());
		simpleMailMessage.setSubject("Delivery");
		simpleMailMessage.setText("You have a delivery to " +livraisonManagedEntity.getOrder().getClient().getAdress_client() 
				+ " please come to take the percel");
		
		javaMailSender.send(simpleMailMessage);
		System.out.println("sent email ...");
	}
	

	public void deleteDileveryAuto() {
		DeliveryRepo.deleteDileveryAuto();
	}
	@Override
	public List<String> afficherDispo(Timestamp datet , Timestamp datee) {
		return DeliveryRepo.afficherDispo(datet,datee);
	}
}

package tn.esprit.spring.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.Delivery_ManRepository;
import tn.esprit.spring.entity.Delivery_Man;

@Service
public class Delivery_ManService implements IDelivery_ManService {
	
	private JavaMailSender javaMailSender;

	@Autowired
	public Delivery_ManService  (JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	private Delivery_ManRepository Delivery_ManRepo; 
	
	public Delivery_Man saveDelivery_Man(Delivery_Man delivery_man) {
		return Delivery_ManRepo.save(delivery_man);
	}
	
	public void updateDelivery_Man(int id_deliv_man) {
		Delivery_Man delivery_man=Delivery_ManRepo.findById(id_deliv_man).get();

		Delivery_ManRepo.save(delivery_man);
	}

	public List<String> findAllDelivery_Mans() {
		return  Delivery_ManRepo.findAllDelivery_Mans();
	}
	
	public void deleteDelivery_Man(int id_deliv_man) {
		Delivery_ManRepo.deleteById(id_deliv_man);
	}


	public Delivery_Man searchDelivery_ManById(int id_deliv_man){
		return 	Delivery_ManRepo.findById((id_deliv_man)).orElse(null);
	}
	
	
	public List<String> Disponibilité() {
		return  Delivery_ManRepo.GetLivreurDispo();
	}
	

	public List<String> NoDisponibilité() {
		return  Delivery_ManRepo.GetLivreurNotDispo();
	}


	public int BestLivreur(){
		return  Delivery_ManRepo.BestLivreur() ;			
	}
	
	
	public void Prime( ) {
		int n;
		
		n =  Delivery_ManRepo.BestLivreur();
		
		Delivery_Man Delivery_man = Delivery_ManRepo.findById(n).get();
		
		List<Delivery_Man> ListeLiv = new ArrayList<Delivery_Man>();
		ListeLiv=Delivery_ManRepo.GetLivreur();
		for(Delivery_Man i :ListeLiv){
			
		i.setChargeT_liv(0);
		Delivery_ManRepo.save(i);
		}
		
		System.out.println("sending email ...");

		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(Delivery_man.getEmail_deliv_man());		
		mail.setFrom("chihaoui.zeineb@gmail.com");
		mail.setSubject("Prime");
		mail.setText("Congratulation you are the delivery man of the month you have recived 500Dt bonus" );
		
		javaMailSender.send(mail);
		System.out.println("sent email to "+Delivery_man.getName_deliv_man() + " " + Delivery_man.getEmail_deliv_man());
	}
	
	public void ChargeDeTravail(int id_deliv_man ) {
		
		Delivery_Man Delivery_man = Delivery_ManRepo.findById(id_deliv_man).get();
		Integer x= Delivery_man.getChargeT_liv();
		Delivery_man.setChargeT_liv(x+1);
		Delivery_ManRepo.save(Delivery_man);
	}
	
	
	public void mettreAjourLivreurBydispo(int id_deliv_man, boolean etat) {
		Delivery_Man delivery_man=Delivery_ManRepo.findById(id_deliv_man).get();
		delivery_man.setEtat(etat);

		Delivery_ManRepo.save(delivery_man);
	}
	
	
	
	
}

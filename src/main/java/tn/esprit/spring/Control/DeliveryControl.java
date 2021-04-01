package tn.esprit.spring.Control;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.service.DeliveryService;
import tn.esprit.spring.service.IDeliveryService;
import org.springframework.mail.MailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DeliveryControl {

	private Logger logger= LoggerFactory.getLogger(DeliveryControl.class);
	
	@Autowired
	IDeliveryService iDeliveryService;
	
	@Autowired
	private DeliveryService deliveryService;
	
	@PostMapping("/saveDeliv/{id_deliv_man}/{id_ord}")
	@ResponseBody
	public Delivery saveDelivery(@RequestBody Delivery delivery,@PathVariable("id_deliv_man") int id_deliv_man,@PathVariable("id_ord")int id_ord) {
		Delivery deliveryy = deliveryService.saveDelivery(delivery,id_deliv_man,id_ord);
	return deliveryy ;
	}
	
	@GetMapping("/findAllDeli")
	@ResponseBody
	public List<String> getDeliverys() {
	List<String> list = deliveryService.findAllDeliverys();
	return list;
	}
	
	@PutMapping("/updateDeliv")
	@ResponseBody
	public Delivery updateDelivery(@RequestBody Delivery delivery) {
	   return deliveryService.updateDelivery(delivery);
	}
	
	@DeleteMapping("/removeDeliv/{id_deliv}")
	@ResponseBody
	public void deleteDelivery(@PathVariable("id_deliv") int id_deliv) {
		deliveryService.deleteDelivery(id_deliv);
	}
	
	@GetMapping("/afficherleslivraison/{id_deliv_man}")
	@ResponseBody
	public List<String> afficherleslivraison(@PathVariable("id_deliv_man") int id_deliv_man) {
	    return iDeliveryService.afficherleslivraison(id_deliv_man);
	}
	
	@GetMapping("/searchDeliveryById/{id_deliv}")
	 @ResponseBody
	 public Delivery searchDeliveryById(@PathVariable("id_deliv")int id_deliv){
		 return iDeliveryService.searchDeliveryById(id_deliv);
	 }
	
	@GetMapping("/calculLiv/{id_deliv}")
	public float CalculerFraisLivraison(@PathVariable("id_deliv") int id_deliv) {
		
		float Distance = 128 ;
		float Poids = 10 ;
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
			fraisMoyenT = (float) 2;
		} else {
			fraisMoyenT = (float) 4;
		}
		
		return (float) ( fraisPoids + fraisDistance + fraisMoyenT) ;
	}
	
	 @PutMapping("/affecterLivraisonALivreur/{id_deliv}/{id_deliv_man}") 
	   @ResponseBody
		public void  affecterLivraisonALivreur(@PathVariable("id_deliv")int id_deliv, @PathVariable("id_deliv_man")int id_deliv_man)
		{

	   try{
		iDeliveryService.affecterLivraisonALivreur( id_deliv_man ,  id_deliv);
		  }
	   catch(MailException e){
			  logger.info("Error sending "+e.getMessage());
		  }
		}
	 
	 @DeleteMapping("/dedeleteDileveryAutolete") 
		@ResponseBody
		public void deleteDileveryAuto() {
		 iDeliveryService.deleteDileveryAuto();		
		}
	 @GetMapping("/afficheDispo/{datet}/{datee}") 
		@ResponseBody
		public List<String> afficherDispo(@PathVariable("datet")Timestamp datet,@PathVariable("datee")Timestamp datee) {
			return iDeliveryService.afficherDispo(datet,datee);		
		}
}

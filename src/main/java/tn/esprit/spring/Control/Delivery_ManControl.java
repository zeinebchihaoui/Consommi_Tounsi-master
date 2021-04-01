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
import tn.esprit.spring.entity.Delivery_Man;
import tn.esprit.spring.service.Delivery_ManService;
import tn.esprit.spring.service.IDelivery_ManService;

@RestController
public class Delivery_ManControl {

	@Autowired
	private Delivery_ManService delivery_manService;

	@Autowired
	IDelivery_ManService iDelivery_manService;
	
	@PostMapping("/saveDelivMan")
	@ResponseBody
	public Delivery_Man saveDelivery_Man(@RequestBody Delivery_Man man) {
	Delivery_Man delivery_man = delivery_manService.saveDelivery_Man(man);
	return delivery_man;
	}
	
	@GetMapping("/findAllDelivMan")
	@ResponseBody
	public List<String> getDelivery_Mans() {
	List<String> list = delivery_manService.findAllDelivery_Mans();
	return list;
	}
	
	@PutMapping("/updateDelivery_Man/{id_deliv_man}")
	@ResponseBody
	public void updateDelivery_Man(@PathVariable("id_deliv_man") int id_deliv_man) {
		iDelivery_manService.updateDelivery_Man(id_deliv_man);
	}
	
	@DeleteMapping("/removeDelivMan/{id_deliv_man}")
	@ResponseBody
	public void removeUser(@PathVariable("id_deliv_man") int id_deliv_man) {
		delivery_manService.deleteDelivery_Man(id_deliv_man);
	}
	
	@GetMapping("/searchDelivery_ManById/{id_deliv_man}")
	 @ResponseBody
	 public Delivery_Man searchDelivery_ManById(@PathVariable("id_deliv_man")int id_deliv_man){
		 return iDelivery_manService.searchDelivery_ManById(id_deliv_man);
	 }
	
	@GetMapping("/BestLivreur")
	@ResponseBody
	public int liv(){
		return iDelivery_manService.BestLivreur();
	}
	
	@GetMapping("/Disponibilité")
	@ResponseBody
	public List<String> Disponibilité() {
	List<String> list = delivery_manService.Disponibilité();
	return list;
	}
	
	@GetMapping("/NoDisponibilité")
	@ResponseBody
	public List<String> NoDisponibilité() {
	List<String> list = delivery_manService.NoDisponibilité();
	return list;
	}

	@PutMapping("/Prime")
	@ResponseBody
	public void Prime() {
		 iDelivery_manService.Prime();
	}
	
	@PutMapping(value = "/ChargeDeTravail/{id_deliv_man}") 
	@ResponseBody
	public void ChargeDeTravail( @PathVariable("id_deliv_man") int id_deliv_man) {
		iDelivery_manService.ChargeDeTravail(id_deliv_man);
	}
	
	@PutMapping("/mettreAjourLivreurBydispo/{id_deliv_man}/{etat}")
	@ResponseBody
	public void mettreAjourLivreurBydispo(@PathVariable("etat") boolean etat,@PathVariable("id_deliv_man") int id_deliv_man) {
		iDelivery_manService.mettreAjourLivreurBydispo(id_deliv_man, etat);
	}

	
	
}

package tn.esprit.spring.Control;

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
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.ReclamationService;
import tn.esprit.spring.service.IReclamationService;

@RestController
public class ReclamationControl {
	@Autowired
	private ReclamationService reclamationService;

	@Autowired
	IReclamationService iReclamationService;
	
	@PostMapping("/saveCompl")
	@ResponseBody
	public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
		Reclamation reclamations = reclamationService.saveReclamation(reclamation);
	return reclamations;
	}
	
	@GetMapping("/findAllCompl")
	@ResponseBody
	public List<String> findAllupdateReclamation() {
	List<String> list = reclamationService.findAllupdateReclamation();
	return list;
	}
	
	@PutMapping("/updateCompl")
	@ResponseBody
	public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
	   return reclamationService.updateReclamation(reclamation);
	}
	
	@DeleteMapping("/removeCompl/{id_recl}")
	@ResponseBody
	public void deleteReclamation(@PathVariable("id_recl") int id_recl) {
		reclamationService.deleteReclamation(id_recl);
	}
	
	@GetMapping("/searchComplains/{id_recl}")
	 @ResponseBody
	 public Reclamation searchReclamation(@PathVariable("id_recl")int id_recl){
		 return iReclamationService.searchReclamation(id_recl);
	 }

	@GetMapping("/afficherlesReclamation/{id_client}")
	@ResponseBody
	public List<String> afficherlesReclamation(@PathVariable("id_client") int id_client) {
	    return iReclamationService.afficherlesReclamation(id_client);
	}
}

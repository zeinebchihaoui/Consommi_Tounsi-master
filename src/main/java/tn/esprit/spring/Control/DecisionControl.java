package tn.esprit.spring.Control;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.service.DecisionService;
import tn.esprit.spring.service.IDecisionService;

@RestController
public class DecisionControl {

	private Logger logger= LoggerFactory.getLogger(DeliveryControl.class);

	@Autowired
	IDecisionService iDecisionService;
	
	@Autowired
	private DecisionService decisionService;
	
	
	@PostMapping("/saveDecision/{id_recl}")
	@ResponseBody
	public Decision saveDecision(@RequestBody Decision decision,@PathVariable("id_recl") int id_recl) {
		Decision decisionn = decisionService. saveDecision(decision,id_recl);
	return decisionn ;
	}
	
	@GetMapping("/findAllDecisions")
	@ResponseBody
	public List<Decision> findAllDecisions() {
	List<Decision> list = decisionService.findAllDecisions();
	return list;
	}
	
	@PutMapping("/updateDecision")
	@ResponseBody
	public Decision updateDecision(@RequestBody Decision decision) {
	   return decisionService.updateDecision(decision);
	}
	
	@DeleteMapping("/deleteDecision/{id_deci}")
	@ResponseBody
	public void deleteDecision(@PathVariable("id_deci") int id_deci) {
		decisionService.deleteDecision(id_deci);
	}
	
	
	@GetMapping("/afficherlesDecisions/{id_recl}")
	@ResponseBody
	public List<String> afficherlesDecisions(@PathVariable("id_recl") int id_recl) {
	    return iDecisionService.afficherlesDecisions(id_recl);
	}
	
	
	@PutMapping("/affecterDecisionAReclamation/{id_client}/{id_deci}") 
	   @ResponseBody
		public void  affecterDecisionAReclamation(@PathVariable("id_client")int id_client,
				@PathVariable("id_deci")int id_deci)
		{

	   try{
		   iDecisionService.affecterDecisionAReclamation(id_client,id_deci);
		  }
	   catch(MailException e){
			  logger.info("Error sending "+e.getMessage());
		  }
		}
}

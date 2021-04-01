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
import tn.esprit.spring.entity.comments;
import tn.esprit.spring.service.commentServiceImpl;

@RestController
public class commentController {
	
	@Autowired
	commentServiceImpl comservice;

	@PostMapping("/addcomments/{idpub}")
	@ResponseBody
    public int addcomments(@RequestBody comments com,@PathVariable("idpub") int idpub) {
		
		comservice.addcomments(com,idpub);
		return com.getIdcomment();
		}
	
	/*
	@PutMapping(value = "/affecterCommentAPub/{idcomment}/{idpub}") 
	public void affecterCommentAPub(@PathVariable("idcomment") int idcomment, @PathVariable("idpub") int idpub) {
		comservice.affecterCommentAPub(idcomment, idpub);
	}
	
	*/
	@GetMapping("/findcmtrbypublication/{idpub}")
	@ResponseBody
	public List <String> findcmtrbypublication(@PathVariable("idpub") int idpub) {
		return  comservice.findcmtrbypublication(idpub);
	

	}
	
	@PutMapping("/update-comment")
	@ResponseBody
	public comments updatecomment(@RequestBody comments com) {
	   return comservice.updatecomments(com);
	}
	
	@DeleteMapping("/remove-com/{idcomment}")
	@ResponseBody
	public void removecomment(@PathVariable("idcomment") int idcomment) {
		comservice.deletecom(idcomment);
		System.out.println("successful deletion");
	}
	
	 @DeleteMapping("/deleteBadJPQL") 
	 @ResponseBody
		public void deleteBadJPQL() {
		 comservice.deleteBadJPQL();
			
		}
	
	 @GetMapping(value= "/nbrcmt/{idpub}")
	public long getNombrecommentsJPQL(@PathVariable("idpub") int idpub){
		return comservice.getNombrecommentsJPQL(idpub);
	}
	
	
	 
	
}

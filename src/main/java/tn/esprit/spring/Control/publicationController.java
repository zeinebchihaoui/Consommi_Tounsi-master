package tn.esprit.spring.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.publication;
import tn.esprit.spring.service.publicationServiceImpl;

@RestController
public class publicationController {

	
	@Autowired
	publicationServiceImpl pubservice;
	
	
	@PostMapping("/addpub")
	@ResponseBody
    public publication addpub(@RequestBody publication pub) {
		System.out.println(" add publication");
		publication publication=pubservice.addpublication(pub);
		return publication;
		}
	
	@PostMapping("/testesujet")
	@ResponseBody
    public int tester(@RequestBody publication pub) {
		System.out.println(" add publication");
		return pubservice.tester(pub);
		 
		}
	
	//pagination
	
	@GetMapping("/getAllPublicationByDate")
	@ResponseBody
	public Page<publication> getAllPublicationByDate(Pageable pag) {
	return pubservice.getAllPublicationByDate(pag) ;
	}
	
	@PutMapping("/update-publication")
	@ResponseBody
	public publication updatepublication(@RequestBody publication pub) {
	   return pubservice.updatepublication(pub);
	}
	
	@DeleteMapping("/remove-pub/{idpub}")
	@ResponseBody
	public void removeUser(@PathVariable("idpub") int idpub) {
		pubservice.deletepub(idpub);
	}
	
	@GetMapping("/getAllpubEtatWaiting")
	@ResponseBody
	public Page<publication> getAllpubEtatWaiting(Pageable pag) {
	return pubservice.getAllpubEtatWaiting(pag);
	}
	
	@PutMapping(value = "/accpeterpublication/{idpub}") 
    @ResponseBody
	public void accpeterpublication(@PathVariable("idpub") int idpub) {
		pubservice.accpeterpublication(idpub);
					
				}
	
	@PutMapping(value = "/Refuserpublication/{idpub}") 
    @ResponseBody
	public void Refuserpublication(@PathVariable("idpub") int idpub) {
		pubservice.Refuserpublication(idpub);
					
				}
	@GetMapping(value= "/nbrpub")
	public long getNombrepublicationJPQL(){
		return pubservice.getNombrepublicationJPQL();
	}
	
	@GetMapping(value= "/getPublicationBySubject/{subject}")
	public List<String> getPublicationBySubject(@PathVariable("subject")String subject){
		return pubservice.getPublicationBySubject(subject);
		
	}
	
	
	
	 @DeleteMapping("/deletePubsWithNoInteractionJPQL") 
	 @ResponseBody
		public void deletePubsWithNoInteractionJPQL() {
		    pubservice.deletePubsNoInteractionJPQL();	
		    System.out.println("done");
		}
	 
	  @PutMapping(value = "/updateRating/{idpub}") 
	  @ResponseBody
		public float updateRatingByPubId(@PathVariable("idpub") int idpub) {
				return pubservice.updateRatingByPubId(idpub);
				
			}
	 
	 
	 //pagination
	 
	 @GetMapping("/publicationbypage")
	 @ResponseBody
		public Page<publication> getPaginated(Pageable page){
			return this.pubservice.findallbypage(page);
		}
		
	
}
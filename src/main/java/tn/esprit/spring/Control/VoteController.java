package tn.esprit.spring.Control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Vote;
import tn.esprit.spring.service.VoteServiceImpl;

@RestController
public class VoteController {

	@Autowired
	VoteServiceImpl voteser;
	
	@PostMapping("/addlike/{idpub}/{idclient}")
	@ResponseBody
	public int AddLikeByPub(Vote v,@PathVariable(value = "idpub")int idpub,@PathVariable(value = "idclient")int idclient ) {
		return voteser.AddLikeByPub(v, idpub, idclient);
		 
	}
	
	
	@PostMapping("/adddislike/{idpub}/{idclient}")
	@ResponseBody
	public int AdddisLikeByPub(Vote v,@PathVariable(value = "idpub")int idpub,@PathVariable(value = "idclient")int idclient ) {
		return voteser.AdddisLikeByPub(v, idpub, idclient);
		
	}
	
	@PutMapping(value = "/editvotelike/{idpub}/{idclient}") 
	@ResponseBody
	public void updateLike(@PathVariable("idpub") int idpub, @PathVariable("idclient") int idclient) {
		voteser.Updatelike(idpub, idclient);
		
	}
	
	@PutMapping(value = "/editvotedislike/{idpub}/{idclient}") 
	@ResponseBody
	public void Updatedislike(@PathVariable("idpub") int idpub, @PathVariable("idclient") int idclient) {
		voteser.Updatedislike(idpub, idclient);
		
	}
	
	@GetMapping(value= "/nbrlike/{idpub}")
	public long NombreLike(@PathVariable("idpub") int idpub){
		return voteser.NombreLike(idpub);
	}
	
	@GetMapping(value= "/nbrdislike/{idpub}")
	public long NombredisLike(@PathVariable("idpub") int idpub){
		return voteser.NombredisLike(idpub);
	}
	
	@GetMapping("/findNomdesClientVoterlikebypub/{idpub}")
	public List<String> findNomdesClientVoterlikebypub(@PathVariable("idpub") int idpub){
		List<String> noms=new ArrayList<String>();
		return voteser.findNomdesClientVoterlikebypub(idpub);
		
	}
	
	@GetMapping("/findNomdesClientVoterdislikebypub/{idpub}")
	public List<String> findNomdesClientVoterdislikebypub(@PathVariable("idpub") int idpub){
		List<String> noms=new ArrayList<String>();
		return voteser.findNomdesClientVoterdislikebypub(idpub);
		
	}
	
	//commentaire
	
	@PostMapping("/AddLikeBycmt/{idcomment}/{idclient}")
	@ResponseBody
	public int AddLikeBycmt(Vote v,@PathVariable(value = "idcomment")int idcomment,@PathVariable(value = "idclient")int idclient ) {
		return voteser.AddLikeBycmt(v, idcomment, idclient);
		 
	}
	
	@PostMapping("/AdddisLikeBycmt/{idcomment}/{idclient}")
	@ResponseBody
	public int AdddisLikeBycmt(Vote v,@PathVariable(value = "idcomment")int idcomment,@PathVariable(value = "idclient")int idclient ) {
		return voteser.AdddisLikeBycmt(v, idcomment, idclient);
		 
	}
	
	@PutMapping(value = "/Updatelikebycmt/{idcomment}/{idclient}") 
	@ResponseBody
	public void Updatelikebycmt(@PathVariable("idcomment") int idcomment, @PathVariable("idclient") int idclient) {
		voteser.Updatelikebycmt(idcomment, idclient);
		
	}
	
	@PutMapping(value = "/Updatedislikebycmt/{idcomment}/{idclient}") 
	@ResponseBody
	public void Updatedislikebycmt(@PathVariable("idcomment") int idcomment, @PathVariable("idclient") int idclient) {
		voteser.Updatedislikebycmt(idcomment, idclient);
		
	}
	
	
	@GetMapping(value= "/nbrlikecmt/{idcomment}")
	public long NombreLikecmt(@PathVariable("idcomment") int idcomment){
		return voteser.NombreLikecmt(idcomment);
	}
	
	@GetMapping(value= "/nbrdislikecmt/{idcomment}")
	public long NombredisLikecmt(@PathVariable("idcomment") int idcomment){
		return voteser.NombredisLikecmt(idcomment);
	}
	
	 @GetMapping(value= "/comtplusperienents")
		public List<String> commentaireplusperienents(){
			return voteser.commentaireplusperienents();
		}
}

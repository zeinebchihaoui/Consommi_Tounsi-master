package tn.esprit.spring.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.service.RatingServiceImpl;

@RestController
public class RatingController {

	@Autowired
	RatingServiceImpl ratservice;
	
	@PostMapping(value = "/addRating/{idclient}/{idpub}/{rating}") 
	@ResponseBody
		public void addRatingByPubId(Rating rat,@PathVariable("idclient") int idclient,@PathVariable("rating") Integer rating, @PathVariable("idpub") int idpub) {
		     ratservice.addRatingByPubId(rat,idclient,rating,idpub);
				
			}
}

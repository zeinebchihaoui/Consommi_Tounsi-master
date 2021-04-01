package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.Repository.RatingRepository;
import tn.esprit.spring.Repository.publicationRepository;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.publication;

@Service
public class RatingServiceImpl implements RatingService {
	
	
	@Autowired
	 RatingRepository ratrep;
	
	@Autowired
	 publicationRepository pubrep;
	
	@Autowired
	 ClientRepository clientrep;
	
	
	public void addRatingByPubId(Rating rat,int idclient, Integer rating, int idpub ) {
		publication pub = pubrep.findById(idpub).get();
		Client client=clientrep.findById(idclient).get();
		rat.setPublication(pub);
		rat.setClient(client);
        rat.setRating(rating);
		ratrep.save(rat);
		
	}

}

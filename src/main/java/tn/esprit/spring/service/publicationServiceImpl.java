package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.RatingRepository;
import tn.esprit.spring.Repository.VusRepository;
import tn.esprit.spring.Repository.publicationRepository;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.publication;

@Service
public class publicationServiceImpl implements publicationService{

	@Autowired
	 publicationRepository pubrep;
	
	@Autowired
	 VusRepository vusrep;
	
	@Autowired
	 RatingRepository ratrep;

	private static final Logger L=LogManager.getLogger(publicationServiceImpl.class);
	
	
	public publication addpublication(publication pub) {
		Date currentSqlDate= new Date (System.currentTimeMillis());
		pub.setDate_discussion(currentSqlDate);
		pub.setRating(0);
		pub.setEtat("Waiting");
		return pubrep.save(pub);
	}

	public int tester(publication pub) {
	
		String subject1 = pub.getSubject();
		List<String> listsubject =pubrep.getAllbysubject();
		
			if ( listsubject.contains(subject1) ){
			
			 System.out.println("subject already inserted");
		}
			else {
			Date currentSqlDate= new Date (System.currentTimeMillis());
			pub.setDate_discussion(currentSqlDate);
			pub.setEtat("Waiting");
			pub.setRating(0);
	           pubrep.save(pub);
			
			} 
	
		return  pub.getIdpub();
				
	}
	
	
	
	public publication updatepublication(publication pub) {
		
		return pubrep.save(pub);
	}

	public List<publication> findall() {
		return (List<publication>)pubrep.findAll();
	}

	public void deletepub(int idpub) {
		pubrep.deleteById(idpub);
		
	}

	public long getNombrepublicationJPQL() {
		return pubrep.getNombrepublicationJPQL();
	}
	
	public Page<publication> getAllPublicationByDate(Pageable pag) {
		return pubrep.getAllPublicationByDate(pag);
	}

	public List<String> getPublicationBySubject(String subject) {
				return pubrep.getPublicationBySubject(subject);
	}
	

	public void deletePubsNoInteractionJPQL() {
		
		
		pubrep.deletePubsWithNoInteractionJPQL();
		System.out.println("done");
		
	}

	//admin
	
	public float updateRatingByPubId(int idpub) {
		publication pub = pubrep.findById(idpub).get();
		float sum =pubrep.sumrating(idpub);
		float nb =pubrep.countrating(idpub);
		float moyenne=sum/nb;
		pub.setRating(moyenne);
		pubrep.save(pub);
		return moyenne;
		
	}
	
	//administrateur
	
	public void accpeterpublication(int idpub) {
		publication pub = pubrep.findById(idpub).get();
		pub.setEtat("Accepted");
		pubrep.save(pub);
		
	}
	
	public void Refuserpublication(int idpub) {
			publication sujet=pubrep.findById(idpub).get();
			sujet.setEtat("Refused");
			pubrep.save(sujet);
		}
	
	public Page<publication> getAllpubEtatWaiting(Pageable pag) {
		return pubrep.getAllpubEtatWaiting(pag);
	}
	

	
	
	//---------api pagination
	
	public Page<publication> findallbypage(Pageable pag) {
		return pubrep.findAll(pag);
		
		}

}

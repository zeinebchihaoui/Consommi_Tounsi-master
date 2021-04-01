package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.publication;

public interface publicationService {

	//add publication
	public publication addpublication(publication pub);
	//update publication
	public publication updatepublication(publication pub);
	//affiche
	public List<publication> findall();
	//delete
	public void deletepub(int idpub);
	
	public long getNombrepublicationJPQL();
	
	public Page<publication> getAllPublicationByDate(Pageable pag);
	
	public List<String> getPublicationBySubject(String subject);
	
	public void deletePubsNoInteractionJPQL();
	
	Page<publication> findallbypage(Pageable pag);
	
	public float updateRatingByPubId( int idpub );
	
	public void accpeterpublication(int idpub);
	
	public void Refuserpublication(int idpub) ;
	
	public Page<publication> getAllpubEtatWaiting(Pageable pag) ;
	
	//public void sendmail() throws MailException;
	
	public int tester(publication pub) ;
	
	//public int calculerrating(publication pub);
}

package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.publication;


public interface publicationRepository extends CrudRepository <publication,Integer>,PagingAndSortingRepository<publication, Integer> {
	
	publication findByidpub(int idpub); 
	
	@Query("SELECT COUNT(p) FROM publication p where etat='Accepted'")
	public long getNombrepublicationJPQL();
	
//@Query("SELECT p.subject,p.contents ,p.date_discussion FROM publication p order by p.date_discussion DESC ")
	@Query("SELECT p.Client.name_client,p.subject,p.contents ,p.date_discussion FROM publication p where etat='Accepted'  order by p.date_discussion DESC ")
	public Page<publication> getAllPublicationByDate(Pageable pag);
	
	@Query("SELECT p.Client.name_client,p.subject,p.contents ,p.date_discussion FROM publication p where subject= :subject order by p.date_discussion DESC")
	public List<String> getPublicationBySubject(@Param("subject")String subject);
	
	@Query("SELECT subject FROM publication")
	public List<String> getAllbysubject();
	//p.Client.name_client, p.subject,p.contents ,p.date_discussion,p.views
	
	
	@Modifying
	@Transactional
    @Query(value="Delete from publication where DATEDIFF(CURRENT_TIMESTAMP,date_discussion)>=15 and rating=0",nativeQuery=true)
    public void deletePubsWithNoInteractionJPQL();
	
	
	@Query("SELECT p.Client.name_client,p.subject,p.contents,p.date_discussion FROM publication p where etat='waiting' ORDER BY date_discussion DESC")
	public Page<publication> getAllpubEtatWaiting(Pageable pag);
	
	
	@Query(value="select SUM(rating) FROM rating where idpub=:idpub",nativeQuery=true)
	public float sumrating(@Param("idpub")int idpub);
	
	
	@Query(value="select COUNT(id) FROM rating r where idpub=:idpub",nativeQuery=true)
	public float countrating(@Param("idpub")int idpub);
	
	
	// api pagination
	Page<publication> findAll(Pageable pageable);
}
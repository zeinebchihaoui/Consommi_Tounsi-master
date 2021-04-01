package tn.esprit.spring.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.comments;
import tn.esprit.spring.entity.publication;

public interface commentRepository  extends CrudRepository <comments,Integer> {
	
	//comments findByidcomment(int idcomment);
	@Query("SELECT COUNT(contents) FROM comments c where idpub= :idpub ")
	public long getNombrecommentsJPQL(@Param("idpub")int idpub);
	
	@Modifying
    @Transactional
    @Query("DELETE from comments c where c.contents='***'")
    public void deleteBadJPQL();
	
	@Query(value ="SELECT c.Client.name_client,c.contents,c.dateComment FROM comments c where idpub= :idpub order by c.dateComment DESC")
	public List<String> findcmtrbypublication(@Param("idpub")int idpub);
	
	
	
	/*
	@Query("SELECT COUNT(likes) from comments where likes=1 and idpub=:idpub ")
	public int NombreLike(@Param("idpub")int idpub);
	
	
	@Query("SELECT COUNT(dislike) from comments where dislike=1 and idpub=:idpub  ")
	public int Nombredislike(@Param("idpub")int idpub);
	*/
}

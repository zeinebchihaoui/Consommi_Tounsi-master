package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Vote;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends CrudRepository <Vote,Integer> {

	@Query(value="select * from vote where idpub=?1 AND id_client=?2",nativeQuery=true)
	public Vote getVoteBypubAndclient(int idpub,int id_client);
	
	@Query(value="select * from vote where idcomment=?1 AND id_client=?2",nativeQuery=true)
	public Vote getVoteBycommentAndclient(int idcomment,int id_client);
	
	
	
	@Query("SELECT COUNT(liked) from Vote where liked=1 and idpub=:idpub ")
	public int NombreLike(@Param("idpub")int idpub);
	
	@Query("SELECT COUNT(dislike) from Vote where dislike=1 and idpub=:idpub  ")
	public int Nombredislike(@Param("idpub")int idpub);
	
	@Query("SELECT COUNT(liked) from Vote where liked=1 and idcomment=:idcomment ")
	public int NombreLikecmt(@Param("idcomment")int idcomment);
	
	@Query("SELECT COUNT(dislike) from Vote where dislike=1 and idcomment=:idcomment  ")
	public int Nombredislikecmt(@Param("idcomment")int idcomment);
	
	@Query(value="SELECT client.name_client,c.contents,COUNT(v.liked) FROM vote v ,comments c,client where v.idcomment=c.idcomment and client.id_client=c.id_client GROUP BY v.idcomment ORDER by COUNT(v.liked) DESC LIMIT 5", nativeQuery =true)
	public List<String> commentaireplusperienents();
}

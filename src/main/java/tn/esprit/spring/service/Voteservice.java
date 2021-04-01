package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Vote;

public interface Voteservice {
	
	public int AddLikeByPub(Vote v,int idpub,int idclient );
	public int AdddisLikeByPub(Vote v,int idpub,int idclient );
	public void Updatelike(int idpub,int id_client) ;
	public void Updatedislike(int idpub,int id_client) ;
	public int NombreLike(int idpub);
	public int NombredisLike(int idpub);
	public List<String> findNomdesClientVoterlikebypub(int idpub) ;
	public List<String> findNomdesClientVoterdislikebypub(int idpub);
	public int AddLikeBycmt(Vote v,int idcomment,int idclient );
	public int AdddisLikeBycmt(Vote v,int idcomment,int idclient );
	public void Updatelikebycmt(int idcomment,int idclient) ;
	public void Updatedislikebycmt(int idcomment,int idclient) ;
	public int NombreLikecmt(int idpub);
	public int NombredisLikecmt(int idpub);
	public List<String> commentaireplusperienents();
	
}

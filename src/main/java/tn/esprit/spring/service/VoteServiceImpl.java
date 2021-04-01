package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.Repository.publicationRepository;
import tn.esprit.spring.Repository.VoteRepository;
import tn.esprit.spring.Repository.commentRepository;
import tn.esprit.spring.entity.Client;

import tn.esprit.spring.entity.Vote;
import tn.esprit.spring.entity.comments;
import tn.esprit.spring.entity.publication;

@Service
public class VoteServiceImpl implements Voteservice {

	
	@Autowired
	 publicationRepository pubrep;
	
	@Autowired
	 VoteRepository voterep;
	
	@Autowired
	 ClientRepository clientrep;
	
	@Autowired
	 commentRepository comrep;
	
	
	
//publication
	
	public int AddLikeByPub(Vote v,int idpub,int idclient ) {
		v.setLiked(1);
		v.setDislike(0);
		publication pub=pubrep.findById(idpub).get();
		Client client=clientrep.findById(idclient).get();
		v.setClient(client);
		v.setPublication(pub);
			voterep.save(v);
			return 0;
	}

	public int AdddisLikeByPub(Vote v, int idpub, int idclient) {
		v.setLiked(0);
		v.setDislike(1);
		publication pub=pubrep.findById(idpub).get();
		Client client=clientrep.findById(idclient).get();
		v.setClient(client);
		v.setPublication(pub);
			voterep.save(v);
			return 0;
	}
	
	
	public void Updatelike(int idpub,int id_client) {
		Vote v=voterep.getVoteBypubAndclient(idpub, id_client);
		v.setLiked(0);
		voterep.save(v);

	}

	public void Updatedislike(int idpub, int id_client) {
		Vote v=voterep.getVoteBypubAndclient(idpub, id_client);
		v.setDislike(0);
		voterep.save(v);
		
	}

	public int NombreLike(int idpub) {
		return voterep.NombreLike(idpub);
	}

	public int NombredisLike(int idpub) {
		return voterep.NombreLike(idpub);
	}
	
	
	public List<String> findNomdesClientVoterlikebypub(int idpub) {
		publication pub = pubrep.findById(idpub).get();
		List<String> noms = new ArrayList<String>();
		
		for (Vote v : pub.getVote())
			if (v.getLiked()==1)
			noms.add(v.getClient().getName_client() );
		return noms;
	}
	
	public List<String> findNomdesClientVoterdislikebypub(int idpub) {
		publication pub = pubrep.findById(idpub).get();
		List<String> noms = new ArrayList<String>();
		
		for (Vote v : pub.getVote())
			if (v.getDislike()==1)
			noms.add(v.getClient().getName_client() );
		return noms;
	}
	
//commentaire
	
	public int AddLikeBycmt(Vote v, int idcomment, int idclient) {
		v.setLiked(1);
		v.setDislike(0);
		Client client=clientrep.findById(idclient).get();
		comments cmt=comrep.findById(idcomment).get();
		v.setClient(client);
		v.setComments(cmt);
			voterep.save(v);
			return 0;
	}

	public int AdddisLikeBycmt(Vote v, int idcomment, int idclient) {
		v.setLiked(0);
		v.setDislike(1);
		comments cmt=comrep.findById(idcomment).get();
		Client client=clientrep.findById(idclient).get();
		v.setClient(client);
		v.setComments(cmt);
			voterep.save(v);
			return 0;
	}

	public void Updatelikebycmt(int idcomment, int id_client) {
		Vote v=voterep.getVoteBycommentAndclient(idcomment, id_client);
		v.setLiked(0);
		voterep.save(v);
	}

	public void Updatedislikebycmt(int idcomment, int id_client) {
		Vote v=voterep.getVoteBycommentAndclient(idcomment, id_client);
		v.setDislike(0);
		voterep.save(v);
		
	}

	public int NombreLikecmt(int idcomment) {
		return voterep.NombreLikecmt(idcomment);
	}

	public int NombredisLikecmt(int idcomment) {
		return voterep.Nombredislikecmt(idcomment);
	}

	public List<String> commentaireplusperienents() {
		return voterep.commentaireplusperienents();
	}
}

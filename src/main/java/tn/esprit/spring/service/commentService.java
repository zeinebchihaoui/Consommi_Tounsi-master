package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.comments;

public interface commentService {
	
	//add comment
	   public int addcomments(comments comment, int idpub);
	
		//update comment
		public comments updatecomments(comments com);
		//comment
		public List<String> findcmtrbypublication(int idpub);
		//delete
		public void deletecom(int idcomment);
		
		public long getNombrecommentsJPQL(int idpub);
		
		public void deleteBadJPQL();
		
		
		
		
}

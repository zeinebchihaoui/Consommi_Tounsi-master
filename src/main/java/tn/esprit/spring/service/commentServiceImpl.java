package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.commentRepository;
import tn.esprit.spring.Repository.publicationRepository;
import tn.esprit.spring.entity.comments;
import tn.esprit.spring.entity.publication;

@Service
public class commentServiceImpl implements commentService{

	@Autowired
	 commentRepository comrep;
	
	@Autowired
	 publicationRepository pubrep;
	
	private static final Logger L=LogManager.getLogger(commentServiceImpl.class);
	
	
	public int addcomments(comments comment, int idpub) {
		
		
		String commentWords = comment.getContents();
		List<String> badwords1=new ArrayList<String>();
		badwords1.add("bad");
		badwords1.add("words");
		badwords1.add("bads");
		
		if (badwords1.contains(commentWords))
		{    
		     publication pub = pubrep.findById(idpub).get(); 
		     comment.setPublication(pub);
			comment.setContents("***");
			Date currentSqlDate= new Date (System.currentTimeMillis());
			comment.setDateComment(currentSqlDate);
			 comrep.save(comment);
		}
		else
		{   
	       publication pub = pubrep.findById(idpub).get(); 
	       comment.setPublication(pub);
			
			Date currentSqlDate= new Date (System.currentTimeMillis());
			comment.setDateComment(currentSqlDate);
			 comrep.save(comment);
			
					}

		 return comment.getIdcomment();
	}
	
	
	
	/*
	public void affecterCommentAPub(int idcomment, int idpub) {
		comments comment = comrep.findById(idcomment).get();   
		publication pub = pubrep.findById(idpub).get();
		comment.setPublication(pub);
		comrep.save(comment);
		
	}*/

	public comments updatecomments(comments comment) {
		
		String badwords[] = new String[] { 
				  "bad", "words", "bads" };
		String commentWords[] = comment.getContents().split(" ");
		
     for(String a : commentWords){
			 
	   for(String b : badwords){
			 
		if (b.contains(a))
		{   
			comment.setContents("***");
			Date currentSqlDate= new Date (System.currentTimeMillis());
			comment.setDateComment(currentSqlDate);
			 comrep.save(comment);
		}
		else
		{
			Date currentSqlDate= new Date (System.currentTimeMillis());
			comment.setDateComment(currentSqlDate);
			 comrep.save(comment);
			
					}}}
           return comment;
	
	
	}

	public void deletecom(int idcomment) {
		comrep.deleteById(idcomment);
		
	}

	public List<String> findcmtrbypublication(int idpub) {
		return comrep.findcmtrbypublication(idpub);
	}

	
	public long getNombrecommentsJPQL(int idpub) {
	
		return comrep.getNombrecommentsJPQL(idpub) ;
	}

	
	
	public void deleteBadJPQL() {
		comrep.deleteBadJPQL();
	}
	
	
	
	
}

	
		
		



	
	
	
	
	


	



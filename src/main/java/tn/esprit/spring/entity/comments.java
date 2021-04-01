package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="comments")
public class comments implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int idcomment;
	
	 @Column(name="contents")
	 @NotEmpty(message = "the content field is required")
     private String contents;
	 
     @Temporal(TemporalType.TIMESTAMP)
 	 @Column(name="dateComment")
     private Date dateComment;
     
    @ManyToOne
    @JoinColumn(name="idpub")
	publication publication; 
	 
    @ManyToOne
    @JoinColumn(name="id_client")
	Client Client;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_admin")
	Administrator admin;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="comments")
	private Set<Vote> Vote ;
    
    
	public comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public comments(int idcomment, String contents, Date dateComment, tn.esprit.spring.entity.publication publication) {
		super();
		this.idcomment = idcomment;
		this.contents = contents;
		this.dateComment = dateComment;
		this.publication = publication;
	
	}



	public int getIdcomment() {
		return idcomment;
	}
	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDateComment() {
		return dateComment;
	}
	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}
	public publication getPublication() {
		return publication;
	}
	public void setPublication(publication publication) {
		this.publication = publication;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}


	public Set<Vote> getVote() {
		return Vote;
	}

	public void setVote(Set<Vote> vote) {
		Vote = vote;
	}

	
	
}

package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Vote")
public class Vote implements java.io.Serializable { 

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	@ManyToOne
	@JoinColumn(name="idcomment")
	comments comments; 

	@ManyToOne
    @JoinColumn(name="id_client")
	Client Client;
	
	@ManyToOne
	@JoinColumn(name="idpub")
	publication publication; 

	@Column(name="liked")
    private int liked ;
	
	@Column(name="dislike")
    private int dislike ;
	


	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Vote(int id,int liked) {
		super();
		this.id = id;
		this.liked = liked;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	

	public comments getComments() {
		return comments;
	}


	public void setComments(comments comments) {
		this.comments = comments;
	}


	public publication getPublication() {
		return publication;
	}


	public void setPublication(publication publication) {
		this.publication = publication;
	}


	public int getLiked() {
		return liked;
	}


	public void setLiked(int liked) {
		this.liked = liked;
	}


	public Client getClient() {
		return Client;
	}


	public void setClient(Client client) {
		Client = client;
	}


	public int getDislike() {
		return dislike;
	}


	public void setDislike(int dislike) {
		this.dislike = dislike;
	}


	
}

package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rating")
public class Rating implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_client")
	Client Client;

	@ManyToOne
	@JoinColumn(name = "idpub")
	publication publication;

	private int rating;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(int id, int rating) {
		super();
		this.id = id;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public publication getPublication() {
		return publication;
	}

	public void setPublication(publication publication) {
		this.publication = publication;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

}

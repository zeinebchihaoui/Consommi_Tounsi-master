package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Vus")
public class Vus implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int nbVus;
	
	@Temporal (TemporalType.DATE)
    private Date dateAjout;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "idpub")
	publication publication;

	@ManyToOne
    @JoinColumn(name="id_client")
	Client Client;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbVus() {
		return nbVus;
	}

	public void setNbVus(int nbVus) {
		this.nbVus = nbVus;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
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
	
	
	
	
}

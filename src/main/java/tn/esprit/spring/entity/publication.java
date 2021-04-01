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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "publication")

public class publication implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpub")
	private int idpub;

	@Column(name = "subject", unique = true)
	@Size(max = 20)
	@NotEmpty(message = "the subject field is required")
	private String subject;

	@Column(name = "contents", nullable = true)
	@Size(max = 20000)
	@NotEmpty(message = "the content field is required")
	private String contents;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_discussion")
	private Date date_discussion;

	@Column(name = "rating")
	private float rating;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publication")
	private Set<comments> comments;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publication")
	private Set<Vote> Vote;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publication")
	private Set<Vus> Vus;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publication")
	private Set<Rating> Rating;

	@ManyToOne
	@JoinColumn(name = "id_client")
	Client Client;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_admin")
	Administrator admin;

	@Column(name = "etat")
	private String etat;

	public publication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public publication(int idpub, String subject, String contents, Date date_discussion,
			Set<tn.esprit.spring.entity.comments> comments, int rating, String etat) {
		super();
		this.idpub = idpub;
		this.subject = subject;
		this.contents = contents;
		this.date_discussion = date_discussion;
		this.comments = comments;
		this.rating = rating;
		this.etat = etat;
	}

	public int getIdpub() {
		return idpub;
	}

	public void setIdpub(int idpub) {
		this.idpub = idpub;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getDate_discussion() {
		return date_discussion;
	}

	public void setDate_discussion(Date date_discussion) {
		this.date_discussion = date_discussion;
	}

	public Set<comments> getComments() {
		return comments;
	}

	public void setComments(Set<comments> comments) {
		this.comments = comments;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Set<Vus> getVus() {
		return Vus;
	}

	public void setVus(Set<Vus> vus) {
		Vus = vus;
	}

	public void setRating(Set<Rating> rating) {
		Rating = rating;
	}

}

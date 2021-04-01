package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_client;

	@Column(name = "name_client")
	private String name_client;

	@Column(name = "phone_num_client")
	private int phone_num_client;

	@Column(name = "email_client")
	private String email_client;

	@Column(name = "password_client")
	private String password_client;

	@Column(name = "actived")
	private boolean actived;

	@Column(name = "city_client")
	private String city_client;

	@Column(name = "adress_client")
	private String adress_client;

	@Column(name = "postal_code_client")
	private int postal_code_client;

	@Column(name = "username")
	private String username;

	@OneToMany(mappedBy = "client")
	private List<Reclamation> reclamations;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Client")
	private List<comments> comments;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Client")
	private List<publication> publication;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Client")
	private List<Vote> Vote;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Client")
	private List<Vus> Vus;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Client")
	private List<Rating> Rating;

	@OneToMany(mappedBy = "client")
	private List<Order> orders;

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getName_client() {
		return name_client;
	}

	public void setName_client(String name_client) {
		this.name_client = name_client;
	}

	public int getPhone_num_client() {
		return phone_num_client;
	}

	public void setPhone_num_client(int phone_num_client) {
		this.phone_num_client = phone_num_client;
	}

	public String getEmail_client() {
		return email_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}

	public String getPassword_client() {
		return password_client;
	}

	public void setPassword_client(String password_client) {
		this.password_client = password_client;
	}

	public String getCity_client() {
		return city_client;
	}

	public void setCity_client(String city_client) {
		this.city_client = city_client;
	}

	public int getPostal_code_client() {
		return postal_code_client;
	}

	public void setPostal_code_client(int postal_code_client) {
		this.postal_code_client = postal_code_client;
	}

	public List<comments> getComments() {
		return comments;
	}

	public void setComments(List<comments> comments) {
		this.comments = comments;
	}

	public List<publication> getPublication() {
		return publication;
	}

	public void setPublication(List<publication> publication) {
		this.publication = publication;
	}

	public List<Vote> getVote() {
		return Vote;
	}

	public void setVote(List<Vote> vote) {
		Vote = vote;
	}

	public List<Vus> getVus() {
		return Vus;
	}

	public void setVus(List<Vus> vus) {
		Vus = vus;
	}

	public List<Rating> getRating() {
		return Rating;
	}

	public void setRating(List<Rating> rating) {
		Rating = rating;
	}

	public String getAdress_client() {
		return adress_client;
	}

	public void setAdress_client(String adress_client) {
		this.adress_client = adress_client;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Client(int id_client, String name_client, int phone_num_client, String email_client, String password_client,
			boolean actived, String city_client, String adress_client, int postal_code_client, String username,
			List<Reclamation> reclamations, List<tn.esprit.spring.entity.comments> comments,
			List<tn.esprit.spring.entity.publication> publication, List<tn.esprit.spring.entity.Vote> vote,
			List<tn.esprit.spring.entity.Vus> vus, List<tn.esprit.spring.entity.Rating> rating, List<Order> orders) {
		super();
		this.id_client = id_client;
		this.name_client = name_client;
		this.phone_num_client = phone_num_client;
		this.email_client = email_client;
		this.password_client = password_client;
		this.actived = actived;
		this.city_client = city_client;
		this.adress_client = adress_client;
		this.postal_code_client = postal_code_client;
		this.username = username;
		this.reclamations = reclamations;
		this.comments = comments;
		this.publication = publication;
		Vote = vote;
		Vus = vus;
		Rating = rating;
		this.orders = orders;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

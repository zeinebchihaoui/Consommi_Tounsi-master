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
@Table(name = "administrator")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_admin;

	@Column(name = "username")
	private String username;

	@Column(name = "name_admin")
	private String name_admin;

	@Column(name = "actived")
	private boolean actived;

	@Column(name = "email_admin")
	private String email_admin;

	@Column(name = "password_admin")
	private String password_admin;

	@OneToMany(mappedBy = "administrator")
	private List<Delivery_Man> delivery_mans;

	@OneToMany(mappedBy = "administrator")
	private List<Delivery> deliverys;

	@OneToMany(mappedBy = "administrator")
	private List<Reclamation> reclamations;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
	private List<comments> comments;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
	private List<publication> publication;

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

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Delivery> getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public List<Delivery_Man> getDelivery_mans() {
		return delivery_mans;
	}

	public void setDelivery_mans(List<Delivery_Man> delivery_mans) {
		this.delivery_mans = delivery_mans;
	}

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getName_admin() {
		return name_admin;
	}

	public void setName_admin(String name_admin) {
		this.name_admin = name_admin;
	}

	public String getEmail_admin() {
		return email_admin;
	}

	public void setEmail_admin(String email_admin) {
		this.email_admin = email_admin;
	}

	public String getPassword_admin() {
		return password_admin;
	}

	public void setPassword_admin(String password_admin) {
		this.password_admin = password_admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Administrator(int id_admin, String username, String name_admin, boolean actived, String email_admin,
			String password_admin, List<Delivery_Man> delivery_mans, List<Delivery> deliverys,
			List<Reclamation> reclamations, List<tn.esprit.spring.entity.comments> comments,
			List<tn.esprit.spring.entity.publication> publication) {
		super();
		this.id_admin = id_admin;
		this.username = username;
		this.name_admin = name_admin;
		this.actived = actived;
		this.email_admin = email_admin;
		this.password_admin = password_admin;
		this.delivery_mans = delivery_mans;
		this.deliverys = deliverys;
		this.reclamations = reclamations;
		this.comments = comments;
		this.publication = publication;
	}

	public Administrator() {
		super();
	}

	@Override
	public String toString() {
		return "Administrator [id_admin=" + id_admin + ", username=" + username + ", name_admin=" + name_admin
				+ ", actived=" + actived + ", email_admin=" + email_admin + ", password_admin=" + password_admin
				+ ", delivery_mans=" + delivery_mans + ", deliverys=" + deliverys + ", reclamations=" + reclamations
				+ ", comments=" + comments + ", publication=" + publication + "]";
	}

}

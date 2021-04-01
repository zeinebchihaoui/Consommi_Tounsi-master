package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="delivery")

public class Delivery implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_deliv;
	
	@Column(name="date_debut")
	private Timestamp date_debut;
	
	@Column(name="date_fin")
	private Timestamp date_fin;
	
	@Column(name="location")
	private String location;
	
	@Column(name="weight")
	private float weight;
	
	@Column(name="fresh")
	private float fresh;
	
	@Column(name="moyen_T")
	private String moyenT;

	@ManyToOne
    @JoinColumn(name="id_deliv_man")
	Delivery_Man delivery_man;
	
	@ManyToOne
    @JoinColumn(name="id_administrator")
	Administrator administrator;
	
	@OneToOne
    @JoinColumn(name="id_order")
	private Order order;

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(int id_deliv, Timestamp date_debut, Timestamp date_fin, String location, float weight, float fresh,
			String moyenT, Delivery_Man delivery_man, Administrator administrator, Order order) {
		super();
		this.id_deliv = id_deliv;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.location = location;
		this.weight = weight;
		this.fresh = fresh;
		this.moyenT = moyenT;
		this.delivery_man = delivery_man;
		this.administrator = administrator;
		this.order = order;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public int getId_deliv() {
		return id_deliv;
	}

	public void setId_deliv(int id_deliv) {
		this.id_deliv = id_deliv;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Timestamp date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Timestamp date_fin) {
		this.date_fin = date_fin;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getFresh() {
		return fresh;
	}

	public void setFresh(float fresh) {
		this.fresh = fresh;
	}

	public String getMoyenT() {
		return moyenT;
	}

	public void setMoyenT(String moyenT) {
		this.moyenT = moyenT;
	}

	public Delivery_Man getDelivery_man() {
		return delivery_man;
	}

	public void setDelivery_man(Delivery_Man delivery_man) {
		this.delivery_man = delivery_man;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}

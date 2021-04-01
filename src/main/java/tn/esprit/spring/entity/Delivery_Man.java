package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_man")
public class Delivery_Man implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_deliv_man;

	@Column(name = "name_deliv_man")
	private String name_deliv_man;

	@Column(name = "phone_num_deliv_man")
	private int phone_num_deliv_man;

	@Column(name = "email_deliv_man")
	private String email_deliv_man;

	@Column(name = "chargeT_liv")
	private int chargeT_liv;

	@Column(name = "etat")
	private boolean etat;

	@OneToMany(mappedBy = "delivery_man")
	private List<Delivery> deliverys;

	@ManyToOne
	@JoinColumn(name = "id_administrator")
	Administrator administrator;

	public Delivery_Man() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery_Man(int id_deliv_man, String name_deliv_man, int phone_num_deliv_man, String email_deliv_man,
			int chargeT_liv, boolean etat, List<Delivery> deliverys, Administrator administrator) {
		super();
		this.id_deliv_man = id_deliv_man;
		this.name_deliv_man = name_deliv_man;
		this.phone_num_deliv_man = phone_num_deliv_man;
		this.email_deliv_man = email_deliv_man;
		this.chargeT_liv = chargeT_liv;
		this.etat = etat;
		this.deliverys = deliverys;
		this.administrator = administrator;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public List<Delivery> getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public int getId_deliv_man() {
		return id_deliv_man;
	}

	public void setId_deliv_man(int id_deliv_man) {
		this.id_deliv_man = id_deliv_man;
	}

	public String getName_deliv_man() {
		return name_deliv_man;
	}

	public void setName_deliv_man(String name_deliv_man) {
		this.name_deliv_man = name_deliv_man;
	}

	public int getPhone_num_deliv_man() {
		return phone_num_deliv_man;
	}

	public void setPhone_num_deliv_man(int phone_num_deliv_man) {
		this.phone_num_deliv_man = phone_num_deliv_man;
	}

	public String getEmail_deliv_man() {
		return email_deliv_man;
	}

	public void setEmail_deliv_man(String email_deliv_man) {
		this.email_deliv_man = email_deliv_man;
	}

	public int getChargeT_liv() {
		return chargeT_liv;
	}

	public void setChargeT_liv(int chargeT_liv) {
		this.chargeT_liv = chargeT_liv;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

}

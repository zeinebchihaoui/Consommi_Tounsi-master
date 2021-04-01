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

@Entity
@Table (name = "orders")
public class Order implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_ord;

	@Temporal (TemporalType.DATE)
	private java.util.Date date_order;
	
	@ManyToOne
    @JoinColumn(name="id_client")
	Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Order(int id_ord, Date date_order) {
		super();
		this.id_ord = id_ord;
		this.date_order = date_order;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_ord() {
		return id_ord;
	}

	public void setId_ord(int id_ord) {
		this.id_ord = id_ord;
	}

	public java.util.Date getDate_order() {
		return date_order;
	}

	public void setDate_order(java.util.Date date_order) {
		this.date_order = date_order;
	}
	
	
	
}

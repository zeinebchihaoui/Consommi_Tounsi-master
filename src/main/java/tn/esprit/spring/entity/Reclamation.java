package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reclamation")
public class Reclamation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_recl;

	@Column(name = "object")
	private String object;

	@Column(name = "content")
	private String content;

	@ManyToOne
	@JoinColumn(name = "id_client")
	Client client;

	@ManyToOne
	@JoinColumn(name = "id_administrator")
	Administrator administrator;

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reclamation(int id_recl, String object, String content, Client client, Administrator administrator) {
		super();
		this.id_recl = id_recl;
		this.object = object;
		this.content = content;
		this.client = client;
		this.administrator = administrator;

	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getId_recl() {
		return id_recl;
	}

	public void setId_recl(int id_recl) {
		this.id_recl = id_recl;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "decision")
public class Decision implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_deci")
	private int id_deci;
	
	@Column(name="typedecision")
	private String typedecision;

	@OneToOne
    @JoinColumn(name="id_recl")
    private Reclamation reclamation;
	
	public Decision() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Decision(int id_deci, String typedecision, Reclamation reclamation) {
		super();
		this.id_deci = id_deci;
		this.typedecision = typedecision;
		this.reclamation = reclamation;
	}

	public int getId_deci() {
		return id_deci;
	}

	public void setId_deci(int id_deci) {
		this.id_deci = id_deci;
	}

	public String getTypedecision() {
		return typedecision;
	}

	public void setTypedecision(String typedecision) {
		this.typedecision = typedecision;
	}

	public Reclamation getReclamation() {
		return reclamation;
	}

	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}

}

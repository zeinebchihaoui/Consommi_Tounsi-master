package tn.esprit.spring.entity;

public class Stat {
	public int nbmission;
	public String username;
	
	
	public int getNbmission() {
		return nbmission;
	}
	public void setNbmission(int nbmission) {
		this.nbmission = nbmission;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Stat(int nbmission, String username) {
		super();
		this.nbmission = nbmission;
		this.username = username;
	}
	
	
	
	
	
	

}

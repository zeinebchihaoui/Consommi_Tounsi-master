package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Vus;

public interface VusService {
	public Vus addvus(Vus v,int idpub,int idclient);
	public long getNombrevus(int idpub);
	public List<String> troisTopViews();
	
	
}

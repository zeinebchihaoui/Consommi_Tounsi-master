package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.Repository.VusRepository;
import tn.esprit.spring.Repository.publicationRepository;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Vus;
import tn.esprit.spring.entity.publication;

@Service
public class VusServcieImpl implements VusService{

	@Autowired
	 publicationRepository pubrep;
	
	@Autowired
	 VusRepository vusrep;
	
	@Autowired
	 ClientRepository clientrep;
	
	public Vus addvus(Vus v,int idpub,int idclient) {
		publication pub = pubrep.findById(idpub).get();
		Client client=clientrep.findById(idclient).get();
		Date currentSqlDate= new Date (System.currentTimeMillis());
		v.setDateAjout(currentSqlDate);
		v.setPublication(pub);
		v.setClient(client);
		v.setNbVus(1);
		return vusrep.save(v);
		
	}
	
	public long getNombrevus(int idpub) {
		return vusrep.getNombreVusbypub(idpub);
	}

	public List<String> troisTopViews() {
		return vusrep.troisTopViews();
	}

	
		
	}

	
	


package tn.esprit.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.ReclamationRepository;
import tn.esprit.spring.entity.Reclamation;

@Service
public class ReclamationService implements IReclamationService{
	
	@Autowired
	private ReclamationRepository reclamationRepo; 
	
	
	public Reclamation saveReclamation(Reclamation reclamation) {
		return reclamationRepo.save(reclamation);
	}


	public Reclamation updateReclamation(Reclamation reclamation) {
		return reclamationRepo.save(reclamation);
	}


	public List<String> findAllupdateReclamation() {
		return  reclamationRepo.findAllupdateReclamation();
	}
	
	
	public void deleteReclamation(int id_recl) {
		reclamationRepo.deleteById(id_recl);
	}
	
	
	public Reclamation searchReclamation(int id_recl){
		return 	reclamationRepo.findById((id_recl)).orElse(null);
	}
	

	public List<String> afficherlesReclamation(int id_client) {
		return reclamationRepo.afficherlesReclamation(id_client);
	}
}

package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.Reclamation;

public interface IReclamationService {
	public Reclamation saveReclamation(Reclamation reclamation);
	public Reclamation updateReclamation(Reclamation reclamation);
	public List<String> findAllupdateReclamation();
	public void deleteReclamation(int id_recl);
	public Reclamation searchReclamation(int id_recl);
	public List<String> afficherlesReclamation(int id_client);

}

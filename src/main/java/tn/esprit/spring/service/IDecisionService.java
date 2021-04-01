package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Decision;

public interface IDecisionService {

	public Decision saveDecision(Decision decision, int id_recl) ;
	public Decision updateDecision(Decision decision);
	public List<Decision> findAllDecisions();
	public void deleteDecision(int id_deci);
	public List<String> afficherlesDecisions(int id_recl);
	public void affecterDecisionAReclamation(int id_client,int id_deci);

}

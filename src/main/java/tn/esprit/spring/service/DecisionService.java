package tn.esprit.spring.service;

import java.util.List;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.Repository.ReclamationRepository;
import tn.esprit.spring.Repository.DecisionRepository;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Decision;

@Service
public class DecisionService implements IDecisionService {
	
	@Autowired
	private DecisionRepository DecisionRepo;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private ReclamationRepository reclamationRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	public DecisionService  (JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	public Decision saveDecision(Decision decision, int id_recl) {
		Reclamation r = reclamationRepo.findById(id_recl).get();
		decision.setReclamation(r);

		return DecisionRepo.save(decision);
	}

	public Decision updateDecision(Decision decision) {
		return DecisionRepo.save(decision);
	}
	
	
	public List<Decision> findAllDecisions() {
		return (List<Decision>) DecisionRepo.findAll();
	}
	
	
	public void deleteDecision(int id_deci) {
		DecisionRepo.deleteById(id_deci);
	}
	

	public List<String> afficherlesDecisions(int id_recl) {
		return DecisionRepo.afficherlesDecisions(id_recl);
	}
	

public void affecterDecisionAReclamation(int id_client,int id_deci) {
		
		Client clientManagedEntity = clientRepo.findById(id_client).get();
		Decision decisionManagedEntity = DecisionRepo.findById(id_deci).get();

		System.out.println("sending email ...");

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("chihaoui.zeineb@gmail.com");
		simpleMailMessage.setTo(clientManagedEntity.getEmail_client());
		simpleMailMessage.setSubject("Decision Reclamation");
		simpleMailMessage.setText(decisionManagedEntity.getTypedecision() + ": Is our decision about your reclamation " );

		javaMailSender.send(simpleMailMessage);
		System.out.println("sent email ...");
	}
}

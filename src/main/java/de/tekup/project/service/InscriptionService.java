package de.tekup.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.project.Model.Evenements;
import de.tekup.project.Model.Inscription;
import de.tekup.project.Repository.EvenementRepository;
import de.tekup.project.Repository.InscriptionRepository;
@Service
public class InscriptionService  {
	private InscriptionRepository   inscriptionRepository;
	private EvenementRepository evenementRepository;
@Autowired
public InscriptionService(InscriptionRepository inscriptionRepository, EvenementRepository evenementRepository) {
		super();
		this.inscriptionRepository = inscriptionRepository;
		this.evenementRepository = evenementRepository;
	}
public Inscription getEntityById(Integer id) {
	Optional<Inscription> opt = inscriptionRepository.findById(id);
	Inscription entity;
	if(opt.isPresent())
		entity= opt.get();
	else
		throw new NoSuchElementException("inscription with this Id is not found");
	return entity;
}
public Inscription createinscription(Inscription entity) {
	
	return inscriptionRepository.save(entity);
}
public Inscription modifyPatient(Integer id, Inscription newEntity) {
	Inscription oldinscription = this.getEntityById(id);
	if(newEntity.getNbpass()!= 0)
		oldinscription.setNbpass(newEntity.getNbpass());
	return inscriptionRepository.save(oldinscription);
}

public Inscription deleteinscription(Integer id) {
	Inscription entity = this.getEntityById(id);
	inscriptionRepository.deleteById(id);
	return entity;
}

public List<Inscription> getAllEntities() {
		// TODO Auto-generated method stub
		return inscriptionRepository.findAll();
	}

	public float montant_a_payer(Integer idinscription ,Integer idevenement) {
		Optional<Evenements> opt = evenementRepository.findById(idevenement);
		Evenements entity;
		entity= opt.get();
		float prixevenment = entity.getPrix();
		Optional<Inscription> opt1 = inscriptionRepository.findById(idinscription);
		Inscription entity1 = null;
		if(opt1.isPresent())
		entity1= opt1.get();
		int nbpass = entity1.getNbpass();
		float montant = nbpass * prixevenment;
		return montant;	
	}
}

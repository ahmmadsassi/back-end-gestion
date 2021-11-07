package de.tekup.project.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.project.Model.Evenements;
import de.tekup.project.Model.Inscription;
import de.tekup.project.Model.Jaime;
import de.tekup.project.Repository.JaimeRepository;

@Service

public class JaimeService {
	private JaimeRepository       jaimeRepository ;

	public JaimeService(JaimeRepository jaimeRepository) {
		super();
		this.jaimeRepository = jaimeRepository;
	}
	
	public Jaime createjaime(Jaime entity) {
		
		return jaimeRepository.save(entity);
	}
	public Jaime getEntityById(Integer id) {
		Optional<Jaime> opt = jaimeRepository.findById(id);
		Jaime entity;
		if(opt.isPresent())
			entity= opt.get();
		else
			throw new NoSuchElementException("jaime with this Id is not found");
		return entity;
	}
	public Jaime deletejaime(Integer id) {
		Jaime entity = this.getEntityById(id);
		jaimeRepository.deleteById(id);
		return entity;
	}

	
}

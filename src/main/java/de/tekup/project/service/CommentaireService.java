package de.tekup.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.project.Model.Commentaire;
import de.tekup.project.Model.Evenements;
import de.tekup.project.Repository.CommentaireRepository;

@Service

public class CommentaireService {

	private CommentaireRepository commentaireRepository;

	public CommentaireService(CommentaireRepository commentaireRepository) {
		super();
		this.commentaireRepository = commentaireRepository;
	}
	
	public Commentaire getEntityById(Integer id) {
		Optional<Commentaire> opt = commentaireRepository.findById(id);
		Commentaire entity;
		if(opt.isPresent())
			entity= opt.get();
		else
			throw new NoSuchElementException("commentaire with this Id is not found");
		return entity;
	}
	public Commentaire createcommentaire(Commentaire entity) {
		
		return commentaireRepository.save(entity);
	}
	public Commentaire modifycommentaire(Integer id, Commentaire newEntity) {
		Commentaire oldcommentaire = this.getEntityById(id);
		if(newEntity.getContenu()!= null)
			oldcommentaire.setContenu(newEntity.getContenu());
		return commentaireRepository.save(oldcommentaire);
	}
	public Commentaire deleteCommentaire(Integer id) {
		Commentaire entity = this.getEntityById(id);
		commentaireRepository.deleteById(id);
		return entity;
	}
	public List<Commentaire> getAllEntities() {
		// TODO Auto-generated method stub
		return commentaireRepository.findAll();
	}
}

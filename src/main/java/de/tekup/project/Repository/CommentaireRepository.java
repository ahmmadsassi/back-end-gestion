package de.tekup.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.project.Model.Commentaire;
@Repository

public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {

}

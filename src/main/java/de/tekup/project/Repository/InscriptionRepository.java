package de.tekup.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.project.Model.Inscription;
@Repository

public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {

}

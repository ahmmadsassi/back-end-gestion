package de.tekup.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.project.Model.Jaime;
@Repository

public interface JaimeRepository extends JpaRepository<Jaime, Integer> {

}

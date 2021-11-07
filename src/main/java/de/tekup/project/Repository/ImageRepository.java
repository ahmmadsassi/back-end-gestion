package de.tekup.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.Model.ImageDb;

public interface ImageRepository extends JpaRepository<ImageDb, String> {

}

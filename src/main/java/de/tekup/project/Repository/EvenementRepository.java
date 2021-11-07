package de.tekup.project.Repository;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import de.tekup.project.Model.Evenements;

public interface EvenementRepository extends JpaRepository<Evenements,Integer> {

	Evenements findByid(int evenemntid);

	void deleteByid(int evenmentid);
	
	List<Evenements> findAll();
}

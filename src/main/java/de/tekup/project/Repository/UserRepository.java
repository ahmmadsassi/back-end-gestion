package de.tekup.project.Repository;

import java.util.Optional; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import org.springframework.stereotype.Repository;

import de.tekup.project.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	 public Optional<User> findByUserName(String userName);
	  public boolean existsByEmail(String email);
	  public boolean existsByUserName(String userName);
}

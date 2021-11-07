package de.tekup.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import org.springframework.stereotype.Repository;

import de.tekup.project.Model.Role;
import de.tekup.project.Model.Roles;
@Repository
public interface RoleRepositroy extends JpaRepository<Role, Integer>{
	 Optional<Role> findByRoleName(Roles role);







}

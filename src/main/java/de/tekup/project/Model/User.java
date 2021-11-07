package de.tekup.project.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.In;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@Column(name="name")
	private String userName ;
	@Column(name="email")
	private String email ;
	@Column(name="password")
	private String password ;
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_role", 
	      joinColumns = @JoinColumn(name="USER_ID", referencedColumnName="ID"),
	      inverseJoinColumns = @JoinColumn(name="ROLE_ID", referencedColumnName="ID"))
	  private Set<Role> roles = new HashSet<>();
	@OneToMany(mappedBy = "client" ,cascade = CascadeType.REMOVE)
	private List<Inscription> inscriptions ;
	@OneToMany(mappedBy = "client" ,cascade = CascadeType.REMOVE)
	private List<Jaime> jaimes ;
	@OneToMany(mappedBy = "client" ,cascade = CascadeType.REMOVE)
	private List<Commentaire> commentaires;
	
	
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

}

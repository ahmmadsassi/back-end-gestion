package de.tekup.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity

public class Jaime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@ManyToOne
	private User client;
	@ManyToOne
	private Evenements evenement;

	public Jaime() {
		// TODO Auto-generated constructor stub
	}

}

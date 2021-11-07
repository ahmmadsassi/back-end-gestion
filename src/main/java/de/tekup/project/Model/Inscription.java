package de.tekup.project.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;
@Data
@Entity
public class Inscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private Date date;
	private int nbpass;
	private float total;
	@ManyToOne
	private User client ;
	@ManyToOne
	private Evenements evenement;
	public Inscription() {
		// TODO Auto-generated constructor stub
	}

}

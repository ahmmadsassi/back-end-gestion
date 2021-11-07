package de.tekup.project.Model;

import java.io.Serializable;
import java.time.LocalDate;  
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true) 
@EqualsAndHashCode(exclude = {"image"})
@ToString(exclude = {"image"})
public class Evenements  implements Serializable {
	
	private static final long serialVersionUID = -7446162716367847201L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id ;
	 private String nom;
	 private String type;
	 private String adresse;
	 private float prix;
	 private int place_disp;
	 @Lob
	 private byte[] evenmentimage;
	 private String date;
	 @OneToMany(mappedBy = "evenement" ,cascade = CascadeType.REMOVE)
	 @JsonIgnore
	 private List<Inscription> inscriptions ;
	 @OneToMany(mappedBy = "evenement" ,cascade = CascadeType.REMOVE)
	 @JsonIgnore
	 private List<Jaime> jaimes ;
	 @OneToMany(mappedBy = "evenement" ,cascade = CascadeType.REMOVE)
	 @JsonIgnore
	 private List<Commentaire> commentaires ;
	public Evenements(Integer id, String nom, String type, String adresse, float prix, int place_disp,
			byte[] evenmentimage, String date) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.adresse = adresse;
		this.prix = prix;
		this.place_disp = place_disp;
		this.evenmentimage = evenmentimage;
		this.date = date;
	}




	public Evenements() {
		super();
	}


	

}

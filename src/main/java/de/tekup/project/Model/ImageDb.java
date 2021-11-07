package de.tekup.project.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class ImageDb {
	  @Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name ="uuid",strategy ="uuid2")
	  private String id;
	  private String name;
	  private String type;
	  @Lob
	  private byte[] image ;
	 

	public ImageDb() {
		// TODO Auto-generated constructor stub
	}

	public ImageDb( String name, String type, byte[] image) {
		super();
		this.name = name;
		this.type = type;
		this.image = image;
	}



	

	
}

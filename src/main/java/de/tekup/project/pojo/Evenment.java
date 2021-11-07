package de.tekup.project.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(using = LocalDateSerializer.class)
public class Evenment {

	 private String nom;
	 private String type;
	 private String adresse;
	 private float prix;
	 private int place_disp;
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private LocalDate date;
	
	
	
	
	
	
	
	public Evenment() {
		// TODO Auto-generated constructor stub
	}

}

package de.tekup.project.message;

import java.util.List;

import de.tekup.project.Model.Evenements;
import de.tekup.project.Model.Inscription;
import lombok.Data;
@Data
public class inscriptionreponse {
	
	
	private String status;
	private String message;
	private String AUTH_TOKEN;
	private List<Inscription> Inlist;
	
	

}

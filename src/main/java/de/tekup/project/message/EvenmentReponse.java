package de.tekup.project.message;

import java.util.List;



import de.tekup.project.Model.Evenements;
import lombok.Data;
@Data
public class EvenmentReponse {
	
	private String status;
	private String message;
	private String AUTH_TOKEN;
	private List<Evenements> oblist;

}

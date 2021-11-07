package de.tekup.project.message;

import lombok.Data;

@Data
public class Reponsemessage {
	 private String message;

	 
	public Reponsemessage() {
		// TODO Auto-generated constructor stub
	}


	public Reponsemessage(String message) {
		super();
		this.message = message;
	}

}

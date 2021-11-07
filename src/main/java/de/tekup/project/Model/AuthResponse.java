package de.tekup.project.Model;

import antlr.collections.List;
import lombok.Data;

@Data
public class AuthResponse {
	 private String token;
	  private java.util.List<String> roles;
	public AuthResponse() {
		// TODO Auto-generated constructor stub
	}

}

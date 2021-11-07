package de.tekup.project.Model;

import lombok.Data;

@Data
public class SignupRequest {
	private String userName; 
	private String email;
	private String password;
	private String[] roles;
	public SignupRequest() {
		// TODO Auto-generated constructor stub
	}

}

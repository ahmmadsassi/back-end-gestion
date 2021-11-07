package de.tekup.project.message;

import lombok.Data;

@Data
public class Reponseimage {
	private String name;
	  private String url;
	  private String type;
	  private long size;

	

	public Reponseimage(String name, String url, String type, long size) {
		super();
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}



	public Reponseimage() {
		// TODO Auto-generated constructor stub
	}

}

package de.tekup.project;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("de.tekup.project.Repository")
public class GestionDesEvenmentsLqstVersionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesEvenmentsLqstVersionApplication.class, args);
	}
	
	
}

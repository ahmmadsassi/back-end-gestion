package de.tekup.project.endpoint;

import java.io.IOException;    
 
import java.time.LocalDate;

import javax.persistence.Lob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import de.tekup.project.Model.Evenements;
import de.tekup.project.Repository.EvenementRepository;
import de.tekup.project.exeception.EvenmentCustomException;
import de.tekup.project.message.EvenmentReponse;
import de.tekup.project.message.ResponseCode;
import de.tekup.project.util.Validator;


@CrossOrigin()
@RestController
@RequestMapping("/evenment")
public class EvenmentController {
	
	
	@Autowired
	private EvenementRepository evenementRepository;
    @Autowired
	private JmsTemplate jmsTemplate;

	
	
	


	public EvenmentController() {
		super();
	}


	@PostMapping("/addEvenment")
	public ResponseEntity<EvenmentReponse> addevenment(
			@RequestParam(name="file") MultipartFile evenmentimage,
			@RequestParam(name ="nom") String nom,
			@RequestParam(name ="type" ) String type,
			@RequestParam(name ="adresse") String adresse,
			@RequestParam(name ="prix") String prix,
			@RequestParam(name ="date") String date,
			@RequestParam(name ="place_disp") String place_disp) throws IOException {
	     EvenmentReponse evres = new EvenmentReponse();
		if (Validator.isStringEmpty(nom) || Validator.isStringEmpty(type)
				|| Validator.isStringEmpty(adresse) ||  Validator.isStringEmpty(prix) || Validator.isStringEmpty(place_disp)  ) {
			evres.setStatus("400");
			evres.setMessage("BAD_REQUEST");
			return new ResponseEntity<EvenmentReponse>(evres, HttpStatus.NOT_ACCEPTABLE);
		} else {
			try {
				Evenements  eve = new Evenements();
				eve.setNom(nom);
				eve.setAdresse(adresse);
				eve.setDate(date);
				eve.setPlace_disp(Integer.parseInt(place_disp));
				eve.setPrix(Float.parseFloat(prix));
				eve.setType(type);
				if (evenmentimage != null) {
					eve.setEvenmentimage(evenmentimage.getBytes());
				}
				evenementRepository.save(eve);
				jmsTemplate.convertAndSend("evenmentque", eve);
				evres.setStatus("200");
				evres.setMessage("SUCCESS");
			     evres.setOblist(evenementRepository.findAll());
			} catch (Exception e) {
				throw new EvenmentCustomException(e.getMessage());
			}
		}
     	return new ResponseEntity<EvenmentReponse>(evres, HttpStatus.OK);
	}
	
	
	@PutMapping("/updateevenment")
	public ResponseEntity<de.tekup.project.message.ServerResponse> updateEvenment(
			@RequestParam(name="file") MultipartFile evenmentimage,
			@RequestParam(name ="nom") String nom,
			@RequestParam(name ="type" ) String type,
			@RequestParam(name ="adresse") String adresse,
			@RequestParam(name ="prix") String prix,
			@RequestParam(name ="date") String date,
			@RequestParam(name ="place_disp") String place_disp,	
			@RequestParam(name ="id") String evenmentid) throws IOException {
		de.tekup.project.message.ServerResponse evres = new de.tekup.project.message.ServerResponse();
		if (Validator.isStringEmpty(nom) || Validator.isStringEmpty(type)
				|| Validator.isStringEmpty(adresse) || Validator.isStringEmpty(prix) || Validator.isStringEmpty(date) || Validator.isStringEmpty(place_disp) )
		{	evres.setStatus("400");
		evres.setMessage("BAD_REQUEST");
		return new ResponseEntity<de.tekup.project.message.ServerResponse>(evres, HttpStatus.NOT_ACCEPTABLE);
		}
		    else {
			     try {
				if ( evenmentimage != null) {
					
					float p = Float.parseFloat(prix);
					Evenements evenment =  new Evenements(Integer.parseInt(evenmentid), nom,type,adresse,
							p, Integer.parseInt(place_disp), evenmentimage.getBytes(),date);
				evenementRepository.save(evenment);
				} else {
					Evenements evenmentOrg = evenementRepository.findByid(Integer.parseInt(evenmentid));
					Evenements evenment1 =   new Evenements(Integer.parseInt(evenmentid), nom,type,adresse,
							Float.parseFloat(prix), Integer.parseInt(place_disp), evenmentimage.getBytes(),date) ;
					evenementRepository.save(evenment1);
					evres.setStatus("200");
					evres.setMessage("SUCCESS");
				}
			
			} catch (Exception e) {
				throw new EvenmentCustomException("Unable to update Evenment details, please try again");
			}
		}
		return new ResponseEntity<de.tekup.project.message.ServerResponse>(evres, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deletevenment")
	public ResponseEntity<EvenmentReponse> delProduct(@RequestParam(name = "id") String evenemntid)
			throws IOException {
		EvenmentReponse evres = new EvenmentReponse();
		if (Validator.isStringEmpty(evenemntid)) {
			evres.setStatus("400");
			evres.setMessage("BAD_REQUEST");
			return new ResponseEntity<EvenmentReponse>(evres, HttpStatus.NOT_ACCEPTABLE);
		} else {
			try {
				evenementRepository.deleteById(Integer.parseInt(evenemntid));
				evres.setStatus("200");
				evres.setMessage("SUCCESS");
			} catch (Exception e) {
				throw new EvenmentCustomException(e.getMessage());
			
		}
		return new ResponseEntity<EvenmentReponse>(evres, HttpStatus.OK);}
	}

		@GetMapping("/getevenments")
		public ResponseEntity<EvenmentReponse> getEvenments() throws IOException {
			EvenmentReponse eve = new EvenmentReponse();
			try {
				eve.setStatus(ResponseCode.SUCCESS_CODE);
				eve.setMessage(ResponseCode.LIST_SUCCESS_MESSAGE);
				eve.setOblist(evenementRepository.findAll());
			} catch (Exception e) {
				throw new EvenmentCustomException("Unable to retrieve evenment, please try again");
			}
			return new ResponseEntity<EvenmentReponse>(eve, HttpStatus.OK);
		}
	
	
}

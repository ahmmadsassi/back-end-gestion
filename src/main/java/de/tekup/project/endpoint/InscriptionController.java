package de.tekup.project.endpoint;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.project.Model.Evenements;
import de.tekup.project.Model.Inscription;
import de.tekup.project.Repository.EvenementRepository;
import de.tekup.project.Repository.InscriptionRepository;
import de.tekup.project.Repository.UserRepository;
import de.tekup.project.exeception.EvenmentCustomException;
import de.tekup.project.message.EvenmentReponse;
import de.tekup.project.message.ResponseCode;
import de.tekup.project.message.inscriptionreponse;
import de.tekup.project.service.InscriptionService;
import de.tekup.project.util.Validator;
import org.springframework.jms.core.*;


@CrossOrigin()
@RestController
@RequestMapping("/inscription")
public class InscriptionController {


	@Autowired
	private InscriptionService inscrptionservice;
	@Autowired
	private InscriptionRepository inscrepository;
	@Autowired
	private UserRepository userr;
	@Autowired
	private EvenementRepository evr;
	
	
	

	
	@PostMapping("/add")
	public ResponseEntity<inscriptionreponse>createinscription(@RequestParam(name ="nbpass") int nbpass,
			@RequestParam(name ="total" ) String total,@RequestParam(name ="iduser" ) String iduser,@RequestParam(name ="ideve" ) String ideve) {
		inscriptionreponse inreponse = new inscriptionreponse();
	  
	  if ( Validator.isStringEmpty(iduser)
				|| Validator.isStringEmpty(ideve) ) {
			inreponse.setStatus("400");
			inreponse.setMessage("BAD_REQUEST");
			return new ResponseEntity<inscriptionreponse>(inreponse, HttpStatus.NOT_ACCEPTABLE);
		} else {
			try {
				Date date = new Date();
				Inscription in = new Inscription();
				in.setClient(userr.getById(Integer.parseInt(iduser)));
				in.setEvenement(evr.findByid(Integer.parseInt(ideve)));
				in.setNbpass(nbpass);
				in.setTotal(Float.parseFloat(total));
				in.setDate(date);
				inscrepository.save(in);
				inreponse.setStatus("200");
				inreponse.setMessage("SUCCESS");
			    inreponse.setInlist(inscrepository.findAll());
			} catch (Exception e) {
				throw new EvenmentCustomException(e.getMessage());
			}
		}
   	return new ResponseEntity<inscriptionreponse>(inreponse, HttpStatus.OK); 	}
			

  /*
  }
  return new ResponseEntity<inscriptionreponse>(inreponse, HttpStatus.OK);
  }
		
	@GetMapping("/allin")
	public ResponseEntity<inscriptionreponse> getAllin() {
	
	
 inscriptionreponse inr = new inscriptionreponse();
		
		
        try {        inr.setInlist(inscrptionservice.getAllEntities()); 
        ResponseCode res = new ResponseCode();
        inr.setStatus(res.SUCCESS_CODE);
  	    inr.setMessage(res.ADD_SUCCESS_MESSAGE); 
  	
        }
        catch(Exception e ){
        	
        	throw new EvenmentCustomException(e.getMessage());	
        }
        return new ResponseEntity<inscriptionreponse>(inr, HttpStatus.OK);
	}
		
		
	@DeleteMapping("/deletein")
	public  ResponseEntity<inscriptionreponse>  deleteinscriptionById(@RequestParam(name= "id") String  id) {
			
		 inscriptionreponse inr = new inscriptionreponse();
		
        try {      
        	
        	inscrptionservice.deleteinscription(Integer.parseInt(id));	
        inr.setInlist(inscrptionservice.getAllEntities()); 
        ResponseCode res = new ResponseCode();
        inr.setStatus(res.SUCCESS_CODE);
  	    inr.setMessage(res.ADD_SUCCESS_MESSAGE); 
  	 
        }
        catch(Exception e ){
        	
        	throw new EvenmentCustomException(e.getMessage());	
        }
        return new ResponseEntity<inscriptionreponse>(inr, HttpStatus.OK);
	}
        @PutMapping("/editinsc")
    	public  ResponseEntity<inscriptionreponse>  editinscription(@RequestParam(name= "id") String  id, @RequestBody Inscription entity) {
    			
    		 inscriptionreponse inr = new inscriptionreponse();
    		
            try {      
            	
            	inscrptionservice.modifyPatient(Integer.parseInt(id),entity);	
            inr.setInlist(inscrptionservice.getAllEntities()); 
            ResponseCode res = new ResponseCode();
            inr.setStatus(res.SUCCESS_CODE);
      	    inr.setMessage(res.ADD_SUCCESS_MESSAGE); 
      	 
            }
            catch(Exception e ){
            	
            	throw new EvenmentCustomException(e.getMessage());	
            }
		
		
		
            return new ResponseEntity<inscriptionreponse>(inr, HttpStatus.OK);
		
	
	}
		
		
		
	*/
	
	
}

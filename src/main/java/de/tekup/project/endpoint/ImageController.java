package de.tekup.project.endpoint;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import de.tekup.project.Model.ImageDb;
import de.tekup.project.message.Reponseimage;
import de.tekup.project.message.Reponsemessage;
import de.tekup.project.service.ImageService;

@Controller
@CrossOrigin()
@RequestMapping("/data")
public class ImageController {
	  Date datenow ;

	@Autowired
	private ImageService imageService;
	
	
	
	public ImageController() {
		// TODO Auto-generated constructor stub
	}

	
	 @PostMapping("/upload")
	  public ResponseEntity<Reponsemessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      imageService.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new Reponsemessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Reponsemessage(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<Reponseimage>> getListFiles() {
		  List<Reponseimage> files = imageService.getAllFiles().map(ImageDb -> {
		                                      String fileDownloadUri = ServletUriComponentsBuilder
		          .fromCurrentContextPath()
		          .path("/files/")
		          .path(ImageDb.getId())
		          .toUriString();

		      return new Reponseimage(
		          ImageDb.getName(),
		          fileDownloadUri,
		          ImageDb.getType(),
		          ImageDb.getImage().length);
		    }).collect(Collectors.toList());;

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    ImageDb image = imageService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
	        .body(image.getImage());
	  }
	
}

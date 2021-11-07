package de.tekup.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.tekup.project.message.Reponsemessage;

public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler{
	public FileUploadExceptionAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<Reponsemessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Reponsemessage("File too large!"));
	  }
	
	

}

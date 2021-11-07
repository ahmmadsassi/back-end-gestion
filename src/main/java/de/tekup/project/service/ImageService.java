package de.tekup.project.service;

import java.awt.font.ImageGraphicAttribute;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;
import de.tekup.project.Model.ImageDb;
import de.tekup.project.Repository.ImageRepository;

@Service
public class ImageService {

	
	 @Autowired
	  private ImageRepository imageRepository;

	  public ImageDb store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    ImageDb image = new ImageDb(fileName, file.getContentType(), file.getBytes());

	    return imageRepository.save(image);
	  }

	  public ImageDb getFile(String id) {
	    return imageRepository.findById(id).get();
	  }
	  
	  public Stream<ImageDb> getAllFiles() {
	    return imageRepository.findAll().stream();
	  }

}

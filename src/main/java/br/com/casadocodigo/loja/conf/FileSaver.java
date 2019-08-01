package br.com.casadocodigo.loja.conf;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;
	 
	@Autowired
	private AmazonS3Client s3;
	
	public String write(String baseFolder, MultipartFile file) {
		
		try {
			s3.putObject("casadocodigo", file.getOriginalFilename(), file.getInputStream(), new ObjectMetadata());			
			return "http://localhost:9444/s3/casadocodigo/"+file.getOriginalFilename()+"?noAuth=true";						
		}catch(AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}

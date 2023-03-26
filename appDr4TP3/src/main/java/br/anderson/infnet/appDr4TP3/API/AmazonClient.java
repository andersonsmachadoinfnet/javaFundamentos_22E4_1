package br.anderson.infnet.appDr4TP3.API;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;



@Service
public class AmazonClient {

    private AmazonS3 s3client;

    //@Value("${amazonProperties.endpointUrl}")
    private String endpointUrl = "https://andersonbucketinfnet.s3.amazonaws.com";
    //@Value("${amazonProperties.bucketName}")
    private String bucketName = "andersonbucketinfnet";
    //@Value("${amazonProperties.accessKey}")
    private String accessKey = "";
    //@Value("${amazonProperties.secretKey}")
    private String secretKey = "";
  
    @PostConstruct
    private void initializeAmazon() {
       AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
       this.s3client = new AmazonS3Client(credentials);
    }
    
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    
    private String generateFileName (MultipartFile multiPart) { 
        return new Date (). getTime () + "-" + multiPart.getOriginalFilename (). replace ("", "_"); 
    }
    
    public String uploadFile(MultipartFile multipartFile) {

        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            //uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return fileUrl;
    }
}

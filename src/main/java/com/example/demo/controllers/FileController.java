package com.example.demo.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/service/v1/file")
public class FileController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(/*@RequestParam("file")*/ @RequestBody MultipartFile file) {
        LOGGER.info("file name:" + file.getName());
        LOGGER.info("file original name:" + file.getOriginalFilename());
        LOGGER.info("file size:" + file.getSize());
        try {
            LOGGER.info("file bytes:" + file.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<>("Sucessfully uploaded file:" + file.getName(), HttpStatus.OK);
    }
    
}

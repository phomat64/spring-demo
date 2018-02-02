package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Mail;
import com.example.demo.ras.IMailClient;

@RestController
@RequestMapping(value = "/service/v1")
public class MailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailController.class);
    
    @Autowired
    private IMailClient mailClient;

    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public ResponseEntity sendMail(@RequestBody Mail mail, 
                                   @RequestParam(required = false) Boolean sendErrorCode) {
        LOGGER.info("Sending mail to: " + mail.getTo());
        try {
            mailClient.sendEmail(mail);
        } catch (com.example.demo.domain.exceptions.MailException me) {
            LOGGER.error("Failed to send mail", me);
            if (sendErrorCode) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.OK);
    }

}

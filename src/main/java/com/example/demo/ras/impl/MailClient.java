package com.example.demo.ras.impl;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Mail;
import com.example.demo.ras.IMailClient;


@Component
public class MailClient implements IMailClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MailClient.class);
    
    private static final String MAIL_FROM_PROPERTY = "demo.email.from";
    
    @Autowired
    private JavaMailSenderImpl mailSender;
    
    @Autowired
    private Environment env;
    
    @Override
    public void sendEmail(Mail mail) {
        MimeMessage message = mailSender.createMimeMessage();
        
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            
            helper.setFrom(env.getProperty(MAIL_FROM_PROPERTY));
            
            List<String> toList = mail.getTo();
            helper.setTo(toList.toArray(new String[toList.size()]));
            
            List<String> ccList = mail.getCc();
            if (ccList != null) {
                helper.setCc(ccList.toArray(new String[ccList.size()]));
            }
            
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getText(), false);
            
            Map<String, byte[]> attachmentMap = mail.getAttachmentMap();
            if (attachmentMap != null) {
                for (Map.Entry<String, byte[]> attachmentEntry : attachmentMap.entrySet()) {
                    String attachmentName = attachmentEntry.getKey();
                    LOGGER.info("Adding attachment: " + attachmentName);
                    helper.addAttachment(attachmentName,
                            new ByteArrayResource(attachmentMap.get(attachmentName)));
                }
            }
            
            LOGGER.info("Sending email to: ", mail.getTo());
            mailSender.send(message);
            LOGGER.info("Sent success: " + mail.getSubject());
            
        } catch (MessagingException e) {
            LOGGER.error("Messaging exception building email: " + mail.getSubject(), e);
            throw new com.example.demo.domain.exceptions.MailException("There was a problem building the email message.");
        } catch (MailSendException e) {
            LOGGER.error("Main server connection failure: " + mail.getSubject(), e);
            throw new com.example.demo.domain.exceptions.MailException("There was a problem connecting to the mail server.");
        } catch (MailException e) {
            LOGGER.error("Email send failed: " + mail.getSubject(), e);
            throw new com.example.demo.domain.exceptions.MailException("There was a problem sending the email.");
        }
    }

}

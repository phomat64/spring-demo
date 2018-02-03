package com.example.demo.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailConfig.class);

    private static final String MAIL_HOST_PROPERTY = "demo.email.host";
    private static final String MAIL_PORT_PROPERTY = "demo.email.port";
    private static final String MAIL_AUTH_PROPERTY = "demo.email.auth";
    private static final String MAIL_TLS_PROPERTY = "demo.email.starttls.enable";

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("******");
        mailSender.setPassword("******");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;

        // @Bean
        // JavaMailSenderImpl mailSender() {
        // JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        //
        // try {
        // String smtpHost = env.getProperty(MAIL_HOST_PROPERTY);
        // int smtpPort = Integer.parseInt(env.getProperty(MAIL_PORT_PROPERTY));
        // String smtpAuth = env.getProperty(MAIL_AUTH_PROPERTY);
        // String smtpStarttlsEnable = env.getProperty(MAIL_TLS_PROPERTY);
        //
        // mailSender.setHost(smtpHost);
        // mailSender.setPort(smtpPort);
        // Properties props = new Properties();
        // props.setProperty("mail.smtp.auth", smtpAuth);
        // props.setProperty("mail.smtp.starttls.enable", smtpStarttlsEnable);
        // mailSender.setJavaMailProperties(props);
        // } catch (Exception e) {
        // LOGGER.error("Error retrieving mail configuration.", e);
        // }
        //
        // return mailSender;
        // }
    }
}

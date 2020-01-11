package com.example.salesken.config;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class MailService {

	final String username = "nikhilrathoredeveloper11@gmail.com"; 
    final String password = "12345678naman";

    public String createMail(String emailId) {
    	
    	Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
	    Session session = Session.getInstance(prop,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	
	    try {
	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("nikhilrathoredeveloper11@gmail.com"));
	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse(emailId)
	        );
	        message.setSubject("Employee registration successfull");
	        message.setText("Welcome to salseken");
	
	        Transport.send(message);
	
	        System.out.println("mail is sent successfull");
	
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		return "mail is sent successfull";
    }
    
    
    public String updateMail(String emailId) {
    	
    	Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
	    Session session = Session.getInstance(prop,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	
	    try {
	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("nikhilrathoredeveloper11@gmail.com"));
	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse(emailId)
	        );
	        message.setSubject("Employee successfully updated");
	        message.setText("Your data is updated");
	
	        Transport.send(message);
	
	        System.out.println("mail is sent successfull");
	
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		return "mail is sent successfull";
    }
    
    
	public String getMail(String emailId) {
	    	
	    	Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true");
	        
		    Session session = Session.getInstance(prop,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });
		
		    try {
		
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("nikhilrathoredeveloper11@gmail.com"));
		        message.setRecipients(
		                Message.RecipientType.TO,
		                InternetAddress.parse(emailId)
		        );
		        message.setSubject("Employee data retrieved");
		        message.setText("your data is retrieved");
		
		        Transport.send(message);
		
		        System.out.println("mail is sent successfull");
		
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
			return "mail is sent successfull";
	    }
	
	public String deleteMail(String emailId) {
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
	    prop.put("mail.smtp.port", "587");
	    prop.put("mail.smtp.auth", "true");
	    prop.put("mail.smtp.starttls.enable", "true");
	    
	    Session session = Session.getInstance(prop,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	
	    try {
	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("nikhilrathoredeveloper11@gmail.com"));
	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse(emailId)
	        );
	        message.setSubject("Employee is successfully deleted");
	        message.setText("Bye bye bye! your data is deleted");
	
	        Transport.send(message);
	
	        System.out.println("mail is sent successfull");
	
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		return "mail is sent successfull";
	}


}

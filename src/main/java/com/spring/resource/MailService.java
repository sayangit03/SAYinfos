package com.spring.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(MailService.class);

	public void sendEmail(String to, String subject, String text) {
		LOG.info("Email service called..");
		if(to!=null && to!="") {
			try {
				LOG.info("Email service called. Initiated.");
				SimpleMailMessage message = new SimpleMailMessage(); 
				message.setTo(to); 
				message.setSubject(subject); 
				message.setText(text);
				javaMailSender.send(message);
				LOG.info("Email service called. Completed.");
			}catch (Exception e) {
				LOG.info("MailService: Mail not sent.");
				e.printStackTrace();
			}
		}
	}
}

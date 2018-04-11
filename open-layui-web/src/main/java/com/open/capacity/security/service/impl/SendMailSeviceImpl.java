package com.open.capacity.security.service.impl;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.open.capacity.security.service.SendMailSevice;

@Service
public class SendMailSeviceImpl implements SendMailSevice {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String serverMail;

	@Override
	public void sendMail(List<String> toUser, String subject, String text) {
		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(serverMail);
			helper.setTo(toUser.toArray(new String[toUser.size()]));
			helper.setSubject(subject);
			helper.setText(text, true);

			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendMail(String toUser, String subject, String text) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(serverMail);
		helper.setTo(toUser);
		helper.setSubject(subject);
		helper.setText(text, true);

		javaMailSender.send(message);
	}
}

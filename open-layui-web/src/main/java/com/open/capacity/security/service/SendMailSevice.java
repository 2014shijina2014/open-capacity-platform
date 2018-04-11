package com.open.capacity.security.service;

import java.util.List;

import javax.mail.MessagingException;

public interface SendMailSevice {

	/**
	 * 
	 * @param toUser
	 * @param subject
	 *            标题
	 * @param text
	 *            内容（支持html格式）
	 */
	void sendMail(List<String> toUser, String subject, String text);

	void sendMail(String toUser, String subject, String text) throws MessagingException;
}

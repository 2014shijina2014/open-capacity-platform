package com.open.capacity.security.service;

import java.util.List;

import com.open.capacity.security.model.Mail;

public interface MailService {

	void save(Mail mail, List<String> toUser);
}

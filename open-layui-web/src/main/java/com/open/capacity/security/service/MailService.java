package com.open.capacity.security.service;

import com.open.capacity.security.model.Mail;

import java.util.List;

public interface MailService {

    void save(Mail mail, List<String> toUser);
}

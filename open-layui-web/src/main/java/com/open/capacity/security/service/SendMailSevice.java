package com.open.capacity.security.service;

import javax.mail.MessagingException;
import java.util.List;

public interface SendMailSevice {

    /**
     * @param toUser
     * @param subject 标题
     * @param text    内容（支持html格式）
     */
    void sendMail(List<String> toUser, String subject, String text);

    void sendMail(String toUser, String subject, String text) throws MessagingException;
}

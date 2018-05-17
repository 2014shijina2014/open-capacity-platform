package com.xxl.job.admin.core.util;

import java.nio.charset.Charset;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 邮件发送.Util
 *
 * @author xuxueli 2016-3-12 15:06:20
 */
public class MailUtil {
	private static Logger logger = LoggerFactory.getLogger(MailUtil.class);
	
	/**
	 *
	 * @param toAddress		收件人邮箱
	 * @param mailSubject	邮件主题
	 * @param mailBody		邮件正文
	 * @return
	 */
	public static boolean sendMail(String toAddress, String mailSubject, String mailBody){

		try {
			// Create the email message
			HtmlEmail email = new HtmlEmail();

			//email.setDebug(true);		// 将会打印一些log
			//email.setTLS(true);		// 是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验
			//email.setSSL(true);

			email.setHostName(PropertiesUtil.getString("xxl.job.mail.host"));

			if ("true".equals(PropertiesUtil.getString("xxl.job.mail.ssl"))) {
				email.setSslSmtpPort(PropertiesUtil.getString("xxl.job.mail.port"));
				email.setSSLOnConnect(true);
			} else {
				email.setSmtpPort(Integer.valueOf(PropertiesUtil.getString("xxl.job.mail.port")));
			}

			email.setAuthenticator(new DefaultAuthenticator(PropertiesUtil.getString("xxl.job.mail.username"), 
					PropertiesUtil.getString("xxl.job.mail.password")));
			email.setCharset(Charset.defaultCharset().name());

			email.setFrom(PropertiesUtil.getString("xxl.job.mail.username"), PropertiesUtil.getString("xxl.job.mail.sendNick"));
			email.addTo(toAddress);
			email.setSubject(mailSubject);
			email.setMsg(mailBody);

			//email.attach(attachment);	// add the attachment

			email.send();				// send the email
			return true;
		} catch (EmailException e) {
			logger.error(e.getMessage(), e);

		}
		return false;
	}

}

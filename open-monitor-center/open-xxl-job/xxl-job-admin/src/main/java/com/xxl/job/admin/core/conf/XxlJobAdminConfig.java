package com.xxl.job.admin.core.conf;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
@Configuration
public class XxlJobAdminConfig implements InitializingBean{
    private static XxlJobAdminConfig adminConfig = null;
    public static XxlJobAdminConfig getAdminConfig() {
        return adminConfig;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        adminConfig = this;
    }

    @Value("${xxl.job.mail.host:127.0.0.1}")
    private String mailHost;

    @Value("${xxl.job.mail.port:9999}")
    private String mailPort;

    @Value("${xxl.job.mail.ssl:false}")
    private boolean mailSSL;

    @Value("${xxl.job.mail.username:admin}")
    private String mailUsername;

    @Value("${xxl.job.mail.password:123456}")
    private String mailPassword;

    @Value("${xxl.job.mail.sendNick:owen}")
    private String mailSendNick;

    @Value("${xxl.job.login.username:admin}")
    private String loginUsername;

    @Value("${xxl.job.login.password:123456}")
    private String loginPassword;

    @Value("${xxl.job.i18n:}")
    private String i18n;


    public String getMailHost() {
        return mailHost;
    }

    public String getMailPort() {
        return mailPort;
    }

    public boolean isMailSSL() {
        return mailSSL;
    }

    public String getMailUsername() {
        return mailUsername;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public String getMailSendNick() {
        return mailSendNick;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getI18n() {
        return i18n;
    }

}

package com.open.capacity.security.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 首页配置
 */
@Controller
public class LoginPageConfig {


    /**
     * 默认跳转到静态登陆页面
     *
     * @return 重定向
     */
    @RequestMapping("/")
    public RedirectView loginPage() {
        return new RedirectView("/login.html");
    }

}

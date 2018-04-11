package com.open.capacity.security.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginPageConfig {

	@RequestMapping("/")
	public RedirectView loginPage() {
		return new RedirectView("/login.html");
	}
}

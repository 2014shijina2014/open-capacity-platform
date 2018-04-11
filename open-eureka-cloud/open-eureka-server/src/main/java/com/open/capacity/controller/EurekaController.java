package com.open.capacity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2018年3月20日 上午9:58:08 
* 类说明 
*/
@RestController
public class EurekaController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	
}

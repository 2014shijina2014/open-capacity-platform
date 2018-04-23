package com.open.capacity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2017年11月28日 下午22:50:29 
* 类说明 
*/
@RestController
public class EurekaController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	
}

package com.open.capacity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2017年11月28日 下午21:52:43 
* 类说明 
*/
@RestController
public class EurekaManageController {
	

	//手工启停标识
	public static boolean upOrDown = true;

	
	@RequestMapping(value = "/resume", method = RequestMethod.POST)  
	public void up( ) {  
		upOrDown = true ;
	}  
 
	
	@RequestMapping(value = "/pause", method = RequestMethod.POST)  
	public void down( ) {  
		upOrDown = false ;
	}  

}

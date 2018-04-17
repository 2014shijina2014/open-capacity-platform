package com.open.capacity.service;

import java.util.logging.Logger;

import cn.chinaunicom.ws.srenewser.SrenewSerImpl;

/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2018年4月17日 下午3:55:06 
* 类说明 
*/
public class SrenewSerUtils {
	
	public static SrenewSerUtils instance  ;
	private SrenewSerUtils(){
		
	}
	public static SrenewSerUtils getInstance() {
		
		if(instance==null){
			instance = new SrenewSerUtils();
		}
		return instance ;
	}
	
	 private static final Logger LOG = Logger.getLogger(SrenewSerUtils.class.getName());

	    /* (non-Javadoc)
	     * @see cn.chinaunicom.ws.srenewser.SrenewSer#qryChgProd(cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODINPUT  parameters )*
	     */
	    public cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT qryChgProd(cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODINPUT parameters) { 
	        LOG.info("Executing operation qryChgProd");
	        System.out.println(parameters);
	        try {
	            cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT _return = null;
	            return _return;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	    }

	    /* (non-Javadoc)
	     * @see cn.chinaunicom.ws.srenewser.SrenewSer#srenewTrade(cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEINPUT  parameters )*
	     */
	    public cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT srenewTrade(cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEINPUT parameters) {
	    	
	    	
	    	
	        LOG.info("Executing operation srenewTrade");
	        System.out.println(parameters);
	        try {
	            cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT _return = null;
	            return _return;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	    }

	    /* (non-Javadoc)
	     * @see cn.chinaunicom.ws.srenewser.SrenewSer#srenewSub(cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBINPUT  parameters )*
	     */
	    public cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT srenewSub(cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBINPUT parameters) { 
	        LOG.info("Executing operation srenewSub");
	        System.out.println(parameters);
	        try {
	            cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT _return = null;
	            return _return;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	    }

}

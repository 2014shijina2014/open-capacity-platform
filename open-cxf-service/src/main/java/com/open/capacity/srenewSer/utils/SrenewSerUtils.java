package com.open.capacity.srenewSer.utils;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.capacity.srenewSer.bo.SrenewSerBO;
import com.open.capacity.srenewSer.bo.impl.SrenewSerBOImpl;
import com.open.capacity.utils.SpringUtil;

import cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.qrychgprodreq.QRYCHGPRODREQ;
import cn.chinaunicom.ws.srenewser.unibssbody.qrychgprodrsp.QRYCHGPRODRSP;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewsubrsp.SRENEWSUBRSP;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewtradersp.SRENEWTRADERSP;


/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年04月23日 上午20:01:06 类说明
 */
public class SrenewSerUtils {

	public static SrenewSerUtils instance;
	
	private ObjectMapper objectMapper =  SpringUtil.getBean(ObjectMapper.class) ;

	private static final Logger LOG = Logger.getLogger(SrenewSerBOImpl.class.getName());
	
	private SrenewSerUtils() {

	}

	public static SrenewSerUtils getInstance() {

		if (instance == null) {
			instance = new SrenewSerUtils();
		}
		return instance;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.chinaunicom.ws.srenewser.SrenewSer#qryChgProd(cn.chinaunicom.ws.
	 * srenewser.unibssbody.QRYCHGPRODINPUT parameters )*
	 */
	public cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT qryChgProd(
			cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODINPUT parameters) {
		
		try {
			cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT _return = SpringUtil.getBean(SrenewSerBO.class).qryChgProd(parameters);
			
			try {
				LOG.info("响应的报文"+objectMapper.writeValueAsString(_return));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return _return;
		} catch (Exception ex) {
			QRYCHGPRODOUTPUT out = new QRYCHGPRODOUTPUT();

			QRYCHGPRODOUTPUT.UNIBSSBODY body = new QRYCHGPRODOUTPUT.UNIBSSBODY();
			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			out.getUNIBSSHEAD().setACTIONCODE("1");
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("程序异常");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			
			out.setUNIBSSBODY(body);

			QRYCHGPRODRSP rsp = new QRYCHGPRODRSP();

			QRYCHGPRODREQ req = parameters.getUNIBSSBODY().getQRYCHGPRODREQ();

			rsp.setRESPCODE("8888");
			rsp.setRESPDESC("程序异常");
			body.setQRYCHGPRODRSP(rsp);
			try {
				LOG.info("响应的报文"+objectMapper.writeValueAsString(out));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return out ;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.chinaunicom.ws.srenewser.SrenewSer#srenewTrade(cn.chinaunicom.ws.
	 * srenewser.unibssbody.SRENEWTRADEINPUT parameters )*
	 */
	public cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT srenewTrade(
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEINPUT parameters) {

		
		try {
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT _return = SpringUtil.getBean(SrenewSerBO.class)
					.srenewTrade(parameters);
			try {
				LOG.info("响应的报文"+objectMapper.writeValueAsString(_return));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return _return;
		} catch (Exception ex) {

			SRENEWTRADEOUTPUT out = new SRENEWTRADEOUTPUT();
			SRENEWTRADEOUTPUT.UNIBSSBODY body = new SRENEWTRADEOUTPUT.UNIBSSBODY();
			out.setUNIBSSBODY(body);

			SRENEWTRADERSP resp = new SRENEWTRADERSP();

			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			out.getUNIBSSHEAD().setACTIONCODE("1");
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("程序异常");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			resp.setRESPCODE("8888");
			resp.setRESPDESC("程序异常");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			try {
				LOG.info("响应的报文"+objectMapper.writeValueAsString(out));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return out;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.chinaunicom.ws.srenewser.SrenewSer#srenewSub(cn.chinaunicom.ws.
	 * srenewser.unibssbody.SRENEWSUBINPUT parameters )*
	 */
	public cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT srenewSub(
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBINPUT parameters) {
		
		try {
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT _return = SpringUtil.getBean(SrenewSerBO.class).srenewSub(parameters);
			try {
				LOG.info("响应的报文"+objectMapper.writeValueAsString(_return));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return _return;
		} catch (Exception ex) {
			SRENEWSUBOUTPUT out = new SRENEWSUBOUTPUT();
			SRENEWSUBOUTPUT.UNIBSSBODY body = new SRENEWSUBOUTPUT.UNIBSSBODY();
			out.setUNIBSSBODY(body);
			SRENEWSUBRSP resp = new SRENEWSUBRSP();
			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			out.getUNIBSSHEAD().setACTIONCODE("1");
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("程序异常");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			resp.setRESPCODE("8888");
			resp.setRESPDESC("程序异常");
			out.getUNIBSSBODY().setSRENEWSUBRSP(resp);
			try {
				LOG.info("响应的报文"+objectMapper.writeValueAsString(out));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return out;
			
		}
	}

}

package com.open.capacity.srenewSer.utils;

import java.util.logging.Logger;

import com.open.capacity.srenewSer.bo.SrenewSerBO;
import com.open.capacity.utils.SpringUtil;

import cn.chinaunicom.ws.srenewser.SrenewSerImpl;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewtradersp.SRENEWTRADERSP;

/**
 * @author 作者 owen E-mail: wang.wen@neusoft.com
 * @version 创建时间：2018年4月17日 下午3:55:06 类说明
 */
public class SrenewSerUtils {

	public static SrenewSerUtils instance;

	private SrenewSerUtils() {

	}

	public static SrenewSerUtils getInstance() {

		if (instance == null) {
			instance = new SrenewSerUtils();
		}
		return instance;
	}

	private static final Logger LOG = Logger.getLogger(SrenewSerUtils.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.chinaunicom.ws.srenewser.SrenewSer#qryChgProd(cn.chinaunicom.ws.
	 * srenewser.unibssbody.QRYCHGPRODINPUT parameters )*
	 */
	public cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT qryChgProd(
			cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODINPUT parameters) {
		LOG.info("Executing operation qryChgProd");
		LOG.info(parameters.toString());
		try {
			cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT _return = SpringUtil.getBean(SrenewSerBO.class).qryChgProd(parameters);
			return _return;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
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

		LOG.info("Executing operation srenewTrade");
		LOG.info(parameters.toString());
		try {
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT _return = SpringUtil.getBean(SrenewSerBO.class)
					.srenewTrade(parameters);
			
			LOG.info(_return.toString());
			return _return;
		} catch (Exception ex) {

			SRENEWTRADEOUTPUT out = new SRENEWTRADEOUTPUT();
			SRENEWTRADEOUTPUT.UNIBSSBODY body = new SRENEWTRADEOUTPUT.UNIBSSBODY();
			out.setUNIBSSBODY(body);

			SRENEWTRADERSP resp = new SRENEWTRADERSP();

			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			resp.setRESPCODE("8888");
			resp.setRESPDESC("程序异常");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			LOG.info(out.toString());
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
		LOG.info("Executing operation srenewSub");
		LOG.info(parameters.toString());
		try {
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT _return = SpringUtil.getBean(SrenewSerBO.class).srenewSub(parameters);
			return _return;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}

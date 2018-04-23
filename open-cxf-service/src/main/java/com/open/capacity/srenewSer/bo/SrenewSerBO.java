package com.open.capacity.srenewSer.bo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年04月23日 上午20:01:06 类说明
 */

public interface SrenewSerBO {

	public cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT qryChgProd(
			cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODINPUT parameters);

	public cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT srenewTrade(
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEINPUT parameters);

	public cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT srenewSub(
			cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBINPUT parameters);

}

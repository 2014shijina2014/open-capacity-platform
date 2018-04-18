package com.open.capacity.srenewSer.bo.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.open.capacity.srenewSer.bo.SrenewSerBO;
import com.open.capacity.srenewSer.dao.AcceptTempDao;

import cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODINPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBINPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEINPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewsubreq.SRENEWSUBREQ;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewtradereq.SRENEWTRADEREQ;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewtradersp.SRENEWTRADERSP;

/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2018年4月18日 下午3:22:42 
* 类说明 
*/
@Service
public class SrenewSerBOImpl implements SrenewSerBO {
	
	@Autowired
	private AcceptTempDao acceptTempDao ;
	
	@Override
	public QRYCHGPRODOUTPUT qryChgProd(QRYCHGPRODINPUT parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SRENEWTRADEOUTPUT srenewTrade(SRENEWTRADEINPUT parameters) {
		// TODO Auto-generated method stub
		
		Map<String, Object> param = new HashMap<>();
		SRENEWTRADEREQ req  = parameters.getUNIBSSBODY().getSRENEWTRADEREQ() ;
		
		
		SRENEWTRADEOUTPUT out = new SRENEWTRADEOUTPUT();
		SRENEWTRADEOUTPUT.UNIBSSBODY body = new SRENEWTRADEOUTPUT.UNIBSSBODY();
		out.setUNIBSSBODY(body);
		
		SRENEWTRADERSP resp = new SRENEWTRADERSP();
		
		if(!"1".equals(req.getCHANGETAG())){
			
			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			resp.setRESPCODE("1816");
			resp.setRESPDESC("当前产品不支持续费业务或已做过包年交费业务");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out ;
			
		}
		
		param.put("accept_date", req.getACCEPTDATE()) ;
		param.put("account_id", req.getACCTID()) ;
		param.put("channel_id", req.getCHANNELID()) ;
		param.put("customer_id", req.getCUSTID()) ;
		param.put("in_mode", req.getEINMODE()) ;
		param.put("eparchy_code", req.getEPARCHYCODE()) ;
		param.put("net_type_code", req.getNETTYPECODE()) ;
		param.put("oper_id", req.getOPERID());
		param.put("province_code", req.getPROVINCECODE()) ;
		param.put("service_id", req.getSERIALNUMBER()) ;
		param.put("subscribe_id", req.getSUBSCRIBEID()) ;
		param.put("trade_id", req.getTRADEID()) ;
		param.put("trade_type_code", req.getTRADETYPECODE()) ;
		param.put("user_id", req.getUSERID()) ;
		
		
		Map serviceKind = acceptTempDao.getServiceKind(param) ;
		
		param.put("service_kind", Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND")))) ;
		
		
		
		//bb_service_relation_t
		Map userinfo = acceptTempDao.getServiceInfo(param) ;
		
		if (userinfo == null){
			
			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			resp.setRESPCODE("1204");
			resp.setRESPDESC("号码不存在");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out ;
		}
		
		if(!"4".equals(String.valueOf(userinfo.get("PAY_TYPE")))){
			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			resp.setRESPCODE("8888");
			resp.setRESPDESC("当前用户非趸交用户");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out ;
		}
		
		
		Map flowinfo =acceptTempDao.getFlowInfo(param) ;
		
		if (flowinfo != null){
			
			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			resp.setRESPCODE("1493");
			resp.setRESPDESC("当前用户存在在途工单");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out ;
		}
		
		
		
		Map bulkinfo =acceptTempDao.getBulkInfo(param) ;
		Date date = (Date) bulkinfo.get("END_DATE") ;
		
 
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		LocalDate localDate= localDateTime.toLocalDate();
		
		if( localDate.isBefore(localDate.now())){
			
			out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
			resp.setRESPCODE("8888");
			resp.setRESPDESC("当前用户非趸交用户");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out ;
			
		}
		
		
		
		userinfo.put("accept_date",String.valueOf( param.get("param")));
		userinfo.put("oper_id",String.valueOf( param.get("oper_id")));
		userinfo.putAll(bulkinfo);
		
		Map<String,Object> registerNumberInfo = new HashMap<>();
		acceptTempDao.getRegisterNumber(registerNumberInfo);
		
		userinfo.putAll(registerNumberInfo);
		
		
		acceptTempDao.saveAcceptTemp(userinfo) ;
		
		if( Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND")))==55){
			
			userinfo.putAll( acceptTempDao.getWidefo(param));

			acceptTempDao.saveWideTemp(userinfo) ;
			
		}
		
		acceptTempDao.saveBulkTemp(userinfo) ;
		
		return null;
	}

	//提交
	@Override
	public SRENEWSUBOUTPUT srenewSub(SRENEWSUBINPUT parameters) {
		// TODO Auto-generated method stub
		
		
		Map<String, Object> param = new HashMap<>();
		SRENEWSUBREQ req  = parameters.getUNIBSSBODY().getSRENEWSUBREQ() ;
		param.put("accept_date", req.getACCEPTDATE()) ;
		param.put("channel_id", req.getCHANNELID()) ;
		param.put("eparchy_code", req.getEPARCHYCODE()) ;
		param.put("fee_info", req.getFEEINFO()) ;
		param.put("oper_id", req.getOPERID()) ;
		param.put("pay_info", req.getPAYINFO());
		param.put("province_code", req.getPROVINCECODE()) ;
		param.put("register_number", req.getSUBSCRIBEID()) ;
		
		return null;
	}

}

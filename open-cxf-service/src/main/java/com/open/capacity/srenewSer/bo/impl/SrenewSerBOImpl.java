package com.open.capacity.srenewSer.bo.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.open.capacity.srenewSer.bo.SrenewSerBO;
import com.open.capacity.srenewSer.dao.AcceptTempDao;

import cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODINPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.QRYCHGPRODOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBINPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWSUBOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEINPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.SRENEWTRADEOUTPUT;
import cn.chinaunicom.ws.srenewser.unibssbody.qrychgprodreq.QRYCHGPRODREQ;
import cn.chinaunicom.ws.srenewser.unibssbody.qrychgprodrsp.QRYCHGPRODRSP;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewsubreq.SRENEWSUBREQ;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewsubrsp.SRENEWSUBRSP;
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
	
 
	public QRYCHGPRODOUTPUT qryChgProd(QRYCHGPRODINPUT parameters) {
		// TODO Auto-generated method stub
		
		QRYCHGPRODOUTPUT out = new QRYCHGPRODOUTPUT();
		
		QRYCHGPRODOUTPUT.UNIBSSBODY body = new QRYCHGPRODOUTPUT.UNIBSSBODY();
		out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
		out.setUNIBSSBODY(body);
		
		QRYCHGPRODRSP rsp = new QRYCHGPRODRSP();
		
		QRYCHGPRODREQ req = parameters.getUNIBSSBODY().getQRYCHGPRODREQ() ;
		
		rsp.setRESPCODE("0000");
		rsp.setRESPDESC("成功");
		body.setQRYCHGPRODRSP(rsp);
		
		QRYCHGPRODRSP.PRODUCTINFO product = new QRYCHGPRODRSP.PRODUCTINFO();
		
		Map<String, Object> param = new HashMap<>();
 
		param.put("eparchy_code", req.getEPARCHYCODE()) ;
		param.put("net_type_code", req.getNETTYPECODE()) ;
		param.put("province_code", req.getPROVINCECODE()) ;
		param.put("service_id", req.getSERIALNUMBER()) ;
		
		
		Map serviceKind = acceptTempDao.getServiceKind(param) ;
		
		param.put("service_kind", Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND")))) ;
		
		Map userinfo = acceptTempDao.getServiceInfo(param) ;
		
		
		product.setPRODUCTID(String.valueOf(userinfo.get("SERVICE_FAVOUR_ID")));
		
		param.put("product_id", String.valueOf(userinfo.get("SERVICE_FAVOUR_ID"))) ;
		
		
		QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO discntinfo = new QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO();
		
		discntinfo.setSTARTENABLE("1");
		
		product.getDISCNTINFO().add(discntinfo) ;
	 
		rsp.getPRODUCTINFO().add(product) ;
		
		out.getUNIBSSBODY().setQRYCHGPRODRSP(rsp);
		
		
		return out;
	}

	@Override
	@Transactional
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
		
		

		
		userinfo.put("accept_date",String.valueOf( param.get("accept_date")));
		userinfo.put("oper_id",String.valueOf( param.get("oper_id")));
		
		userinfo.put("channel_id",String.valueOf( param.get("channel_id")));
		userinfo.put("service_kind",String.valueOf( param.get("service_kind")));
		userinfo.put("service_id",String.valueOf( param.get("service_id")));
		userinfo.put("eparchy_code",String.valueOf( param.get("eparchy_code")));
		userinfo.putAll(bulkinfo);
		
		
		LocalDate af = localDate.plusMonths(Long.valueOf(String.valueOf(userinfo.get("EFFECT_VALUES")))) ;
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = af.atStartOfDay(zoneId);
		
		userinfo.put("BEGIN_DATE", bulkinfo.get("END_DATE")) ;
		userinfo.put("END_DATE", Date.from(zdt.toInstant()));
		
		Map<String,Object> registerNumberInfo = new HashMap<>();
		acceptTempDao.getRegisterNumber(registerNumberInfo);
		
		userinfo.putAll(registerNumberInfo);
		
		
		acceptTempDao.saveAcceptTemp(userinfo) ;
		
		
		
		if( Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND")))==55){
			
			userinfo.putAll( acceptTempDao.getWidefo(param));

			acceptTempDao.saveWideTemp(userinfo) ;
			
		}
		
		acceptTempDao.saveBulkTemp(userinfo) ;
		
		
		out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
		resp.setRESPCODE("0000");
		resp.setRESPDESC("成功");
		
	 
		
		
		SRENEWTRADERSP.RESPINFO info = new SRENEWTRADERSP.RESPINFO();
		
		info.setFEE(String.valueOf(userinfo.get("BULK_PRICE")) +"000");
		info.setOLDFEE(String.valueOf(userinfo.get("BULK_PRICE")) +"000");
		info.setPAYTAG("0");
		info.setOPERATETYPE("1");
		info.setSUBSCRIBEID(String.valueOf(userinfo.get("OS_TEMP_RGST")));
		info.setTRADEID(parameters.getUNIBSSBODY().getSRENEWTRADEREQ().getTRADEID());
		info.setFEEMODE("2");
		info.setFEETYPECODE("783");
		info.setFEETYPENAME("趸交预存费用");
		resp.getRESPINFO().add(info) ;
		
		out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
		
		return out;
	}

	//提交
	@Override
	public SRENEWSUBOUTPUT srenewSub(SRENEWSUBINPUT parameters) {
		// TODO Auto-generated method stub
		
		SRENEWSUBOUTPUT out = new SRENEWSUBOUTPUT();
		SRENEWSUBOUTPUT.UNIBSSBODY body = new SRENEWSUBOUTPUT.UNIBSSBODY ();
		
		SRENEWSUBRSP rsp = new SRENEWSUBRSP();
		body.setSRENEWSUBRSP(rsp);
		out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
		out.setUNIBSSBODY(body);
		
		Map<String, Object> param = new HashMap<>();
		SRENEWSUBREQ req  = parameters.getUNIBSSBODY().getSRENEWSUBREQ() ;
		//受理信息
		param.put("register_number", req.getSUBSCRIBEID()) ;
		
		Map bulkTemp = acceptTempDao.getServiceKindByReg(param) ;
		String feeStr = null ;
		
		if(bulkTemp==null){
			rsp.setRESPCODE("8888");
			rsp.setRESPDESC("临时受理编号不存在");
			out.getUNIBSSBODY().setSRENEWSUBRSP(rsp);
			return out;
		}
		
		
		if(Integer.parseInt(String.valueOf(bulkTemp.get("SERVICE_KIND"))) == 55){
			feeStr = "55`783`趸交预存费用`"+String.valueOf(bulkTemp.get("BULK_PRICE"))+"`0``1`1`~" ;
		} 
		
		param.put("IS_TEMP_RGST_NO",  req.getSUBSCRIBEID()) ;
		param.put("IS_SERVICE_KIND_STR", String.valueOf(bulkTemp.get("SERVICE_KIND"))) ;
		param.put("IS_FEE_STR",  feeStr) ;
 
		
		acceptTempDao.submit(param);
		
		Integer ON_FLAG =Integer.parseInt( String.valueOf(param.get("ON_FLAG") )) ;
		String OS_PROMPT = String.valueOf(param.get("OS_PROMPT") );
		String ON_FEE_STATUS = String.valueOf(param.get("ON_FEE_STATUS") ) ;
		
		if(1==ON_FLAG){
			rsp.setRESPCODE("0000");
			rsp.setRESPDESC("成功");
			
		}else{
			rsp.setRESPCODE("8888");
			rsp.setRESPDESC(OS_PROMPT);
		}
		
		out.getUNIBSSBODY().setSRENEWSUBRSP(rsp);
		
		return out;
	}

}

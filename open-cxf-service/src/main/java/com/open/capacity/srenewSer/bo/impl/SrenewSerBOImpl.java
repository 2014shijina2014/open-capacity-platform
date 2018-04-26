package com.open.capacity.srenewSer.bo.impl;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import cn.chinaunicom.ws.unibsshead.UNIBSSHEAD;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年04月23日 上午20:01:06 类说明
 */
@Service
public class SrenewSerBOImpl implements SrenewSerBO {

	private static final Logger LOG = Logger.getLogger(SrenewSerBOImpl.class.getName());

	@Autowired
	private AcceptTempDao acceptTempDao;
	
	@Autowired
	private RedisTemplate<String, Object>  redisTemplate ;


	@Resource
	private ObjectMapper objectMapper; // springmvc启动时自动装配json处理类
	
	public QRYCHGPRODOUTPUT qryChgProd(QRYCHGPRODINPUT parameters) {
		// TODO Auto-generated method stub

		try {
			LOG.info("请求的报文:"+objectMapper.writeValueAsString(parameters));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QRYCHGPRODOUTPUT out = new QRYCHGPRODOUTPUT();

		QRYCHGPRODOUTPUT.UNIBSSBODY body = new QRYCHGPRODOUTPUT.UNIBSSBODY();
		out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
		out.setUNIBSSBODY(body);

		out.setUNIBSSATTACHED(parameters.getUNIBSSATTACHED());
		
		
		out.getUNIBSSHEAD().setACTIONCODE("1");
		
		UNIBSSHEAD.RESPONSE response = new UNIBSSHEAD.RESPONSE ();
		out.getUNIBSSHEAD().setRESPONSE(response);
		
		out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("0000");
		out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("成功");
		out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
		
		QRYCHGPRODRSP rsp = new QRYCHGPRODRSP();

		QRYCHGPRODREQ req = parameters.getUNIBSSBODY().getQRYCHGPRODREQ();

		rsp.setRESPCODE("0000");
		rsp.setRESPDESC("成功");
		body.setQRYCHGPRODRSP(rsp);

		QRYCHGPRODRSP.PRODUCTINFO product = new QRYCHGPRODRSP.PRODUCTINFO();

		Map<String, Object> param = new HashMap<>();

		param.put("eparchy_code", req.getEPARCHYCODE());
		param.put("net_type_code", req.getNETTYPECODE());
		param.put("province_code", req.getPROVINCECODE());
		param.put("service_id", req.getSERIALNUMBER());

//		Map serviceKind = acceptTempDao.getServiceKind(param);
		
		String serviceKindKey = req.getSERIALNUMBER()+":serviceKind" ;
		
		Map serviceKind = (Map) redisTemplate.opsForValue().get(serviceKindKey);
		
		if(serviceKind==null){
			serviceKind = acceptTempDao.getServiceKind(param);
			redisTemplate.opsForValue().set(serviceKindKey, serviceKind, 120, TimeUnit.SECONDS);
		}
		
		 
		
//		redisTemplate.opsForValue().set(key, value);

		param.put("service_kind", Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND"))));

		Map userinfo = (Map) redisTemplate.opsForValue().get(req.getSERIALNUMBER()+":userInfo");
				
		if(userinfo ==null){
			userinfo = acceptTempDao.getServiceInfo(param);
			redisTemplate.opsForValue().set(req.getSERIALNUMBER()+":userInfo", userinfo, 120, TimeUnit.SECONDS);
		}
				
				
		
		if (userinfo == null) {

			rsp.setRESPCODE("8888");
			rsp.setRESPDESC("号码不存在");
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("号码不存在");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			out.getUNIBSSBODY().setQRYCHGPRODRSP(rsp);
			return out;
		}
		
		
		userinfo.put("user_id", userinfo.get("USER_ID"));

		Map prodinfo =  acceptTempDao.getProductInfo(userinfo);

		
		product.setPRODUCTID(String.valueOf(userinfo.get("SERVICE_FAVOUR_ID")));
		product.setPRODUCTNAME(String.valueOf(prodinfo.get("F_PROD_NAME")));
		product.setPRODUCTDESC(String.valueOf(prodinfo.get("F_PROD_DESC")));
		
		product.setPRODUCTMODE("1");
		
		param.put("product_id", String.valueOf(userinfo.get("SERVICE_FAVOUR_ID")));

		if(Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND")))==55){
			Map serviceInfo =  (Map) redisTemplate.opsForValue().get(req.getSERIALNUMBER()+":serviceInfo");
					
			if(serviceInfo ==null ){
				serviceInfo = acceptTempDao.getWidefo(userinfo);
				redisTemplate.opsForValue().set(req.getSERIALNUMBER()+":serviceInfo", serviceInfo,120, TimeUnit.SECONDS);
			}
			
			userinfo.putAll(serviceInfo);

		}else if (Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND")))==11){
			
			Map serviceInfo =  (Map) redisTemplate.opsForValue().get(req.getSERIALNUMBER()+":serviceInfo");
					
			
			if(serviceInfo ==null ){
				serviceInfo = acceptTempDao.getAdslfo(userinfo)  ;
				redisTemplate.opsForValue().set(req.getSERIALNUMBER()+":serviceInfo", serviceInfo, 120, TimeUnit.SECONDS);
			}
			
					
			
			userinfo.putAll(serviceInfo);

		}
		Map bulkinfo = (Map) redisTemplate.opsForValue().get(req.getSERIALNUMBER()+":bulkInfo");
		
		if(bulkinfo ==null){
			bulkinfo = acceptTempDao.getBulkInfo(param); 
			redisTemplate.opsForValue().set(req.getSERIALNUMBER()+":bulkInfo", bulkinfo, 120, TimeUnit.SECONDS);
		}
				
				
		
		if (bulkinfo == null) {

			rsp.setRESPCODE("8888");
			rsp.setRESPDESC("非趸交用户");
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("非趸交用户");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			out.getUNIBSSBODY().setQRYCHGPRODRSP(rsp);
			return out;
		}
		
		
		
		
		
		QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO discntinfo = new QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO();
		
		discntinfo.setDISCNTCODE("783");
		discntinfo.setDISCNTNAME(String.valueOf(userinfo.get("BANDWIDTH"))+"M宽带" +String.valueOf(bulkinfo.get("BULK_PRICE"))+"元"+String.valueOf(bulkinfo.get("EFFECT_VALUES"))+"个月");
		discntinfo.setDISCNTDESC(String.valueOf(userinfo.get("BANDWIDTH"))+"M宽带" +String.valueOf(bulkinfo.get("BULK_PRICE"))+"元"+String.valueOf(bulkinfo.get("EFFECT_VALUES"))+"个月");
		discntinfo.setDISCNTFEE(String.valueOf(bulkinfo.get("BULK_PRICE")+"000"));
		discntinfo.setBRANDSPEED(String.valueOf(userinfo.get("BANDWIDTH")));
		discntinfo.setSTARTENABLE("1");
		discntinfo.setBRANDNUMBER(String.valueOf(bulkinfo.get("EFFECT_VALUES")));
		product.getDISCNTINFO().add(discntinfo);

		rsp.getPRODUCTINFO().add(product);

		out.getUNIBSSBODY().setQRYCHGPRODRSP(rsp);

		
		
		return out;
	}

	@Override
	@Transactional
	public SRENEWTRADEOUTPUT srenewTrade(SRENEWTRADEINPUT parameters) {
		// TODO Auto-generated method stub

		try {
			LOG.info("请求的报文:"+objectMapper.writeValueAsString(parameters));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, Object> param = new HashMap<>();
		SRENEWTRADEREQ req = parameters.getUNIBSSBODY().getSRENEWTRADEREQ();

		SRENEWTRADEOUTPUT out = new SRENEWTRADEOUTPUT();
		SRENEWTRADEOUTPUT.UNIBSSBODY body = new SRENEWTRADEOUTPUT.UNIBSSBODY();
		out.setUNIBSSBODY(body);
		out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
		
		UNIBSSHEAD.RESPONSE response = new UNIBSSHEAD.RESPONSE ();
		out.getUNIBSSHEAD().setRESPONSE(response);
		
		out.getUNIBSSHEAD().setACTIONCODE("1");
		out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("0000");
		out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("成功");
		out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
		out.setUNIBSSATTACHED(parameters.getUNIBSSATTACHED());
		SRENEWTRADERSP resp = new SRENEWTRADERSP();

		if (!"1".equals(req.getCHANGETAG())) {

			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("1816");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("当前产品不支持续费业务或已做过包年交费业务");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			resp.setRESPCODE("1816");
			resp.setRESPDESC("当前产品不支持续费业务或已做过包年交费业务");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out;

		}

		param.put("accept_date", req.getACCEPTDATE());
		param.put("account_id", req.getACCTID());
		param.put("channel_id", req.getCHANNELID());
		param.put("customer_id", req.getCUSTID());
		param.put("in_mode", req.getEINMODE());
		param.put("eparchy_code", req.getEPARCHYCODE());
		param.put("net_type_code", req.getNETTYPECODE());
		param.put("oper_id", req.getOPERID());
		param.put("province_code", req.getPROVINCECODE());
		param.put("service_id", req.getSERIALNUMBER());
		param.put("subscribe_id", req.getSUBSCRIBEID());
		param.put("trade_id", req.getTRADEID());
		param.put("trade_type_code", req.getTRADETYPECODE());
		param.put("user_id", req.getUSERID());

		String serviceKindKey = req.getSERIALNUMBER()+":serviceKind" ;
		
		Map serviceKind = (Map) redisTemplate.opsForValue().get(serviceKindKey);
		
		if(serviceKind==null){
			serviceKind = acceptTempDao.getServiceKind(param);
			redisTemplate.opsForValue().set(serviceKindKey, serviceKind, 120, TimeUnit.SECONDS);
		}

		param.put("service_kind", Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND"))));

		// bb_service_relation_t
		
		Map userinfo = (Map) redisTemplate.opsForValue().get(req.getSERIALNUMBER()+":userInfo");
		
		if(userinfo ==null){
			userinfo = acceptTempDao.getServiceInfo(param);
			redisTemplate.opsForValue().set(req.getSERIALNUMBER()+":userInfo", userinfo, 120, TimeUnit.SECONDS);
		}
		
		
		if (userinfo == null) {

			resp.setRESPCODE("1204");
			resp.setRESPDESC("号码不存在");
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("1204");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("号码不存在");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out;
		}

		if (!"4".equals(String.valueOf(userinfo.get("PAY_TYPE")))) {
			resp.setRESPCODE("8888");
			resp.setRESPDESC("当前用户非趸交用户");
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("当前用户非趸交用户");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out;
		}
		param.put("user_id", userinfo.get("USER_ID"));
		Map flowinfo = acceptTempDao.getFlowInfo(param);

		if (flowinfo != null) {
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("1493");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("当前用户存在在途工单");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			resp.setRESPCODE("1493");
			resp.setRESPDESC("当前用户存在在途工单");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out;
		}
		flowinfo = null ;
		flowinfo = acceptTempDao.getFlowInfo1(param) ;
		if (flowinfo != null) {
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("1493");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("当前用户存在在途工单");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			resp.setRESPCODE("1493");
			resp.setRESPDESC("当前用户存在在途工单");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out;
		}

		Map bulkinfo = (Map) redisTemplate.opsForValue().get(req.getSERIALNUMBER()+":bulkInfo");
		
		if(bulkinfo ==null){
			bulkinfo = acceptTempDao.getBulkInfo(param); 
			redisTemplate.opsForValue().set(req.getSERIALNUMBER()+":bulkInfo", bulkinfo, 120, TimeUnit.SECONDS);
		}
		
		Date date = (Date) bulkinfo.get("END_DATE");

		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		LocalDate localDate = localDateTime.toLocalDate();

		if (localDate.isBefore(localDate.now())) {
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("当前用户非趸交用户");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			resp.setRESPCODE("8888");
			resp.setRESPDESC("当前用户非趸交用户");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out;

		}

		userinfo.put("accept_date", String.valueOf(param.get("accept_date")));
		userinfo.put("oper_id", String.valueOf(param.get("oper_id")));

		userinfo.put("channel_id", String.valueOf(param.get("channel_id")));
		userinfo.put("service_kind", String.valueOf(param.get("service_kind")));
		userinfo.put("service_id", String.valueOf(param.get("service_id")));
		userinfo.put("eparchy_code", String.valueOf(param.get("eparchy_code")));
		userinfo.putAll(bulkinfo);

		
		List<Map> list = acceptTempDao.ifDiscut(userinfo) ;
		
		if(list.size()>0){
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("测试，体验，和折扣 不能通过支付宝续费");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			resp.setRESPCODE("8888");
			resp.setRESPDESC("测试，体验，和折扣 不能通过支付宝续费");
			out.getUNIBSSBODY().setSRENEWTRADERSP(resp);
			return out;
		}
		
		
		LocalDate af = localDate.plusMonths(Long.valueOf(String.valueOf(userinfo.get("EFFECT_VALUES"))));
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = af.atStartOfDay(zoneId);

		userinfo.put("BEGIN_DATE", bulkinfo.get("END_DATE"));
		userinfo.put("END_DATE", Date.from(zdt.toInstant()));

		Map<String, Object> registerNumberInfo = new HashMap<>();
		acceptTempDao.getRegisterNumber(registerNumberInfo);

		userinfo.putAll(registerNumberInfo);

		acceptTempDao.saveAcceptTemp(userinfo);

		if (Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND"))) == 55) {

			userinfo.putAll(acceptTempDao.getWidefo(param));

			acceptTempDao.saveWideTemp(userinfo);

		}else if (Integer.parseInt(String.valueOf(serviceKind.get("SERVICEKIND"))) == 11) {

			userinfo.putAll(acceptTempDao.getAdslfo(param));

			acceptTempDao.saveAdslTemp(userinfo);

		}
 

		acceptTempDao.saveBulkTemp(userinfo);

		out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
		resp.setRESPCODE("0000");
		resp.setRESPDESC("成功");

		SRENEWTRADERSP.RESPINFO info = new SRENEWTRADERSP.RESPINFO();

		info.setFEE(String.valueOf(userinfo.get("BULK_PRICE")) + "000");
		info.setOLDFEE(String.valueOf(userinfo.get("BULK_PRICE")) + "000");
		info.setPAYTAG("0");
		info.setOPERATETYPE("1");
		if( parameters.getUNIBSSBODY().getSRENEWTRADEREQ().getTRADEID() !=null ){
			
			info.setTRADEID(parameters.getUNIBSSBODY().getSRENEWTRADEREQ().getTRADEID());
		}else{
			info.setTRADEID(  new SimpleDateFormat("yyyyMMddhhmmssSS").format(new Date()));
		}
		
		
		
		info.setSUBSCRIBEID(String.valueOf(userinfo.get("OS_TEMP_RGST")));
		info.setFEEMODE("2");
		info.setFEETYPECODE("783");
		info.setFEETYPENAME("趸交预存费用");
		resp.getRESPINFO().add(info);

		out.getUNIBSSBODY().setSRENEWTRADERSP(resp);

	 
		return out;
	}

	// 提交
	@Override
	@Transactional
	public SRENEWSUBOUTPUT srenewSub(SRENEWSUBINPUT parameters) {
		// TODO Auto-generated method stub

		try {
			LOG.info("请求的报文:"+objectMapper.writeValueAsString(parameters));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SRENEWSUBOUTPUT out = new SRENEWSUBOUTPUT();
		SRENEWSUBOUTPUT.UNIBSSBODY body = new SRENEWSUBOUTPUT.UNIBSSBODY();

		SRENEWSUBRSP rsp = new SRENEWSUBRSP();
		body.setSRENEWSUBRSP(rsp);
		out.setUNIBSSHEAD(parameters.getUNIBSSHEAD());
		UNIBSSHEAD.RESPONSE response = new UNIBSSHEAD.RESPONSE ();
		out.getUNIBSSHEAD().setRESPONSE(response);
		out.getUNIBSSHEAD().setACTIONCODE("1");
		out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("0000");
		out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("成功");
		out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
		out.setUNIBSSBODY(body);
		out.setUNIBSSATTACHED(parameters.getUNIBSSATTACHED());
		Map<String, Object> param = new HashMap<>();
		SRENEWSUBREQ req = parameters.getUNIBSSBODY().getSRENEWSUBREQ();
		// 受理信息
		param.put("register_number", req.getSUBSCRIBEID());
		param.put("order_id", req.getTRADEID());

		Map bulkTemp = acceptTempDao.getServiceKindByReg(param);
		String feeStr = null;

		if (bulkTemp == null) {
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC("临时受理编号不存在");
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			rsp.setRESPCODE("8888");
			rsp.setRESPDESC("临时受理编号不存在");
			out.getUNIBSSBODY().setSRENEWSUBRSP(rsp);
			return out;
		}

		if (Integer.parseInt(String.valueOf(bulkTemp.get("SERVICE_KIND"))) == 55) {
			feeStr = "55`783`趸交预存费用`" + String.valueOf(bulkTemp.get("BULK_PRICE")) + "`0``1`1`~";
		}else{
			if (Integer.parseInt(String.valueOf(bulkTemp.get("SERVICE_KIND"))) == 11) {
				feeStr = "11`783`趸交预存费用`" + String.valueOf(bulkTemp.get("BULK_PRICE")) + "`0``1`1`~";
			}
		}

		param.put("IS_BIPCODE", "");
		param.put("IS_TEMP_RGST_NO", req.getSUBSCRIBEID());
		param.put("IS_SERVICE_KIND_STR", String.valueOf(bulkTemp.get("SERVICE_KIND")));
		param.put("IS_FEE_STR", feeStr);

		param.putAll(bulkTemp);
		
		acceptTempDao.saveOrderTemp(param) ;
		acceptTempDao.submit(param);

		Integer ON_FLAG = Integer.parseInt(String.valueOf(param.get("ON_FLAG")));
		String OS_PROMPT = String.valueOf(param.get("OS_PROMPT"));
		String ON_FEE_STATUS = String.valueOf(param.get("ON_FEE_STATUS"));

		if (1 == ON_FLAG) {
			rsp.setRESPCODE("0000");
			rsp.setRESPDESC("成功");

//			自动执行
//			
//			param.put("IS_REGISTER_NUMBER", OS_PROMPT) ;
//			param.put("IS_ACCEPT_CITY", String.valueOf(bulkTemp.get("CITY_CODE"))) ;
//			param.put("IN_SERVICE_KIND", String.valueOf(bulkTemp.get("SERVICE_KIND"))) ;
//			param.put("IS_SERVICE_ID", String.valueOf(bulkTemp.get("SERVICE_ID"))) ;
//			param.put("IN_APPLY_EVENT", "302") ;
//			param.put("IN_ACTION", "2") ;
//			param.put("IS_DEPARTMENT", "") ;
//			param.put("IS_OPER_PERSON", "") ;
//			
//			acceptTempDao.auto(param);
//			Integer resp_code = Integer.parseInt(String.valueOf(param.get("ON_FLAG")));
//			String resp_desc = String.valueOf(param.get("OS_PROMPT"));
//			
//			if (0 == resp_code) {
//				rsp.setRESPCODE("0000");
//				rsp.setRESPDESC("成功");
//			}else{
//				rsp.setRESPCODE("8888");
//				rsp.setRESPDESC(resp_desc);
//			}
			
			
		} else {
			out.getUNIBSSHEAD().getRESPONSE().setRSPCODE("8888");
			out.getUNIBSSHEAD().getRESPONSE().setRSPDESC(OS_PROMPT);
			out.getUNIBSSHEAD().getRESPONSE().setRSPTYPE("1");
			rsp.setRESPCODE("8888");
			rsp.setRESPDESC(OS_PROMPT);
		}

		out.getUNIBSSBODY().setSRENEWSUBRSP(rsp);
		 
		return out;
	}

}

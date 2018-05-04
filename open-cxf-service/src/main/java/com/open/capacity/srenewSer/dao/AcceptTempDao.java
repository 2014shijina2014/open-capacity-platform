package com.open.capacity.srenewSer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年04月23日 上午20:01:06 类说明
 */
@Mapper
public interface AcceptTempDao {

	// 服务消费者注入容错机制，加入hystrix支持容错
	public void getRegisterNumber(Map<String, Object> map);

	@Insert("INSERT INTO CRM_OWNER_USER.BB_ACCEPT_TEMP_T (F_TEMP_RGST_NO, F_CUST_ORDER_ID, F_BUNDLE_KIND, F_OPER_KIND, F_ACCEPT_CITY, "
			+ "F_ACCEPT_STATUS,F_CONTACT_ID, F_APPLY_EVENT,F_ACCEPT_PERSON, F_ACCEPT_ADDRESS_ID, "
			+ "F_ACCEPT_WAY, F_ACCEPT_DATE,F_SERVICE_KIND,F_SERVICE_ID, F_BATCH_FLAG, "
			+ "GROUP_PRODUCT, F_IF_ACCOUNT, F_BUNDLE_ID,F_UPDATE_NETWORK, STOP_MONTH, "
			+ "F_IF_GROUP_ACCEPT, F_O_DEVELOPERDEALER,F_ODEVELOPER) "
			+ "VALUES (#{OS_TEMP_RGST}, '24328582',0,0,  #{CITY_CODE}, "
			+ "0,4170324819906,302,#{oper_id}, #{channel_id}, "
			+ "44, TO_DATE (#{accept_date}, 'YYYYMMDDHH24MISS'),#{service_kind},  #{service_id},0, " + "0,0, 0,0,0, "
			+ "0,'0', '0')")
	public int saveAcceptTemp(Map<String, Object> map);

	@Insert("INSERT INTO CRM_OWNER_USER.BB_WIDE_BUS_TEMP_T (REGISTER_NUMBER,ACCEPT_STATUS,  ACCEPT_CITY, APPLY_EVENT, ACCEPT_DATE,"
			+ "ACCEPT_PERSON,ACCEPT_ADDRESS_ID,  ACCEPT_WAY, APPLY_REASON, CITY_CODE,"
			+ "BUNDLE_ID,REGION_CODE, BELONG_CODE, USER_ID,CUSTOMER_ID,"
			+ "ACCOUNT_ID,  INHERIT_FLAG,  INHERIT_ID, SERVICE_ID,OPER_LEVEL,"
			+ "INNET_METHOD, DEALER_INNET_METHOD,CREDIT_SOLUTION, CREDIT_SOLU, IF_SELF_CONTROL,"
			+ "PASSWORD, SERV_CREDIT_CONTROL,PAY_TYPE,DEVELOPER_DEALER,DEVELOPER,"
			+ "SERVICE_FAVOUR_ID,SERVICE_GROUP_ID, SERVICE_IF_VALID,SER_SERVING_STATUS, ACCESS_LEVEL,"
			+ "BUS_FAVOUR_ID,PAY_WAY,INTELLIGENTIZE_FLAG, MONTH_FEE, IP_NUM,"
			+ "ACCESS_MAX_NUM,  IDLE_TIMEOUT, SESSION_TIMEOUT,  EXPIRATION_FLAG, EXPIRATION_DATE,"
			+ "TRUNKS_COUNT,INSTALL_ADDRESS, IF_SPAN_BUREAU,INSTALL_GROUP_ID, DATA_USER_LEVEL,"
			+ "AVAILABLE, IF_MSC, CONTRACT_TIME, RATE,NET_CIRCUIT,"
			+ "IF_INSTALL,  SCHOOL_ID, POS_FEE, MONEY_FEE,MONEY_WAY,"
			+ "MONTH_NUM,PC_BANK,INSTALL_KIND,BIND_SERVICE_KIND,  PRESENT_FEE,"
			+ "SOURCE_ID, IF_PRE_COOP,  IF_EMERGENCY,  IF_PRE_FEE, IF_DEPOSIT,"
			+ "IF_RESERVE, ACCEPT_SOURCE,  BRAND_ID,  VIA_ID_KIND,GRT_ID,"
			+ "GRT_IDENTITY_KIND,  GRT_DEPOSIT,GROUP_ID, USER_TYPE, SALES_MODE,"
			+ " APPLY_START_DATE,SERVICE_START_DATE,  DEALER_RETURN_DATE, DEALER_INPUT_DATE,STATUS_CHANGE_DATE,"
			+ "BRAND_ORG,SHARE_SCALE, NET_GRID)" + " VALUES ("
			+ "#{OS_TEMP_RGST}, 0, #{CITY_CODE}, 302,  TO_DATE (#{accept_date}, 'YYYYMMDDHH24MISS'),"
			+ " #{oper_id},#{channel_id}, 44, 0, #{CITY_CODE},"
			+ " 0,   #{REGION_CODE},  #{BELONG_CODE},  #{USER_ID}, #{CUSTOMER_ID},"
			+ " #{ACCOUNT_ID}, 0, #{INHERIT_ID}, #{service_id},  #{service_kind}," + "#{INNET_METHOD}, -1, 0, 0, 0,"
			+ " #{PASSWORD}, 1, #{PAY_TYPE},#{DEVELOPER_DEALER},#{DEVELOPER},"
			+ " #{SERVICE_FAVOUR_ID}, 0, 0,   0,  3,"
			+ " 0,0,  0,  0,  0," + " 0, 0,  0,  1, '2015-09-08'," + " 1, #{REAL_INSTALL_ADDRESS}, 0,  '0',  0,"
			+ " 0,0,  0, '2',   0," + " 0,  0,   0,  0, 0," + " 0,  0,  0,   0,  0," + " #{channel_id},   0,  0, 0, 0,"
			+ "  0,0, '0', 0, 0," + " 1,  0,  '0',  0,   0,"
			+ " #{APPLY_START_DATE},  #{SERVICE_START_DATE}, #{DEALER_RETURN_DATE} , #{DEALER_INPUT_DATE} ,  #{STATUS_CHANGE_DATE} ,"
			+ " 0, 0,   #{NET_GRID})")
	public int saveWideTemp(Map<String, Object> map);
	
	
	
	@Insert("INSERT INTO CRM_OWNER_USER.BB_ADSL_BUS_TEMP_T ("
			+ "REGISTER_NUMBER, ACCEPT_STATUS, ACCEPT_CITY,   APPLY_EVENT,  ACCEPT_DATE,"
			+ "ACCEPT_PERSON,  ACCEPT_ADDRESS_ID,ACCEPT_WAY,APPLY_REASON,  CITY_CODE, "
			+ "BUNDLE_ID,REGION_CODE, BELONG_CODE, USER_ID, CUSTOMER_ID,  "
			+ "ACCOUNT_ID, INHERIT_FLAG,INHERIT_ID, SERVICE_ID, OPER_LEVEL, "
			+ "INNET_METHOD,DEALER_INNET_METHOD,  CREDIT_SOLUTION,CREDIT_SOLU, IF_SELF_CONTROL, "
			+ "PASSWORD, SERV_CREDIT_CONTROL,PAY_TYPE,  DEVELOPER_DEALER,   DEVELOPER,  "
			+ "SERVICE_FAVOUR_ID,SERVICE_GROUP_ID, SERVICE_IF_VALID,SER_SERVING_STATUS,   ACCESS_LEVEL,"
			+ "BUS_FAVOUR_ID, PAY_WAY, INTELLIGENTIZE_FLAG,  MONTH_FEE, IP_NUM,"
			+ "ACCESS_MAX_NUM,  IDLE_TIMEOUT,  SESSION_TIMEOUT,  EXPIRATION_FLAG,  BANDWIDTH, "
			+ "TRUNKS_COUNT,INSTALL_KIND,  IF_SPAN_BUREAU,   INSTALL_ADDRESS, LINE_NO,   "
			+ "OLD_LINE_NO,  DATA_USER_LEVEL,  AVAILABLE,    IF_BIND_ACCOUNT, IF_BIND,  "
			+ "CONTRACT_TIME, RATE, NET_CIRCUIT, IF_INSTALL,   SCHOOL_ID,"
			+ "POS_FEE,MONEY_FEE, MONEY_WAY, MONTH_NUM,  PC_BANK,"
			+ "RADIUS_LEVEL, PROJECT_ID, DEVICE_ID,IF_BIND_CARD, ANNUAL_NUMBER,"
			+ "ANNUAL_FEE, PRESENT_MONTH,  PRESENT_FEE1, IF_CONTINUE,  PRE_ANNUAL_NUMBER,"
			+ "PRE_ANNUAL_FEE, PRE_PRESENT_MONTH, PRE_PRESENT_FEE1,  PRE_CONTINUE_FLAG, ANNUAL_FLAG, "
			+ "CONTRACT_MONTHS,   PRESENT_FEE, SOURCE_ID,  IF_PRE_COOP,  IF_EMERGENCY, "
			+ "IF_PRE_FEE, IF_DEPOSIT, IF_RESERVE,   ACCEPT_SOURCE, BRAND_ID,  "
			+ "VIA_ID_KIND, GRT_ID,GRT_IDENTITY_KIND, GRT_DEPOSIT, GROUP_ID,  "
			+ "USER_TYPE, SALES_MODE, APPLY_START_DATE,  SERVICE_START_DATE, SERVICE_STOP_DATE, "
			+ "DEALER_RETURN_DATE, DEALER_INPUT_DATE,  STATUS_CHANGE_DATE, NEW_ACC_TYPE,  IN_TYPE,"
			+ "PRODUCT_WAY, BIND_TYPE, BRAND_ORG, SHARE_SCALE,  NET_GRID)"
			+ "VALUES (#{OS_TEMP_RGST},1, #{CITY_CODE},   302,    TO_DATE (#{accept_date}, 'YYYYMMDDHH24MISS'),"
			+ "#{oper_id},    #{channel_id},   1,  0, #{CITY_CODE},"
			+ "0,    #{REGION_CODE},  #{BELONG_CODE},   #{USER_ID},  #{CUSTOMER_ID},"
			+ "#{ACCOUNT_ID},  0, #{INHERIT_ID},  #{service_id},  #{service_kind},"
			+ "1, -1,  0,   0,   0,"
			+ "#{PASSWORD},  1,  #{PAY_TYPE},  #{DEVELOPER_DEALER},  #{DEVELOPER},"
			+ " #{SERVICE_FAVOUR_ID},   0,  0,   0,   3,"
			+ " 0,   0,  0,   0, 0,"
			+ " 0,  0,   0,   1,  '4',"
			+ "  0,   2, 0,  #{INSTALL_ADDRESS},  0,"
			+ " 0, 1, 0, 0,0,"
			+ " 0,'4M', 0,   0,  0,"
			+ " 0,  0,    0,0,  0,"
			+ "  0,  0, 0, 0,   0,"
			+ "  0, 0, 0,0, 0,"
			+ " 0, 0, 0,0,  0,"
			+ " 0,  0,  'C74012725',   0, 0,"
			+ " 0, 0,  0,  0,'0',"
			+ " 0, 0,  1,  0,   '0',"
			+ " 0,  0,  #{APPLY_START_DATE}, #{SERVICE_START_DATE},#{SERVICE_STOP_DATE},"
			+ " #{DEALER_RETURN_DATE},#{DEALER_INPUT_DATE},  #{STATUS_CHANGE_DATE},  0,  0,"
			+ " 0,  0,   0,  0, #{NET_GRID})")
	public int saveAdslTemp(Map<String, Object> map);
	

	@Insert("Insert into CRM_OWNER_USER.BB_BULK_SALE_BUS_TEMP_T(REGISTER_NUMBER, CITY_CODE, SERVICE_KIND, SERVICE_ID, USER_ID, "
			+ "BULK_PRICE, FAVOUR_GROUP, SALES_MODE, PERIOD_TYPE, EFFECT_VALUES, " + "BEGIN_DATE, END_DATE) "
			+ "Values (#{OS_TEMP_RGST}, #{CITY_CODE}, #{service_kind}, #{service_id}, #{USER_ID}, "
			+ "#{BULK_PRICE}, #{FAVOUR_GROUP}, #{SALES_MODE}, #{PERIOD_TYPE}, #{EFFECT_VALUES}, "
			+ "#{BEGIN_DATE}, #{END_DATE} )")
	public int saveBulkTemp(Map<String, Object> map);

	@Select("select bb_uni_get_info_detail_f(1,0,#{eparchy_code},#{service_id},'CBSS',2,'') serviceKind from dual")
	public Map getServiceKind(Map<String, Object> map);

	@Select("select * from bb_service_relation_t where service_kind = #{service_kind} and service_id=#{service_id} and city_code = #{eparchy_code} and if_valid=1 ")
	public Map getServiceInfo(Map<String, Object> map);

	@Select(" select * from ("
			+ "select "
			+ "max(CITY_CODE) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) CITY_CODE ,"
			+ "max(SERVICE_KIND) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) SERVICE_KIND,"
			+ "max(SERVICE_ID) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) SERVICE_ID,"
			+ "max(USER_ID) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) USER_ID,"
			+ "max(BULK_PRICE) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) BULK_PRICE,"
			+ "max(FAVOUR_GROUP) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) FAVOUR_GROUP,"
			+ "max(SALES_MODE) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) SALES_MODE ,"
			+ "max(PERIOD_TYPE) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) PERIOD_TYPE ,"
			+ "max(EFFECT_VALUES) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) EFFECT_VALUES,"
			+ "max(BEGIN_DATE) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) BEGIN_DATE,"
			+ "max(END_DATE) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) END_DATE ,"
			+ "max(BEG_RGST_NUM) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) BEG_RGST_NUM ,"
			+ "max(PRESERVE01) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) PRESERVE01 ,"
			+ "max(PRESERVE02) keep  (  DENSE_RANK  first order by END_DATE desc   )  over (partition by service_id ) PRESERVE02 "
			+ "from bb_bulk_sale_info_t t  where    service_id = #{service_id}  and service_kind =#{service_kind}   ) where  rownum <=1")
	public Map getBulkInfo(Map<String, Object> map);

	@Select("select * from bb_bus_control_t  where service_kind = #{service_kind} and service_id=#{service_id} and accept_city = #{eparchy_code} and rownum<=1")
	public Map getFlowInfo(Map<String, Object> map);
	
	
	@Select("select * from bb_accept_temp_t where f_service_id =  #{service_id} and f_service_kind =#{service_kind}  and rownum <=1")
	public Map getFlowInfo1(Map<String, Object> map);
	

	@Select("   select * from bb_wide_service_info_t where user_id= #{user_id}")
	public Map getWidefo(Map<String, Object> map);

	
	@Select("   select * from bb_adsl_service_info_t where user_id= #{user_id}")
	public Map getAdslfo(Map<String, Object> map);
	
	@Select(" select * from BB_BULK_SALE_BUS_TEMP_T where register_number =  #{register_number}")
	public Map getServiceKindByReg(Map<String, Object> map);
	
	
	@Select("  SELECT *   "
			+ "FROM BB_BULK_res_dealer_T  WHERE "
			+ "(city_code = #{CITY_CODE}  OR city_code = '075') "
			+ "AND service_kind = #{SERVICE_KIND}"
			+ "AND kind = #{SALES_MODE}")
	public List<Map> ifDiscut(Map<String, Object> map);
	

	public void submit(Map<String, Object> map);
	
	public void auto(Map<String, Object> map);
	
	
	@Select("select * from pm_product_T where  f_prod_id=  #{SERVICE_FAVOUR_ID}")
	public Map getProductInfo(Map<String, Object> map);
	
	@Insert("Insert into CRM_OWNER_USER.BB_UNI_ORDER_RELA_T(F_CITY_CODE, F_UNI_ORDERSID, F_UNI_SUB_ORDERSID, F_REGTMP, F_REGTMP_DATE, F_COMPLETE_STATUS, F_PRESERVE05, BATCH_FLAG) "
			+ " Values (#{CITY_CODE}, #{order_id}, #{order_id}, #{register_number}, sysdate,  0, 0, 0) ")
	public int saveOrderTemp(Map<String, Object> map);
	

}

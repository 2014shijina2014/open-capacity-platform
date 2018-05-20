 

CREATE DATABASE IF NOT EXISTS `oauth2-security` DEFAULT CHARACTER SET = utf8mb4;

Use `oauth2-security`;
 

set session  
sql_mode='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';  

 

CREATE TABLE `all_services` (
  `create_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `catalog` varchar(255) NOT NULL,
  `pathID` int(11) NOT NULL,
  `apiID` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pathID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "all_services"
#

INSERT INTO `all_services` VALUES ('2017-07-26 15:14:15',1,'公共校验-中至号码校验','/zznumbercheck',1,'bss',1,'bipxx1','公共校验-中至号码校验的描述，公共校验-中至号码校验公共校验-中至号码校验的描述，公共校验-中至号码校验'),('2017-07-26 15:16:04',1,'公共校验-黑名单与实名制校验','/blackandrealname',1,'bss',2,NULL,NULL),('2017-07-26 15:17:57',1,'网厅-23G缴费','/payfee',1,'bss',3,NULL,NULL),('2017-07-26 15:18:30',1,'全业务-流量订购','/doresources',1,'bss',4,NULL,NULL),('2017-08-16 15:03:44',1,'吉安大数据服务','/checkjian',1,'bss',5,NULL,NULL),('2017-09-04 17:58:33',1,'网厅-佣金审核','/commision',1,'bss',6,NULL,NULL),('2017-09-25 10:04:09',1,'路由查询接口','/routeinfo',1,'bss',7,NULL,NULL),('2017-09-25 10:04:51',1,'话费余额查询接口','/qryrealfeeinfo',1,'bss',8,NULL,NULL),('2017-09-25 10:05:47',1,'普通产品3G号码订购','/doo2oprod',1,'bss',9,NULL,NULL),('2017-09-25 10:06:37',1,'4G所有已订购产品查询','/ecaop.trades.query.comm.orderpro.qry',1,'bss',10,NULL,NULL),('2017-09-25 10:07:24',1,'流量产品4G号码订购','/ecaop.trades.sell.mob.comm.traffic.sub',1,'bss',11,NULL,NULL),('2017-09-25 10:13:50',1,'3G账单查询','/billqry',1,'bss',12,NULL,NULL),('2017-09-25 15:06:08',1,'免费资源查询','/qryFeePolicyAddup',1,'bss',13,NULL,NULL),('2017-09-29 15:07:13',1,'3G套餐余量与流量查询','/queryproductinfo',1,'bss',25,NULL,NULL),('2017-10-09 15:03:04',1,'4G缴费接口','/ecaop.trades.serv.payment.fee.sub',1,'bss',26,NULL,NULL),('2017-10-16 16:22:53',1,'liyuntest','/liyuntest',1,'bss',27,'',NULL),('2017-10-19 16:56:30',1,'年度账单接口','/yearbill',1,'bss',28,'',NULL),('2017-12-20 15:54:57',1,'一证五户-用户号码查询','/OneCardFiveUserSer_QryUserNumbe',1,'bss',29,'',NULL),('2017-12-20 16:09:59',1,'国政通校验_身份认证','/faceRecognition_identityCheck',1,'bss',30,'',NULL),('2017-12-27 23:54:04',1,'商品订购用户鉴权接口','/paygoodsauth',1,'bss',31,'',NULL),('2017-12-27 23:54:27',1,'商品订购订单状态查询接口','/paygoodsstatusquery',1,'bss',32,'',NULL),('2017-12-27 23:55:18',1,'商品订购接口','/paygoodsorder',1,'bss',33,'',NULL),('2017-12-28 00:28:57',1,'欠费/实时话费查询','/qryowefeeinfo',1,'bss',34,'',NULL),('2018-03-29 20:04:43',1,'中台-沃受理_订单生产回单','/bss.trades.sell.brd.produce.back',1,'bss',35,'',NULL),('2018-03-29 20:05:04',1,'中台-二维码生成查询接口','/contactcentre.QRCodeManage.createQRCodeByRequest',1,'bss',36,'',NULL),('2018-03-29 20:05:21',1,'沃受理-码上购移网信息同步接口','/mobieOrderInfoSync',1,'bss',37,'',NULL),('2018-03-29 20:05:38',1,'沃受理-码上购融合信息同步接口','/mixOrderInfoSync',1,'bss',38,'',NULL),('2018-03-29 20:05:55',1,'沃受理-预约单信息同步接口','/serviceReceiveOnlineOrde',1,'bss',39,'',NULL),('2018-03-29 20:06:11',1,'沃受理-预订单状态查询接口','/serviceOrderStatusQueryOrder',1,'bss',40,'',NULL),('2018-03-29 22:00:22',1,'AOP-CBSS号码资源查询-简单版','/ecaop.trades.query.comm.simpsnres.qry',1,'bss',41,'',NULL),('2018-03-29 22:00:39',1,'AOP-CBSS号码状态变更-简单版','/ecaop.trades.query.comm.simpsnres.chg',1,'bss',42,'',NULL),('2018-03-29 22:00:56',1,'AOP-CBSS开户处理申请接口','/ecaop.trades.sell.mob.newu.open.app',1,'bss',43,'',NULL),('2018-03-29 22:01:13',1,'AOP-CBSS开户处理提交接口','/ecaop.trades.sell.mob.newu.open.sub',1,'bss',44,'',NULL),('2018-03-29 22:01:31',1,'AOP-CBSS开户卡数据同步接口','/ecaop.trades.sell.mob.newu.opencarddate.syn',1,'bss',45,'',NULL),('2018-03-29 22:01:52',1,'AOP-CBSS写卡数据查询接口','/ecaop.trades.sell.mob.comm.carddate.qry',1,'bss',46,'',NULL),('2018-03-29 22:02:48',1,'AOP-CBSS写卡结果通知接口','/ecaop.trades.sell.mob.comm.cardres.notify',1,'bss',47,'',NULL),('2018-03-29 22:03:03',1,'AOP-CBSS订单信息同步接口','/ecaop.trades.syn.orderinfo.sub',1,'bss',48,'',NULL),('2018-03-29 22:03:20',1,'AOP-CBSS客户资料校验接口','/ecaop.trades.query.comm.cust.check',1,'bss',49,'',NULL),('2018-03-29 22:03:40',1,'AOP-CBSS终端状态查询变更-BSS用','/ecaop.trades.query.resi.term.bsschg',1,'bss',50,'',NULL),('2018-03-29 22:13:10',1,'固网装移修状态查询','/broadbandselfquery',1,'bss',51,'',NULL),('2018-03-29 22:44:57',1,'号码中心_选占','/numberCenter_selectedNum',1,'bss',52,'',NULL),('2018-03-29 22:46:14',1,'BSS客户资料校验接口','/T2000501',1,'bss',53,'',NULL);

#
# Structure for table "client_services"
#

CREATE TABLE `client_services` (
  `service_id` varchar(255) NOT NULL,
  `client_id` varchar(255) NOT NULL,
  `status` int(1) NOT NULL,
  `filter_id` varchar(20) DEFAULT NULL,
  `latch_num` varchar(18) DEFAULT NULL,
  `latch_type` varchar(2) DEFAULT NULL,
  `latch_time` datetime DEFAULT NULL,
  `latch_end` varchar(20) DEFAULT NULL,
  UNIQUE KEY `client_services_i` (`service_id`,`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "client_services"
#

INSERT INTO `client_services` VALUES ('1','9hyb3mnDQUd3dSmRhuf5',1,NULL,NULL,NULL,NULL,NULL),('1','DTt2xqJMby31XPAYchrt',1,NULL,NULL,NULL,NULL,NULL),('1','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('1','KsUKSx1W1OrDD5prtJd2',1,'','',NULL,NULL,NULL),('1','LXcTfXL2cGZTDQ8ejdtt',1,NULL,NULL,NULL,NULL,NULL),('1','UgtMR61nA2mW7WuFJX57',1,'','',NULL,NULL,''),('1','YfDJIu0k1K3DuDTSuGhb',1,'','',NULL,NULL,NULL),('1','ynrAR6HDs2GiLJJAmSe1',1,NULL,NULL,NULL,NULL,NULL),('1','yvqJ1Ji5WrtLJlNCPrkC',1,'','',NULL,NULL,NULL),('10','7NctTv3kOeb8V5PXapag',2,NULL,NULL,NULL,NULL,NULL),('10','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('10','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('10','hxllfenfa',1,NULL,NULL,NULL,NULL,NULL),('10','xWOpbjKtQDcop7enpBwU',1,NULL,NULL,NULL,NULL,NULL),('11','7NctTv3kOeb8V5PXapag',1,NULL,NULL,NULL,NULL,NULL),('11','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('11','hxllfenfa',1,NULL,NULL,NULL,NULL,NULL),('11','xWOpbjKtQDcop7enpBwU',1,NULL,NULL,NULL,NULL,NULL),('12','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('2','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('2','KsUKSx1W1OrDD5prtJd2',1,'','',NULL,NULL,NULL),('2','LXcTfXL2cGZTDQ8ejdtt',1,NULL,NULL,NULL,NULL,NULL),('2','UgtMR61nA2mW7WuFJX57',1,'','',NULL,NULL,NULL),('2','YfDJIu0k1K3DuDTSuGhb',1,'','',NULL,NULL,NULL),('2','yvqJ1Ji5WrtLJlNCPrkC',1,'','',NULL,NULL,NULL),('25','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('26','YfDJIu0k1K3DuDTSuGhb',1,'','',NULL,NULL,NULL),('29','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('29','LSsMdMUIjQ8Gwqy8fXwS',1,NULL,NULL,NULL,NULL,NULL),('3','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('3','UgtMR61nA2mW7WuFJX57',1,'','',NULL,NULL,NULL),('3','YfDJIu0k1K3DuDTSuGhb',1,'','',NULL,NULL,NULL),('30','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('30','LSsMdMUIjQ8Gwqy8fXwS',1,NULL,NULL,NULL,NULL,NULL),('31','Irb7fPzXSJKJRUBp1o9m',1,NULL,NULL,NULL,NULL,NULL),('32','Irb7fPzXSJKJRUBp1o9m',1,NULL,NULL,NULL,NULL,NULL),('33','Irb7fPzXSJKJRUBp1o9m',1,NULL,NULL,NULL,NULL,NULL),('34','7NctTv3kOeb8V5PXapag',1,NULL,NULL,NULL,NULL,NULL),('34','xWOpbjKtQDcop7enpBwU',1,NULL,NULL,NULL,NULL,NULL),('35','LSsMdMUIjQ8Gwqy8fXwS',1,NULL,NULL,NULL,NULL,NULL),('36','LSsMdMUIjQ8Gwqy8fXwS',1,NULL,NULL,NULL,NULL,NULL),('37','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('38','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('39','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('4','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('4','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('4','UgtMR61nA2mW7WuFJX57',1,'1','1','6','2017-10-13 11:09:20','100'),('4','YfDJIu0k1K3DuDTSuGhb',1,'','',NULL,NULL,NULL),('40','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('41','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('42','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('43','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('44','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('45','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('46','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('47','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('48','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('49','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('5','3PVKhw072sLvwxlsHqUi',1,'','',NULL,NULL,NULL),('5','dMJuf873pL91xHME5BH0',1,'','',NULL,NULL,NULL),('5','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('5','HwChS6qfl7IsJen3hvsK',2,'','',NULL,NULL,NULL),('5','pt9sD1xsiq9WO0mdptAh',1,'','',NULL,NULL,NULL),('5','q12XZwmdmLB4xRz31PJp',1,'','',NULL,NULL,NULL),('5','w0rYW674932e9HUvs3MN',1,'','',NULL,NULL,NULL),('5','xwQLurzJcOlA6CdZWOQz',1,'','',NULL,NULL,NULL),('5','YI9dJdJLxlHg7H15u16u',1,'','',NULL,NULL,NULL),('50','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('51','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('52','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('53','jxbss_zt',1,NULL,NULL,NULL,NULL,NULL),('6','2Tl9bfPmGVS8d7YSn3Xd',2,'','',NULL,NULL,NULL),('6','EroXhe2qMnijGxhFlh75',1,'','',NULL,NULL,NULL),('6','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('6','LSsMdMUIjQ8Gwqy8fXwS',1,'','',NULL,NULL,NULL),('7','7NctTv3kOeb8V5PXapag',1,NULL,NULL,NULL,NULL,NULL),('7','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('7','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('7','GzIBYtFz2wWQ36dI1OMB',1,'','',NULL,NULL,NULL),('7','hxllfenfa',1,NULL,NULL,NULL,NULL,NULL),('7','UgtMR61nA2mW7WuFJX57',1,'','',NULL,NULL,NULL),('7','xWOpbjKtQDcop7enpBwU',1,NULL,NULL,NULL,NULL,NULL),('7','YfDJIu0k1K3DuDTSuGhb',1,'','',NULL,NULL,NULL),('8','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('8','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL),('9','bLL6XuZA3g8mDspHvzFr',1,'','',NULL,NULL,NULL),('9','gmR1gMebojozhUsq1mRK',1,NULL,NULL,NULL,NULL,NULL);

#
# Structure for table "gateway_api_define"
#

CREATE TABLE `gateway_api_define` (
  `id` varchar(50) NOT NULL,
  `path` varchar(255) NOT NULL,
  `service_id` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `retryable` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `strip_prefix` int(11) DEFAULT NULL,
  `api_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "gateway_api_define"
#

INSERT INTO `gateway_api_define` VALUES ('authentication-center','/auth/**','open-auth-server',NULL,0,1,1,NULL),('test163','/test163/**',NULL,'http://www.163.com',0,1,1,NULL),('test164','/test164/**',NULL,'http://www.baidu.com',0,1,1,NULL),('web','/web',NULL,'http://127.0.0.1:9999',0,1,0,NULL);

#
# Structure for table "oauth_access_token"
#

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "oauth_access_token"
#


#
# Structure for table "oauth_approvals"
#


CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "oauth_approvals"
#



#
# Structure for table "oauth_client_details"
#

CREATE TABLE `oauth_client_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "oauth_client_details"
#



INSERT INTO `oauth_client_details` (`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`,`lastModifiedAt`) VALUES ('app','','app','app','password,refresh_token',NULL,NULL,NULL,NULL,NULL,NULL,'0000-00-00 00:00:00'),('hello','','hello','app','password,refresh_token',NULL,NULL,NULL,NULL,NULL,NULL,'0000-00-00 00:00:00'),('mobile','','mobile','all','password,refresh_token',NULL,NULL,NULL,NULL,NULL,NULL,'0000-00-00 00:00:00'),('owen',NULL,'owen','app','authorization_code,password,refresh_token,client_credentials','http://127.0.0.1:9997/clientOne/login',NULL,NULL,NULL,NULL,NULL,'0000-00-00 00:00:00'),('test','','test','test','password,refresh_token',NULL,NULL,NULL,NULL,NULL,NULL,'0000-00-00 00:00:00'),('webApp','','webApp','app','authorization_code,password,refresh_token,client_credentials','http://www.baidu.com',NULL,NULL,NULL,NULL,NULL,'0000-00-00 00:00:00');


#
# Structure for table "oauth_client_token"
#

CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "oauth_client_token"
#


#
# Structure for table "oauth_code"
#

CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "oauth_code"
#


#
# Structure for table "oauth_refresh_token"
#

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "oauth_refresh_token"
#


 

# Create Database
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS ApolloConfigDB DEFAULT CHARACTER SET = utf8mb4;

Use ApolloConfigDB;

# Host: 47.94.252.160  (Version 5.7.22)
# Date: 2018-06-26 20:02:25
# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "app"
#

DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Name` varchar(500) NOT NULL DEFAULT 'default' COMMENT '应用名',
  `OrgId` varchar(32) NOT NULL DEFAULT 'default' COMMENT '部门Id',
  `OrgName` varchar(64) NOT NULL DEFAULT 'default' COMMENT '部门名字',
  `OwnerName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerName',
  `OwnerEmail` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerEmail',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Name` (`Name`(191))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='应用表';

#
# Data for table "app"
#

INSERT INTO `app` VALUES (1,'SampleApp','Sample App','TEST1','样例部门1','apollo','apollo@acme.com',b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(2,'zuulservice','zuulservice-dev','TEST1','样例部门1','apollo','apollo@acme.com',b'0','apollo','2018-04-04 00:09:41','apollo','2018-04-04 00:09:41');

#
# Structure for table "appnamespace"
#

DROP TABLE IF EXISTS `appnamespace`;
CREATE TABLE `appnamespace` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Name` varchar(32) NOT NULL DEFAULT '' COMMENT 'namespace名字，注意，需要全局唯一',
  `AppId` varchar(32) NOT NULL DEFAULT '' COMMENT 'app id',
  `Format` varchar(32) NOT NULL DEFAULT 'properties' COMMENT 'namespace的format类型',
  `IsPublic` bit(1) NOT NULL DEFAULT b'0' COMMENT 'namespace是否为公共',
  `Comment` varchar(64) NOT NULL DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_AppId` (`AppId`),
  KEY `Name_AppId` (`Name`,`AppId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='应用namespace定义';

#
# Data for table "appnamespace"
#

INSERT INTO `appnamespace` VALUES (1,'application','SampleApp','properties',b'0','default app namespace',b'0','','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(2,'application','zuulservice','properties',b'0','default app namespace',b'0','apollo','2018-04-04 00:09:43','apollo','2018-04-04 00:09:43');

#
# Structure for table "audit"
#

DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `EntityName` varchar(50) NOT NULL DEFAULT 'default' COMMENT '表名',
  `EntityId` int(10) unsigned DEFAULT NULL COMMENT '记录ID',
  `OpName` varchar(50) NOT NULL DEFAULT 'default' COMMENT '操作类型',
  `Comment` varchar(500) DEFAULT NULL COMMENT '备注',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COMMENT='日志审计表';

#
# Data for table "audit"
#

INSERT INTO `audit` VALUES (1,'App',2,'INSERT',NULL,b'0','apollo','2018-04-04 00:09:43',NULL,'2018-04-04 00:09:43'),(2,'AppNamespace',2,'INSERT',NULL,b'0','apollo','2018-04-04 00:09:43',NULL,'2018-04-04 00:09:43'),(3,'Cluster',2,'INSERT',NULL,b'0','apollo','2018-04-04 00:09:43',NULL,'2018-04-04 00:09:43'),(4,'Namespace',2,'INSERT',NULL,b'0','apollo','2018-04-04 00:09:43',NULL,'2018-04-04 00:09:43'),(5,'Item',2,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(6,'Item',3,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(7,'Item',4,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(8,'Item',5,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(9,'Item',6,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(10,'Item',7,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(11,'Item',8,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(12,'Item',9,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(13,'Item',10,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(14,'Item',11,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(15,'Item',12,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(16,'Item',13,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(17,'Item',14,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(18,'Item',15,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(19,'Item',16,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(20,'Item',17,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(21,'Item',18,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(22,'Item',19,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(23,'Item',20,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(24,'Item',21,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(25,'Item',22,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(26,'Item',23,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(27,'Item',24,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(28,'Item',25,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(29,'Item',26,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(30,'Item',27,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(31,'ItemSet',NULL,'INSERT',NULL,b'0','apollo','2018-04-04 00:11:27',NULL,'2018-04-04 00:11:27'),(32,'Item',8,'UPDATE',NULL,b'0','apollo','2018-04-04 00:12:13',NULL,'2018-04-04 00:12:13'),(33,'Item',16,'UPDATE',NULL,b'0','apollo','2018-04-04 00:12:13',NULL,'2018-04-04 00:12:13'),(34,'Item',20,'UPDATE',NULL,b'0','apollo','2018-04-04 00:12:13',NULL,'2018-04-04 00:12:13'),(35,'Item',21,'UPDATE',NULL,b'0','apollo','2018-04-04 00:12:13',NULL,'2018-04-04 00:12:13'),(36,'Item',26,'UPDATE',NULL,b'0','apollo','2018-04-04 00:12:13',NULL,'2018-04-04 00:12:13'),(37,'ItemSet',NULL,'UPDATE',NULL,b'0','apollo','2018-04-04 00:12:13',NULL,'2018-04-04 00:12:13'),(38,'Release',2,'INSERT',NULL,b'0','apollo','2018-04-04 00:12:29',NULL,'2018-04-04 00:12:29'),(39,'ReleaseHistory',2,'INSERT',NULL,b'0','apollo','2018-04-04 00:12:29',NULL,'2018-04-04 00:12:29'),(40,'Item',21,'UPDATE',NULL,b'0','apollo','2018-04-04 00:22:18',NULL,'2018-04-04 00:22:18'),(41,'ItemSet',NULL,'UPDATE',NULL,b'0','apollo','2018-04-04 00:22:19',NULL,'2018-04-04 00:22:19'),(42,'Release',3,'INSERT',NULL,b'0','apollo','2018-04-04 00:22:21',NULL,'2018-04-04 00:22:21'),(43,'ReleaseHistory',3,'INSERT',NULL,b'0','apollo','2018-04-04 00:22:21',NULL,'2018-04-04 00:22:21'),(44,'Item',28,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(45,'Item',29,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(46,'Item',30,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(47,'Item',31,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(48,'Item',32,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(49,'Item',33,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(50,'Item',34,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(51,'Item',35,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(52,'Item',36,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(53,'ItemSet',NULL,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(54,'Item',13,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(55,'Item',18,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(56,'Item',11,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(57,'Item',12,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(58,'Item',19,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(59,'Item',23,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:46',NULL,'2018-04-04 00:55:46'),(60,'Item',24,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(61,'Item',14,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(62,'Item',15,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(63,'Item',17,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(64,'Item',7,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(65,'Item',9,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(66,'Item',10,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(67,'Item',20,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(68,'Item',22,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(69,'Item',25,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(70,'Item',21,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(71,'ItemSet',NULL,'UPDATE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(72,'Item',8,'DELETE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(73,'Item',27,'DELETE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(74,'Item',5,'DELETE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(75,'Item',16,'DELETE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(76,'Item',2,'DELETE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(77,'Item',26,'DELETE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(78,'ItemSet',NULL,'DELETE',NULL,b'0','apollo','2018-04-04 00:55:47',NULL,'2018-04-04 00:55:47'),(79,'Release',4,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:50',NULL,'2018-04-04 00:55:50'),(80,'ReleaseHistory',4,'INSERT',NULL,b'0','apollo','2018-04-04 00:55:50',NULL,'2018-04-04 00:55:50'),(81,'Item',21,'UPDATE',NULL,b'0','apollo','2018-04-03 19:25:16',NULL,'2018-04-03 19:25:16'),(82,'Release',5,'INSERT',NULL,b'0','apollo','2018-04-03 19:25:22',NULL,'2018-04-03 19:25:22'),(83,'ReleaseHistory',5,'INSERT',NULL,b'0','apollo','2018-04-03 19:25:22',NULL,'2018-04-03 19:25:22'),(84,'Item',21,'UPDATE',NULL,b'0','apollo','2018-04-04 17:53:27',NULL,'2018-04-04 17:53:27'),(85,'Release',6,'INSERT',NULL,b'0','apollo','2018-04-04 17:53:31',NULL,'2018-04-04 17:53:31'),(86,'ReleaseHistory',6,'INSERT',NULL,b'0','apollo','2018-04-04 17:53:31',NULL,'2018-04-04 17:53:31'),(87,'Item',37,'INSERT',NULL,b'0','apollo','2018-04-04 17:56:31',NULL,'2018-04-04 17:56:31'),(88,'ItemSet',NULL,'INSERT',NULL,b'0','apollo','2018-04-04 17:56:31',NULL,'2018-04-04 17:56:31'),(89,'Item',21,'UPDATE',NULL,b'0','apollo','2018-04-04 17:56:31',NULL,'2018-04-04 17:56:31'),(90,'ItemSet',NULL,'UPDATE',NULL,b'0','apollo','2018-04-04 17:56:31',NULL,'2018-04-04 17:56:31'),(91,'Release',7,'INSERT',NULL,b'0','apollo','2018-04-04 17:56:35',NULL,'2018-04-04 17:56:35'),(92,'ReleaseHistory',7,'INSERT',NULL,b'0','apollo','2018-04-04 17:56:35',NULL,'2018-04-04 17:56:35'),(93,'Item',37,'DELETE',NULL,b'0','apollo','2018-04-04 19:38:49',NULL,'2018-04-04 19:38:49'),(94,'Release',8,'INSERT',NULL,b'0','apollo','2018-04-04 19:39:15',NULL,'2018-04-04 19:39:15'),(95,'ReleaseHistory',8,'INSERT',NULL,b'0','apollo','2018-04-04 19:39:15',NULL,'2018-04-04 19:39:15'),(96,'Item',38,'INSERT',NULL,b'0','apollo','2018-04-04 19:41:46',NULL,'2018-04-04 19:41:46'),(97,'ItemSet',NULL,'INSERT',NULL,b'0','apollo','2018-04-04 19:41:46',NULL,'2018-04-04 19:41:46'),(98,'Release',9,'INSERT',NULL,b'0','apollo','2018-04-04 19:41:50',NULL,'2018-04-04 19:41:50'),(99,'ReleaseHistory',9,'INSERT',NULL,b'0','apollo','2018-04-04 19:41:50',NULL,'2018-04-04 19:41:50'),(100,'Item',24,'UPDATE',NULL,b'0','apollo','2018-06-26 19:59:13',NULL,'2018-06-26 19:59:13'),(101,'ItemSet',NULL,'UPDATE',NULL,b'0','apollo','2018-06-26 19:59:14',NULL,'2018-06-26 19:59:14'),(102,'Release',10,'INSERT',NULL,b'0','apollo','2018-06-26 19:59:20',NULL,'2018-06-26 19:59:20'),(103,'ReleaseHistory',10,'INSERT',NULL,b'0','apollo','2018-06-26 19:59:20',NULL,'2018-06-26 19:59:20'),(104,'Item',21,'UPDATE',NULL,b'0','apollo','2018-06-26 20:00:37',NULL,'2018-06-26 20:00:37'),(105,'Release',11,'INSERT',NULL,b'0','apollo','2018-06-26 20:00:42',NULL,'2018-06-26 20:00:42'),(106,'ReleaseHistory',11,'INSERT',NULL,b'0','apollo','2018-06-26 20:00:42',NULL,'2018-06-26 20:00:42');

#
# Structure for table "cluster"
#

DROP TABLE IF EXISTS `cluster`;
CREATE TABLE `cluster` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Name` varchar(32) NOT NULL DEFAULT '' COMMENT '集群名字',
  `AppId` varchar(32) NOT NULL DEFAULT '' COMMENT 'App id',
  `ParentClusterId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父cluster',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_AppId_Name` (`AppId`,`Name`),
  KEY `IX_ParentClusterId` (`ParentClusterId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='集群';

#
# Data for table "cluster"
#

INSERT INTO `cluster` VALUES (1,'default','SampleApp',0,b'0','','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(2,'default','zuulservice',0,b'0','apollo','2018-04-04 00:09:43','apollo','2018-04-04 00:09:43');

#
# Structure for table "commit"
#

DROP TABLE IF EXISTS `commit`;
CREATE TABLE `commit` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ChangeSets` longtext NOT NULL COMMENT '修改变更集',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `NamespaceName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'namespaceName',
  `Comment` varchar(500) DEFAULT NULL COMMENT '备注',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `AppId` (`AppId`(191)),
  KEY `ClusterName` (`ClusterName`(191)),
  KEY `NamespaceName` (`NamespaceName`(191))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='commit 历史表';

#
# Data for table "commit"
#

INSERT INTO `commit` VALUES (1,'{\"createItems\":[{\"namespaceId\":2,\"key\":\"zuul.routes.test165.path\",\"value\":\"/test165/**\",\"comment\":\"\",\"lineNum\":1,\"id\":2,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"ribbon.ConnectTimeout\",\"value\":\"10000\",\"comment\":\"\",\"lineNum\":2,\"id\":3,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"ribbon.OkToRetryOnAllOperations\",\"value\":\"true\",\"comment\":\"\",\"lineNum\":3,\"id\":4,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test166.path\",\"value\":\"/test166/**\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"ribbon.MaxAutoRetriesNextServer\",\"value\":\"2\",\"comment\":\"\",\"lineNum\":5,\"id\":6,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.host.connect-timeout-millis\",\"value\":\"10000\",\"comment\":\"\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test164.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":7,\"id\":8,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.host.maxTotalConnections\",\"value\":\"1024\",\"comment\":\"\",\"lineNum\":8,\"id\":9,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.host.maxPerRouteConnections\",\"value\":\"512\",\"comment\":\"\",\"lineNum\":9,\"id\":10,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"management.security.enabled\",\"value\":\"false\",\"comment\":\"\",\"lineNum\":10,\"id\":11,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"spring.application.name\",\"value\":\"sop-api-gateway\",\"comment\":\"\",\"lineNum\":11,\"id\":12,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"ribbon.MaxAutoRetries\",\"value\":\"1\",\"comment\":\"\",\"lineNum\":12,\"id\":13,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.semaphore.max-semaphores\",\"value\":\"1024\",\"comment\":\"\",\"lineNum\":13,\"id\":14,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.host.socket-timeout-millis\",\"value\":\"10000\",\"comment\":\"\",\"lineNum\":14,\"id\":15,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test166.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":15,\"id\":16,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:26\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.ignored-services\",\"value\":\"\\\"*\\\"\",\"comment\":\"\",\"lineNum\":16,\"id\":17,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"ribbon.ReadTimeout\",\"value\":\"10000\",\"comment\":\"\",\"lineNum\":17,\"id\":18,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\",\"value\":\"10000\",\"comment\":\"\",\"lineNum\":18,\"id\":19,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test163.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":19,\"id\":20,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http\\\\://130.75.131.236\\\\:1111/eureka/\",\"comment\":\"\",\"lineNum\":20,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test163.path\",\"value\":\"/test163/**\",\"comment\":\"\",\"lineNum\":21,\"id\":22,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"hystrix.command.default.execution.timeout.enabled\",\"value\":\"true\",\"comment\":\"\",\"lineNum\":22,\"id\":23,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"server.port\",\"value\":\"9000\",\"comment\":\"\",\"lineNum\":23,\"id\":24,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"eureka.instance.prefer-ip-address\",\"value\":\"true\",\"comment\":\"\",\"lineNum\":24,\"id\":25,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test165.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":25,\"id\":26,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test164.path\",\"value\":\"/test164/**\",\"comment\":\"\",\"lineNum\":26,\"id\":27,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"}],\"updateItems\":[],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:11:27'),(2,'{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test164.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":7,\"id\":8,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},\"newItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test164.url\",\"value\":\"http://www.163.com\",\"comment\":\"\",\"lineNum\":7,\"id\":8,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:12:13\"}},{\"oldItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test166.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":15,\"id\":16,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},\"newItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test166.url\",\"value\":\"http://www.163.com\",\"comment\":\"\",\"lineNum\":15,\"id\":16,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:12:13\"}},{\"oldItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test163.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":19,\"id\":20,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},\"newItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test163.url\",\"value\":\"http://www.163.com\",\"comment\":\"\",\"lineNum\":19,\"id\":20,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:12:13\"}},{\"oldItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http\\\\://130.75.131.236\\\\:1111/eureka/\",\"comment\":\"\",\"lineNum\":20,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},\"newItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236\\\\:1111/eureka/\",\"comment\":\"\",\"lineNum\":20,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:12:13\"}},{\"oldItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test165.url\",\"value\":\"http\\\\://www.163.com\",\"comment\":\"\",\"lineNum\":25,\"id\":26,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:11:27\"},\"newItem\":{\"namespaceId\":2,\"key\":\"zuul.routes.test165.url\",\"value\":\"http://www.163.com\",\"comment\":\"\",\"lineNum\":25,\"id\":26,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:12:13\"}}],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 00:12:13','apollo','2018-04-04 00:12:13'),(3,'{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236\\\\:1111/eureka/\",\"comment\":\"\",\"lineNum\":20,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:12:13\"},\"newItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236:1111/eureka/\",\"comment\":\"\",\"lineNum\":20,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:22:18\"}}],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 00:22:19','apollo','2018-04-04 00:22:19'),(4,'{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236:1111/eureka/\",\"comment\":\"\",\"lineNum\":20,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:22:19\"},\"newItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236:1111/eureka\",\"comment\":\"\",\"lineNum\":29,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:46\"}}],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"zuul.routes.test164.url\",\"value\":\"http://www.163.com\",\"comment\":\"\",\"lineNum\":7,\"id\":8,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:46\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test164.path\",\"value\":\"/test164/**\",\"comment\":\"\",\"lineNum\":26,\"id\":27,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:46\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test166.path\",\"value\":\"/test166/**\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:46\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test166.url\",\"value\":\"http://www.163.com\",\"comment\":\"\",\"lineNum\":15,\"id\":16,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:46\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test165.path\",\"value\":\"/test165/**\",\"comment\":\"\",\"lineNum\":1,\"id\":2,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:46\"},{\"namespaceId\":2,\"key\":\"zuul.routes.test165.url\",\"value\":\"http://www.163.com\",\"comment\":\"\",\"lineNum\":25,\"id\":26,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:46\"}]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 00:55:47','apollo','2018-04-04 00:55:47'),(5,'{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236:1111/eureka\",\"comment\":\"\",\"lineNum\":29,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:47\"},\"newItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://192.168.3.151:1111/eureka\",\"comment\":\"\",\"lineNum\":29,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-03 19:25:16\"}}],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-03 19:25:16','apollo','2018-04-03 19:25:16'),(6,'{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://192.168.3.151:1111/eureka\",\"comment\":\"\",\"lineNum\":29,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-03 19:25:16\"},\"newItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236:1111/eureka\",\"comment\":\"\",\"lineNum\":29,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 17:53:26\"}}],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 17:53:27','apollo','2018-04-04 17:53:27'),(7,'{\"createItems\":[{\"namespaceId\":2,\"key\":\"eureka.client.register-with-eureka\",\"value\":\"false\",\"comment\":\"\",\"lineNum\":29,\"id\":37,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 17:56:31\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 17:56:31\"}],\"updateItems\":[],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 17:56:31','apollo','2018-04-04 17:56:31'),(8,'{\"createItems\":[],\"updateItems\":[],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"eureka.client.register-with-eureka\",\"value\":\"false\",\"comment\":\"\",\"lineNum\":29,\"id\":37,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 17:56:31\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 19:38:49\"}]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 19:38:49','apollo','2018-04-04 19:38:49'),(9,'{\"createItems\":[{\"namespaceId\":2,\"key\":\"eureka.instance.instance-id\",\"value\":\"${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}}\",\"comment\":\"\",\"lineNum\":29,\"id\":38,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 19:41:46\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 19:41:46\"}],\"updateItems\":[],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-04-04 19:41:46','apollo','2018-04-04 19:41:46'),(10,'{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"server.port\",\"value\":\"9999\",\"comment\":\"\",\"lineNum\":15,\"id\":24,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 00:55:47\"},\"newItem\":{\"namespaceId\":2,\"key\":\"server.port\",\"value\":\"9000\",\"comment\":\"\",\"lineNum\":15,\"id\":24,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-06-26 19:59:13\"}}],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-06-26 19:59:14','apollo','2018-06-26 19:59:14'),(11,'{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://130.75.131.236:1111/eureka\",\"comment\":\"\",\"lineNum\":30,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-04-04 17:56:31\"},\"newItem\":{\"namespaceId\":2,\"key\":\"eureka.client.serviceUrl.defaultZone\",\"value\":\"http://127.0.0.1:1111/eureka\",\"comment\":\"\",\"lineNum\":30,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-04-04 00:11:27\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-06-26 20:00:37\"}}],\"deleteItems\":[]}','zuulservice','default','application',NULL,b'0','apollo','2018-06-26 20:00:37','apollo','2018-06-26 20:00:37');

#
# Structure for table "grayreleaserule"
#

DROP TABLE IF EXISTS `grayreleaserule`;
CREATE TABLE `grayreleaserule` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Cluster Name',
  `NamespaceName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Namespace Name',
  `BranchName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'branch name',
  `Rules` varchar(16000) DEFAULT '[]' COMMENT '灰度规则',
  `ReleaseId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '灰度对应的release',
  `BranchStatus` tinyint(2) DEFAULT '1' COMMENT '灰度分支状态: 0:删除分支,1:正在使用的规则 2：全量发布',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Namespace` (`AppId`,`ClusterName`,`NamespaceName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='灰度规则表';

#
# Data for table "grayreleaserule"
#


#
# Structure for table "instance"
#

DROP TABLE IF EXISTS `instance`;
CREATE TABLE `instance` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `AppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `DataCenter` varchar(64) NOT NULL DEFAULT 'default' COMMENT 'Data Center Name',
  `Ip` varchar(32) NOT NULL DEFAULT '' COMMENT 'instance ip',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_UNIQUE_KEY` (`AppId`,`ClusterName`,`Ip`,`DataCenter`),
  KEY `IX_IP` (`Ip`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='使用配置的应用实例';

#
# Data for table "instance"
#

INSERT INTO `instance` VALUES (1,'zuulservice','default','','192.168.249.1','2018-04-04 00:21:12','2018-04-04 00:21:12'),(2,'zuulservice','default','','192.168.3.151','2018-04-03 19:28:09','2018-04-03 19:28:09'),(3,'zuulservice','default','','130.75.131.236','2018-04-04 19:34:26','2018-04-04 19:34:26');

#
# Structure for table "instanceconfig"
#

DROP TABLE IF EXISTS `instanceconfig`;
CREATE TABLE `instanceconfig` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `InstanceId` int(11) unsigned DEFAULT NULL COMMENT 'Instance Id',
  `ConfigAppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Config App Id',
  `ConfigClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Config Cluster Name',
  `ConfigNamespaceName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Config Namespace Name',
  `ReleaseKey` varchar(64) NOT NULL DEFAULT '' COMMENT '发布的Key',
  `ReleaseDeliveryTime` timestamp NULL DEFAULT NULL COMMENT '配置获取时间',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_UNIQUE_KEY` (`InstanceId`,`ConfigAppId`,`ConfigNamespaceName`),
  KEY `IX_ReleaseKey` (`ReleaseKey`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Valid_Namespace` (`ConfigAppId`,`ConfigClusterName`,`ConfigNamespaceName`,`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='应用实例的配置信息';

#
# Data for table "instanceconfig"
#

INSERT INTO `instanceconfig` VALUES (1,1,'zuulservice','default','application','20180626200041-7231d6ad3e03c09a','2018-06-26 20:00:42','2018-04-04 00:21:11','2018-06-26 20:00:43'),(2,2,'zuulservice','default','application','20180403192522-723164972d4b5883','2018-04-03 19:28:08','2018-04-03 19:28:08','2018-04-03 19:28:08'),(3,3,'zuulservice','default','application','20180404194149-723164972d357e8a','2018-04-04 19:41:50','2018-04-04 19:34:26','2018-04-04 19:41:51');

#
# Structure for table "item"
#

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `NamespaceId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '集群NamespaceId',
  `Key` varchar(128) NOT NULL DEFAULT 'default' COMMENT '配置项Key',
  `Value` longtext NOT NULL COMMENT '配置项值',
  `Comment` varchar(1024) DEFAULT '' COMMENT '注释',
  `LineNum` int(10) unsigned DEFAULT '0' COMMENT '行号',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_GroupId` (`NamespaceId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COMMENT='配置项目';

#
# Data for table "item"
#

INSERT INTO `item` VALUES (1,1,'timeout','100','sample timeout配置',1,b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(2,2,'zuul.routes.test165.path','/test165/**','',1,b'1','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(3,2,'ribbon.ConnectTimeout','10000','',2,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:11:27'),(4,2,'ribbon.OkToRetryOnAllOperations','true','',3,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:11:27'),(5,2,'zuul.routes.test166.path','/test166/**','',4,b'1','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(6,2,'ribbon.MaxAutoRetriesNextServer','2','',5,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:11:27'),(7,2,'zuul.host.connect-timeout-millis','10000','',22,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(8,2,'zuul.routes.test164.url','http://www.163.com','',7,b'1','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(9,2,'zuul.host.maxTotalConnections','1024','',23,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(10,2,'zuul.host.maxPerRouteConnections','512','',24,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(11,2,'management.security.enabled','false','',6,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(12,2,'spring.application.name','sop-api-gateway','',8,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(13,2,'ribbon.MaxAutoRetries','1','',1,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(14,2,'zuul.semaphore.max-semaphores','1024','',19,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(15,2,'zuul.host.socket-timeout-millis','10000','',20,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(16,2,'zuul.routes.test166.url','http://www.163.com','',15,b'1','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(17,2,'zuul.ignored-services','\"*\"','',21,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(18,2,'ribbon.ReadTimeout','10000','',4,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(19,2,'hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds','10000','',10,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(20,2,'zuul.routes.test163.url','http://www.163.com','',25,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(21,2,'eureka.client.serviceUrl.defaultZone','http://127.0.0.1:1111/eureka','',30,b'0','apollo','2018-04-04 00:11:27','apollo','2018-06-26 20:00:37'),(22,2,'zuul.routes.test163.path','/test163/**','',26,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(23,2,'hystrix.command.default.execution.timeout.enabled','true','',11,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(24,2,'server.port','9000','',15,b'0','apollo','2018-04-04 00:11:27','apollo','2018-06-26 19:59:14'),(25,2,'eureka.instance.prefer-ip-address','true','',28,b'0','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(26,2,'zuul.routes.test165.url','http://www.163.com','',25,b'1','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(27,2,'zuul.routes.test164.path','/test164/**','',26,b'1','apollo','2018-04-04 00:11:27','apollo','2018-04-04 00:55:47'),(28,2,'','','',7,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(29,2,'','','',9,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(30,2,'','','',12,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(31,2,'','','',13,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(32,2,'','','',14,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(33,2,'','','',16,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(34,2,'','','',17,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(35,2,'','','',18,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(36,2,'','','',27,b'0','apollo','2018-04-04 00:55:46','apollo','2018-04-04 00:55:46'),(37,2,'eureka.client.register-with-eureka','false','',29,b'1','apollo','2018-04-04 17:56:31','apollo','2018-04-04 19:38:49'),(38,2,'eureka.instance.instance-id','${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}}','',29,b'0','apollo','2018-04-04 19:41:46','apollo','2018-04-04 19:41:46');

#
# Structure for table "namespace"
#

DROP TABLE IF EXISTS `namespace`;
CREATE TABLE `namespace` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'Cluster Name',
  `NamespaceName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'Namespace Name',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId_ClusterName_NamespaceName` (`AppId`(191),`ClusterName`(191),`NamespaceName`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_NamespaceName` (`NamespaceName`(191))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='命名空间';

#
# Data for table "namespace"
#

INSERT INTO `namespace` VALUES (1,'SampleApp','default','application',b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(2,'zuulservice','default','application',b'0','apollo','2018-04-04 00:09:43','apollo','2018-04-04 00:09:43');

#
# Structure for table "namespacelock"
#

DROP TABLE IF EXISTS `namespacelock`;
CREATE TABLE `namespacelock` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `NamespaceId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '集群NamespaceId',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT 'default' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `IsDeleted` bit(1) DEFAULT b'0' COMMENT '软删除',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_NamespaceId` (`NamespaceId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='namespace的编辑锁';

#
# Data for table "namespacelock"
#


#
# Structure for table "release"
#

DROP TABLE IF EXISTS `release`;
CREATE TABLE `release` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `ReleaseKey` varchar(64) NOT NULL DEFAULT '' COMMENT '发布的Key',
  `Name` varchar(64) NOT NULL DEFAULT 'default' COMMENT '发布名字',
  `Comment` varchar(256) DEFAULT NULL COMMENT '发布说明',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `NamespaceName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'namespaceName',
  `Configurations` longtext NOT NULL COMMENT '发布配置',
  `IsAbandoned` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否废弃',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId_ClusterName_GroupName` (`AppId`(191),`ClusterName`(191),`NamespaceName`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_ReleaseKey` (`ReleaseKey`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='发布';

#
# Data for table "release"
#

INSERT INTO `release` VALUES (1,'20161009155425-d3a0749c6e20bc15','20161009155424-release','Sample发布','SampleApp','default','application','{\"timeout\":\"100\"}',b'0',b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(2,'20180404001228-7231d1afd3efc760','20180403161355-release','','zuulservice','default','application','{\"zuul.routes.test164.url\":\"http://www.163.com\",\"zuul.routes.test164.path\":\"/test164/**\",\"zuul.host.maxPerRouteConnections\":\"512\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236\\\\:1111/eureka/\",\"zuul.routes.test166.path\":\"/test166/**\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\",\"ribbon.MaxAutoRetries\":\"1\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.routes.test166.url\":\"http://www.163.com\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.routes.test165.path\":\"/test165/**\",\"zuul.routes.test165.url\":\"http://www.163.com\",\"zuul.semaphore.max-semaphores\":\"1024\"}',b'0',b'0','apollo','2018-04-04 00:12:29','apollo','2018-04-04 00:12:29'),(3,'20180404002220-7231d1afd3efc761','20180403162348-release','','zuulservice','default','application','{\"zuul.routes.test164.url\":\"http://www.163.com\",\"zuul.routes.test164.path\":\"/test164/**\",\"zuul.host.maxPerRouteConnections\":\"512\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236:1111/eureka/\",\"zuul.routes.test166.path\":\"/test166/**\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\",\"ribbon.MaxAutoRetries\":\"1\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.routes.test166.url\":\"http://www.163.com\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.routes.test165.path\":\"/test165/**\",\"zuul.routes.test165.url\":\"http://www.163.com\",\"zuul.semaphore.max-semaphores\":\"1024\"}',b'0',b'0','apollo','2018-04-04 00:22:20','apollo','2018-04-04 00:22:20'),(4,'20180404005550-7231d1afd3efc762','20180403165718-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-04-04 00:55:50','apollo','2018-04-04 00:55:50'),(5,'20180403192522-723164972d4b5883','20180403192755-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://192.168.3.151:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-04-03 19:25:22','apollo','2018-04-03 19:25:22'),(6,'20180404175330-723164972d189c81','20180404095329-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-04-04 17:53:30','apollo','2018-04-04 17:53:30'),(7,'20180404175634-723164972d189c82','20180404095633-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"eureka.client.register-with-eureka\":\"false\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-04-04 17:56:35','apollo','2018-04-04 17:56:35'),(8,'20180404193915-723164972d357e89','20180404113911-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-04-04 19:39:15','apollo','2018-04-04 19:39:15'),(9,'20180404194149-723164972d357e8a','20180404114148-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"eureka.instance.instance-id\":\"${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}}\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9999\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-04-04 19:41:50','apollo','2018-04-04 19:41:50'),(10,'20180626195919-7231d6ad3e03c099','20180626195916-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"eureka.instance.instance-id\":\"${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}}\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9000\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://130.75.131.236:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-06-26 19:59:20','apollo','2018-06-26 19:59:20'),(11,'20180626200041-7231d6ad3e03c09a','20180626200039-release','','zuulservice','default','application','{\"ribbon.MaxAutoRetries\":\"1\",\"eureka.instance.instance-id\":\"${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}}\",\"spring.application.name\":\"sop-api-gateway\",\"ribbon.ConnectTimeout\":\"10000\",\"hystrix.command.default.execution.timeout.enabled\":\"true\",\"zuul.host.connect-timeout-millis\":\"10000\",\"ribbon.OkToRetryOnAllOperations\":\"true\",\"zuul.host.maxPerRouteConnections\":\"512\",\"eureka.instance.prefer-ip-address\":\"true\",\"zuul.host.socket-timeout-millis\":\"10000\",\"zuul.ignored-services\":\"\\\"*\\\"\",\"ribbon.ReadTimeout\":\"10000\",\"zuul.routes.test163.url\":\"http://www.163.com\",\"zuul.host.maxTotalConnections\":\"1024\",\"management.security.enabled\":\"false\",\"server.port\":\"9000\",\"zuul.semaphore.max-semaphores\":\"1024\",\"zuul.routes.test163.path\":\"/test163/**\",\"ribbon.MaxAutoRetriesNextServer\":\"2\",\"eureka.client.serviceUrl.defaultZone\":\"http://127.0.0.1:1111/eureka\",\"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds\":\"10000\"}',b'0',b'0','apollo','2018-06-26 20:00:41','apollo','2018-06-26 20:00:41');

#
# Structure for table "releasehistory"
#

DROP TABLE IF EXISTS `releasehistory`;
CREATE TABLE `releasehistory` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `AppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `NamespaceName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'namespaceName',
  `BranchName` varchar(32) NOT NULL DEFAULT 'default' COMMENT '发布分支名',
  `ReleaseId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联的Release Id',
  `PreviousReleaseId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '前一次发布的ReleaseId',
  `Operation` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '发布类型，0: 普通发布，1: 回滚，2: 灰度发布，3: 灰度规则更新，4: 灰度合并回主分支发布，5: 主分支发布灰度自动发布，6: 主分支回滚灰度自动发布，7: 放弃灰度',
  `OperationContext` longtext NOT NULL COMMENT '发布上下文信息',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_Namespace` (`AppId`,`ClusterName`,`NamespaceName`,`BranchName`),
  KEY `IX_ReleaseId` (`ReleaseId`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='发布历史';

#
# Data for table "releasehistory"
#

INSERT INTO `releasehistory` VALUES (1,'SampleApp','default','application','default',1,0,0,'{}',b'0','apollo','2018-04-03 23:19:15','apollo','2018-04-03 23:19:15'),(2,'zuulservice','default','application','default',2,0,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-04 00:12:29','apollo','2018-04-04 00:12:29'),(3,'zuulservice','default','application','default',3,2,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-04 00:22:21','apollo','2018-04-04 00:22:21'),(4,'zuulservice','default','application','default',4,3,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-04 00:55:50','apollo','2018-04-04 00:55:50'),(5,'zuulservice','default','application','default',5,4,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-03 19:25:22','apollo','2018-04-03 19:25:22'),(6,'zuulservice','default','application','default',6,5,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-04 17:53:31','apollo','2018-04-04 17:53:31'),(7,'zuulservice','default','application','default',7,6,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-04 17:56:35','apollo','2018-04-04 17:56:35'),(8,'zuulservice','default','application','default',8,7,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-04 19:39:15','apollo','2018-04-04 19:39:15'),(9,'zuulservice','default','application','default',9,8,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-04-04 19:41:50','apollo','2018-04-04 19:41:50'),(10,'zuulservice','default','application','default',10,9,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-06-26 19:59:20','apollo','2018-06-26 19:59:20'),(11,'zuulservice','default','application','default',11,10,0,'{\"isEmergencyPublish\":false}',b'0','apollo','2018-06-26 20:00:42','apollo','2018-06-26 20:00:42');

#
# Structure for table "releasemessage"
#

DROP TABLE IF EXISTS `releasemessage`;
CREATE TABLE `releasemessage` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Message` varchar(1024) NOT NULL DEFAULT '' COMMENT '发布的消息内容',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Message` (`Message`(191))
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='发布消息';

#
# Data for table "releasemessage"
#

INSERT INTO `releasemessage` VALUES (10,'zuulservice+default+application','2018-06-26 20:00:42');

#
# Structure for table "serverconfig"
#

DROP TABLE IF EXISTS `serverconfig`;
CREATE TABLE `serverconfig` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Key` varchar(64) NOT NULL DEFAULT 'default' COMMENT '配置项Key',
  `Cluster` varchar(32) NOT NULL DEFAULT 'default' COMMENT '配置对应的集群，default为不针对特定的集群',
  `Value` varchar(2048) NOT NULL DEFAULT 'default' COMMENT '配置项值',
  `Comment` varchar(1024) DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_Key` (`Key`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='配置服务自身配置';

#
# Data for table "serverconfig"
#

INSERT INTO `serverconfig` VALUES (1,'eureka.service.url','default','http://134.224.240.170:1111/eureka/','Eureka服务Url，多个service以英文逗号分隔 http://130.75.131.236:1111/eureka/  http://192.168.3.151:1111/eureka/',b'0','default','2018-04-03 23:19:15','','2018-06-26 11:52:52'),(2,'namespace.lock.switch','default','false','一次发布只能有一个人修改开关',b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(3,'item.value.length.limit','default','20000','item value最大长度限制',b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(4,'config-service.cache.enabled','default','false','ConfigService是否开启缓存，开启后能提高性能，但是会增大内存消耗！',b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15'),(5,'item.key.length.limit','default','128','item key 最大长度限制',b'0','default','2018-04-03 23:19:15','','2018-04-03 23:19:15');

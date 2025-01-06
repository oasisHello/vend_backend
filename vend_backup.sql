-- MySQL dump 10.13  Distrib 9.0.1, for macos14.7 (arm64)
--
-- Host: localhost    Database: vend
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `vend`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `vend` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `vend`;

--
-- Table structure for table `gen_table`
--

DROP TABLE IF EXISTS `gen_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gen_table` (
  `table_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `tpl_web_type` varchar(30) DEFAULT '' COMMENT '前端模板类型（element-ui模版 element-plus模版）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='代码生成业务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table`
--

LOCK TABLES `gen_table` WRITE;
/*!40000 ALTER TABLE `gen_table` DISABLE KEYS */;
INSERT INTO `gen_table` VALUES (1,'tb_emp','Employee',NULL,NULL,'emp','crud','element-plus','oasis.vend.manage','manage','emp','Employee List','oasis','0','/','{\"parentMenuId\":2000}','admin','2024-12-31 16:25:48','','2024-12-31 16:33:59',NULL),(2,'tb_role','Role table',NULL,NULL,'Role','crud','element-plus','oasis.vend.manage','manage','role','Role List','oasis','0','/','{\"parentMenuId\":2000}','admin','2024-12-31 16:25:48','','2024-12-31 16:36:20',NULL);
/*!40000 ALTER TABLE `gen_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gen_table_column`
--

DROP TABLE IF EXISTS `gen_table_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gen_table_column` (
  `column_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` bigint DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='代码生成业务表字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table_column`
--

LOCK TABLES `gen_table_column` WRITE;
/*!40000 ALTER TABLE `gen_table_column` DISABLE KEYS */;
INSERT INTO `gen_table_column` VALUES (1,1,'id','Primary key for employee','int','Long','id','1','1','0','0',NULL,NULL,NULL,'EQ','input','',1,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(2,1,'user_name','Employee name','varchar(50)','String','userName','0','0','1','1','1','1','1','LIKE','input','',2,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(3,1,'region_id','Associated region ID','int','Long','regionId','0','0','1','1','1','0','1','EQ','input','',3,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(4,1,'region_name','Region name','varchar(50)','String','regionName','0','0','0','0','0','1','0','LIKE','input','',4,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(5,1,'role_id','Associated role ID','int','Long','roleId','0','0','1','1','1','0','1','EQ','input','',5,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(6,1,'role_code','Role code','varchar(10)','String','roleCode','0','0','0','0','0','1','1','EQ','input','',6,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(7,1,'role_name','Role name','varchar(50)','String','roleName','0','0','0','0','0','1','0','LIKE','input','',7,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(8,1,'mobile','Mobile phone number','varchar(15)','String','mobile','0','0','1','1','1','1','0','EQ','input','',8,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(9,1,'image','Profile picture','varchar(500)','String','image','0','0','1','1','1','0','0','EQ','imageUpload','',9,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(10,1,'status','Status (1 active, 0 inactive)','tinyint(1)','Integer','status','0','0','1','1','1','0','1','EQ','radio','employee_status',10,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(11,1,'create_time','Creation time','timestamp','Date','createTime','0','0','0','0',NULL,NULL,NULL,'EQ','datetime','',11,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(12,1,'update_time','Last updated time','timestamp','Date','updateTime','0','0','0','0','0',NULL,NULL,'EQ','datetime','',12,'admin','2024-12-31 16:25:48','','2024-12-31 16:33:59'),(13,2,'role_id','Primary key for role','int','Long','roleId','1','1','0','0',NULL,NULL,NULL,'EQ','input','',1,'admin','2024-12-31 16:25:48','','2024-12-31 16:36:20'),(14,2,'role_code','Role code','varchar(50)','String','roleCode','0','0','1','1','1','1','1','EQ','input','',2,'admin','2024-12-31 16:25:48','','2024-12-31 16:36:20'),(15,2,'role_name','Role name','varchar(50)','String','roleName','0','0','1','1','1','1','1','LIKE','input','',3,'admin','2024-12-31 16:25:48','','2024-12-31 16:36:20');
/*!40000 ALTER TABLE `gen_table_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_config` (
  `config_id` int NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2024-12-31 16:03:47','',NULL,'蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2024-12-31 16:03:47','',NULL,'初始化密码 123456'),(3,'主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2024-12-31 16:03:47','',NULL,'深色主题theme-dark，浅色主题theme-light'),(4,'账号自助-验证码开关','sys.account.captchaEnabled','true','Y','admin','2024-12-31 16:03:47','',NULL,'是否开启验证码功能（true开启，false关闭）'),(5,'账号自助-是否开启用户注册功能','sys.account.registerUser','false','Y','admin','2024-12-31 16:03:47','',NULL,'是否开启注册用户功能（true开启，false关闭）'),(6,'用户登录-黑名单列表','sys.login.blackIPList','','Y','admin','2024-12-31 16:03:47','',NULL,'设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept` (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (100,0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(101,100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(102,100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(103,101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(104,101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(105,101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(106,101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(108,102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL),(109,102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2024-12-31 16:03:47','',NULL);
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES (1,1,'男','0','sys_user_sex','','','Y','0','admin','2024-12-31 16:03:47','',NULL,'性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2024-12-31 16:03:47','',NULL,'性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2024-12-31 16:03:47','',NULL,'性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2024-12-31 16:03:47','',NULL,'显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2024-12-31 16:03:47','',NULL,'正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2024-12-31 16:03:47','',NULL,'正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'停用状态'),(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2024-12-31 16:03:47','',NULL,'默认分组'),(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2024-12-31 16:03:47','',NULL,'系统分组'),(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2024-12-31 16:03:47','',NULL,'系统默认是'),(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'系统默认否'),(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2024-12-31 16:03:47','',NULL,'通知'),(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2024-12-31 16:03:47','',NULL,'公告'),(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2024-12-31 16:03:47','',NULL,'正常状态'),(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'关闭状态'),(18,99,'其他','0','sys_oper_type','','info','N','0','admin','2024-12-31 16:03:47','',NULL,'其他操作'),(19,1,'新增','1','sys_oper_type','','info','N','0','admin','2024-12-31 16:03:47','',NULL,'新增操作'),(20,2,'修改','2','sys_oper_type','','info','N','0','admin','2024-12-31 16:03:47','',NULL,'修改操作'),(21,3,'删除','3','sys_oper_type','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'删除操作'),(22,4,'授权','4','sys_oper_type','','primary','N','0','admin','2024-12-31 16:03:47','',NULL,'授权操作'),(23,5,'导出','5','sys_oper_type','','warning','N','0','admin','2024-12-31 16:03:47','',NULL,'导出操作'),(24,6,'导入','6','sys_oper_type','','warning','N','0','admin','2024-12-31 16:03:47','',NULL,'导入操作'),(25,7,'强退','7','sys_oper_type','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'强退操作'),(26,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2024-12-31 16:03:47','',NULL,'生成操作'),(27,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'清空操作'),(28,1,'成功','0','sys_common_status','','primary','N','0','admin','2024-12-31 16:03:47','',NULL,'正常状态'),(29,2,'失败','1','sys_common_status','','danger','N','0','admin','2024-12-31 16:03:47','',NULL,'停用状态'),(100,1,'Enable','1','employee_status','','default','N','0','admin','2024-12-31 16:23:00','admin','2024-12-31 16:24:34',NULL),(101,2,'Disable','2','employee_status','','default','N','0','admin','2024-12-31 16:23:24','admin','2024-12-31 16:24:46',NULL);
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES (1,'用户性别','sys_user_sex','0','admin','2024-12-31 16:03:47','',NULL,'用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2024-12-31 16:03:47','',NULL,'菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2024-12-31 16:03:47','',NULL,'系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2024-12-31 16:03:47','',NULL,'任务状态列表'),(5,'任务分组','sys_job_group','0','admin','2024-12-31 16:03:47','',NULL,'任务分组列表'),(6,'系统是否','sys_yes_no','0','admin','2024-12-31 16:03:47','',NULL,'系统是否列表'),(7,'通知类型','sys_notice_type','0','admin','2024-12-31 16:03:47','',NULL,'通知类型列表'),(8,'通知状态','sys_notice_status','0','admin','2024-12-31 16:03:47','',NULL,'通知状态列表'),(9,'操作类型','sys_oper_type','0','admin','2024-12-31 16:03:47','',NULL,'操作类型列表'),(10,'系统状态','sys_common_status','0','admin','2024-12-31 16:03:47','',NULL,'登录状态列表'),(100,'Employee Status','employee_status','0','admin','2024-12-31 16:22:06','admin','2024-12-31 16:22:14',NULL);
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job`
--

DROP TABLE IF EXISTS `sys_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job` (
  `job_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务调度表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job`
--

LOCK TABLES `sys_job` WRITE;
/*!40000 ALTER TABLE `sys_job` DISABLE KEYS */;
INSERT INTO `sys_job` VALUES (1,'系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2024-12-31 16:03:47','',NULL,''),(2,'系统默认（有参）','DEFAULT','ryTask.ryParams(\'ry\')','0/15 * * * * ?','3','1','1','admin','2024-12-31 16:03:47','',NULL,''),(3,'系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2024-12-31 16:03:47','',NULL,'');
/*!40000 ALTER TABLE `sys_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job_log`
--

DROP TABLE IF EXISTS `sys_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务调度日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job_log`
--

LOCK TABLES `sys_job_log` WRITE;
/*!40000 ALTER TABLE `sys_job_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logininfor`
--

DROP TABLE IF EXISTS `sys_logininfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`),
  KEY `idx_sys_logininfor_s` (`status`),
  KEY `idx_sys_logininfor_lt` (`login_time`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统访问记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logininfor`
--

LOCK TABLES `sys_logininfor` WRITE;
/*!40000 ALTER TABLE `sys_logininfor` DISABLE KEYS */;
INSERT INTO `sys_logininfor` VALUES (100,'admin','127.0.0.1','内网IP','Chrome 12','Mac OS X','0','登录成功','2025-01-01 17:23:06'),(101,'admin','127.0.0.1','内网IP','Chrome 12','Mac OS X','1','验证码错误','2025-01-02 10:12:39'),(102,'admin','127.0.0.1','内网IP','Chrome 12','Mac OS X','0','登录成功','2025-01-02 10:12:45'),(103,'admin','127.0.0.1','内网IP','Chrome 12','Mac OS X','0','登录成功','2025-01-02 19:33:51'),(104,'admin','127.0.0.1','内网IP','Chrome 12','Mac OS X','0','登录成功','2025-01-03 21:29:33');
/*!40000 ALTER TABLE `sys_logininfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) DEFAULT NULL COMMENT '路由参数',
  `route_name` varchar(50) DEFAULT '' COMMENT '路由名称',
  `is_frame` int DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',0,1,'system',NULL,'','',1,0,'M','0','0','','system','admin','2024-12-31 16:03:47','',NULL,'系统管理目录'),(2,'系统监控',0,2,'monitor',NULL,'','',1,0,'M','0','0','','monitor','admin','2024-12-31 16:03:47','',NULL,'系统监控目录'),(3,'系统工具',0,3,'tool',NULL,'','',1,0,'M','0','0','','tool','admin','2024-12-31 16:03:47','',NULL,'系统工具目录'),(4,'若依官网',0,4,'http://ruoyi.vip',NULL,'','',0,0,'M','0','0','','guide','admin','2024-12-31 16:03:47','',NULL,'若依官网地址'),(100,'用户管理',1,1,'user','system/user/index','','',1,0,'C','0','0','system:user:list','user','admin','2024-12-31 16:03:47','',NULL,'用户管理菜单'),(101,'角色管理',1,2,'role','system/role/index','','',1,0,'C','0','0','system:role:list','peoples','admin','2024-12-31 16:03:47','',NULL,'角色管理菜单'),(102,'菜单管理',1,3,'menu','system/menu/index','','',1,0,'C','0','0','system:menu:list','tree-table','admin','2024-12-31 16:03:47','',NULL,'菜单管理菜单'),(103,'部门管理',1,4,'dept','system/dept/index','','',1,0,'C','0','0','system:dept:list','tree','admin','2024-12-31 16:03:47','',NULL,'部门管理菜单'),(104,'岗位管理',1,5,'post','system/post/index','','',1,0,'C','0','0','system:post:list','post','admin','2024-12-31 16:03:47','',NULL,'岗位管理菜单'),(105,'字典管理',1,6,'dict','system/dict/index','','',1,0,'C','0','0','system:dict:list','dict','admin','2024-12-31 16:03:47','',NULL,'字典管理菜单'),(106,'参数设置',1,7,'config','system/config/index','','',1,0,'C','0','0','system:config:list','edit','admin','2024-12-31 16:03:47','',NULL,'参数设置菜单'),(107,'通知公告',1,8,'notice','system/notice/index','','',1,0,'C','0','0','system:notice:list','message','admin','2024-12-31 16:03:47','',NULL,'通知公告菜单'),(108,'日志管理',1,9,'log','','','',1,0,'M','0','0','','log','admin','2024-12-31 16:03:47','',NULL,'日志管理菜单'),(109,'在线用户',2,1,'online','monitor/online/index','','',1,0,'C','0','0','monitor:online:list','online','admin','2024-12-31 16:03:47','',NULL,'在线用户菜单'),(110,'定时任务',2,2,'job','monitor/job/index','','',1,0,'C','0','0','monitor:job:list','job','admin','2024-12-31 16:03:47','',NULL,'定时任务菜单'),(111,'数据监控',2,3,'druid','monitor/druid/index','','',1,0,'C','0','0','monitor:druid:list','druid','admin','2024-12-31 16:03:47','',NULL,'数据监控菜单'),(112,'服务监控',2,4,'server','monitor/server/index','','',1,0,'C','0','0','monitor:server:list','server','admin','2024-12-31 16:03:47','',NULL,'服务监控菜单'),(113,'缓存监控',2,5,'cache','monitor/cache/index','','',1,0,'C','0','0','monitor:cache:list','redis','admin','2024-12-31 16:03:47','',NULL,'缓存监控菜单'),(114,'缓存列表',2,6,'cacheList','monitor/cache/list','','',1,0,'C','0','0','monitor:cache:list','redis-list','admin','2024-12-31 16:03:47','',NULL,'缓存列表菜单'),(115,'表单构建',3,1,'build','tool/build/index','','',1,0,'C','0','0','tool:build:list','build','admin','2024-12-31 16:03:47','',NULL,'表单构建菜单'),(116,'代码生成',3,2,'gen','tool/gen/index','','',1,0,'C','0','0','tool:gen:list','code','admin','2024-12-31 16:03:47','',NULL,'代码生成菜单'),(117,'系统接口',3,3,'swagger','tool/swagger/index','','',1,0,'C','0','0','tool:swagger:list','swagger','admin','2024-12-31 16:03:47','',NULL,'系统接口菜单'),(500,'操作日志',108,1,'operlog','monitor/operlog/index','','',1,0,'C','0','0','monitor:operlog:list','form','admin','2024-12-31 16:03:47','',NULL,'操作日志菜单'),(501,'登录日志',108,2,'logininfor','monitor/logininfor/index','','',1,0,'C','0','0','monitor:logininfor:list','logininfor','admin','2024-12-31 16:03:47','',NULL,'登录日志菜单'),(1000,'用户查询',100,1,'','','','',1,0,'F','0','0','system:user:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1001,'用户新增',100,2,'','','','',1,0,'F','0','0','system:user:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1002,'用户修改',100,3,'','','','',1,0,'F','0','0','system:user:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1003,'用户删除',100,4,'','','','',1,0,'F','0','0','system:user:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1004,'用户导出',100,5,'','','','',1,0,'F','0','0','system:user:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1005,'用户导入',100,6,'','','','',1,0,'F','0','0','system:user:import','#','admin','2024-12-31 16:03:47','',NULL,''),(1006,'重置密码',100,7,'','','','',1,0,'F','0','0','system:user:resetPwd','#','admin','2024-12-31 16:03:47','',NULL,''),(1007,'角色查询',101,1,'','','','',1,0,'F','0','0','system:role:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1008,'角色新增',101,2,'','','','',1,0,'F','0','0','system:role:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1009,'角色修改',101,3,'','','','',1,0,'F','0','0','system:role:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1010,'角色删除',101,4,'','','','',1,0,'F','0','0','system:role:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1011,'角色导出',101,5,'','','','',1,0,'F','0','0','system:role:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1012,'菜单查询',102,1,'','','','',1,0,'F','0','0','system:menu:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1013,'菜单新增',102,2,'','','','',1,0,'F','0','0','system:menu:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1014,'菜单修改',102,3,'','','','',1,0,'F','0','0','system:menu:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1015,'菜单删除',102,4,'','','','',1,0,'F','0','0','system:menu:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1016,'部门查询',103,1,'','','','',1,0,'F','0','0','system:dept:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1017,'部门新增',103,2,'','','','',1,0,'F','0','0','system:dept:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1018,'部门修改',103,3,'','','','',1,0,'F','0','0','system:dept:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1019,'部门删除',103,4,'','','','',1,0,'F','0','0','system:dept:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1020,'岗位查询',104,1,'','','','',1,0,'F','0','0','system:post:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1021,'岗位新增',104,2,'','','','',1,0,'F','0','0','system:post:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1022,'岗位修改',104,3,'','','','',1,0,'F','0','0','system:post:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1023,'岗位删除',104,4,'','','','',1,0,'F','0','0','system:post:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1024,'岗位导出',104,5,'','','','',1,0,'F','0','0','system:post:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1025,'字典查询',105,1,'#','','','',1,0,'F','0','0','system:dict:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1026,'字典新增',105,2,'#','','','',1,0,'F','0','0','system:dict:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1027,'字典修改',105,3,'#','','','',1,0,'F','0','0','system:dict:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1028,'字典删除',105,4,'#','','','',1,0,'F','0','0','system:dict:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1029,'字典导出',105,5,'#','','','',1,0,'F','0','0','system:dict:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1030,'参数查询',106,1,'#','','','',1,0,'F','0','0','system:config:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1031,'参数新增',106,2,'#','','','',1,0,'F','0','0','system:config:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1032,'参数修改',106,3,'#','','','',1,0,'F','0','0','system:config:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1033,'参数删除',106,4,'#','','','',1,0,'F','0','0','system:config:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1034,'参数导出',106,5,'#','','','',1,0,'F','0','0','system:config:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1035,'公告查询',107,1,'#','','','',1,0,'F','0','0','system:notice:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1036,'公告新增',107,2,'#','','','',1,0,'F','0','0','system:notice:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1037,'公告修改',107,3,'#','','','',1,0,'F','0','0','system:notice:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1038,'公告删除',107,4,'#','','','',1,0,'F','0','0','system:notice:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1039,'操作查询',500,1,'#','','','',1,0,'F','0','0','monitor:operlog:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1040,'操作删除',500,2,'#','','','',1,0,'F','0','0','monitor:operlog:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1041,'日志导出',500,3,'#','','','',1,0,'F','0','0','monitor:operlog:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1042,'登录查询',501,1,'#','','','',1,0,'F','0','0','monitor:logininfor:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1043,'登录删除',501,2,'#','','','',1,0,'F','0','0','monitor:logininfor:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1044,'日志导出',501,3,'#','','','',1,0,'F','0','0','monitor:logininfor:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1045,'账户解锁',501,4,'#','','','',1,0,'F','0','0','monitor:logininfor:unlock','#','admin','2024-12-31 16:03:47','',NULL,''),(1046,'在线查询',109,1,'#','','','',1,0,'F','0','0','monitor:online:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1047,'批量强退',109,2,'#','','','',1,0,'F','0','0','monitor:online:batchLogout','#','admin','2024-12-31 16:03:47','',NULL,''),(1048,'单条强退',109,3,'#','','','',1,0,'F','0','0','monitor:online:forceLogout','#','admin','2024-12-31 16:03:47','',NULL,''),(1049,'任务查询',110,1,'#','','','',1,0,'F','0','0','monitor:job:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1050,'任务新增',110,2,'#','','','',1,0,'F','0','0','monitor:job:add','#','admin','2024-12-31 16:03:47','',NULL,''),(1051,'任务修改',110,3,'#','','','',1,0,'F','0','0','monitor:job:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1052,'任务删除',110,4,'#','','','',1,0,'F','0','0','monitor:job:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1053,'状态修改',110,5,'#','','','',1,0,'F','0','0','monitor:job:changeStatus','#','admin','2024-12-31 16:03:47','',NULL,''),(1054,'任务导出',110,6,'#','','','',1,0,'F','0','0','monitor:job:export','#','admin','2024-12-31 16:03:47','',NULL,''),(1055,'生成查询',116,1,'#','','','',1,0,'F','0','0','tool:gen:query','#','admin','2024-12-31 16:03:47','',NULL,''),(1056,'生成修改',116,2,'#','','','',1,0,'F','0','0','tool:gen:edit','#','admin','2024-12-31 16:03:47','',NULL,''),(1057,'生成删除',116,3,'#','','','',1,0,'F','0','0','tool:gen:remove','#','admin','2024-12-31 16:03:47','',NULL,''),(1058,'导入代码',116,4,'#','','','',1,0,'F','0','0','tool:gen:import','#','admin','2024-12-31 16:03:47','',NULL,''),(1059,'预览代码',116,5,'#','','','',1,0,'F','0','0','tool:gen:preview','#','admin','2024-12-31 16:03:47','',NULL,''),(1060,'生成代码',116,6,'#','','','',1,0,'F','0','0','tool:gen:code','#','admin','2024-12-31 16:03:47','',NULL,''),(2000,'Employee',0,4,'employ',NULL,NULL,'',1,0,'M','0','0',NULL,'peoples','admin','2024-12-31 16:15:52','',NULL,''),(2001,'Employee List',2000,1,'emp','manage/emp/index',NULL,'',1,0,'C','0','0','manage:emp:list','#','admin','2024-12-31 16:38:22','',NULL,'Employee List菜单'),(2002,'Employee List查询',2001,1,'#','',NULL,'',1,0,'F','0','0','manage:emp:query','#','admin','2024-12-31 16:38:22','',NULL,''),(2003,'Employee List新增',2001,2,'#','',NULL,'',1,0,'F','0','0','manage:emp:add','#','admin','2024-12-31 16:38:22','',NULL,''),(2004,'Employee List修改',2001,3,'#','',NULL,'',1,0,'F','0','0','manage:emp:edit','#','admin','2024-12-31 16:38:22','',NULL,''),(2005,'Employee List删除',2001,4,'#','',NULL,'',1,0,'F','0','0','manage:emp:remove','#','admin','2024-12-31 16:38:22','',NULL,''),(2006,'Employee List导出',2001,5,'#','',NULL,'',1,0,'F','0','0','manage:emp:export','#','admin','2024-12-31 16:38:22','',NULL,''),(2007,'Role List',2000,1,'role','manage/role/index',NULL,'',1,0,'C','0','0','manage:role:list','#','admin','2025-01-02 19:44:40','',NULL,'Role List菜单'),(2008,'Role List查询',2007,1,'#','',NULL,'',1,0,'F','0','0','manage:role:query','#','admin','2025-01-02 19:44:40','',NULL,''),(2009,'Role List新增',2007,2,'#','',NULL,'',1,0,'F','0','0','manage:role:add','#','admin','2025-01-02 19:44:40','',NULL,''),(2010,'Role List修改',2007,3,'#','',NULL,'',1,0,'F','0','0','manage:role:edit','#','admin','2025-01-02 19:44:40','',NULL,''),(2011,'Role List删除',2007,4,'#','',NULL,'',1,0,'F','0','0','manage:role:remove','#','admin','2025-01-02 19:44:40','',NULL,''),(2012,'Role List导出',2007,5,'#','',NULL,'',1,0,'F','0','0','manage:role:export','#','admin','2025-01-02 19:44:40','',NULL,'');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='通知公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
INSERT INTO `sys_notice` VALUES (1,'温馨提醒：2018-07-01 若依新版本发布啦','2',_binary '新版本内容','0','admin','2024-12-31 16:03:47','',NULL,'管理员'),(2,'维护通知：2018-07-01 若依系统凌晨维护','1',_binary '维护内容','0','admin','2024-12-31 16:03:47','',NULL,'管理员');
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oper_log`
--

DROP TABLE IF EXISTS `sys_oper_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(200) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  `cost_time` bigint DEFAULT '0' COMMENT '消耗时间',
  PRIMARY KEY (`oper_id`),
  KEY `idx_sys_oper_log_bt` (`business_type`),
  KEY `idx_sys_oper_log_s` (`status`),
  KEY `idx_sys_oper_log_ot` (`oper_time`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oper_log`
--

LOCK TABLES `sys_oper_log` WRITE;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
INSERT INTO `sys_oper_log` VALUES (100,'菜单管理',1,'oasis.vend.web.controller.system.SysMenuController.add()','POST',1,'admin','研发部门','/system/menu','127.0.0.1','内网IP','{\"children\":[],\"createBy\":\"admin\",\"icon\":\"peoples\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"Employee\",\"menuType\":\"M\",\"orderNum\":4,\"params\":{},\"parentId\":0,\"path\":\"employ\",\"status\":\"0\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:15:52',154),(101,'字典类型',1,'oasis.vend.web.controller.system.SysDictTypeController.add()','POST',1,'admin','研发部门','/system/dict/type','127.0.0.1','内网IP','{\"createBy\":\"admin\",\"dictName\":\"Employee Status\",\"dictType\":\"employee_status\",\"params\":{},\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:22:06',136),(102,'字典类型',2,'oasis.vend.web.controller.system.SysDictTypeController.edit()','PUT',1,'admin','研发部门','/system/dict/type','127.0.0.1','内网IP','{\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:22:06\",\"dictId\":100,\"dictName\":\"Employee Status\",\"dictType\":\"employee_status\",\"params\":{},\"status\":\"0\",\"updateBy\":\"admin\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:22:14',76),(103,'字典数据',1,'oasis.vend.web.controller.system.SysDictDataController.add()','POST',1,'admin','研发部门','/system/dict/data','127.0.0.1','内网IP','{\"createBy\":\"admin\",\"cssClass\":\"Oncall\",\"default\":false,\"dictLabel\":\"1\",\"dictSort\":1,\"dictType\":\"employee_status\",\"dictValue\":\"1\",\"listClass\":\"default\",\"params\":{},\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:23:00',46),(104,'字典数据',1,'oasis.vend.web.controller.system.SysDictDataController.add()','POST',1,'admin','研发部门','/system/dict/data','127.0.0.1','内网IP','{\"createBy\":\"admin\",\"cssClass\":\"Suspension\",\"default\":false,\"dictLabel\":\"2\",\"dictSort\":2,\"dictType\":\"employee_status\",\"dictValue\":\"2\",\"listClass\":\"default\",\"params\":{},\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:23:24',36),(105,'字典数据',2,'oasis.vend.web.controller.system.SysDictDataController.edit()','PUT',1,'admin','研发部门','/system/dict/data','127.0.0.1','内网IP','{\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:23:00\",\"cssClass\":\"\",\"default\":false,\"dictCode\":100,\"dictLabel\":\"Enable\",\"dictSort\":1,\"dictType\":\"employee_status\",\"dictValue\":\"1\",\"isDefault\":\"N\",\"listClass\":\"default\",\"params\":{},\"status\":\"0\",\"updateBy\":\"admin\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:24:34',57),(106,'字典数据',2,'oasis.vend.web.controller.system.SysDictDataController.edit()','PUT',1,'admin','研发部门','/system/dict/data','127.0.0.1','内网IP','{\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:23:24\",\"cssClass\":\"\",\"default\":false,\"dictCode\":101,\"dictLabel\":\"Disable\",\"dictSort\":2,\"dictType\":\"employee_status\",\"dictValue\":\"2\",\"isDefault\":\"N\",\"listClass\":\"default\",\"params\":{},\"status\":\"0\",\"updateBy\":\"admin\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:24:46',35),(107,'代码生成',6,'oasis.vend.generator.controller.GenController.importTableSave()','POST',1,'admin','研发部门','/tool/gen/importTable','127.0.0.1','内网IP','{\"tables\":\"tb_emp,tb_role\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:25:48',276),(108,'代码生成',2,'oasis.vend.generator.controller.GenController.editSave()','PUT',1,'admin','研发部门','/tool/gen','127.0.0.1','内网IP','{\"businessName\":\"emp\",\"className\":\"emp\",\"columns\":[{\"capJavaField\":\"Id\",\"columnComment\":\"Primary key for employee\",\"columnId\":1,\"columnName\":\"id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":true,\"insert\":false,\"isIncrement\":\"1\",\"isInsert\":\"0\",\"isPk\":\"1\",\"isRequired\":\"0\",\"javaField\":\"id\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":true,\"query\":false,\"queryType\":\"EQ\",\"required\":false,\"sort\":1,\"superColumn\":false,\"tableId\":1,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"UserName\",\"columnComment\":\"Employee name\",\"columnId\":2,\"columnName\":\"user_name\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"isRequired\":\"1\",\"javaField\":\"userName\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"LIKE\",\"required\":true,\"sort\":2,\"superColumn\":false,\"tableId\":1,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"RegionId\",\"columnComment\":\"Associated region ID\",\"columnId\":3,\"columnName\":\"region_id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"0\",\"isPk\":\"0\",\"isQuery\":\"1\",\"isRequired\":\"1\",\"javaField\":\"regionId\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":true,\"sort\":3,\"superColumn\":false,\"tableId\":1,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"RegionName\",\"columnComment\":\"Region name\",\"columnId\":4,\"columnName\":\"region_name\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":false,\"insert\":false,\"isEdit\":\"0\",\"isIncrement\":\"0\",\"isInsert\":\"0\",\"isList\":\"1\",\"isPk\":\"0\",\"isQ','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:33:59',213),(109,'代码生成',2,'oasis.vend.generator.controller.GenController.editSave()','PUT',1,'admin','研发部门','/tool/gen','127.0.0.1','内网IP','{\"businessName\":\"role\",\"className\":\"Role\",\"columns\":[{\"capJavaField\":\"RoleId\",\"columnComment\":\"Primary key for role\",\"columnId\":13,\"columnName\":\"role_id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":true,\"insert\":false,\"isIncrement\":\"1\",\"isInsert\":\"0\",\"isPk\":\"1\",\"isRequired\":\"0\",\"javaField\":\"roleId\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":true,\"query\":false,\"queryType\":\"EQ\",\"required\":false,\"sort\":1,\"superColumn\":false,\"tableId\":2,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"RoleCode\",\"columnComment\":\"Role code\",\"columnId\":14,\"columnName\":\"role_code\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"isRequired\":\"1\",\"javaField\":\"roleCode\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":true,\"sort\":2,\"superColumn\":false,\"tableId\":2,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"RoleName\",\"columnComment\":\"Role name\",\"columnId\":15,\"columnName\":\"role_name\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"isRequired\":\"1\",\"javaField\":\"roleName\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"LIKE\",\"required\":true,\"sort\":3,\"superColumn\":false,\"tableId\":2,\"updateBy\":\"\",\"usableColumn\":false}],\"crud\":true,\"functionAuthor\":\"oasis\",\"functionName\":\"Role List\",\"genPath\":\"/\",\"genType\":\"0\",\"moduleName\":\"manage\",\"options\":\"{\\\"parentMenuId\\\":2000}\",\"packageName\":\"oasis.vend.manage\",\"params\":{\"parentMenuId\":2000},\"parentMenuId\":2000,\"sub\":false,\"tableComment\":\"Role table\",\"tableId\":2,\"tableName\":\"tb_role\",\"tplCategory\":\"','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:35:36',58),(110,'代码生成',2,'oasis.vend.generator.controller.GenController.editSave()','PUT',1,'admin','研发部门','/tool/gen','127.0.0.1','内网IP','{\"businessName\":\"role\",\"className\":\"Role\",\"columns\":[{\"capJavaField\":\"RoleId\",\"columnComment\":\"Primary key for role\",\"columnId\":13,\"columnName\":\"role_id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":true,\"insert\":false,\"isIncrement\":\"1\",\"isInsert\":\"0\",\"isPk\":\"1\",\"isRequired\":\"0\",\"javaField\":\"roleId\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":true,\"query\":false,\"queryType\":\"EQ\",\"required\":false,\"sort\":1,\"superColumn\":false,\"tableId\":2,\"updateBy\":\"\",\"updateTime\":\"2024-12-31 17:35:36\",\"usableColumn\":false},{\"capJavaField\":\"RoleCode\",\"columnComment\":\"Role code\",\"columnId\":14,\"columnName\":\"role_code\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"isRequired\":\"1\",\"javaField\":\"roleCode\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":true,\"sort\":2,\"superColumn\":false,\"tableId\":2,\"updateBy\":\"\",\"updateTime\":\"2024-12-31 17:35:36\",\"usableColumn\":false},{\"capJavaField\":\"RoleName\",\"columnComment\":\"Role name\",\"columnId\":15,\"columnName\":\"role_name\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"createTime\":\"2024-12-31 17:25:48\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"isRequired\":\"1\",\"javaField\":\"roleName\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"LIKE\",\"required\":true,\"sort\":3,\"superColumn\":false,\"tableId\":2,\"updateBy\":\"\",\"updateTime\":\"2024-12-31 17:35:36\",\"usableColumn\":false}],\"crud\":true,\"functionAuthor\":\"oasis\",\"functionName\":\"Role List\",\"genPath\":\"/\",\"genType\":\"0\",\"moduleName\":\"manage\",\"options\":\"{\\\"parentMenuId\\\":2000}\",\"packageName\":\"oasis.vend.manage\",\"params\":{\"parentMenuId\":2000},\"par','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2024-12-31 16:36:20',89),(111,'代码生成',8,'oasis.vend.generator.controller.GenController.batchGenCode()','GET',1,'admin','研发部门','/tool/gen/batchGenCode','127.0.0.1','内网IP','{\"tables\":\"tb_emp,tb_role\"}',NULL,0,NULL,'2024-12-31 16:36:32',759),(112,'Employee List',1,'oasis.vend.manage.controller.empController.add()','POST',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 17:30:05\",\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101173003A001.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"status\":1,\"userName\":\"1\"}',NULL,1,'\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`))\n### The error may exist in file [/Users/oasis/code/vend_backend/vend-manage/target/classes/mapper/manage/empMapper.xml]\n### The error may involve oasis.vend.manage.mapper.empMapper.insertemp-Inline\n### The error occurred while setting parameters\n### SQL: insert into tb_emp          ( user_name,             region_id,                          role_id,                                       mobile,             image,             status,             create_time )           values ( ?,             ?,                          ?,                                       ?,             ?,             ?,             ? )\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`))\n; Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`)); nested exception is java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`))','2025-01-01 17:30:05',329),(113,'Employee List',1,'oasis.vend.manage.controller.empController.add()','POST',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 18:32:27\",\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101183225A003.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"status\":1,\"userName\":\"1\"}',NULL,1,'\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`))\n### The error may exist in file [/Users/oasis/code/vend_backend/vend-manage/target/classes/mapper/manage/empMapper.xml]\n### The error may involve oasis.vend.manage.mapper.empMapper.insertemp-Inline\n### The error occurred while setting parameters\n### SQL: insert into tb_emp          ( user_name,             region_id,                          role_id,                                       mobile,             image,             status,             create_time )           values ( ?,             ?,                          ?,                                       ?,             ?,             ?,             ? )\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`))\n; Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`)); nested exception is java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`vend`.`tb_emp`, CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`))','2025-01-01 18:32:27',497),(114,'Employee List',1,'oasis.vend.manage.controller.empController.add()','POST',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 18:47:48\",\"id\":3,\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101183225A003.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"status\":1,\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-01 18:47:48',123),(115,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 18:47:48\",\"id\":3,\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101183225A003.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"status\":1,\"updateTime\":\"2025-01-01 19:08:00\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-01 19:08:00',65),(116,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 18:47:48\",\"id\":3,\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101183225A003.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"status\":1,\"updateTime\":\"2025-01-01 19:08:45\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-01 19:08:45',23),(117,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 18:47:48\",\"id\":3,\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101183225A003.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"status\":1,\"updateTime\":\"2025-01-01 19:10:00\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-01 19:10:00',41),(118,'Employee List',3,'oasis.vend.manage.controller.empController.remove()','DELETE',1,'admin','研发部门','/manage/emp/3','127.0.0.1','内网IP','[3]','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-01 19:10:03',23),(119,'Employee List',1,'oasis.vend.manage.controller.empController.add()','POST',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101191013A001.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"roleName\":\"Administrator\",\"status\":1,\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-01 19:10:16',50),(120,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"/profile/upload/2025/01/01/v2-580f56de9cd8175a3304bfc5aa9228f2_r_20250101191013A001.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleCode\":\"Administrator\",\"roleId\":1,\"roleName\":\"Administrator\",\"status\":1,\"updateTime\":\"2025-01-01 19:12:17\",\"userName\":\"1\"}',NULL,1,'\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'role_code\' at row 1\n### The error may exist in file [/Users/oasis/code/vend_backend/vend-manage/target/classes/mapper/manage/empMapper.xml]\n### The error may involve oasis.vend.manage.mapper.empMapper.updateemp-Inline\n### The error occurred while setting parameters\n### SQL: update tb_emp          SET user_name = ?,             region_id = ?,                          role_id = ?,             role_code = ?,             role_name = ?,             mobile = ?,             image = ?,             status = ?,             create_time = ?,             update_time = ?          where id = ?\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'role_code\' at row 1\n; Data truncation: Data too long for column \'role_code\' at row 1; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'role_code\' at row 1','2025-01-01 19:12:18',222),(121,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admin\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:45:07',117),(122,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admin\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:45:11',29),(123,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:48:23',30),(124,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:48:26',28),(125,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:48:30',28),(126,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:54:05',65),(127,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:54:56',34),(128,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:55:06',20),(129,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:55:41',25),(130,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:55:46',26),(131,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:56:16',17),(132,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 19:56:20',14),(133,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-02 20:04:57',62),(134,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Administrator\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-02 20:07:30',30),(135,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-02 20:07:38',13),(136,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:08:47',55),(137,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:08:51',28),(138,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:08:55',16),(139,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:08:59',13),(140,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:16:37',91),(141,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:19:40',114),(142,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:20:52',42),(143,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:25:06',95),(144,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:34:24',93),(145,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:39:53',107),(146,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:47:52',60),(147,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:49:22',109),(148,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:51:49',91),(149,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:51:58',99),(150,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}',NULL,1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'roleName\' not found. Available parameters are [arg1, arg0, param1, param2]','2025-01-02 20:52:02',18),(151,'Role List',2,'oasis.vend.manage.controller.RoleController.edit()','PUT',1,'admin','研发部门','/manage/role','127.0.0.1','内网IP','{\"params\":{},\"roleCode\":\"ADMIN\",\"roleId\":1,\"roleName\":\"Admini\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-02 20:54:34',94),(152,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777ddf1a2f4aad0a436dfe2.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"roleName\":\"Admini\",\"status\":1,\"updateTime\":\"2025-01-03 21:54:14\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-03 21:54:14',131),(153,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777ddf1a2f4aad0a436dfe2.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"roleName\":\"Admini\",\"status\":1,\"updateTime\":\"2025-01-03 21:56:16\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-03 21:56:16',64),(154,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777df1fa2f4aad0a436dfe3.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"roleName\":\"Admini\",\"status\":1,\"updateTime\":\"2025-01-03 21:59:51\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-03 21:59:51',159),(155,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777dfb7a2f4aad0a436dfe4.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"roleName\":\"Admini\",\"status\":1,\"updateTime\":\"2025-01-03 22:13:43\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-03 22:13:43',76),(156,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777e32ba2f4aad0a436dfe6.jpg\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"roleName\":\"Admini\",\"status\":1,\"updateTime\":\"2025-01-03 22:16:33\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-03 22:16:33',39),(157,'Employee List',2,'oasis.vend.manage.controller.empController.edit()','PUT',1,'admin','研发部门','/manage/emp','127.0.0.1','内网IP','{\"createTime\":\"2025-01-01 19:10:16\",\"id\":4,\"image\":\"https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777e32ba2f4aad0a436dfe6.jpg,https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777e37ca2f4aad0a436dfe7.JPG\",\"mobile\":\"1\",\"params\":{},\"regionId\":1,\"roleId\":1,\"roleName\":\"Admini\",\"status\":1,\"updateTime\":\"2025-01-03 22:18:04\",\"userName\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2025-01-03 22:18:04',50);
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_post` (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES (1,'ceo','董事长',1,'0','admin','2024-12-31 16:03:47','',NULL,''),(2,'se','项目经理',2,'0','admin','2024-12-31 16:03:47','',NULL,''),(3,'hr','人力资源',3,'0','admin','2024-12-31 16:03:47','',NULL,''),(4,'user','普通员工',4,'0','admin','2024-12-31 16:03:47','',NULL,'');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'超级管理员','admin',1,'1',1,1,'0','0','admin','2024-12-31 16:03:47','',NULL,'超级管理员'),(2,'普通角色','common',2,'2',1,1,'0','0','admin','2024-12-31 16:03:47','',NULL,'普通角色');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `dept_id` bigint NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和部门关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dept`
--

LOCK TABLES `sys_role_dept` WRITE;
/*!40000 ALTER TABLE `sys_role_dept` DISABLE KEYS */;
INSERT INTO `sys_role_dept` VALUES (2,100),(2,101),(2,105);
/*!40000 ALTER TABLE `sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (2,1),(2,2),(2,3),(2,4),(2,100),(2,101),(2,102),(2,103),(2,104),(2,105),(2,106),(2,107),(2,108),(2,109),(2,110),(2,111),(2,112),(2,113),(2,114),(2,115),(2,116),(2,117),(2,500),(2,501),(2,1000),(2,1001),(2,1002),(2,1003),(2,1004),(2,1005),(2,1006),(2,1007),(2,1008),(2,1009),(2,1010),(2,1011),(2,1012),(2,1013),(2,1014),(2,1015),(2,1016),(2,1017),(2,1018),(2,1019),(2,1020),(2,1021),(2,1022),(2,1023),(2,1024),(2,1025),(2,1026),(2,1027),(2,1028),(2,1029),(2,1030),(2,1031),(2,1032),(2,1033),(2,1034),(2,1035),(2,1036),(2,1037),(2,1038),(2,1039),(2,1040),(2,1041),(2,1042),(2,1043),(2,1044),(2,1045),(2,1046),(2,1047),(2,1048),(2,1049),(2,1050),(2,1051),(2,1052),(2,1053),(2,1054),(2,1055),(2,1056),(2,1057),(2,1058),(2,1059),(2,1060);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,103,'admin','若依','00','ry@163.com','15888888888','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2025-01-03 20:29:32','admin','2024-12-31 16:03:47','','2025-01-03 21:29:32','管理员'),(2,105,'ry','若依','00','ry@qq.com','15666666666','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2024-12-31 16:03:47','admin','2024-12-31 16:03:47','',NULL,'测试员');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_post` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emp`
--

DROP TABLE IF EXISTS `tb_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_emp` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary key for employee',
  `user_name` varchar(50) NOT NULL COMMENT 'Employee name',
  `region_id` int NOT NULL COMMENT 'Associated region ID',
  `region_name` varchar(50) DEFAULT NULL COMMENT 'Region name',
  `role_id` int NOT NULL COMMENT 'Associated role ID',
  `role_code` varchar(10) DEFAULT NULL COMMENT 'Role code',
  `role_name` varchar(50) DEFAULT NULL COMMENT 'Role name',
  `mobile` varchar(15) DEFAULT NULL COMMENT 'Mobile phone number',
  `image` varchar(500) DEFAULT NULL COMMENT 'Profile picture',
  `status` tinyint(1) DEFAULT '1' COMMENT 'Status (1 active, 0 inactive)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last updated time',
  PRIMARY KEY (`id`),
  KEY `fk_region_id` (`region_id`),
  KEY `fk_role_id` (`role_id`),
  CONSTRAINT `fk_region_id` FOREIGN KEY (`region_id`) REFERENCES `tb_region` (`id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Employee table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emp`
--

LOCK TABLES `tb_emp` WRITE;
/*!40000 ALTER TABLE `tb_emp` DISABLE KEYS */;
INSERT INTO `tb_emp` VALUES (4,'1',1,NULL,1,NULL,'Admini','1','https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777e32ba2f4aad0a436dfe6.jpg,https://oasis-cloud.s3.ap-southeast-2.amazonaws.com/s3/2025/01/03/6777e37ca2f4aad0a436dfe7.JPG',1,'2025-01-01 09:10:16','2025-01-03 12:18:04');
/*!40000 ALTER TABLE `tb_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_region`
--

DROP TABLE IF EXISTS `tb_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_region` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary key for region',
  `region_name` varchar(255) NOT NULL COMMENT 'Region name',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last updated time',
  `create_by` varchar(64) DEFAULT NULL COMMENT 'Created by',
  `update_by` varchar(64) DEFAULT NULL COMMENT 'Updated by',
  `remark` text COMMENT 'Remarks',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Region table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_region`
--

LOCK TABLES `tb_region` WRITE;
/*!40000 ALTER TABLE `tb_region` DISABLE KEYS */;
INSERT INTO `tb_region` VALUES (1,'North America','2025-01-01 09:47:33','2025-01-01 09:47:33',NULL,NULL,NULL),(2,'Europe','2025-01-01 09:47:33','2025-01-01 09:47:33',NULL,NULL,NULL),(3,'Asia','2025-01-01 09:47:33','2025-01-01 09:47:33',NULL,NULL,NULL),(4,'Africa','2025-01-01 09:47:33','2025-01-01 09:47:33',NULL,NULL,NULL),(5,'South America','2025-01-01 09:47:33','2025-01-01 09:47:33',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary key for role',
  `role_code` varchar(50) NOT NULL COMMENT 'Role code',
  `role_name` varchar(50) NOT NULL COMMENT 'Role name',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Role table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES (1,'ADMIN','Admini'),(2,'USER','Regular User'),(3,'GUEST','Guest User');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-04 13:41:33

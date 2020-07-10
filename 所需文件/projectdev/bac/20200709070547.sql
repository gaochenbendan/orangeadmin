-- MySQL dump 10.13  Distrib 5.5.40, for Win64 (x86)
--
-- Host: localhost    Database: background
-- ------------------------------------------------------
-- Server version	5.5.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(1024) NOT NULL,
  `create_time` datetime NOT NULL,
  `reply_to` varchar(64) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlwqielki359fs4py1a4iw2fdt` (`customer_id`),
  KEY `FK7t8wpasnyrivxxk5957kej44f` (`goods_id`),
  CONSTRAINT `FK7t8wpasnyrivxxk5957kej44f` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `FKlwqielki359fs4py1a4iw2fdt` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `academy` varchar(15) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `grade` varchar(15) DEFAULT NULL,
  `head_pic` varchar(128) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `password` varchar(18) NOT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `school` varchar(15) DEFAULT NULL,
  `sn` varchar(18) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1e20u46s1ox7wauu41e6vso0o` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'大数据科学','2020-07-03 08:54:35','大二','1593778294171.png','19834341312','高晨帅哥','123456','330409764','山西工程技术学院','180713138',1),(2,'大数据科学','2020-07-05 10:36:36','大二','1593945503332.jpg','19834341312','胡乖乖','123456','1437292385','山西工程技术学院','180716035',1),(3,NULL,'2020-07-08 10:10:16',NULL,NULL,NULL,NULL,'123456','126356489',NULL,'180716032',1),(6,NULL,'2020-07-08 10:21:00',NULL,NULL,NULL,NULL,'123456','33409764',NULL,'180713139',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `database_bak`
--

DROP TABLE IF EXISTS `database_bak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `database_bak` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `filename` varchar(32) NOT NULL,
  `filepath` varchar(128) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `database_bak`
--

LOCK TABLES `database_bak` WRITE;
/*!40000 ALTER TABLE `database_bak` DISABLE KEYS */;
INSERT INTO `database_bak` VALUES (12,'2020-07-09 01:45:13','20200709094513.sql','D:\\projectdev\\bac\\','2020-07-09 01:45:13'),(13,'2020-07-09 01:45:52','20200709094552.sql','D:\\projectdev\\bac\\','2020-07-09 01:45:52'),(14,'2020-07-09 01:45:56','20200709094556.sql','D:\\projectdev\\bac\\','2020-07-09 01:45:56'),(15,'2020-07-09 11:05:47','20200709070547.sql','D:\\projectdev\\bac\\','2020-07-09 11:05:47');
/*!40000 ALTER TABLE `database_bak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `buy_price` float NOT NULL,
  `content` varchar(1024) NOT NULL,
  `flag` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `photo` varchar(128) NOT NULL,
  `recommend` int(11) NOT NULL,
  `sell_price` float NOT NULL,
  `status` int(11) NOT NULL,
  `view_number` int(11) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `goods_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsyssfteeatqhbvd5st3keiytj` (`customer_id`),
  KEY `FKdpbeg1u12cys5u9alkwb4g90e` (`goods_category_id`),
  CONSTRAINT `FKdpbeg1u12cys5u9alkwb4g90e` FOREIGN KEY (`goods_category_id`) REFERENCES `goods_category` (`id`),
  CONSTRAINT `FKsyssfteeatqhbvd5st3keiytj` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'2020-07-04 14:09:16','2020-07-05 10:37:37',9999,'我的心 想买吗 想买吗 想买吗 想买吗 想买吗',0,'我的心','1593930886489.jpg',1,9998,3,49,1,12),(2,'2020-07-04 14:30:38','2020-07-09 10:47:39',599,'刚买的海绵宝宝 现在就卖了 现在就卖了',1,'海绵宝宝','1593930982075.jpg',1,300,1,44,1,12),(3,'2020-07-05 08:08:39','2020-07-09 10:47:01',520,'加油祝福！！哥哥的加油祝福',1,'加油祝福','1593936498102.png',1,12,1,11,1,15),(6,'2020-07-05 13:48:39','2020-07-09 00:58:48',5,'最二的狗子你值得拥有',0,'二狗子','1593956893290.jpg',1,1,1,7,2,29),(7,'2020-07-05 14:00:18','2020-07-08 08:42:51',25,'萌萌的三狗子~~~~',0,'三狗子','1593957596069.jpg',0,2,1,14,2,29),(8,'2020-07-05 14:01:48','2020-07-08 10:14:20',99,'威武的大狗子~~~嗷嗷',0,'大狗子','1593957678843.jpg',0,15,1,7,2,29),(9,'2020-07-05 14:02:37','2020-07-08 06:59:59',75,'有理想的四狗子~~嗷嗷',0,'四狗子','1593957736150.jpg',0,26,1,14,2,29),(10,'2020-07-05 14:03:33','2020-07-05 14:31:39',568,'机器人~~~~~~滴答滴',1,'机器人~~~~~~','1593957795560.jpg',1,55,1,1,1,15),(11,'2020-07-05 14:04:37','2020-07-09 10:47:50',52,'卧倒的机器人~~~哐哧哐哧',1,'卧倒的机器人','1593957852767.jpg',1,16,1,2,1,26),(12,'2020-07-05 14:05:35','2020-07-09 10:49:31',15,'大山猫~~喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵',0,'大山猫喵','1593957916224.jpg',0,2,1,10,1,28),(13,'2020-07-05 14:06:17','2020-07-09 10:59:52',9999,'小奶猫~~嘤嘤嘤嘤嘤嘤嘤嘤嘤嘤嘤嘤',0,'小奶猫','1593957958722.jpg',0,6666,1,17,1,28),(15,'2020-07-08 10:21:55','2020-07-09 10:50:33',159,'压力球~~~~~~~~~~~~~~~~',0,'压力球','1594203713672.jpg',0,15,1,13,6,12);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_category`
--

DROP TABLE IF EXISTS `goods_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `name` varchar(18) NOT NULL,
  `sort` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkbi8714k65bs9dihfy4jc174w` (`parent_id`),
  CONSTRAINT `FKkbi8714k65bs9dihfy4jc174w` FOREIGN KEY (`parent_id`) REFERENCES `goods_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_category`
--

LOCK TABLES `goods_category` WRITE;
/*!40000 ALTER TABLE `goods_category` DISABLE KEYS */;
INSERT INTO `goods_category` VALUES (5,'2020-07-01 12:26:47','1593610761231.png','手机',1,NULL),(11,'2020-07-01 13:48:26','1593611294643.png','小米',3,5),(12,'2020-07-01 13:49:14','1593611352212.png','魅族',4,5),(13,'2020-07-01 13:50:04','1593611397078.png','电脑',5,NULL),(14,'2020-07-01 13:51:11','1593611446823.png','联想',6,13),(15,'2020-07-01 13:51:29','1593611480622.png','惠普',7,13),(17,'2020-07-02 02:57:33','1593658643750.png','华为',2,5),(18,'2020-07-02 05:37:55','1593668264569.png','耳机',8,NULL),(19,'2020-07-02 05:38:07','1593668281413.png','相机',9,NULL),(20,'2020-07-02 05:38:21','1593668293784.png','租房',10,NULL),(21,'2020-07-02 05:38:38','1593668306102.png','游戏相关',11,NULL),(22,'2020-07-02 05:39:02','1593668332283.png','交通工具',12,NULL),(23,'2020-07-02 05:39:54','1593668389337.png','衣服',13,NULL),(24,'2020-07-02 05:40:09','1593668401840.png','体育用品',14,NULL),(25,'2020-07-02 05:40:27','1593668416721.png','索尼',15,18),(26,'2020-07-03 06:41:17','1593758475448.png','阿迪王',16,23),(27,'2020-07-05 14:25:25','1593959113267.png','宠物',20,NULL),(28,'2020-07-05 14:25:45','1593959136059.png','猫',21,27),(29,'2020-07-05 14:26:06','1593959157719.png','狗子',22,27),(30,'2020-07-05 14:26:24','1593959174811.png','机器人',17,13);
/*!40000 ALTER TABLE `goods_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `is_button` bit(1) NOT NULL,
  `is_show` bit(1) NOT NULL,
  `name` varchar(18) NOT NULL,
  `sort` int(11) NOT NULL,
  `url` varchar(128) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `FKgeupubdqncc1lpgf2cn4fqwbc` (`parent_id`),
  CONSTRAINT `FKgeupubdqncc1lpgf2cn4fqwbc` FOREIGN KEY (`parent_id`) REFERENCES `menu` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2020-06-29 22:05:23','mdi-settings','\0','','系统设置',0,NULL,NULL),(2,'2020-06-29 22:10:22','mdi-plus','\0','','菜单管理',1,'/admin/menu/list',1),(3,'2020-06-29 22:16:04','mdi-plus','\0','','新增',2,'/admin/menu/add',2),(4,'2020-06-29 14:21:27','mdi-alert-octagram','\0','','角色管理',0,'/admin/role/list',1),(5,'2020-06-29 14:26:29','mdi-alpha','\0','','用户管理',0,'/admin/user/list',1),(6,'2020-06-29 15:34:27','mdi-behance','','','编辑',0,'edit(\'/admin/menu/edit\')',2),(7,'2020-06-29 15:35:25','mdi-biohazard','','','删除',0,'del(\'/admin/menu/delete\')',2),(9,'2020-06-29 15:40:27','mdi-amazon-clouddrive','\0','','新增',0,'/admin/role/add',4),(10,'2020-06-29 15:41:07','mdi-file-xml','','','编辑',0,'edit(\'/admin/role/edit\')',4),(11,'2020-06-29 15:41:48','mdi-earth','','','删除',0,'del(\'/admin/role/delete\')',4),(12,'2020-06-29 15:42:17','mdi-all-inclusive','\0','','新增',0,'/admin/user/add',5),(13,'2020-06-29 15:42:43','mdi-gate','','','编辑',0,'edit(\'/admin/user/edit\')',5),(14,'2020-06-29 15:43:06','mdi-format-underline','','','删除',0,'del(\'/admin/user/delete\')',5),(16,'2020-06-29 15:52:58','mdi-arrange-bring-to-front','\0','','日志管理',0,'/system/operator_log_list',1),(17,'2020-06-29 15:53:47','mdi-format-list-bulleted-type','','','删除',0,'del(\'/system/delete_log_list\')',16),(18,'2020-06-29 15:54:15','mdi-folder-plus','','','全部清除',0,'delAll(\'/system/delete_log_list_all\')',16),(19,'2020-06-29 15:59:18','mdi-angularjs','','','数据备份',0,'/admin/database_bak/list',1),(20,'2020-06-29 16:00:06','mdi-folder-multiple-outline','','','备份',0,'add(\'/admin/database_bak/add\')',19),(21,'2020-06-29 16:00:30','mdi-elevation-decline','','','删除',0,'del(\'/admin/database_bak/delete\')',19),(22,'2020-06-29 16:00:57','mdi-archive','','','还原',0,'restore(\'/admin/database_bak/restore\')',19),(23,'2020-06-30 09:31:13','mdi-fridge-filled-bottom','\0','','物品管理',0,'',NULL),(24,'2020-06-30 09:34:05','mdi-gamepad','','','分类管理',0,'/admin/good_category/list',23),(25,'2020-06-30 09:35:15','mdi-serial-port','','','物品管理',0,'/admin/goods/list',23),(26,'2020-06-30 09:36:09','mdi-folder-plus','\0','','新增',0,'/admin/good_category/add',24),(27,'2020-06-30 09:36:38','mdi-gesture','','','删减',0,'del(\'/admin/good_category/delete\')',24),(28,'2020-06-30 09:41:08','mdi-city','','','编辑',0,'edit(\'/admin/good_category/edit\')',24),(29,'2020-07-09 02:17:05','mdi-coins','','','上架',0,'up(\'/admin/goods/up_down\')',25),(30,'2020-07-09 02:18:40','mdi-angularjs','','','下架',0,'down(\'/admin/goods/updown\')',25),(31,'2020-07-09 02:20:24','mdi-delete','','','删除',0,'del(\'/admin/goods/delete\')',25),(32,'2020-07-09 10:34:03','mdi-heart-outline','','','推荐',0,'recommend(\'/admin/goods/recommend\')',25),(33,'2020-07-09 10:48:50','mdi-navigation','','','取消推荐',0,'unrecommend(\'/admin/goods/recommend\')',25);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operater_log`
--

DROP TABLE IF EXISTS `operater_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operater_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(128) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` int(11) NOT NULL,
  `operator` varchar(18) NOT NULL,
  `site_name` varchar(255) DEFAULT NULL,
  `updata_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=363 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operater_log`
--

LOCK TABLES `operater_log` WRITE;
/*!40000 ALTER TABLE `operater_log` DISABLE KEYS */;
INSERT INTO `operater_log` VALUES (335,'【高晨】登录于：【2020-07-09 16:45:45】','2020-07-09 08:45:45',1,'高晨','【登录于山西运城】','2020-07-09 08:45:45'),(336,'【高晨】登录于：【2020-07-09 17:00:12】','2020-07-09 09:00:12',1,'高晨','【登录于山西运城】','2020-07-09 09:00:12'),(337,'【高晨】登录于：【2020-07-09 17:02:44】','2020-07-09 09:02:44',1,'高晨','【登录于山西运城】','2020-07-09 09:02:44'),(338,'修改菜单信息:【上架】','2020-07-09 09:04:09',1,'高晨','【山西运城】','2020-07-09 09:04:09'),(339,'【高晨】登录于：【2020-07-09 17:04:47】','2020-07-09 09:04:47',1,'高晨','【登录于山西运城】','2020-07-09 09:04:47'),(340,'【高晨】登录于：【2020-07-09 17:08:24】','2020-07-09 09:08:25',1,'高晨','【登录于山西运城】','2020-07-09 09:08:25'),(341,'【高晨】登录于：【2020-07-09 17:09:45】','2020-07-09 09:09:45',1,'高晨','【登录于山西运城】','2020-07-09 09:09:45'),(342,'【高晨】登录于：【2020-07-09 17:11:00】','2020-07-09 09:11:00',1,'高晨','【登录于山西运城】','2020-07-09 09:11:00'),(343,'【高晨】登录于：【2020-07-09 17:16:35】','2020-07-09 09:16:35',1,'高晨','【登录于山西运城】','2020-07-09 09:16:35'),(344,'【高晨】登录于：【2020-07-09 18:31:59】','2020-07-09 10:31:59',1,'高晨','【登录于山西运城】','2020-07-09 10:31:59'),(345,'修改菜单信息:【删除】','2020-07-09 10:32:52',1,'高晨','【山西运城】','2020-07-09 10:32:52'),(346,'【高晨】登录于：【2020-07-09 18:32:59】','2020-07-09 10:32:59',1,'高晨','【登录于山西运城】','2020-07-09 10:32:59'),(347,'添加菜单信息:【推荐】','2020-07-09 10:34:03',1,'高晨','【山西运城】','2020-07-09 10:34:03'),(348,'修改菜单信息:【推荐】','2020-07-09 10:34:32',1,'高晨','【山西运城】','2020-07-09 10:34:32'),(349,'【高晨】登录于：【2020-07-09 18:45:21】','2020-07-09 10:45:21',1,'高晨','【登录于山西运城】','2020-07-09 10:45:21'),(350,'【高晨】登录于：【2020-07-09 18:46:27】','2020-07-09 10:46:27',1,'高晨','【登录于山西运城】','2020-07-09 10:46:27'),(351,'修改角色信息:名称-》【超级管理员】','2020-07-09 10:46:34',1,'高晨','【山西运城】','2020-07-09 10:46:34'),(352,'【高晨】登录于：【2020-07-09 18:46:49】','2020-07-09 10:46:49',1,'高晨','【登录于山西运城】','2020-07-09 10:46:49'),(353,'添加菜单信息:【取消推荐】','2020-07-09 10:48:50',1,'高晨','【山西运城】','2020-07-09 10:48:50'),(354,'修改菜单信息:【取消推荐】','2020-07-09 10:49:04',1,'高晨','【山西运城】','2020-07-09 10:49:04'),(355,'修改角色信息:名称-》【超级管理员】','2020-07-09 10:49:13',1,'高晨','【山西运城】','2020-07-09 10:49:13'),(356,'【高晨】登录于：【2020-07-09 18:49:21】','2020-07-09 10:49:21',1,'高晨','【登录于山西运城】','2020-07-09 10:49:21'),(357,'【高晨】登录于：【2020-07-09 18:50:46】','2020-07-09 10:50:46',1,'高晨','【登录于山西运城】','2020-07-09 10:50:46'),(358,'【高晨】登录于：【2020-07-09 18:54:13】','2020-07-09 10:54:13',1,'高晨','【登录于山西运城】','2020-07-09 10:54:13'),(359,'修改菜单信息:【删除】','2020-07-09 10:55:17',1,'高晨','【山西运城】','2020-07-09 10:55:17'),(360,'【高晨】登录于：【2020-07-09 18:55:57】','2020-07-09 10:55:57',1,'高晨','【登录于山西运城】','2020-07-09 10:55:57'),(361,'【高晨】登录于：【2020-07-09 18:57:38】','2020-07-09 10:57:38',1,'高晨','【登录于山西运城】','2020-07-09 10:57:38'),(362,'【高晨】登录于：【2020-07-09 19:05:06】','2020-07-09 11:05:06',1,'高晨','【登录于山西运城】','2020-07-09 11:05:06');
/*!40000 ALTER TABLE `operater_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_goods`
--

DROP TABLE IF EXISTS `report_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(1024) NOT NULL,
  `create_time` datetime NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKofrxmrqwghunf5n3bxbno5s1j` (`customer_id`),
  KEY `FK7hajssf4crp2enq3pn8c06kks` (`goods_id`),
  CONSTRAINT `FK7hajssf4crp2enq3pn8c06kks` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `FKofrxmrqwghunf5n3bxbno5s1j` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_goods`
--

LOCK TABLES `report_goods` WRITE;
/*!40000 ALTER TABLE `report_goods` DISABLE KEYS */;
INSERT INTO `report_goods` VALUES (4,'太可爱了吧','2020-07-08 08:34:50',1,8);
/*!40000 ALTER TABLE `report_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `name` varchar(18) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'2020-06-29 15:45:01','超级管理员','无敌的人',1,'2020-07-09 10:49:13');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_authorities`
--

DROP TABLE IF EXISTS `role_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_authorities` (
  `role_id` bigint(20) NOT NULL,
  `authorities_menu_id` bigint(20) NOT NULL,
  KEY `FKpetyx30axgd98wq1ox0ovmmy5` (`authorities_menu_id`),
  KEY `FK8dv2uo3imjpm4dmk7pge9v2vo` (`role_id`),
  CONSTRAINT `FK8dv2uo3imjpm4dmk7pge9v2vo` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKpetyx30axgd98wq1ox0ovmmy5` FOREIGN KEY (`authorities_menu_id`) REFERENCES `menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_authorities`
--

LOCK TABLES `role_authorities` WRITE;
/*!40000 ALTER TABLE `role_authorities` DISABLE KEYS */;
INSERT INTO `role_authorities` VALUES (2,1),(2,2),(2,3),(2,6),(2,7),(2,4),(2,9),(2,10),(2,11),(2,5),(2,12),(2,13),(2,14),(2,16),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,23),(2,24),(2,26),(2,27),(2,28),(2,25),(2,29),(2,30),(2,31),(2,32),(2,33);
/*!40000 ALTER TABLE `role_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_message`
--

DROP TABLE IF EXISTS `user_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creat_time` datetime NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `head_pic` varchar(128) DEFAULT NULL,
  `is_delete` int(11) NOT NULL,
  `net_name` varchar(20) NOT NULL,
  `password` varchar(18) NOT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `updata_time` datetime NOT NULL,
  `user_name` varchar(18) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jdrf7m77ddcvns8wd2xj785u2` (`user_name`),
  KEY `FKnl3qlcrce2kta5ycesbtjnkwy` (`role_id`),
  CONSTRAINT `FKnl3qlcrce2kta5ycesbtjnkwy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_message`
--

LOCK TABLES `user_message` WRITE;
/*!40000 ALTER TABLE `user_message` DISABLE KEYS */;
INSERT INTO `user_message` VALUES (2,'2020-07-08 14:07:02','330409764@qq.com','1594260836498.jpg',1,'高晨','123456','19834341312',1,1,'2020-07-09 02:13:58','admin',2);
/*!40000 ALTER TABLE `user_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wanted_goods`
--

DROP TABLE IF EXISTS `wanted_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wanted_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(1024) NOT NULL,
  `create_time` datetime NOT NULL,
  `name` varchar(32) NOT NULL,
  `sell_price` float NOT NULL,
  `trade_place` varchar(128) NOT NULL,
  `update_time` datetime NOT NULL,
  `view_number` int(11) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtmvmyjfpjmdc7k8yc7rn2pe2w` (`customer_id`),
  CONSTRAINT `FKtmvmyjfpjmdc7k8yc7rn2pe2w` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wanted_goods`
--

LOCK TABLES `wanted_goods` WRITE;
/*!40000 ALTER TABLE `wanted_goods` DISABLE KEYS */;
INSERT INTO `wanted_goods` VALUES (1,'一个活力鸟`~~~~~~~~~~~','2020-07-07 03:03:29','一个活力鸟',159,'西操场东北站台南门','2020-07-07 03:03:29',0,1),(3,'火星老狗快更新~~~~~~~~~~','2020-07-07 03:10:42','逆天',158,'西操场东北站台南门','2020-07-07 03:10:42',0,1),(4,'大菠萝手机~~~~来一个·····','2020-07-07 04:05:04','大菠萝手机',758,'西操场东北站台南门','2020-07-07 04:05:04',0,2);
/*!40000 ALTER TABLE `wanted_goods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-09 19:05:49

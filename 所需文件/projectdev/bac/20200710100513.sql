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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'这只猫咪好贵呀！！~~~','2020-07-10 01:17:57',NULL,1,13);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'大数据科学','2020-07-03 08:54:35','大二','1593778294171.png','19834341312','高晨帅哥','123456','330409764','山西工程技术学院','180713138',1),(2,'大数据科学','2020-07-05 10:36:36','大二','1593945503332.jpg','19834341312','胡乖乖','123456','1437292385','山西工程技术学院','180716035',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `database_bak`
--

LOCK TABLES `database_bak` WRITE;
/*!40000 ALTER TABLE `database_bak` DISABLE KEYS */;
INSERT INTO `database_bak` VALUES (15,'2020-07-09 11:05:47','20200709070547.sql','D:\\projectdev\\bac\\','2020-07-09 11:05:47'),(16,'2020-07-09 11:51:54','20200709075154.sql','D:\\projectdev\\bac\\','2020-07-09 11:51:54'),(17,'2020-07-10 14:05:13','20200710100513.sql','D:\\projectdev\\bac\\','2020-07-10 14:05:13');
/*!40000 ALTER TABLE `database_bak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_link`
--

DROP TABLE IF EXISTS `friend_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `name` varchar(64) NOT NULL,
  `sort` int(11) NOT NULL,
  `url` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_link`
--

LOCK TABLES `friend_link` WRITE;
/*!40000 ALTER TABLE `friend_link` DISABLE KEYS */;
INSERT INTO `friend_link` VALUES (1,'2020-07-10 10:35:03','山西',1,'http://www.shanxi.gov.cn/'),(4,'2020-07-10 10:36:25','运城',2,'https://baike.sogou.com/v80605.htm?fromTitle=%E8%BF%90%E5%9F%8E'),(5,'2020-07-10 10:46:46','绛县',3,'https://baike.sogou.com/v89528.htm?fromTitle=%E7%BB%9B%E5%8E%BF&ch=sogou.city.vr'),(6,'2020-07-10 11:32:45','后台登录',4,'http://127.0.0.1:8086/system/login');
/*!40000 ALTER TABLE `friend_link` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'2020-07-04 14:09:16','2020-07-10 13:33:05',9999,'我的心 想买吗 想买吗 想买吗 想买吗 想买吗',1,'我的心','1593930886489.jpg',1,9998,3,49,1,12),(2,'2020-07-04 14:30:38','2020-07-09 10:47:39',599,'刚买的海绵宝宝 现在就卖了 现在就卖了',1,'海绵宝宝','1593930982075.jpg',1,300,1,44,1,12),(3,'2020-07-05 08:08:39','2020-07-09 10:47:01',520,'加油祝福！！哥哥的加油祝福',1,'加油祝福','1593936498102.png',1,12,1,11,1,15),(6,'2020-07-05 13:48:39','2020-07-09 11:39:33',5,'最二的狗子你值得拥有',0,'二狗子','1593956893290.jpg',1,1,1,8,2,29),(7,'2020-07-05 14:00:18','2020-07-08 08:42:51',25,'萌萌的三狗子~~~~',0,'三狗子','1593957596069.jpg',0,2,1,14,2,29),(8,'2020-07-05 14:01:48','2020-07-08 10:14:20',99,'威武的大狗子~~~嗷嗷',0,'大狗子','1593957678843.jpg',0,15,1,7,2,29),(9,'2020-07-05 14:02:37','2020-07-10 08:26:50',75,'有理想的四狗子~~嗷嗷',0,'四狗子','1593957736150.jpg',0,26,1,15,2,29),(10,'2020-07-05 14:03:33','2020-07-10 01:19:42',568,'机器人~~~~~~滴答滴',1,'机器人~~~~~~','1593957795560.jpg',1,55,1,4,1,15),(11,'2020-07-05 14:04:37','2020-07-09 10:47:50',52,'卧倒的机器人~~~哐哧哐哧',1,'卧倒的机器人','1593957852767.jpg',1,16,1,2,1,26),(12,'2020-07-05 14:05:35','2020-07-10 14:02:55',15,'大山猫~~喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵',0,'大山猫喵','1593957916224.jpg',0,2,2,14,1,28),(13,'2020-07-05 14:06:17','2020-07-10 13:31:03',9999,'小奶猫~~嘤嘤嘤嘤嘤嘤嘤嘤嘤嘤嘤嘤',0,'小奶猫','1593957958722.jpg',0,6666,1,28,1,28),(16,'2020-07-09 11:38:02','2020-07-10 13:30:54',15,'小可爱的瞄瞄瞄瞄~~~~~~~~~',0,'小可爱','1594294659196.jpg',0,23,1,5,1,28);
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2020-06-29 22:05:23','mdi-settings','\0','','系统设置',0,NULL,NULL),(2,'2020-06-29 22:10:22','mdi-plus','\0','','菜单管理',1,'/admin/menu/list',1),(3,'2020-06-29 22:16:04','mdi-plus','\0','','新增',2,'/admin/menu/add',2),(4,'2020-06-29 14:21:27','mdi-alert-octagram','\0','','角色管理',0,'/admin/role/list',1),(5,'2020-06-29 14:26:29','mdi-alpha','\0','','用户管理',0,'/admin/user/list',1),(6,'2020-06-29 15:34:27','mdi-behance','','','编辑',0,'edit(\'/admin/menu/edit\')',2),(7,'2020-06-29 15:35:25','mdi-biohazard','','','删除',0,'del(\'/admin/menu/delete\')',2),(9,'2020-06-29 15:40:27','mdi-amazon-clouddrive','\0','','新增',0,'/admin/role/add',4),(10,'2020-06-29 15:41:07','mdi-file-xml','','','编辑',0,'edit(\'/admin/role/edit\')',4),(11,'2020-06-29 15:41:48','mdi-earth','','','删除',0,'del(\'/admin/role/delete\')',4),(12,'2020-06-29 15:42:17','mdi-all-inclusive','\0','','新增',0,'/admin/user/add',5),(13,'2020-06-29 15:42:43','mdi-gate','','','编辑',0,'edit(\'/admin/user/edit\')',5),(14,'2020-06-29 15:43:06','mdi-format-underline','','','删除',0,'del(\'/admin/user/delete\')',5),(16,'2020-06-29 15:52:58','mdi-arrange-bring-to-front','\0','','日志管理',0,'/system/operator_log_list',1),(17,'2020-06-29 15:53:47','mdi-format-list-bulleted-type','','','删除',0,'del(\'/system/delete_log_list\')',16),(18,'2020-06-29 15:54:15','mdi-folder-plus','','','全部清除',0,'delAll(\'/system/delete_log_list_all\')',16),(19,'2020-06-29 15:59:18','mdi-angularjs','','','数据备份',0,'/admin/database_bak/list',1),(20,'2020-06-29 16:00:06','mdi-folder-multiple-outline','','','备份',0,'add(\'/admin/database_bak/add\')',19),(21,'2020-06-29 16:00:30','mdi-elevation-decline','','','删除',0,'del(\'/admin/database_bak/delete\')',19),(22,'2020-06-29 16:00:57','mdi-archive','','','还原',0,'restore(\'/admin/database_bak/restore\')',19),(23,'2020-06-30 09:31:13','mdi-fridge-filled-bottom','\0','','物品管理',0,'',NULL),(24,'2020-06-30 09:34:05','mdi-gamepad','','','分类管理',0,'/admin/good_category/list',23),(25,'2020-06-30 09:35:15','mdi-serial-port','','','物品管理',0,'/admin/goods/list',23),(26,'2020-06-30 09:36:09','mdi-folder-plus','\0','','新增',0,'/admin/good_category/add',24),(27,'2020-06-30 09:36:38','mdi-gesture','','','删减',0,'del(\'/admin/good_category/delete\')',24),(28,'2020-06-30 09:41:08','mdi-city','','','编辑',0,'edit(\'/admin/good_category/edit\')',24),(29,'2020-07-09 02:17:05','mdi-coins','','','上架',0,'up(\'/admin/goods/up_down\')',25),(30,'2020-07-09 02:18:40','mdi-angularjs','','','下架',0,'down(\'/admin/goods/updown\')',25),(31,'2020-07-09 02:20:24','mdi-delete','','','删除',0,'del(\'/admin/goods/delete\')',25),(32,'2020-07-09 10:34:03','mdi-heart-outline','','','推荐',0,'recommend(\'/admin/goods/recommend\')',25),(33,'2020-07-09 10:48:50','mdi-navigation','','','取消推荐',0,'unrecommend(\'/admin/goods/recommend\')',25),(34,'2020-07-09 11:21:22','mdi-flag','','','求购管理',0,'/admin/wanted_goods/list',23),(35,'2020-07-09 11:31:01','mdi-seat-legroom-normal','','','删除',0,'del(\'/admin/wanted_goods/delete\')',34),(36,'2020-07-09 11:49:06','mdi-account-switch','','','用户管理',0,'',NULL),(37,'2020-07-09 11:53:59','mdi-account-settings','','','用户列表',0,'/admin/customer/list',36),(38,'2020-07-09 11:55:29','mdi-thought-bubble','','','冻结',0,'freeze(\'/admin/customer/update_status\')',37),(39,'2020-07-09 11:57:18','mdi-account-settings-variant','','','激活',0,'openStudent(\'/admin/customer/update_status\')',37),(40,'2020-07-09 11:58:31','mdi-flashlight-off','','','删除',0,'del(\'/admin/customer/delete\')',37),(41,'2020-07-10 00:37:56','mdi-message-settings','\0','','评论列表',0,'/admin/comment/list',36),(42,'2020-07-10 00:41:02','mdi-home-outline','','','删除',0,'del(\'/admin/comment/delete\')',41),(43,'2020-07-10 02:02:48','mdi-code-greater-than','\0','','举报列表',0,'/admin/reporter/list',36),(44,'2020-07-10 02:03:21','mdi-bomb-off','','','删除',0,'del(\'/admin/reporter/delete\')',43),(45,'2020-07-10 03:18:04','mdi-dip-switch','','','消息管理',0,'',NULL),(46,'2020-07-10 03:18:36','mdi-apple-safari','\0','','新闻列表',0,'/admin/news/list',45),(47,'2020-07-10 03:19:26','mdi-cube-outline','\0','','新增',0,'/admin/news/add',46),(48,'2020-07-10 03:19:51','mdi-call-missed','','','编辑',0,'edit(\'/admin/news/edit\')',46),(49,'2020-07-10 03:20:23','mdi-home-map-marker','','','删除',0,'del(\'/admin/news/delete\')',46),(50,'2020-07-10 10:24:32','mdi-access-point','\0','','友情链接',0,'/admin/friend_link/list',45),(51,'2020-07-10 10:25:15','mdi-google-circles','\0','','新增',0,'/admin/friend_link/add',50),(52,'2020-07-10 10:27:50','mdi-camera-metering-partial','','','编辑',0,'edit(\'/admin/friend_link/edit\')',50),(53,'2020-07-10 10:28:18','mdi-food-fork-drink','','','删除',0,'del(\'/admin/friend_link/delete\')',50),(54,'2020-07-10 12:01:28','mdi-all-inclusive','\0','','网页设置',0,'/admin/site_setting/setting',1),(55,'2020-07-10 13:02:13','mdi-angularjs','\0','\0','保存',0,'/admin/site_setting/save_setting',54),(56,'2020-07-10 13:21:48','mdi-emoticon','','','彩蛋！！',0,'',45);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(10024) NOT NULL,
  `create_time` datetime NOT NULL,
  `sort` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,
  `update_time` datetime NOT NULL,
  `view_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (4,'1.正品承诺：橙子网出售的大部分商品已获得品牌商或总代授权，进货渠道正规，所出售的产品均为正品行货，承诺假一罚二。\r\n\r\n2.平民价格：橙子网在产品定价上以让利顾客为主，更为合理的价格就能让顾客享受到专业体育器材的品质；再加上网站定期会推出 厂家让利活动，所以不再议价。\r\n\r\n3.产品色差：所有产品均为实物拍摄，我们的照片尽可能的与实物颜色保持一致，货品图片颜色大小因拍摄或计算机屏幕设定产生差异会 略有不同，以实际货品颜色大小为准\r\n\r\n4.关于缺货：橙子网所上架的商品在销售过程中可能出现短期缺货的情况，而没有及时下架，造成您的订单中产品缺货的，动品网会及时告知，您可以根据自己的情况进行退款，取消订单或者换货。','2020-07-10 08:00:48',1,'购物须知','2020-07-10 10:09:11',20),(5,'0、求购与卖出者达成私下交易，平台不提供交易服务\r\n\r\n1、不要在网吧，图书馆等公共场合使用支付宝。 支付宝上面有个人的账户信息，有的还有资金。尽量不要网吧，图书馆等地方使用支付宝了\r\n\r\n2、采用官方推荐和提供的方法。 使用支付宝的时候，要注意官方推荐的安全支付方法。如绑定手机号，实名认证，安装数字证书，有必要的话开通宝令。总之，让支付宝的安全等级高一点。自然安全系数也会高一点;\r\n\r\n3、及时关注官方安全中心，留意支付宝诈骗伎俩和防范方法。 这一点，支付宝的官方论坛到处都是。因此，偶尔去那里逛一下，增长一点知识和见闻，也是很有必要的。比如，假冒的支付宝客服和邮箱，这些简单地诈骗伎俩一定要学会防范;\r\n\r\n4、登录密码和支付密码不要太简单了。支付宝官方已经要求用户在设置密码的时候不要太简单了，要使用字母数字符号的组合键设置，也建议将登录密码和支付密码设置成不一样的密码;\r\n\r\n5、不建议手机蹭网时使用支付宝。现在很多人的手机都安装了支付宝钱包，手机上使用支付宝钱包的时候，记得设置一个手势密码。有的人喜欢蹭网使用免费wifi，这里要注意了，很多免费的wifi的安全性不高，不建议蹭网时用支付宝。','2020-07-10 08:05:51',2,'支付须知','2020-07-10 09:54:18',4),(6,'请联系开发人员\r\nqq：330409764\r\n邮箱：330409764@qq.com\r\n微信：gc13994993711','2020-07-10 09:05:45',3,'关于BUG','2020-07-10 09:47:28',1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=532 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operater_log`
--

LOCK TABLES `operater_log` WRITE;
/*!40000 ALTER TABLE `operater_log` DISABLE KEYS */;
INSERT INTO `operater_log` VALUES (429,'【高晨】登录于：【2020-07-10 10:01:59】','2020-07-10 02:01:59',1,'高晨','【登录于山西运城】','2020-07-10 02:01:59'),(430,'添加菜单信息:【举报列表】','2020-07-10 02:02:48',1,'高晨','【山西运城】','2020-07-10 02:02:48'),(431,'添加菜单信息:【删除】','2020-07-10 02:03:21',1,'高晨','【山西运城】','2020-07-10 02:03:21'),(432,'修改角色信息:名称-》【超级管理员】','2020-07-10 02:03:27',1,'高晨','【山西运城】','2020-07-10 02:03:27'),(433,'【高晨】登录于：【2020-07-10 10:03:33】','2020-07-10 02:03:33',1,'高晨','【登录于山西运城】','2020-07-10 02:03:33'),(434,'【高晨】登录于：【2020-07-10 10:04:32】','2020-07-10 02:04:32',1,'高晨','【登录于山西运城】','2020-07-10 02:04:32'),(435,'用户登录:学号为【180713138】','2020-07-10 02:08:07',1,'消费者日志','【山西运城】','2020-07-10 02:08:07'),(436,'【高晨】登录于：【2020-07-10 11:17:27】','2020-07-10 03:17:27',1,'高晨','【登录于山西运城】','2020-07-10 03:17:27'),(437,'添加菜单信息:【新闻管理】','2020-07-10 03:18:04',1,'高晨','【山西运城】','2020-07-10 03:18:04'),(438,'添加菜单信息:【新闻列表】','2020-07-10 03:18:36',1,'高晨','【山西运城】','2020-07-10 03:18:36'),(439,'添加菜单信息:【新增】','2020-07-10 03:19:26',1,'高晨','【山西运城】','2020-07-10 03:19:26'),(440,'添加菜单信息:【编辑】','2020-07-10 03:19:51',1,'高晨','【山西运城】','2020-07-10 03:19:51'),(441,'添加菜单信息:【删除】','2020-07-10 03:20:23',1,'高晨','【山西运城】','2020-07-10 03:20:23'),(442,'修改角色信息:名称-》【超级管理员】','2020-07-10 03:21:08',1,'高晨','【山西运城】','2020-07-10 03:21:08'),(443,'【高晨】登录于：【2020-07-10 11:21:15】','2020-07-10 03:21:15',1,'高晨','【登录于山西运城】','2020-07-10 03:21:15'),(444,'【高晨】登录于：【2020-07-10 11:22:55】','2020-07-10 03:22:55',1,'高晨','【登录于山西运城】','2020-07-10 03:22:55'),(445,'【高晨】登录于：【2020-07-10 11:26:25】','2020-07-10 03:26:25',1,'高晨','【登录于山西运城】','2020-07-10 03:26:25'),(446,'【高晨】登录于：【2020-07-10 11:27:23】','2020-07-10 03:27:23',1,'高晨','【登录于山西运城】','2020-07-10 03:27:23'),(447,'【高晨】登录于：【2020-07-10 11:28:47】','2020-07-10 03:28:47',1,'高晨','【登录于山西运城】','2020-07-10 03:28:47'),(448,'【高晨】登录于：【2020-07-10 11:29:16】','2020-07-10 03:29:16',1,'高晨','【登录于山西运城】','2020-07-10 03:29:16'),(449,'【高晨】登录于：【2020-07-10 11:30:50】','2020-07-10 03:30:50',1,'高晨','【登录于山西运城】','2020-07-10 03:30:50'),(450,'修改菜单信息:【编辑】','2020-07-10 03:34:00',1,'高晨','【山西运城】','2020-07-10 03:34:00'),(451,'新增新闻信息:ID-》【1】','2020-07-10 03:43:31',1,'admin','【山西运城】','2020-07-10 03:43:31'),(452,'删除新闻信息:ID-》【1】','2020-07-10 03:43:38',1,'admin','【山西运城】','2020-07-10 03:43:38'),(453,'新增新闻信息:ID-》【2】','2020-07-10 03:49:04',1,'admin','【山西运城】','2020-07-10 03:49:04'),(454,'新增新闻信息:ID-》【3】','2020-07-10 03:49:16',1,'admin','【山西运城】','2020-07-10 03:49:16'),(455,'删除新闻信息:ID-》【2】','2020-07-10 03:49:46',1,'admin','【山西运城】','2020-07-10 03:49:46'),(456,'【高晨】登录于：【2020-07-10 12:00:23】','2020-07-10 04:00:23',1,'高晨','【登录于山西运城】','2020-07-10 04:00:23'),(457,'【高晨】登录于：【2020-07-10 12:02:31】','2020-07-10 04:02:31',1,'高晨','【登录于山西运城】','2020-07-10 04:02:31'),(458,'【高晨】登录于：【2020-07-10 12:03:56】','2020-07-10 04:03:56',1,'高晨','【登录于山西运城】','2020-07-10 04:03:56'),(459,'编辑新闻信息:ID-》【3】','2020-07-10 04:05:27',1,'admin','【山西运城】','2020-07-10 04:05:27'),(460,'【高晨】登录于：【2020-07-10 15:59:17】','2020-07-10 07:59:17',1,'高晨','【登录于山西运城】','2020-07-10 07:59:17'),(461,'新增新闻信息:ID-》【4】','2020-07-10 08:00:48',1,'admin','【山西运城】','2020-07-10 08:00:48'),(462,'新增新闻信息:ID-》【5】','2020-07-10 08:05:51',1,'admin','【山西运城】','2020-07-10 08:05:51'),(463,'删除新闻信息:ID-》【3】','2020-07-10 08:05:56',1,'admin','【山西运城】','2020-07-10 08:05:56'),(464,'编辑新闻信息:ID-》【4】','2020-07-10 08:07:10',1,'admin','【山西运城】','2020-07-10 08:07:10'),(465,'编辑新闻信息:ID-》【4】','2020-07-10 08:07:26',1,'admin','【山西运城】','2020-07-10 08:07:26'),(466,'【高晨】登录于：【2020-07-10 16:08:58】','2020-07-10 08:08:58',1,'高晨','【登录于山西运城】','2020-07-10 08:08:58'),(467,'【高晨】登录于：【2020-07-10 16:34:21】','2020-07-10 08:34:21',1,'高晨','【登录于山西运城】','2020-07-10 08:34:21'),(468,'用户登录:学号为【180713138】','2020-07-10 08:37:33',1,'消费者日志','【山西运城】','2020-07-10 08:37:33'),(469,'【高晨】登录于：【2020-07-10 17:04:47】','2020-07-10 09:04:47',1,'高晨','【登录于山西运城】','2020-07-10 09:04:47'),(470,'新增新闻信息:ID-》【6】','2020-07-10 09:05:45',1,'admin','【山西运城】','2020-07-10 09:05:45'),(471,'【高晨】登录于：【2020-07-10 17:26:27】','2020-07-10 09:26:27',1,'高晨','【登录于山西运城】','2020-07-10 09:26:27'),(472,'用户登录:学号为【180713138】','2020-07-10 09:47:21',1,'消费者日志','【山西运城】','2020-07-10 09:47:21'),(473,'用户登录:学号为【180716035】','2020-07-10 10:09:31',1,'消费者日志','【山西运城】','2020-07-10 10:09:31'),(474,'用户登录:学号为【180716035】','2020-07-10 10:22:29',1,'消费者日志','【山西运城】','2020-07-10 10:22:29'),(475,'【高晨】登录于：【2020-07-10 18:22:42】','2020-07-10 10:22:42',1,'高晨','【登录于山西运城】','2020-07-10 10:22:42'),(476,'修改菜单信息:【消息管理】','2020-07-10 10:23:16',1,'高晨','【山西运城】','2020-07-10 10:23:16'),(477,'修改菜单信息:【消息管理】','2020-07-10 10:23:16',1,'高晨','【山西运城】','2020-07-10 10:23:16'),(478,'修改菜单信息:【消息管理】','2020-07-10 10:23:16',1,'高晨','【山西运城】','2020-07-10 10:23:16'),(479,'修改菜单信息:【消息管理】','2020-07-10 10:23:16',1,'高晨','【山西运城】','2020-07-10 10:23:16'),(480,'添加菜单信息:【友情链接】','2020-07-10 10:24:32',1,'高晨','【山西运城】','2020-07-10 10:24:32'),(481,'修改菜单信息:【友情链接】','2020-07-10 10:24:47',1,'高晨','【山西运城】','2020-07-10 10:24:47'),(482,'添加菜单信息:【新增】','2020-07-10 10:25:15',1,'高晨','【山西运城】','2020-07-10 10:25:15'),(483,'添加菜单信息:【编辑】','2020-07-10 10:27:50',1,'高晨','【山西运城】','2020-07-10 10:27:50'),(484,'添加菜单信息:【删除】','2020-07-10 10:28:18',1,'高晨','【山西运城】','2020-07-10 10:28:18'),(485,'修改角色信息:名称-》【超级管理员】','2020-07-10 10:28:30',1,'高晨','【山西运城】','2020-07-10 10:28:30'),(486,'修改菜单信息:【删除】','2020-07-10 10:28:46',1,'高晨','【山西运城】','2020-07-10 10:28:46'),(487,'修改角色信息:名称-》【超级管理员】','2020-07-10 10:28:58',1,'高晨','【山西运城】','2020-07-10 10:28:58'),(488,'【高晨】登录于：【2020-07-10 18:29:04】','2020-07-10 10:29:04',1,'高晨','【登录于山西运城】','2020-07-10 10:29:04'),(489,'【高晨】登录于：【2020-07-10 18:34:22】','2020-07-10 10:34:22',1,'高晨','【登录于山西运城】','2020-07-10 10:34:22'),(490,'修改菜单信息:【编辑】','2020-07-10 10:39:19',1,'高晨','【山西运城】','2020-07-10 10:39:19'),(491,'【高晨】登录于：【2020-07-10 18:39:30】','2020-07-10 10:39:30',1,'高晨','【登录于山西运城】','2020-07-10 10:39:30'),(492,'【高晨】登录于：【2020-07-10 18:40:33】','2020-07-10 10:40:33',1,'高晨','【登录于山西运城】','2020-07-10 10:40:33'),(493,'【高晨】登录于：【2020-07-10 18:41:32】','2020-07-10 10:41:32',1,'高晨','【登录于山西运城】','2020-07-10 10:41:32'),(494,'【高晨】登录于：【2020-07-10 18:46:18】','2020-07-10 10:46:18',1,'高晨','【登录于山西运城】','2020-07-10 10:46:18'),(495,'用户登录:学号为【180713138】','2020-07-10 11:31:18',1,'消费者日志','【山西运城】','2020-07-10 11:31:18'),(496,'【高晨】登录于：【2020-07-10 19:32:30】','2020-07-10 11:32:30',1,'高晨','【登录于山西运城】','2020-07-10 11:32:30'),(497,'【高晨】登录于：【2020-07-10 19:35:26】','2020-07-10 11:35:26',1,'高晨','【登录于山西运城】','2020-07-10 11:35:26'),(498,'【高晨】登录于：【2020-07-10 19:58:57】','2020-07-10 11:58:57',1,'高晨','【登录于山西运城】','2020-07-10 11:58:57'),(499,'添加菜单信息:【网页设置】','2020-07-10 12:01:28',1,'高晨','【山西运城】','2020-07-10 12:01:28'),(500,'修改角色信息:名称-》【超级管理员】','2020-07-10 12:02:00',1,'高晨','【山西运城】','2020-07-10 12:02:00'),(501,'【高晨】登录于：【2020-07-10 20:02:11】','2020-07-10 12:02:11',1,'高晨','【登录于山西运城】','2020-07-10 12:02:11'),(502,'【高晨】登录于：【2020-07-10 20:34:25】','2020-07-10 12:34:25',1,'高晨','【登录于山西运城】','2020-07-10 12:34:25'),(503,'【高晨】登录于：【2020-07-10 20:51:36】','2020-07-10 12:51:36',1,'高晨','【登录于山西运城】','2020-07-10 12:51:36'),(504,'【高晨】登录于：【2020-07-10 21:00:00】','2020-07-10 13:00:00',1,'高晨','【登录于山西运城】','2020-07-10 13:00:00'),(505,'【高晨】登录于：【2020-07-10 21:00:30】','2020-07-10 13:00:30',1,'高晨','【登录于山西运城】','2020-07-10 13:00:30'),(506,'添加菜单信息:【保存】','2020-07-10 13:02:13',1,'高晨','【山西运城】','2020-07-10 13:02:13'),(507,'修改角色信息:名称-》【超级管理员】','2020-07-10 13:02:21',1,'高晨','【山西运城】','2020-07-10 13:02:21'),(508,'【高晨】登录于：【2020-07-10 21:02:31】','2020-07-10 13:02:31',1,'高晨','【登录于山西运城】','2020-07-10 13:02:31'),(509,'【高晨】登录于：【2020-07-10 21:06:54】','2020-07-10 13:06:54',1,'高晨','【登录于山西运城】','2020-07-10 13:06:54'),(510,'【高晨】登录于：【2020-07-10 21:18:28】','2020-07-10 13:18:28',1,'高晨','【登录于山西运城】','2020-07-10 13:18:28'),(511,'修改菜单信息:【友情链接】','2020-07-10 13:19:47',1,'高晨','【山西运城】','2020-07-10 13:19:47'),(512,'【高晨】登录于：【2020-07-10 21:19:53】','2020-07-10 13:19:53',1,'高晨','【登录于山西运城】','2020-07-10 13:19:53'),(513,'添加菜单信息:【彩蛋！！】','2020-07-10 13:21:48',1,'高晨','【山西运城】','2020-07-10 13:21:48'),(514,'修改角色信息:名称-》【超级管理员】','2020-07-10 13:22:00',1,'高晨','【山西运城】','2020-07-10 13:22:00'),(515,'【高晨】登录于：【2020-07-10 21:22:06】','2020-07-10 13:22:06',1,'高晨','【登录于山西运城】','2020-07-10 13:22:06'),(516,'修改菜单信息:【彩蛋！！】','2020-07-10 13:22:21',1,'高晨','【山西运城】','2020-07-10 13:22:21'),(517,'修改角色信息:名称-》【超级管理员】','2020-07-10 13:22:28',1,'高晨','【山西运城】','2020-07-10 13:22:28'),(518,'【高晨】登录于：【2020-07-10 21:22:35】','2020-07-10 13:22:35',1,'高晨','【登录于山西运城】','2020-07-10 13:22:35'),(519,'用户登录:学号为【180713138】','2020-07-10 13:32:47',1,'消费者日志','【山西运城】','2020-07-10 13:32:47'),(520,'修改了自己的信息:学号为【1】','2020-07-10 13:41:50',1,'消费者日志','【山西运城】','2020-07-10 13:41:50'),(521,'修改了自己的信息:学号为【1】','2020-07-10 13:43:46',1,'消费者日志','【山西运城】','2020-07-10 13:43:46'),(522,'修改了自己的信息:学号为【1】','2020-07-10 13:45:30',1,'消费者日志','【山西运城】','2020-07-10 13:45:30'),(523,'修改了自己的信息:学号为【1】','2020-07-10 13:45:31',1,'消费者日志','【山西运城】','2020-07-10 13:45:31'),(524,'修改了自己的信息:学号为【1】','2020-07-10 13:45:33',1,'消费者日志','【山西运城】','2020-07-10 13:45:33'),(525,'修改了自己的信息:学号为【1】','2020-07-10 13:46:13',1,'消费者日志','【山西运城】','2020-07-10 13:46:13'),(526,'修改了自己的信息:学号为【1】','2020-07-10 13:48:07',1,'消费者日志','【山西运城】','2020-07-10 13:48:07'),(527,'用户登录:学号为【180713138】','2020-07-10 13:54:51',1,'消费者日志','【山西运城】','2020-07-10 13:54:51'),(528,'用户登录:学号为【180713138】','2020-07-10 13:55:08',1,'消费者日志','【山西运城】','2020-07-10 13:55:08'),(529,'用户登录:学号为【180713138】','2020-07-10 14:02:08',1,'消费者日志','【山西运城】','2020-07-10 14:02:08'),(530,'【高晨】登录于：【2020-07-10 22:02:45】','2020-07-10 14:02:45',1,'高晨','【登录于山西运城】','2020-07-10 14:02:45'),(531,'修改了自己的信息:学号为【1】','2020-07-10 14:03:01',1,'消费者日志','【山西运城】','2020-07-10 14:03:01');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'2020-06-29 15:45:01','超级管理员','无敌的人',1,'2020-07-10 13:22:28');
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
INSERT INTO `role_authorities` VALUES (2,1),(2,2),(2,3),(2,6),(2,7),(2,4),(2,9),(2,10),(2,11),(2,5),(2,12),(2,13),(2,14),(2,16),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,54),(2,55),(2,23),(2,24),(2,26),(2,27),(2,28),(2,25),(2,29),(2,30),(2,31),(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),(2,39),(2,40),(2,41),(2,42),(2,43),(2,44),(2,45),(2,46),(2,47),(2,48),(2,49),(2,50),(2,51),(2,52),(2,53),(2,56);
/*!40000 ALTER TABLE `role_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_setting`
--

DROP TABLE IF EXISTS `site_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `all_rights` varchar(256) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `logo_1` varchar(256) NOT NULL,
  `logo_2` varchar(256) NOT NULL,
  `qrcode` varchar(256) NOT NULL,
  `site_name` varchar(128) NOT NULL,
  `site_url` varchar(256) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_setting`
--

LOCK TABLES `site_setting` WRITE;
/*!40000 ALTER TABLE `site_setting` DISABLE KEYS */;
INSERT INTO `site_setting` VALUES (1,'©2020 orange公司 版权所有 开发By orange','2020-07-10 13:07:34','1594387654673.jpg','1594386590340.png','1594386595273.jpg','橙子-二手交易平台','http://127.0.0.1:8086/home/index/index','2020-07-10 13:27:36');
/*!40000 ALTER TABLE `site_setting` ENABLE KEYS */;
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
INSERT INTO `user_message` VALUES (2,'2020-07-08 14:07:02','330409764@qq.com','1594387156021.jpg',1,'高晨','123456','19834341312',1,1,'2020-07-10 13:19:17','admin',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wanted_goods`
--

LOCK TABLES `wanted_goods` WRITE;
/*!40000 ALTER TABLE `wanted_goods` DISABLE KEYS */;
INSERT INTO `wanted_goods` VALUES (2,'一个活力鸟一个活力鸟一个活力鸟','2020-07-10 02:08:59','一个活力鸟',12,'西操场东北站台南门','2020-07-10 02:08:59',0,1),(3,'一个兔子~~~~~~~~~一个兔子','2020-07-10 02:09:18','一个兔子',189,'西操场东北站台南门','2020-07-10 02:09:18',0,1);
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

-- Dump completed on 2020-07-10 22:05:15

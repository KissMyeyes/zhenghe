/*
MySQL Backup
Database: test
Backup Time: 2018-11-15 14:51:19
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `test`.`admin`;
DROP TABLE IF EXISTS `test`.`city`;
DROP TABLE IF EXISTS `test`.`country`;
DROP TABLE IF EXISTS `test`.`permission`;
DROP TABLE IF EXISTS `test`.`role`;
DROP TABLE IF EXISTS `test`.`role_permission`;
DROP TABLE IF EXISTS `test`.`user`;
DROP TABLE IF EXISTS `test`.`user_role`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT '',
  `password` varchar(20) DEFAULT '',
  `nick_name` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `is_del` int(11) DEFAULT '0',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='市级信息';
CREATE TABLE `country` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8 COMMENT='国家信息';
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮id',
  `parent_id` bigint(20) NOT NULL COMMENT '上级菜单id',
  `permission_name` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单url',
  `perms` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `type` char(2) NOT NULL COMMENT '类型 0菜单 1按钮',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '菜单/按钮id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(64) NOT NULL COMMENT '姓名',
  `real_name` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `locked` char(1) NOT NULL COMMENT '状态 0锁定 1有效',
  `crate_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近访问时间',
  `ssex` char(1) DEFAULT NULL COMMENT '性别 0男 1女',
  `theme` varchar(10) DEFAULT NULL COMMENT '主题',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `test`.`admin` WRITE;
DELETE FROM `test`.`admin`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `test`.`city` WRITE;
DELETE FROM `test`.`city`;
INSERT INTO `test`.`city` (`id`,`name`,`state`) VALUES (1, '石家庄', '河北'),(2, '邯郸', '河北'),(3, '上海1987', '上海');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `test`.`country` WRITE;
DELETE FROM `test`.`country`;
INSERT INTO `test`.`country` (`Id`,`countryname`,`countrycode`) VALUES (1, 'Angola', 'AO'),(2, 'Afghanistan', 'AF'),(3, 'Albania', 'AL'),(4, 'Algeria', 'DZ'),(5, 'Andorra', 'AD'),(6, 'Anguilla', 'AI'),(7, 'Antigua and Barbuda', 'AG'),(8, 'Argentina', 'AR'),(9, 'Armenia', 'AM'),(10, 'Australia', 'AU'),(11, 'Austria', 'AT'),(12, 'Azerbaijan', 'AZ'),(13, 'Bahamas', 'BS'),(14, 'Bahrain', 'BH'),(15, 'Bangladesh', 'BD'),(16, 'Barbados', 'BB'),(17, 'Belarus', 'BY'),(18, 'Belgium', 'BE'),(19, 'Belize', 'BZ'),(20, 'Benin', 'BJ'),(21, 'Bermuda Is.', 'BM'),(22, 'Bolivia', 'BO'),(23, 'Botswana', 'BW'),(24, 'Brazil', 'BR'),(25, 'Brunei', 'BN'),(26, 'Bulgaria', 'BG'),(27, 'Burkina-faso', 'BF'),(28, 'Burma', 'MM'),(29, 'Burundi', 'BI'),(30, 'Cameroon', 'CM'),(31, 'Canada', 'CA'),(32, 'Central African Republic', 'CF'),(33, 'Chad', 'TD'),(34, 'Chile', 'CL'),(35, 'China', 'CN'),(36, 'Colombia', 'CO'),(37, 'Congo', 'CG'),(38, 'Cook Is.', 'CK'),(39, 'Costa Rica', 'CR'),(40, 'Cuba', 'CU'),(41, 'Cyprus', 'CY'),(42, 'Czech Republic', 'CZ'),(43, 'Denmark', 'DK'),(44, 'Djibouti', 'DJ'),(45, 'Dominica Rep.', 'DO'),(46, 'Ecuador', 'EC'),(47, 'Egypt', 'EG'),(48, 'EI Salvador', 'SV'),(49, 'Estonia', 'EE'),(50, 'Ethiopia', 'ET'),(51, 'Fiji', 'FJ'),(52, 'Finland', 'FI'),(53, 'France', 'FR'),(54, 'French Guiana', 'GF'),(55, 'Gabon', 'GA'),(56, 'Gambia', 'GM'),(57, 'Georgia', 'GE'),(58, 'Germany', 'DE'),(59, 'Ghana', 'GH'),(60, 'Gibraltar', 'GI'),(61, 'Greece', 'GR'),(62, 'Grenada', 'GD'),(63, 'Guam', 'GU'),(64, 'Guatemala', 'GT'),(65, 'Guinea', 'GN'),(66, 'Guyana', 'GY'),(67, 'Haiti', 'HT'),(68, 'Honduras', 'HN'),(69, 'Hongkong', 'HK'),(70, 'Hungary', 'HU'),(71, 'Iceland', 'IS'),(72, 'India', 'IN'),(73, 'Indonesia', 'ID'),(74, 'Iran', 'IR'),(75, 'Iraq', 'IQ'),(76, 'Ireland', 'IE'),(77, 'Israel', 'IL'),(78, 'Italy', 'IT'),(79, 'Jamaica', 'JM'),(80, 'Japan', 'JP'),(81, 'Jordan', 'JO'),(82, 'Kampuchea (Cambodia )', 'KH'),(83, 'Kazakstan', 'KZ'),(84, 'Kenya', 'KE'),(85, 'Korea', 'KR'),(86, 'Kuwait', 'KW'),(87, 'Kyrgyzstan', 'KG'),(88, 'Laos', 'LA'),(89, 'Latvia', 'LV'),(90, 'Lebanon', 'LB'),(91, 'Lesotho', 'LS'),(92, 'Liberia', 'LR'),(93, 'Libya', 'LY'),(94, 'Liechtenstein', 'LI'),(95, 'Lithuania', 'LT'),(96, 'Luxembourg', 'LU'),(97, 'Macao', 'MO'),(98, 'Madagascar', 'MG'),(99, 'Malawi', 'MW'),(100, 'Malaysia', 'MY'),(101, 'Maldives', 'MV'),(102, 'Mali', 'ML'),(103, 'Malta', 'MT'),(104, 'Mauritius', 'MU'),(105, 'Mexico', 'MX'),(106, 'Moldova, Republic of', 'MD'),(107, 'Monaco', 'MC'),(108, 'Mongolia', 'MN'),(109, 'Montserrat Is', 'MS'),(110, 'Morocco', 'MA'),(111, 'Mozambique', 'MZ'),(112, 'Namibia', 'NA'),(113, 'Nauru', 'NR'),(114, 'Nepal', 'NP'),(115, 'Netherlands', 'NL'),(116, 'New Zealand', 'NZ'),(117, 'Nicaragua', 'NI'),(118, 'Niger', 'NE'),(119, 'Nigeria', 'NG'),(120, 'North Korea', 'KP'),(121, 'Norway', 'NO'),(122, 'Oman', 'OM'),(123, 'Pakistan', 'PK'),(124, 'Panama', 'PA'),(125, 'Papua New Cuinea', 'PG'),(126, 'Paraguay', 'PY'),(127, 'Peru', 'PE'),(128, 'Philippines', 'PH'),(129, 'Poland', 'PL'),(130, 'French Polynesia', 'PF'),(131, 'Portugal', 'PT'),(132, 'Puerto Rico', 'PR'),(133, 'Qatar', 'QA'),(134, 'Romania', 'RO'),(135, 'Russia', 'RU'),(136, 'Saint Lueia', 'LC'),(137, 'Saint Vincent', 'VC'),(138, 'San Marino', 'SM'),(139, 'Sao Tome and Principe', 'ST'),(140, 'Saudi Arabia', 'SA'),(141, 'Senegal', 'SN'),(142, 'Seychelles', 'SC'),(143, 'Sierra Leone', 'SL'),(144, 'Singapore', 'SG'),(145, 'Slovakia', 'SK'),(146, 'Slovenia', 'SI'),(147, 'Solomon Is', 'SB'),(148, 'Somali', 'SO'),(149, 'South Africa', 'ZA'),(150, 'Spain', 'ES'),(151, 'Sri Lanka', 'LK'),(152, 'St.Lucia', 'LC'),(153, 'St.Vincent', 'VC'),(154, 'Sudan', 'SD'),(155, 'Suriname', 'SR'),(156, 'Swaziland', 'SZ'),(157, 'Sweden', 'SE'),(158, 'Switzerland', 'CH'),(159, 'Syria', 'SY'),(160, 'Taiwan', 'TW'),(161, 'Tajikstan', 'TJ'),(162, 'Tanzania', 'TZ'),(163, 'Thailand', 'TH'),(164, 'Togo', 'TG'),(165, 'Tonga', 'TO'),(166, 'Trinidad and Tobago', 'TT'),(167, 'Tunisia', 'TN'),(168, 'Turkey', 'TR'),(169, 'Turkmenistan', 'TM'),(170, 'Uganda', 'UG'),(171, 'Ukraine', 'UA'),(172, 'United Arab Emirates', 'AE'),(173, 'United Kiongdom', 'GB'),(174, 'United States of America', 'US'),(175, 'Uruguay', 'UY'),(176, 'Uzbekistan', 'UZ'),(177, 'Venezuela', 'VE'),(178, 'Vietnam', 'VN'),(179, 'Yemen', 'YE'),(180, 'Yugoslavia', 'YU'),(181, 'Zimbabwe', 'ZW'),(182, 'Zaire', 'ZR'),(183, 'Zambia', 'ZM');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `test`.`permission` WRITE;
DELETE FROM `test`.`permission`;
INSERT INTO `test`.`permission` (`id`,`parent_id`,`permission_name`,`url`,`perms`,`icon`,`type`,`order_num`,`create_time`,`modify_time`) VALUES (1, 0, '系统管理', NULL, NULL, 'zmdi zmdi-settings', '0', 1, '2017-12-27 16:39:07', NULL),(2, 0, '系统监控', NULL, NULL, 'zmdi zmdi-shield-security', '0', 2, '2017-12-27 16:45:51', '2018-01-17 17:08:28'),(3, 1, '用户管理', 'user', 'user:list', '', '0', 1, '2017-12-27 16:47:13', '2018-04-25 09:00:01'),(4, 1, '角色管理', 'role', 'role:list', '', '0', 2, '2017-12-27 16:48:09', '2018-04-25 09:01:12'),(5, 1, '菜单管理', 'permission', 'permission:list', '', '0', 3, '2017-12-27 16:48:57', '2018-04-25 09:01:30'),(6, 1, '部门管理', 'dept', 'dept:list', '', '0', 4, '2017-12-27 16:57:33', '2018-04-25 09:01:40'),(8, 2, '在线用户', 'session', 'session:list', '', '0', 1, '2017-12-27 16:59:33', '2018-04-25 09:02:04'),(10, 2, '系统日志', 'log', 'log:list', '', '0', 3, '2017-12-27 17:00:50', '2018-04-25 09:02:18'),(11, 3, '新增用户', NULL, 'user:add', NULL, '1', NULL, '2017-12-27 17:02:58', NULL),(12, 3, '修改用户', NULL, 'user:update', NULL, '1', NULL, '2017-12-27 17:04:07', NULL),(13, 3, '删除用户', NULL, 'user:delete', NULL, '1', NULL, '2017-12-27 17:04:58', NULL),(14, 4, '新增角色', NULL, 'role:add', NULL, '1', NULL, '2017-12-27 17:06:38', NULL),(15, 4, '修改角色', NULL, 'role:update', NULL, '1', NULL, '2017-12-27 17:06:38', NULL),(16, 4, '删除角色', NULL, 'role:delete', NULL, '1', NULL, '2017-12-27 17:06:38', NULL),(17, 5, '新增菜单', NULL, 'permission:add', NULL, '1', NULL, '2017-12-27 17:08:02', NULL),(18, 5, '修改菜单', NULL, 'permission:update', NULL, '1', NULL, '2017-12-27 17:08:02', NULL),(19, 5, '删除菜单', NULL, 'permission:delete', NULL, '1', NULL, '2017-12-27 17:08:02', NULL),(20, 6, '新增部门', NULL, 'dept:add', NULL, '1', NULL, '2017-12-27 17:09:24', NULL),(21, 6, '修改部门', NULL, 'dept:update', NULL, '1', NULL, '2017-12-27 17:09:24', NULL),(22, 6, '删除部门', NULL, 'dept:delete', NULL, '1', NULL, '2017-12-27 17:09:24', NULL),(23, 8, '踢出用户', NULL, 'user:kickout', NULL, '1', NULL, '2017-12-27 17:11:13', NULL),(24, 10, '删除日志', NULL, 'log:delete', NULL, '1', NULL, '2017-12-27 17:11:45', NULL),(58, 0, '网络资源', NULL, NULL, 'zmdi zmdi-globe-alt', '0', NULL, '2018-01-12 15:28:48', '2018-01-22 19:49:26'),(59, 58, '天气查询', 'weather', 'weather:list', '', '0', NULL, '2018-01-12 15:40:02', '2018-04-25 09:02:57'),(61, 58, '每日一文', 'article', 'article:list', '', '0', NULL, '2018-01-15 17:17:14', '2018-04-25 09:03:08'),(64, 1, '字典管理', 'dict', 'dict:list', '', '0', NULL, '2018-01-18 10:38:25', '2018-04-25 09:01:50'),(65, 64, '新增字典', NULL, 'dict:add', NULL, '1', NULL, '2018-01-18 19:10:08', NULL),(66, 64, '修改字典', NULL, 'dict:update', NULL, '1', NULL, '2018-01-18 19:10:27', NULL),(67, 64, '删除字典', NULL, 'dict:delete', NULL, '1', NULL, '2018-01-18 19:10:47', NULL),(81, 58, '影视资讯', NULL, NULL, NULL, '0', NULL, '2018-01-22 14:12:59', NULL),(82, 81, '正在热映', 'movie/hot', 'movie:hot', '', '0', NULL, '2018-01-22 14:13:47', '2018-04-25 09:03:48'),(83, 81, '即将上映', 'movie/coming', 'movie:coming', '', '0', NULL, '2018-01-22 14:14:36', '2018-04-25 09:04:05'),(86, 58, 'One 一个', NULL, NULL, NULL, '0', NULL, '2018-01-26 09:42:41', '2018-01-26 09:43:46'),(87, 86, '绘画', 'one/painting', 'one:painting', '', '0', NULL, '2018-01-26 09:47:14', '2018-04-25 09:04:17'),(88, 86, '语文', 'one/yuwen', 'one:yuwen', '', '0', NULL, '2018-01-26 09:47:40', '2018-04-25 09:04:30'),(89, 86, '散文', 'one/essay', 'one:essay', '', '0', NULL, '2018-01-26 09:48:05', '2018-04-25 09:04:42'),(101, 0, '任务调度', NULL, NULL, 'zmdi zmdi-alarm', '0', NULL, '2018-02-24 15:52:57', NULL),(102, 101, '定时任务', 'job', 'job:list', '', '0', NULL, '2018-02-24 15:53:53', '2018-04-25 09:05:12'),(103, 102, '新增任务', NULL, 'job:add', NULL, '1', NULL, '2018-02-24 15:55:10', NULL),(104, 102, '修改任务', NULL, 'job:update', NULL, '1', NULL, '2018-02-24 15:55:53', NULL),(105, 102, '删除任务', NULL, 'job:delete', NULL, '1', NULL, '2018-02-24 15:56:18', NULL),(106, 102, '暂停任务', NULL, 'job:pause', NULL, '1', NULL, '2018-02-24 15:57:08', NULL),(107, 102, '恢复任务', NULL, 'job:resume', NULL, '1', NULL, '2018-02-24 15:58:21', NULL),(108, 102, '立即执行任务', NULL, 'job:run', NULL, '1', NULL, '2018-02-24 15:59:45', NULL),(109, 101, '调度日志', 'jobLog', 'jobLog:list', '', '0', NULL, '2018-02-24 16:00:45', '2018-04-25 09:05:25'),(110, 109, '删除日志', NULL, 'jobLog:delete', NULL, '1', NULL, '2018-02-24 16:01:21', NULL),(113, 2, 'Redis监控', 'redis/info', 'redis:list', '', '0', NULL, '2018-06-28 14:29:42', NULL),(114, 2, 'Redis终端', 'redis/terminal', 'redis:terminal', '', '0', NULL, '2018-06-28 15:35:21', NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `test`.`role` WRITE;
DELETE FROM `test`.`role`;
INSERT INTO `test`.`role` (`id`,`name`,`remark`,`create_time`,`modify_time`) VALUES (1, '管理员', '管理员', '2017-12-27 16:23:11', '2018-02-24 16:01:45'),(2, '测试账号', '测试账号', '2017-12-27 16:25:09', '2018-01-23 09:11:11'),(3, '注册账户', '注册账户，只可查看，不可操作', '2017-12-29 16:00:15', '2018-02-24 17:33:45'),(23, '用户管理员', '负责用户的增删改操作', '2018-01-09 15:32:41', NULL),(24, '系统监控员', '可查看系统监控信息，但不可操作', '2018-01-09 15:52:01', '2018-03-07 19:05:33'),(25, '用户查看', '查看用户，无相应操作权限', '2018-01-09 15:56:30', NULL),(63, '影院工作者', '可查看影视信息', '2018-02-06 08:48:28', '2018-03-07 19:05:26'),(64, '天气预报员', '可查看天气预报信息', '2018-02-27 08:47:04', NULL),(65, '文章审核', '文章类', '2018-02-27 08:48:01', '2018-03-13 11:20:34');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `test`.`role_permission` WRITE;
DELETE FROM `test`.`role_permission`;
INSERT INTO `test`.`role_permission` (`role_id`,`permission_id`) VALUES (3, 58),(3, 59),(3, 61),(3, 81),(3, 82),(3, 83),(3, 86),(3, 87),(3, 88),(3, 89),(3, 1),(3, 3),(3, 4),(3, 5),(3, 6),(3, 64),(3, 2),(3, 8),(3, 10),(3, 101),(3, 102),(3, 109),(63, 58),(63, 81),(63, 82),(63, 83),(24, 8),(24, 2),(24, 10),(65, 86),(65, 88),(65, 89),(65, 58),(65, 61),(2, 81),(2, 61),(2, 24),(2, 82),(2, 83),(2, 58),(2, 59),(2, 2),(2, 8),(2, 10),(23, 11),(23, 12),(23, 13),(23, 3),(23, 1),(25, 1),(25, 3),(1, 59),(1, 2),(1, 3),(1, 67),(1, 1),(1, 4),(1, 5),(1, 6),(1, 20),(1, 21),(1, 22),(1, 10),(1, 8),(1, 58),(1, 66),(1, 11),(1, 12),(1, 64),(1, 13),(1, 14),(1, 65),(1, 15),(1, 16),(1, 17),(1, 18),(1, 23),(1, 81),(1, 82),(1, 83),(1, 19),(1, 24),(1, 61),(1, 86),(1, 87),(1, 88),(1, 89),(1, 101),(1, 102),(1, 103),(1, 104),(1, 105),(1, 106),(1, 107),(1, 108),(1, 109),(1, 110),(64, 59),(64, 58),(1, 113),(1, 114);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `test`.`user` WRITE;
DELETE FROM `test`.`user`;
INSERT INTO `test`.`user` (`id`,`user_name`,`real_name`,`password`,`dept_id`,`email`,`mobile`,`locked`,`crate_time`,`modify_time`,`last_login_time`,`ssex`,`theme`,`avatar`,`description`) VALUES (4, 'MrBird', '', '42ee25d1e43e9f57119a00d0a39e5250', 5, 'mrbird@hotmail.com', '13455533222', '1', '2017-12-27 15:47:19', '2018-03-21 09:05:12', '2018-04-02 17:29:32', '0', 'green', 'default.jpg', '我是作者。'),(6, 'tester', '', '243e29429b340192700677d48c09d992', 6, 'tester@qq.com', '13888888888', '1', '2017-12-27 17:35:14', '2018-03-27 09:21:08', '2018-01-23 09:17:27', '1', 'teal', 'default.jpg', NULL),(23, 'scott', '', 'ac3af72d9f95161a502fd326865c2f15', 6, 'scott@qq.com', '15134627380', '1', '2017-12-29 16:16:39', '2018-03-29 16:18:36', '2018-03-20 17:59:04', '0', 'blue-grey', 'default.jpg', '我是scott，嗯嗯'),(24, 'smith', '', '228208eafc74e48c44619cc543fc0efe', 3, 'smith@qq.com', '13364754932', '1', '2017-12-29 16:21:31', '2018-02-27 08:48:16', '2018-02-27 08:48:27', '1', 'teal', 'default.jpg', NULL),(25, 'allen', '', '83baac97928a113986054efacaeec1d2', 3, 'allen@qq.com', '13427374857', '0', '2017-12-29 16:21:54', '2018-01-17 11:28:16', NULL, '1', 'indigo', 'default.jpg', NULL),(26, 'martin', '', 'b26c9edca9a61016bca1f6fb042e679e', 4, 'martin@qq.com', '15562736678', '1', '2017-12-29 16:22:24', '2018-01-25 09:23:15', '2018-01-25 17:24:50', '1', 'teal', 'default.jpg', NULL),(27, 'ford', '', '0448f0dcfd856b0e831842072b532141', 6, 'ford@qq.com', '15599998373', '0', '2017-12-29 16:22:52', '2018-03-13 11:19:56', '2018-03-08 16:31:59', '0', 'cyan', 'default.jpg', NULL),(91, '系统监控员', '', '7c28d1cd33414ac15832f7be92668b7a', 6, 'xtjk@qq.com', '18088736652', '1', '2018-01-09 15:52:56', NULL, '2018-01-09 15:53:12', '0', 'cyan', 'default.jpg', NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `test`.`user_role` WRITE;
DELETE FROM `test`.`user_role`;
INSERT INTO `test`.`user_role` (`user_id`,`role_id`) VALUES (27, 3),(24, 65),(26, 3),(26, 23),(26, 24),(25, 3),(91, 24),(4, 1),(6, 1),(6, 2),(6, 3),(6, 25),(6, 63),(23, 2),(23, 3),(23, 23),(23, 24),(23, 25);
UNLOCK TABLES;
COMMIT;

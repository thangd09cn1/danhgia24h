/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : danhgia24h

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-06-05 17:23:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_privileges
-- ----------------------------
DROP TABLE IF EXISTS `base_privileges`;
CREATE TABLE `base_privileges` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_by` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of base_privileges
-- ----------------------------
INSERT INTO `base_privileges` VALUES ('123', 'priv_base_Role_create', null, 'system', null, '1517882729326', '1517882729327', '1');
INSERT INTO `base_privileges` VALUES ('124', 'priv_base_Role_read', null, 'system', null, '1517882729388', '1517882729388', '1');
INSERT INTO `base_privileges` VALUES ('125', 'priv_base_Role_update', null, 'system', null, '1517882729390', '1517882729390', '1');
INSERT INTO `base_privileges` VALUES ('126', 'priv_base_Role_delete', null, 'system', null, '1517882729393', '1517882729393', '1');
INSERT INTO `base_privileges` VALUES ('127', 'priv_base_Role_super', null, 'system', null, '1517882729395', '1517882729395', '1');
INSERT INTO `base_privileges` VALUES ('128', 'priv_base_Privilege_create', null, 'system', null, '1517882729398', '1517882729398', '1');
INSERT INTO `base_privileges` VALUES ('129', 'priv_base_Privilege_read', null, 'system', null, '1517882729401', '1517882729401', '1');
INSERT INTO `base_privileges` VALUES ('130', 'priv_base_Privilege_update', null, 'system', null, '1517882729404', '1517882729404', '1');
INSERT INTO `base_privileges` VALUES ('131', 'priv_base_Privilege_delete', null, 'system', null, '1517882729408', '1517882729408', '1');
INSERT INTO `base_privileges` VALUES ('132', 'priv_base_Privilege_super', null, 'system', null, '1517882729411', '1517882729411', '1');
INSERT INTO `base_privileges` VALUES ('133', 'priv_master_Company_create', null, 'system', null, '1517882729413', '1517882729413', '1');
INSERT INTO `base_privileges` VALUES ('134', 'priv_master_Company_read', null, 'system', null, '1517882729415', '1517882729415', '1');
INSERT INTO `base_privileges` VALUES ('135', 'priv_master_Company_update', null, 'system', null, '1517882729418', '1517882729418', '1');
INSERT INTO `base_privileges` VALUES ('136', 'priv_master_Company_delete', null, 'system', null, '1517882729420', '1517882729420', '1');
INSERT INTO `base_privileges` VALUES ('137', 'priv_master_Company_super', null, 'system', null, '1517882729423', '1517882729423', '1');
INSERT INTO `base_privileges` VALUES ('138', 'priv_master_UomCategory_create', null, 'system', null, '1517882729426', '1517882729426', '1');
INSERT INTO `base_privileges` VALUES ('139', 'priv_master_UomCategory_read', null, 'system', null, '1517882729429', '1517882729429', '1');
INSERT INTO `base_privileges` VALUES ('140', 'priv_master_UomCategory_update', null, 'system', null, '1517882729432', '1517882729432', '1');
INSERT INTO `base_privileges` VALUES ('141', 'priv_master_UomCategory_delete', null, 'system', null, '1517882729434', '1517882729434', '1');
INSERT INTO `base_privileges` VALUES ('142', 'priv_master_UomCategory_super', null, 'system', null, '1517882729436', '1517882729436', '1');
INSERT INTO `base_privileges` VALUES ('143', 'priv_master_Article_create', null, 'system', null, '1517882729438', '1517882729438', '1');
INSERT INTO `base_privileges` VALUES ('144', 'priv_master_Article_read', null, 'system', null, '1517882729442', '1517882729442', '1');
INSERT INTO `base_privileges` VALUES ('145', 'priv_master_Article_update', null, 'system', null, '1517882729446', '1517882729446', '1');
INSERT INTO `base_privileges` VALUES ('146', 'priv_master_Article_delete', null, 'system', null, '1517882729448', '1517882729448', '1');
INSERT INTO `base_privileges` VALUES ('147', 'priv_master_Article_super', null, 'system', null, '1517882729450', '1517882729450', '1');
INSERT INTO `base_privileges` VALUES ('148', 'priv_master_Tag_create', null, 'system', null, '1517882729452', '1517882729452', '1');
INSERT INTO `base_privileges` VALUES ('149', 'priv_master_Tag_read', null, 'system', null, '1517882729454', '1517882729454', '1');
INSERT INTO `base_privileges` VALUES ('150', 'priv_master_Tag_update', null, 'system', null, '1517882729457', '1517882729457', '1');
INSERT INTO `base_privileges` VALUES ('151', 'priv_master_Tag_delete', null, 'system', null, '1517882729459', '1517882729459', '1');
INSERT INTO `base_privileges` VALUES ('152', 'priv_master_Tag_super', null, 'system', null, '1517882729462', '1517882729462', '1');
INSERT INTO `base_privileges` VALUES ('153', 'priv_master_Category_create', null, 'system', null, '1517882729464', '1517882729464', '1');
INSERT INTO `base_privileges` VALUES ('154', 'priv_master_Category_read', null, 'system', null, '1517882729466', '1517882729466', '1');
INSERT INTO `base_privileges` VALUES ('155', 'priv_master_Category_update', null, 'system', null, '1517882729468', '1517882729468', '1');
INSERT INTO `base_privileges` VALUES ('156', 'priv_master_Category_delete', null, 'system', null, '1517882729470', '1517882729470', '1');
INSERT INTO `base_privileges` VALUES ('157', 'priv_master_Category_super', null, 'system', null, '1517882729472', '1517882729472', '1');
INSERT INTO `base_privileges` VALUES ('158', 'priv_social_Comment_create', null, 'system', null, '1517882729475', '1517882729475', '1');
INSERT INTO `base_privileges` VALUES ('159', 'priv_social_Comment_read', null, 'system', null, '1517882729477', '1517882729477', '1');
INSERT INTO `base_privileges` VALUES ('160', 'priv_social_Comment_update', null, 'system', null, '1517882729479', '1517882729479', '1');
INSERT INTO `base_privileges` VALUES ('161', 'priv_social_Comment_delete', null, 'system', null, '1517882729481', '1517882729481', '1');
INSERT INTO `base_privileges` VALUES ('162', 'priv_social_Comment_super', null, 'system', null, '1517882729482', '1517882729482', '1');
INSERT INTO `base_privileges` VALUES ('163', 'priv_base_User_create', null, 'system', null, '1517882729484', '1517882729484', '1');
INSERT INTO `base_privileges` VALUES ('164', 'priv_base_User_read', null, 'system', null, '1517882729486', '1517882729486', '1');
INSERT INTO `base_privileges` VALUES ('165', 'priv_base_User_update', null, 'system', null, '1517882729488', '1517882729488', '1');
INSERT INTO `base_privileges` VALUES ('166', 'priv_base_User_delete', null, 'system', null, '1517882729490', '1517882729490', '1');
INSERT INTO `base_privileges` VALUES ('167', 'priv_base_User_super', null, 'system', null, '1517882729492', '1517882729492', '1');
INSERT INTO `base_privileges` VALUES ('168', 'priv_master_Uom_create', null, 'system', null, '1517882729494', '1517882729494', '1');
INSERT INTO `base_privileges` VALUES ('169', 'priv_master_Uom_read', null, 'system', null, '1517882729495', '1517882729495', '1');
INSERT INTO `base_privileges` VALUES ('170', 'priv_master_Uom_update', null, 'system', null, '1517882729497', '1517882729497', '1');
INSERT INTO `base_privileges` VALUES ('171', 'priv_master_Uom_delete', null, 'system', null, '1517882729499', '1517882729499', '1');
INSERT INTO `base_privileges` VALUES ('172', 'priv_master_Uom_super', null, 'system', null, '1517882729501', '1517882729501', '1');

-- ----------------------------
-- Table structure for base_roles
-- ----------------------------
DROP TABLE IF EXISTS `base_roles`;
CREATE TABLE `base_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_by` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of base_roles
-- ----------------------------
INSERT INTO `base_roles` VALUES ('1', 'ROLE_ADMIN', 'Admin role', null, null, null, null, null);
INSERT INTO `base_roles` VALUES ('2', 'ROLE_USER', 'User role', null, null, null, null, null);

-- ----------------------------
-- Table structure for base_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `base_role_privilege`;
CREATE TABLE `base_role_privilege` (
  `role_id` bigint(20) DEFAULT NULL,
  `privilege_id` bigint(20) DEFAULT NULL,
  KEY `fk_rp_privilege_id` (`privilege_id`),
  KEY `fk_rp_role_id` (`role_id`),
  CONSTRAINT `base_role_privilege_ibfk_1` FOREIGN KEY (`privilege_id`) REFERENCES `base_privileges` (`id`),
  CONSTRAINT `base_role_privilege_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `base_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of base_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for base_users
-- ----------------------------
DROP TABLE IF EXISTS `base_users`;
CREATE TABLE `base_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_by` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `activated` bigint(20) DEFAULT NULL,
  `activation_token` mediumtext COLLATE utf8_unicode_ci,
  `activation_token_created` bigint(20) DEFAULT NULL,
  `forgot_password_token` mediumtext COLLATE utf8_unicode_ci,
  `forgot_password_token_created` bigint(20) DEFAULT NULL,
  `first_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lang_key` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of base_users
-- ----------------------------
INSERT INTO `base_users` VALUES ('1', 'admin', 'admin', '$2a$10$xBgWuEPtOrSsdyvNJU9Fourp/c5m3Mk24N1su4uH.69xNpCEgCsmG', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_user_role
-- ----------------------------
DROP TABLE IF EXISTS `base_user_role`;
CREATE TABLE `base_user_role` (
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  KEY `fk_ur_user_id` (`user_id`),
  KEY `fk_ur_role_id` (`role_id`),
  CONSTRAINT `base_user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `base_roles` (`id`),
  CONSTRAINT `base_user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `base_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of base_user_role
-- ----------------------------
INSERT INTO `base_user_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO `databasechangelog` VALUES ('1.1', 'thangnc', 'src/main/resources/liquibase/db.changelog-1.1.sql', '2018-02-06 09:05:05', '1', 'EXECUTED', '7:678347e2159e504361834261e4c85592', 'sql', '', null, '3.4.2', null, null);
INSERT INTO `databasechangelog` VALUES ('000001', 'thangnc', 'src/main/resources/liquibase/data/db.load.data-000001.sql', '2018-02-06 09:05:05', '2', 'EXECUTED', '7:cb88c4ee9e752edd41c9cfc928fd3e2f', 'sql', '', null, '3.4.2', null, null);
INSERT INTO `databasechangelog` VALUES ('000002', 'thangnc', 'src/main/resources/liquibase/data/db.load.data-000002.sql', '2018-02-06 09:05:05', '3', 'EXECUTED', '7:03a9b228d6a5e40b5f673075a4820a58', 'sql', '', null, '3.4.2', null, null);

-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------

-- ----------------------------
-- Table structure for master_article
-- ----------------------------
DROP TABLE IF EXISTS `master_article`;
CREATE TABLE `master_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `content` text,
  `link` varchar(200) DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `created_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `hot` tinyint(4) DEFAULT NULL COMMENT 'set hot cho bài viết',
  `views` bigint(20) DEFAULT NULL COMMENT 'Số lượt view',
  `rating` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `constraint_article_category` (`category_id`),
  KEY `constraint_article_supplier` (`supplier_id`),
  CONSTRAINT `constraint_article_category` FOREIGN KEY (`category_id`) REFERENCES `master_article_categories` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `constraint_article_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `master_companies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_article
-- ----------------------------

-- ----------------------------
-- Table structure for master_article_categories
-- ----------------------------
DROP TABLE IF EXISTS `master_article_categories`;
CREATE TABLE `master_article_categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL COMMENT 'mối quan hệ cha - con của chuyên mục - tiểu mục',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_article_categories
-- ----------------------------

-- ----------------------------
-- Table structure for master_article_tags
-- ----------------------------
DROP TABLE IF EXISTS `master_article_tags`;
CREATE TABLE `master_article_tags` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `article_id` bigint(20) NOT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `constraint_tags_article` (`article_id`),
  CONSTRAINT `constraint_tags_article` FOREIGN KEY (`article_id`) REFERENCES `master_article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_article_tags
-- ----------------------------

-- ----------------------------
-- Table structure for master_companies
-- ----------------------------
DROP TABLE IF EXISTS `master_companies`;
CREATE TABLE `master_companies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '\n',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `type` enum('manufacturer','supplier') DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `alias` varchar(45) DEFAULT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `fax_number` varchar(45) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_companies
-- ----------------------------

-- ----------------------------
-- Table structure for master_products
-- ----------------------------
DROP TABLE IF EXISTS `master_products`;
CREATE TABLE `master_products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `sale` int(11) DEFAULT NULL,
  `news` tinyint(4) DEFAULT NULL,
  `hot` tinyint(4) DEFAULT NULL,
  `cost` bigint(20) DEFAULT NULL,
  `cost_uom_id` bigint(20) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `quantity_uom_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `rate_price` int(11) DEFAULT NULL,
  `rate_quality` int(11) DEFAULT NULL,
  `description_sort` varchar(300) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_products
-- ----------------------------

-- ----------------------------
-- Table structure for master_product_categories
-- ----------------------------
DROP TABLE IF EXISTS `master_product_categories`;
CREATE TABLE `master_product_categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_product_categories
-- ----------------------------

-- ----------------------------
-- Table structure for master_product_tags
-- ----------------------------
DROP TABLE IF EXISTS `master_product_tags`;
CREATE TABLE `master_product_tags` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `constraint_tags_article` (`product_id`),
  CONSTRAINT `master_product_tags_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `master_article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_product_tags
-- ----------------------------

-- ----------------------------
-- Table structure for master_uom
-- ----------------------------
DROP TABLE IF EXISTS `master_uom`;
CREATE TABLE `master_uom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `factor` int(11) DEFAULT NULL,
  `rounding` double DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_master_uom_master_uom_categ1_idx` (`category_id`),
  CONSTRAINT `master_uom_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `master_uom_categories` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_uom
-- ----------------------------

-- ----------------------------
-- Table structure for master_uom_categories
-- ----------------------------
DROP TABLE IF EXISTS `master_uom_categories`;
CREATE TABLE `master_uom_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_uom_categories
-- ----------------------------
INSERT INTO `master_uom_categories` VALUES ('1', 'All', null, null, null, null, null, '1');
INSERT INTO `master_uom_categories` VALUES ('2', 'Unit', '1', null, null, null, null, '1');
INSERT INTO `master_uom_categories` VALUES ('3', 'Working time', '1', null, null, null, null, '1');
INSERT INTO `master_uom_categories` VALUES ('4', 'Length-Distance', '1', null, null, null, null, '1');
INSERT INTO `master_uom_categories` VALUES ('5', 'Length', '4', null, null, null, null, '1');
INSERT INTO `master_uom_categories` VALUES ('6', 'Distance', '4', null, null, null, null, '1');
INSERT INTO `master_uom_categories` VALUES ('7', 'Volume ', '1', null, null, null, null, '1');
INSERT INTO `master_uom_categories` VALUES ('8', 'Weight', '1', null, null, null, null, '1');

-- ----------------------------
-- Table structure for social_comments
-- ----------------------------
DROP TABLE IF EXISTS `social_comments`;
CREATE TABLE `social_comments` (
  `id` bigint(20) NOT NULL,
  `message` text,
  `parent_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated` bigint(20) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `constraint_comments_users` (`user_id`),
  KEY `constraint_comments_article` (`article_id`),
  CONSTRAINT `constraint_comments_article` FOREIGN KEY (`article_id`) REFERENCES `master_article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `constraint_comments_users` FOREIGN KEY (`user_id`) REFERENCES `base_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_comments
-- ----------------------------
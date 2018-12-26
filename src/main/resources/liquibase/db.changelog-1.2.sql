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

Alter table `danhgia24h`.`master_products`
drop column `status`,
add column `code` varchar(100) NULL   COMMENT 'code product' after `id`,
change `name` `name` varchar(255) CHARSET utf8 COLLATE utf8_general_ci NOT NULL   COMMENT 'name product',
change `description` `description` varchar(3000) CHARSET utf8 COLLATE utf8_general_ci NOT NULL   COMMENT 'description',
change `description_sort` `description_sort` varchar(300) CHARSET utf8 COLLATE utf8_general_ci NOT NULL   COMMENT 'quick overview'  after `description`,
change `sale` `sale` tinyint(4) NULL   COMMENT 'true/false in list home sale',
change `news` `new` tinyint(4) NULL   COMMENT 'true/false in list home mew',
change `hot` `hot` tinyint(4) NULL   COMMENT 'true/false in list home hot',
change `cost` `cost` double(20,4) NOT NULL   COMMENT 'cost',
add column `cost_sale` double(20,4) NULL   COMMENT 'cost sale' after `cost`,
change `cost_uom_id` `cost_uom_id` bigint(11) NOT NULL,
change `quantity` `quantity` bigint(11) NULL,
change `quantity_uom_id` `uom_id` bigint(20) NULL,
change `company_id` `manufacturer_id` bigint(20) NULL   COMMENT 'nhà sản xuất',
add column `supplier_id` bigint(20) NULL   COMMENT 'nhà cung cấp' after `manufacturer_id`,
add column `availability` tinyint(1) NOT NULL   COMMENT '1: còn hàng/ 0: hết hàng' after `supplier_id`,
add column `rate` int(1) NULL   COMMENT 'đánh giá' after `availability`,
change `rate_price` `rate_price` int(1) NULL,
change `rate_quality` `rate_quality` int(1) NULL,
add column `rate_value` int(1) NULL after `rate_quality`,
change `color` `color` varchar(255) CHARSET utf8 COLLATE utf8_general_ci NULL   COMMENT '[\'RED\',\'GREEN\',\'BLUE\']',
change `size` `size` varchar(255) CHARSET utf8 COLLATE utf8_general_ci NULL   COMMENT '[\'X\',\'XL\',...]',
add column `avartar` varchar(255) NOT NULL   COMMENT 'ảnh đại diện SP' after `size`,
change `images` `images` varchar(500) CHARSET utf8 COLLATE utf8_general_ci NOT NULL   COMMENT '[\'...
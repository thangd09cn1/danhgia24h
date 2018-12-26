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
change `sale` `set_sale` tinyint(4) NULL   COMMENT 'true/false in list home sale',
change `new` `set_new` tinyint(4) NULL   COMMENT 'true/false in list home new',
change `hot` `set_hot` tinyint(4) NULL   COMMENT 'true/false in list home hot',
change `uom_id` `uom_id` double(15,4) NULL   COMMENT 'uom of quantity';
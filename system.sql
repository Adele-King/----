/*
Navicat MySQL Data Transfer

Source Server         : A
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-08-09 18:21:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(20) NOT NULL COMMENT '商品名',
  `type` varchar(20) NOT NULL COMMENT '商品所属类型',
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `discount` float NOT NULL DEFAULT '10' COMMENT '折扣',
  `per` float NOT NULL COMMENT '单价',
  `status` tinyint(4) NOT NULL COMMENT '商品状态',
  `sale` int(11) NOT NULL DEFAULT '0' COMMENT '销售量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员编号',
  `name` varchar(20) NOT NULL COMMENT '会员名',
  `pass` varchar(32) NOT NULL COMMENT '会员密码',
  `score` float NOT NULL DEFAULT '0' COMMENT '积分',
  `account` decimal(7,2) NOT NULL DEFAULT '0.00' COMMENT '余额',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `updateDate` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `member_id` int(11) NOT NULL COMMENT '会员ID',
  `money` decimal(7,2) NOT NULL COMMENT '订单总金额',
  `pay_type` tinyint(4) NOT NULL COMMENT '支付类型',
  `orderDate` datetime NOT NULL COMMENT '下单时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `orderdetails`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详情ID',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `goods_id` int(11) NOT NULL COMMENT '购买商品的ID',
  `goods_num` int(11) NOT NULL COMMENT '购买商品的数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetails
-- ----------------------------

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `name` varchar(20) NOT NULL COMMENT '类型名称',
  `father_id` int(11) NOT NULL COMMENT '父ID',
  `sign` tinyint(4) NOT NULL COMMENT '是否为父类型',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '水果', '0', '1', '2019-08-06 16:04:39', null);
INSERT INTO `type` VALUES ('2', '热带水果', '1', '1', '2019-08-06 16:07:55', null);
INSERT INTO `type` VALUES ('3', '进口热带水果', '2', '0', '2019-08-06 16:08:51', '2019-08-06 16:16:26');
INSERT INTO `type` VALUES ('4', '国内热带水果', '2', '0', '2019-08-06 16:09:38', '2019-08-06 16:17:02');
INSERT INTO `type` VALUES ('5', '零食', '0', '1', '2019-08-06 16:10:25', null);
INSERT INTO `type` VALUES ('6', '饼干', '5', '0', '2019-08-06 16:12:41', null);
INSERT INTO `type` VALUES ('7', '布丁', '5', '0', '2019-08-07 21:09:32', null);

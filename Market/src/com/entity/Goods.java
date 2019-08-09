package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品信息 实体
 * @author 宋月娥
 * @Date 2019年8月4日
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Goods {

	private Integer id;//ID
	private String name;//商品名
	private String type;//商品类型
	private Integer num;//库存数量  0
	private Float per;//单价
	private Byte status;//状态：1-正常  2-下架  3-删除
	private Float discount;//折扣  10
	private Integer sale;//销售量   0
}

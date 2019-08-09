package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 订单详情   实体
 * @author 宋月娥
 * @Date 2019年8月4日
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {

	private Integer id;//详情ID
	private Integer order_id;//订单ID
	private Integer goods_id;//商品ID
	private Integer goods_num;//商品数量
}

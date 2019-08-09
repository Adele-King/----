package com.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 		订单信息  实体
 * @author 宋月娥
 * @Date 2019年8月4日
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	private Integer id;//订单ID
	private Integer member_id;//会员ID
	private BigDecimal  money;//订单总金额
	private Date orderDate;//订单日期
	private Byte pay_type;//支付方式
}

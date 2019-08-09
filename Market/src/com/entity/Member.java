package com.entity;

/**
 * 	会员信息  实体
 * @author 宋月娥
 * @Date 2019年8月4日
 */

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

	private Integer id;//会员ID 
	private String name;//会员名
	private String pass;//密码
	private Float score;//积分
	private BigDecimal account;//余额
	private String phone;//电话
	private Date createDate;//创建日期
	private Date updateDate;//修改时间
}

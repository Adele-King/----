package com.entity;

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
public class Type {

	private Integer id;//类型ID
	private String name;//类型名
	private Integer father_id;//父ID
	private Byte sign;// 是否为父类型   1-是   0-否
	private Date createDate;//创建时间
	private Date updateDate;//修改时间
}

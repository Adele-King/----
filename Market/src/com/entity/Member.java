package com.entity;

/**
 * 	��Ա��Ϣ  ʵ��
 * @author ���¶�
 * @Date 2019��8��4��
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

	private Integer id;//��ԱID 
	private String name;//��Ա��
	private String pass;//����
	private Float score;//����
	private BigDecimal account;//���
	private String phone;//�绰
	private Date createDate;//��������
	private Date updateDate;//�޸�ʱ��
}

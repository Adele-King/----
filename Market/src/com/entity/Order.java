package com.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 		������Ϣ  ʵ��
 * @author ���¶�
 * @Date 2019��8��4��
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	private Integer id;//����ID
	private Integer member_id;//��ԱID
	private BigDecimal  money;//�����ܽ��
	private Date orderDate;//��������
	private Byte pay_type;//֧����ʽ
}

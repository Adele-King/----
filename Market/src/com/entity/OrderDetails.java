package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * ��������   ʵ��
 * @author ���¶�
 * @Date 2019��8��4��
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {

	private Integer id;//����ID
	private Integer order_id;//����ID
	private Integer goods_id;//��ƷID
	private Integer goods_num;//��Ʒ����
}

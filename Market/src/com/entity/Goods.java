package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ��Ʒ��Ϣ ʵ��
 * @author ���¶�
 * @Date 2019��8��4��
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Goods {

	private Integer id;//ID
	private String name;//��Ʒ��
	private String type;//��Ʒ����
	private Integer num;//�������  0
	private Float per;//����
	private Byte status;//״̬��1-����  2-�¼�  3-ɾ��
	private Float discount;//�ۿ�  10
	private Integer sale;//������   0
}

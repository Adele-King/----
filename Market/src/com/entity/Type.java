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

	private Integer id;//����ID
	private String name;//������
	private Integer father_id;//��ID
	private Byte sign;// �Ƿ�Ϊ������   1-��   0-��
	private Date createDate;//����ʱ��
	private Date updateDate;//�޸�ʱ��
}

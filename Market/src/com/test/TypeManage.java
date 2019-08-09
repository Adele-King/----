package com.test;

import java.util.List;
import java.util.Scanner;

import com.dao.TypeDao;
import com.dao.impl.TypeDaoImpl;
import com.entity.Type;
import com.service.TypeService;
import com.service.impl.TypeServiceImpl;

public class TypeManage {


	private TypeDao typeDao;
	private TypeService typeService;

	private Scanner input = new Scanner(System.in);
	
	
	public void Manage() {
		System.out.println();
		System.out.println("********��Ʒ���͹���*********");
		System.out.println("1.	�����Ʒ����");
		System.out.println("2.	ɾ����Ʒ����");
		System.out.println("3.	�޸���Ʒ����");
		System.out.println("4.	��ѯ������Ʒ����");
		System.out.println("5.	��ѯȫ����Ʒ����");
		System.out.println("6.	��ѯ�������µ�����������");
		System.out.println("7.	������һ��");
		System.out.println("��ѡ��˵���");
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("����Ա����>��Ʒ���͹�����>�����Ʒ����");
			System.out.println();
			AddType();
			break;
		case 2:
			System.out.println();
			System.out.println("����Ա����>��Ʒ���͹�����>ɾ����Ʒ����");
			System.out.println();
			DeleteType();
			break;
		case 3:
			System.out.println();
			System.out.println("����Ա����>��Ʒ���͹�����>�޸���Ʒ����");
			System.out.println();
			UpdateType();
			break;
		case 4:
			System.out.println();
			System.out.println("����Ա����>��Ʒ���͹�����>��ѯ������Ʒ����");
			System.out.println();
			SelectOne();
			break;
		case 5:
			System.out.println();
			System.out.println("����Ա����>��Ʒ���͹�����>��ѯȫ����Ʒ����");
			System.out.println();
			SelectAll();
			break;
		case 6:
			System.out.println();
			System.out.println("����Ա����>��Ʒ���͹�����>��ѯ�������µ�����������");
			System.out.println();
			SelectAllChild();
			break;
		case 7:
			System.out.println();
			System.out.println("����Ա����>������һ��Ŀ¼");
			System.out.println();
			returnUp();
			break;
		default:
			System.out.println();
			System.out.println("ллʹ�ã�ף��������죡");
			System.out.println();
			break;
		}
	}
	
	//��ѯ���и��˵�
	private void SelectAllParent() {
		typeService = new TypeServiceImpl();
		
		try {
			List<Type> list = (List<Type>)typeService.selectAllParent(1).get("data");
			list.forEach(type->{
			//	System.out.println(type);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		returnManage();
	}
	//��ѯ�����Ӳ˵�
		private void SelectAllChild() {
			typeService = new TypeServiceImpl();
			
			try {
				List<Type> list = (List<Type>)typeService.selectAllChild(1, 0).get("data");
				list.forEach(type->{
				//	System.out.println(type);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			returnManage();
		}

	//������һ���˵�
	public void returnUp() {
		AdminMain am = new AdminMain();
		am.Menu();
	}
	
	//�����Ʒ����
	public void AddType() {
		typeDao = new TypeDaoImpl();
		Type type = new Type(null,"����",5,(byte) 0,null,null);
		
		try {
			System.out.println(typeDao.addType(type));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//�޸���Ʒ����
	public void UpdateType() {
		typeDao = new TypeDaoImpl();
		Type type = new Type(4,"�����ȴ�ˮ��",2,(byte) 0,null,null);
		
		try {
			System.out.println(typeDao.updateType(type));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//ɾ����Ʒ����
	public void DeleteType() {
		typeService = new TypeServiceImpl();
		
		try {
			System.out.println(typeService.deleteType(new int[] {30,40}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//��ѯ������Ʒ����
	public void SelectOne() {
		typeService = new TypeServiceImpl();
		
		try {
			System.out.println(typeService.selectOne(3).get("data"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//��ѯ������Ʒ����
	public void SelectAll() {
		typeService = new TypeServiceImpl();
		
		try {
			List<Type> list = (List<Type>)typeService.selectAll().get("data");
			list.forEach(type->{
//				System.out.println(goodsType);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		returnManage();
	} 
	
	//���ز˵�
	public void returnManage() {
		Scanner input = new Scanner(System.in);
		System.out.println("����0���ز˵���");
		if (input.nextInt() == 0) {
			Manage();
		} else {
			System.out.println("��������쳣��ֹ��");
		}
	}
}

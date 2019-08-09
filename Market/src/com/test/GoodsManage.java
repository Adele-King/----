package com.test;

import java.util.Scanner;

import com.dao.GoodsDao;
import com.dao.impl.GoodsDaoImpl;
import com.entity.Goods;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

public class GoodsManage {

	private GoodsDao goodsDao;
	private GoodsService goodsService;
	private Scanner input = new Scanner(System.in);
	
	public void Manage() {
		System.out.println();
		System.out.println("************��Ʒ��Ϣ����************");
		System.out.println("1.	�����Ʒ��Ϣ");
		System.out.println("2.	ɾ����Ʒ��Ϣ");
		System.out.println("3.	�޸���Ʒ��Ϣ");
		System.out.println("4.	��ѯ������Ʒ��Ϣ");
		System.out.println("5.	��ѯȫ����Ʒ��Ϣ");
		System.out.println("6.	������һ��Ŀ¼");
		System.out.println("��ѡ��˵���");
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("����Ա����>��Ʒ��Ϣ������>�����Ʒ��Ϣ");
			System.out.println();
			AddGoods();
			break;
		case 2:
			System.out.println();
			System.out.println("����Ա����>��Ʒ��Ϣ������>ɾ����Ʒ��Ϣ");
			System.out.println();
			DeleteGoods();
			break;
		case 3:
			System.out.println();
			System.out.println("����Ա����>��Ʒ��Ϣ������>�޸���Ʒ��Ϣ");
			System.out.println();
			UpdateGoods();
			break;
		case 4:
			System.out.println();
			System.out.println("����Ա����>��Ʒ��Ϣ������>��ѯ������Ʒ��Ϣ");
			System.out.println();
			SelectOne();
			break;
		case 5:
			System.out.println();
			System.out.println("����Ա����>��Ʒ��Ϣ������>��ѯȫ����Ʒ��Ϣ");
			System.out.println();
			SelectAll();
			break;
		case 6:
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

	private void returnUp() {
		AdminMain am = new AdminMain();
		am.Menu();
	}

	private void SelectAll() {
		goodsService = new GoodsServiceImpl();
		
		
		returnManage();
	}

	private void SelectOne() {
		goodsService = new GoodsServiceImpl();
		
		
		returnManage();
	}

	private void UpdateGoods() {
		goodsDao = new GoodsDaoImpl();
		Goods goods = new Goods();//////////////
		
		returnManage();
	}

	private void DeleteGoods() {
		goodsService = new GoodsServiceImpl();
		
		
		returnManage();
	}

	private void AddGoods() {
		goodsDao = new GoodsDaoImpl();
		Goods goods = new Goods();//////////////
		
		returnManage();
	}
	
	public void returnManage() {
		System.out.println("����0���ز˵���");
		if (input.nextInt() == 0) {
			Manage();
		} else {
			System.out.println("��������쳣��ֹ��");
		}
	}
}

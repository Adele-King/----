package com.test;

import java.util.Scanner;

public class AdminMain {


	private Scanner input = new Scanner(System.in);
	
	public void Menu() {
		
		System.out.println();
		System.out.println("��ã�����Ա��");
		System.out.println();
		System.out.println("********��ӭʹ�ñ�ϵͳ*********");
		System.out.println("1.	��Ʒ���͹���                              ");
		System.out.println("2.	��Ʒ����                                      ");
		System.out.println("3.	��Ա����                                      ");
		
		System.out.println("��ѡ��˵���");
		int choice = input.nextInt();
		
		switch(choice) {
		
		case 1:
			System.out.println("����Ա����>��Ʒ���͹���");
			TypeManage tm = new TypeManage();
			tm.Manage();
			break;
		case 2:
			System.out.println("����Ա����>��Ʒ����");
			GoodsManage gm = new GoodsManage();
			gm.Manage();
			break;
		case 3:
			System.out.println("����Ա����>��Ա����");
			MemberManage mm = new MemberManage();
			mm.Manage();
			break;
		default:
			System.out.println();
			System.out.println("ллʹ�ã�ף��������죡");
			System.out.println();
			break;
		}
	}
	
	
}


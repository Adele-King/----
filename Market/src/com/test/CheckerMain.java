package com.test;

import java.util.Scanner;


public class CheckerMain {

	private Scanner input = new Scanner(System.in);
	
	public void Menu() {
		System.out.println();
		System.out.println("��ã�����Ա��");
		System.out.println();
		System.out.println("********��ӭʹ�ñ�ϵͳ*********");
		System.out.println("1.	�������");
		System.out.println("2.	������ѯ");
		System.out.println("3. 	����ͳ��");
		
		System.out.println("��ѡ��˵���");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("����Ա����>�������");//��������ɾ�Ĳ�
			ShoppingManage sm = new ShoppingManage();
			sm.Manage();
			System.out.println();
			break;
		case 2:
			System.out.println();
			System.out.println("����Ա����>������ѯ");//��ѯ ��Ʒ���  ��Ա���
			QueryManage qm = new QueryManage();
			qm.Manage();
			System.out.println();
			break;
		case 3:
			System.out.println();
			System.out.println("����Ա����>����ͳ��");//��ѯ ����Ʒ���     ���·�   ����ǰʮ����Ʒ    ��������
			RankingManage rm = new RankingManage();
			rm.Manage();
			System.out.println();
			break;
		default:
			System.out.println();
			System.out.println("ллʹ�ã�ף��������죡");
			System.out.println();
			break;
		}
	}
	
}

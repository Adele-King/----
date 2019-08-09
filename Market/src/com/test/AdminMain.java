package com.test;

import java.util.Scanner;

public class AdminMain {


	private Scanner input = new Scanner(System.in);
	
	public void Menu() {
		
		System.out.println();
		System.out.println("你好，管理员！");
		System.out.println();
		System.out.println("********欢迎使用本系统*********");
		System.out.println("1.	商品类型管理                              ");
		System.out.println("2.	商品管理                                      ");
		System.out.println("3.	会员管理                                      ");
		
		System.out.println("请选择菜单：");
		int choice = input.nextInt();
		
		switch(choice) {
		
		case 1:
			System.out.println("管理员——>商品类型管理");
			TypeManage tm = new TypeManage();
			tm.Manage();
			break;
		case 2:
			System.out.println("管理员——>商品管理");
			GoodsManage gm = new GoodsManage();
			gm.Manage();
			break;
		case 3:
			System.out.println("管理员——>会员管理");
			MemberManage mm = new MemberManage();
			mm.Manage();
			break;
		default:
			System.out.println();
			System.out.println("谢谢使用，祝您生活愉快！");
			System.out.println();
			break;
		}
	}
	
	
}


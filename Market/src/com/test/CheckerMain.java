package com.test;

import java.util.Scanner;


public class CheckerMain {

	private Scanner input = new Scanner(System.in);
	
	public void Menu() {
		System.out.println();
		System.out.println("你好，收银员！");
		System.out.println();
		System.out.println("********欢迎使用本系统*********");
		System.out.println("1.	购物管理");
		System.out.println("2.	订单查询");
		System.out.println("3. 	排行统计");
		
		System.out.println("请选择菜单：");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("收银员——>购物管理");//订单的增删改查
			ShoppingManage sm = new ShoppingManage();
			sm.Manage();
			System.out.println();
			break;
		case 2:
			System.out.println();
			System.out.println("收银员——>订单查询");//查询 商品编号  会员编号
			QueryManage qm = new QueryManage();
			qm.Manage();
			System.out.println();
			break;
		case 3:
			System.out.println();
			System.out.println("收银员——>排行统计");//查询 按商品类别     按月份   销售前十的商品    总销售量
			RankingManage rm = new RankingManage();
			rm.Manage();
			System.out.println();
			break;
		default:
			System.out.println();
			System.out.println("谢谢使用，祝您生活愉快！");
			System.out.println();
			break;
		}
	}
	
}

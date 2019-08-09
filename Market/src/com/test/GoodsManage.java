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
		System.out.println("************商品信息管理************");
		System.out.println("1.	添加商品信息");
		System.out.println("2.	删除商品信息");
		System.out.println("3.	修改商品信息");
		System.out.println("4.	查询单个商品信息");
		System.out.println("5.	查询全部商品信息");
		System.out.println("6.	返回上一级目录");
		System.out.println("请选择菜单：");
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("管理员——>商品信息管理——>添加商品信息");
			System.out.println();
			AddGoods();
			break;
		case 2:
			System.out.println();
			System.out.println("管理员——>商品信息管理——>删除商品信息");
			System.out.println();
			DeleteGoods();
			break;
		case 3:
			System.out.println();
			System.out.println("管理员——>商品信息管理——>修改商品信息");
			System.out.println();
			UpdateGoods();
			break;
		case 4:
			System.out.println();
			System.out.println("管理员——>商品信息管理——>查询单个商品信息");
			System.out.println();
			SelectOne();
			break;
		case 5:
			System.out.println();
			System.out.println("管理员——>商品信息管理——>查询全部商品信息");
			System.out.println();
			SelectAll();
			break;
		case 6:
			System.out.println();
			System.out.println("管理员——>返回上一级目录");
			System.out.println();
			returnUp();
			break;
		default:
			System.out.println();
			System.out.println("谢谢使用，祝您生活愉快！");
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
		System.out.println("输入0返回菜单：");
		if (input.nextInt() == 0) {
			Manage();
		} else {
			System.out.println("输入错误，异常终止！");
		}
	}
}

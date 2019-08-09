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
		System.out.println("********商品类型管理*********");
		System.out.println("1.	添加商品类型");
		System.out.println("2.	删除商品类型");
		System.out.println("3.	修改商品类型");
		System.out.println("4.	查询单个商品类型");
		System.out.println("5.	查询全部商品类型");
		System.out.println("6.	查询父类型下的所有子类型");
		System.out.println("7.	返回上一级");
		System.out.println("请选择菜单：");
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("管理员——>商品类型管理——>添加商品类型");
			System.out.println();
			AddType();
			break;
		case 2:
			System.out.println();
			System.out.println("管理员——>商品类型管理——>删除商品类型");
			System.out.println();
			DeleteType();
			break;
		case 3:
			System.out.println();
			System.out.println("管理员——>商品类型管理——>修改商品类型");
			System.out.println();
			UpdateType();
			break;
		case 4:
			System.out.println();
			System.out.println("管理员——>商品类型管理——>查询单个商品类型");
			System.out.println();
			SelectOne();
			break;
		case 5:
			System.out.println();
			System.out.println("管理员——>商品类型管理——>查询全部商品类型");
			System.out.println();
			SelectAll();
			break;
		case 6:
			System.out.println();
			System.out.println("管理员——>商品类型管理——>查询父类型下的所有子类型");
			System.out.println();
			SelectAllChild();
			break;
		case 7:
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
	
	//查询所有父菜单
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
	//查询所有子菜单
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

	//返回上一级菜单
	public void returnUp() {
		AdminMain am = new AdminMain();
		am.Menu();
	}
	
	//添加商品类型
	public void AddType() {
		typeDao = new TypeDaoImpl();
		Type type = new Type(null,"布丁",5,(byte) 0,null,null);
		
		try {
			System.out.println(typeDao.addType(type));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//修改商品类型
	public void UpdateType() {
		typeDao = new TypeDaoImpl();
		Type type = new Type(4,"国内热带水果",2,(byte) 0,null,null);
		
		try {
			System.out.println(typeDao.updateType(type));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//删除商品类型
	public void DeleteType() {
		typeService = new TypeServiceImpl();
		
		try {
			System.out.println(typeService.deleteType(new int[] {30,40}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//查询单个商品类型
	public void SelectOne() {
		typeService = new TypeServiceImpl();
		
		try {
			System.out.println(typeService.selectOne(3).get("data"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	//查询所有商品类型
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
	
	//返回菜单
	public void returnManage() {
		Scanner input = new Scanner(System.in);
		System.out.println("输入0返回菜单：");
		if (input.nextInt() == 0) {
			Manage();
		} else {
			System.out.println("输入错误，异常终止！");
		}
	}
}

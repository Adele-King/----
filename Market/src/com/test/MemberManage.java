package com.test;

import java.util.List;
import java.util.Scanner;

import com.dao.MemberDao;
import com.dao.impl.MemberDaoImpl;
import com.entity.Member;
import com.service.MemberService;
import com.service.impl.MemberServiceImpl;

public class MemberManage {

	private MemberDao memberDao;
	private MemberService memberService;
	private Scanner input = new Scanner(System.in);
	
	public void Manage () {
		System.out.println();
		System.out.println("********会员信息管理*********"); 
		System.out.println("1.	添加会员信息");
		System.out.println("2.	删除会员信息");
		System.out.println("3.	修改会员信息");
		System.out.println("4.	查询单个会员信息");
		System.out.println("5.	查询全部会员信息");
		System.out.println("6.	会员余额充值");
		System.out.println("7.	返回上一级");
		System.out.println("请选择菜单：");
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("管理员——>会员信息管理——>添加会员信息");
			System.out.println();
			AddMember();
			break;
		case 2:
			System.out.println();
			System.out.println("管理员——>会员信息管理——>删除会员信息");
			System.out.println();
			DeleteMember();
			break;
		case 3:
			System.out.println();
			System.out.println("管理员——>会员信息管理——>修改会员信息");
			System.out.println();
			UpdateMember();
			break;
		case 4:
			System.out.println();
			System.out.println("管理员——>会员信息管理——>查询单个会员信息");
			System.out.println();
			SelectOne();
			break;
		case 5:
			System.out.println();
			System.out.println("管理员——>会员信息管理——>查询全部会员信息");
			System.out.println();
			SelectAll();
			break;
		case 6:
			System.out.println();
			System.out.println("管理员——>会员信息管理——>会员余额充值");
			System.out.println();
		//	UpdateAccount();
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
	
	public void returnUp() {
		AdminMain am = new AdminMain();
		am.Menu();
	}
	
	public void AddMember() {
		memberDao = new MemberDaoImpl();
	//	Member member = new Member(null,"李想","123",400.00,0,"1679827792",null,null);////////////////////////////////////////
		
//		try {
//			System.out.println(memberDao.addMember(member));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		returnManage();
	}
	
	public void UpdateMember() {
		memberDao = new MemberDaoImpl();
		Member member = new Member();/////////////////////////////
		
		try {
			System.out.println(memberDao.updateMember(member));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	public void DeleteMember() {
		memberService = new MemberServiceImpl();
		
		try {
			System.out.println(memberService.deleteMember(new int[] {30,40}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	public void SelectOne() {
		memberService = new MemberServiceImpl();
		
		try {
			System.out.println(memberService.selectOne(3).get("data"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		returnManage();
	}
	
	public void SelectAll() {
		memberService = new MemberServiceImpl();
		
		try {
			List<Member> list = (List<Member>)memberService.selectAll().get("data");
			list.forEach(member->{
//				System.out.println(goodsType);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
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

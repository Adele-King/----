package com.test;

import java.util.Scanner;

/**
 * 	 分角色登录
 * @author 宋月娥
 * @Date 2019年8月5日
 */
public class Login {


	private Scanner input = new Scanner(System.in);		
	

	public static void main(String[] args) {
		Login st = new Login();
		st.Start();
	}
	
	public void Start() {		
		
		System.out.println("********欢迎使用家庭超市管理系统********");
		System.out.println("*我们将为您提供   温馨                                               *");
		System.out.println("*               高效                                   *");
		System.out.println("*                   便捷  的购物体验   *");
		System.out.println("*********************************");
			
			System.out.println("请输入账户：");
			String user = input.next();
			System.out.println("请输入密码：");
			String pwd = input.next();
			
			if (user.equals("admin") && pwd.equals("123")) {
				AdminMain am = new AdminMain();
				am.Menu();
			} else if(user.equals("checker") && pwd.equals("321")) {
				CheckerMain cm = new CheckerMain();
				cm.Menu();
			} else {
				System.out.println("您的账号或密码错误！");
			}
	}
}

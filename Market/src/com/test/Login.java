package com.test;

import java.util.Scanner;

/**
 * 	 �ֽ�ɫ��¼
 * @author ���¶�
 * @Date 2019��8��5��
 */
public class Login {


	private Scanner input = new Scanner(System.in);		
	

	public static void main(String[] args) {
		Login st = new Login();
		st.Start();
	}
	
	public void Start() {		
		
		System.out.println("********��ӭʹ�ü�ͥ���й���ϵͳ********");
		System.out.println("*���ǽ�Ϊ���ṩ   ��ܰ                                               *");
		System.out.println("*               ��Ч                                   *");
		System.out.println("*                   ���  �Ĺ�������   *");
		System.out.println("*********************************");
			
			System.out.println("�������˻���");
			String user = input.next();
			System.out.println("���������룺");
			String pwd = input.next();
			
			if (user.equals("admin") && pwd.equals("123")) {
				AdminMain am = new AdminMain();
				am.Menu();
			} else if(user.equals("checker") && pwd.equals("321")) {
				CheckerMain cm = new CheckerMain();
				cm.Menu();
			} else {
				System.out.println("�����˺Ż��������");
			}
	}
}

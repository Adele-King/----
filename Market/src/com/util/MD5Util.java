package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class MD5Util {

	public static String encodePass(String pass) {
		Objects.requireNonNull(pass);
		
		try {
			//��������м��ܲ���    MD5��ϢժҪ�㷨
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//�����ܵ����ݴ���messageDigest
			messageDigest.update(pass.getBytes());
			//��������
			byte[] by = messageDigest.digest();
			//BigInteger
			String encodePass = new BigInteger(1, by).toString(16);
			return encodePass;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}

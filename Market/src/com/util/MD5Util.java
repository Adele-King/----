package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class MD5Util {

	public static String encodePass(String pass) {
		Objects.requireNonNull(pass);
		
		try {
			//对密码进行加密操作    MD5信息摘要算法
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//将加密的数据传到messageDigest
			messageDigest.update(pass.getBytes());
			//加密数据
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

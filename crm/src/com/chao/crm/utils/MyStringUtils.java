package com.chao.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MyStringUtils {
	/**
	 * ���md5���ܺ������
	 * 
	 * @param value
	 *            ����
	 * @return ����
	 */
	public static String getMD5Value(String value) {

		try {
			// 1 ���jdk�ṩ��ϢժҪ�㷨������
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 2 ���ܵĽ��10����
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			// 3��10���� ת��16����
			// System.out.println(Arrays.toString(md5ValueByteArray));
			BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);

			return bigInteger.toString(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
			// ����������쳣����Ĭ��ֵ
			// return value;
		}
	}

	public static void main(String[] args) {
		System.out.println(getMD5Value("1234"));
	}
}

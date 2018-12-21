package com.java.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * MD5 算法
 */
public class Md5Util {

	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public Md5Util() {
	}

	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// 转换字节数组为16进制字串
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	// 调用此方法来对密码进行加密(非标准)
	public static String GetMD5Code(String strObj) {
		String resultString1 = null;
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString1 = byteToString(md.digest(strObj.getBytes()));
			//把得到的结果向右移动一位，最后一位移动到第一位
			resultString = resultString1.substring(resultString1.length() - 1)
					+ resultString1.substring(0, resultString1.length() - 1);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}
	// 调用此方法来对密码进行加密(标准)
	public static String GetYMMD5Code(String strObj) {
		String resultString1 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString1 = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString1;
	}
}

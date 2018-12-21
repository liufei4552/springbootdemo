package com.java.utils;

import com.google.gson.Gson;

/**
 * TODO: File comments
 * <p>
 * <p>
 * Author:          LF
 * <p>
 * Date:           2018年7月24日
 * <p>
 * Time:           下午5:09:04
 * <p>
 * Director:        LF
 * <p>
 * <p>
 */
public class StringUtile {
	/**
	 * 传入一个逗号隔开的字符串，然后为每个字符串加上引号返回
	 * @param str
	 * @return
	 */
	public static String Conversion(String str) {
		String str3 = "";
		if (!"".equals(str)&&str!=null) {
			String[] str1 = str.split(",");
			for (int i = 0; i < str1.length; i++) {
				if (i == 0) {
					str3 = "\'" + str1[0] + "\'";
				} else {
					str3 += ",\'" + str1[i] + "\'";
				}

			}
			return str3;
		}
		return "";
	}

	/**
	 * 把object类型数据转化为json字符串
	 * @param object
	 * @return
	 */
	public static  String toJson(Object object){
		Gson gson=new Gson();
		String json=gson.toJson(object);
		return json;
	}

	/**
	 * 去除字符串中的制表符
	 * @param str
	 * @return
	 */
	public static String getString(String str){
		return str.replaceAll("[\b\r\n\t]*", "");
	}
	public static void main(String[] args) {
		String str = null;
		System.out.println(Conversion(str));
	}
}

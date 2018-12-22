/*
 * File name:          Test.java
 * Copyright@Lanqiao (China)
 * Editor:           JDK1.7.32
 */
package com.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO: File comments
 * <p>
 * <p>
 * Author:          LF
 * <p>
 * Date:           2017年3月1日
 * <p>
 * Time:           下午5:27:06
 * <p>
 * Director:        LF
 * <p>
 * <p>
 */
public class Readproperties {
	/**
	* 获取配置信息
	*/
	public String getProperties(String sign) {
		InputStream in = getClass().getResourceAsStream("/application.properties");
		Properties prop = new Properties();
		String properties = "";
		try {
			prop.load(in);
			properties = prop.getProperty(sign).toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return properties;
	}
}

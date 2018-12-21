package com.java.utils;

import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class UrlUtils {

	public static String getURLContent(String urlStr) {
		try {
			URL realUrl = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setReadTimeout(10000);
			connection.setConnectTimeout(10000);
			int responseCode = connection.getResponseCode();
			StringBuffer sb = new StringBuffer();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream urlStream = connection.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlStream, "GB2312"));
				String sCurrentLine = "";
				while ((sCurrentLine = bufferedReader.readLine()) != null) {
					sb.append(sCurrentLine);
				}
				return ChangeCharset.changeCharset(sb.toString(), "UTF-8");
			}
		} catch (Exception e) {
		}
		return "";
	}

	public static void main(String[] args) {
		String str = getURLContent("http://info.sporttery.cn/interface/interface_mixed.php?action=bk_list");
		//System.out.println(str);
		String[] str2 = str.split(";");
		String str3 = str2[2];
		//System.out.println(str3);
		System.out.println("------------------------");
		String str4 = StringUtils.substringAfter(str3, "=");
		//System.out.println(str4);

		JSONArray jsonArray = JSONArray.fromObject(str4);
		//System.out.println(jsonArray);
		Object[] os = jsonArray .toArray();
		//System.out.println(os[0]);
		JSONArray arr = JSONArray.fromObject(os[0]);
		for(Object o :arr){
			JSONArray a = (JSONArray)o;
			System.out.println(a);
			for(int i = 0 ; i < a.size() ; i++){
				System.out.println(a.get(i));
			}
		}

	}
}
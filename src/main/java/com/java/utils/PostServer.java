package com.java.utils;

import com.google.gson.Gson;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PostServer {

	public static String post(String params) throws Exception{
		HttpURLConnection httpConn = null;
		BufferedReader in = null;
		PrintWriter out = null;
		Readproperties r = new Readproperties();
		String path = r.getProperties("Url") + ":" + r.getProperties("PortNumber");
		JSONObject json = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			URL url = new URL(path);
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);

			try {
				//发送post请求参数
				out = new PrintWriter(new OutputStreamWriter(httpConn.getOutputStream(), "utf-8"));
				out.println(params);
				out.flush();

				//读取响应
				if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					StringBuffer content = new StringBuffer();
					String tempStr = "";
					in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
					while ((tempStr = in.readLine()) != null) {
						content.append(tempStr);
					}
					String str = content.toString();
					json = JSONObject.fromObject(str);
				}
			} catch (Exception e) {
				map.put("res", -2);
				json = JSONObject.fromObject(map);
				LogUtil.getGMLog("连接服务器失败，请检查服务器是否已开启。");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				httpConn.disconnect();
			} catch (Exception e) {
				LogUtil.getGMLog("输入流关闭失败。");
			}
		}
		Gson gson = new Gson();
		String json1 = gson.toJson(json);
		return json1;
	}
}

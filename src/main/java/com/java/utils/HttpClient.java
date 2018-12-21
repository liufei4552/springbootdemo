package com.java.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpClient {
	//发送一个GET请求
	public static String get(String path) throws Exception{
	    HttpURLConnection httpConn=null;
	    BufferedReader in=null;
	    try {
	        URL url=new URL(path);
	        httpConn=(HttpURLConnection)url.openConnection();
	         
	        //读取响应
	        if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
	            StringBuffer content=new StringBuffer();
	            String tempStr="";
	            in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
	            while((tempStr=in.readLine())!=null){
	                content.append(tempStr);
	            }
	            return content.toString();
	        }else{
	            throw new Exception("请求出现了问题!");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally{
	        in.close();
	        httpConn.disconnect();
	    }
	    return null;
	}
	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！"+e);
			e.printStackTrace();
		}
		//使用finally块来关闭输出流、输入流
		finally{
			try{
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	/**
	 * 向指定URL发送POST请求
	 * @return 响应结果
	 */
	public static String Post(Map<String, String> paramMap) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		//获取地址和端口
		Readproperties readproperties=new Readproperties();
		String url= readproperties.getProperties("Url") + ":" + readproperties.getProperties("PortNumber");
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// conn.setRequestProperty("Charset", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 设置请求属性
			StringBuilder param = new StringBuilder();
			if (paramMap != null && paramMap.size() > 0) {
				for (String key : paramMap.keySet()) {
					String value = paramMap.get(key);
					param.append(key).append("=").append(value).append("&");
				}
				param = new StringBuilder(param.substring(0, param.length() - 1));
			}

			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			System.err.println("发送 POST 请求出现异常！");
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		//String resMessage=HttpClient.get("http://localhost:3000/hello?hello=hello get");

		String str=HttpClient.sendPost("http://119.57.115.6:8088/interface_decai/interface_recieve.php","cmd=2001&msg=<?xml \n" +
				"\n" +
				" version=\"1.0\" urlencode=\"UTF-8\"?><msg v=\"1.0\" id=\"824793057391022080\"><head><agentid>800151</agentid><cmd>2001</cmd><timestamp>20180522152817</timestamp><cipher>dc1b93ac686c4505c010e9386d187922</cipher></head><body><order lotteryid=\"201\" issue=\"2018058\"><ticket seq=\"824792948087459840\">01_01_01,02,03,04,05,06#10_1_200</ticket></order></body></msg>&inf=jm001\n");
		System.out.println(str);
		//Gson gson=new Gson();
		//System.out.println(gson.toJson(str));
		System.out.println("-------------------------------------------------");
		//Map<String,String>map=new HashMap<>();
		//map.put("nMsgID", "2003");
		//String path="http://192.168.199.90:31004";
		//System.out.println(Post(map));*/
		System.out.println("--------------------------------------------------");

	}

}

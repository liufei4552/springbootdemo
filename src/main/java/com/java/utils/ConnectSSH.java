package com.java.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ConnectSSH {


	public static void go() {
		Readproperties readproperties=new Readproperties();
		 int lport = Integer.parseInt(readproperties.getProperties("localport"));//本地端口
		 String rhost =readproperties.getProperties("rhost");//远程MySQL服务器
		 int rport = Integer.parseInt(readproperties.getProperties("rport"));//远程MySQL服务端口
		String user =readproperties.getProperties("sshuser");//SSH连接用户名
		String password =readproperties.getProperties("sshpassword");//SSH连接密码
		String host =readproperties.getProperties("rserverhost");//SSH服务器
		int port = Integer.parseInt(readproperties.getProperties("serverport"));//SSH访问端口
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
			int assinged_port = session.setPortForwardingL(lport, rhost, rport);
			System.out.println("SSH连接成功:"+"localhost:" + assinged_port + " -> " + rhost + ":" + rport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

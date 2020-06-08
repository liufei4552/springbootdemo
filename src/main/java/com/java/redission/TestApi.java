package com.java.redission;


import com.java.redission.util.RedissLockUtil;
import com.java.redission.util.RedissonLockKeys;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 测试类
 * @author ko
 *
 */
@RestController
@RequestMapping("'/lock")
public class TestApi {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String getCurrentDate(){
		return sdf.format(new Date());
	}

	public static void main(String[] args) {
		testlock("liufei1");
		/*testlock("liufei2");
		testlock("liufei3");*/
	}
	public static String testlock(String name) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
					
				RedissLockUtil.lock(RedissonLockKeys.getTicketOrderkey("001"), TimeUnit.MINUTES, 10);
				
				System.out.println(getCurrentDate()+" "+name+" begin...");
				for (int i = 0; i < 20; i++) {
					try {
						Thread.sleep(1000);
						System.out.println(getCurrentDate()+" "+name+" "+i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(getCurrentDate()+" "+name+" end...");
				
				RedissLockUtil.unlock(RedissonLockKeys.getTicketOrderkey("TK001"));
			}
		}).start();

		return "testlock";
	}
	
}

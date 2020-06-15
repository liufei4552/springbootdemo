package com.java.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.java.bean.User;
import com.java.config.MailConfig;
import com.java.service.UserService;
import com.java.utils.JSONUtil;
import com.java.utils.Page;
import com.java.utils.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.service.impl
 * @ClassName: UserServiceImplTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 15:17
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
//里面内容是为了websocket加的
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HutoolTest {
	@Autowired
	private MailConfig mailConfig;
	@Test
	public void findCount() {
		//邮件发送测试
		/*MailAccount account = new MailAccount();
		account.setHost("smtp.qq.com");
		account.setPort(25);
		account.setAuth(true);
		account.setFrom("304265966@qq.com");
		account.setUser("304265966@qq.com");
		account.setPass("bdascnmkpezhbgej");

		MailUtil.send(account, CollUtil.newArrayList("304265966@qq.com"), "测试", "邮件来自Hutool测试", false);*/
		//企业邮箱
		//邮件发送测试
		MailAccount account1 = new MailAccount();
		account1.setHost(mailConfig.getHost());
		account1.setPort(mailConfig.getPort());
		account1.setAuth(true);
		account1.setFrom(mailConfig.getFrom());
		account1.setUser(mailConfig.getUser());
		account1.setPass(mailConfig.getPass());

		MailUtil.send(account1, CollUtil.newArrayList("304265966@qq.com"), "测试", "邮件来自Hutool测试", false);
	}
}
package com.java.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HutoolTest {
    public static void main(String[] args) {
        //md5加密
        String str1=SecureUtil.md5("123");
        log.info("加密后的字符串:{}",str1);
        //#########################类型转换工具类-Convert
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        log.info("int转string:{}",aStr);
        long[] b = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        log.info("int数组转string:{}",bStr);
        String[] c = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(c);
        log.info("{}",intArray.length);
        long[] d = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(d);
        log.info("{}",intArray2.length);

        String e = "2017-05-06";
        Date value = Convert.toDate(e);
        log.info("{}",value);

        String ab = "我是一个小小的可爱的字符串";

        //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(ab);
        log.info("{}",unicode);
        //结果为："我是一个小小的可爱的字符串"
        String raw = Convert.unicodeToStr(unicode);
        log.info("{}",raw);
        //Convert.convertTime方法主要用于转换时长单位，比如一个很大的毫秒，我想获得这个毫秒数对应多少分：
        long ac = 4535345;
        //结果为：75
        long minutes = Convert.convertTime(ac, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
        //面对财务类需求，Convert.digitToChinese将金钱数转换为大写形式：
        double ad = 67556.32;
        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(ad);

        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();

        String id=IdUtil.objectId();
        log.info("{}",id);

        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        long id2 = snowflake.nextId();
        log.info("{}",id2);

        //邮件发送测试
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("304265966@qq.com");
        account.setUser("304265966@qq.com");
        account.setPass("bdascnmkpezhbgej");

        MailUtil.send(account, CollUtil.newArrayList("304265966@qq.com"), "测试", "邮件来自Hutool测试", false);
        //企业邮箱
        //邮件发送测试
        MailAccount account1 = new MailAccount();
        account1.setHost("smtp.exmail.qq.com");
        account1.setPort(25);
        account1.setAuth(true);
        account1.setFrom("ota@roamwifi.com");
        account1.setUser("ota@roamwifi.com");
        account1.setPass("Roam.190730123@#");

        MailUtil.send(account, CollUtil.newArrayList("304265966@qq.com"), "测试", "邮件来自Hutool测试", false);
    }
}

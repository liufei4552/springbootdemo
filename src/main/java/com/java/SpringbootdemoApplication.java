package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
/**
 *@Mapper在dao的类上声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
 */
@MapperScan("com.java.dao")
/**
 *开启事务管理
 */
@EnableTransactionManagement
/**
* @Author LiuFei 
* @Description springboot程序启动类
* @Date 18:01 2018/12/22
* @Param 
* @return 
**/
public class SpringbootdemoApplication {
	/**
	 * 程序启动主函数
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}


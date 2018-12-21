package com.java.utils;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
	/**
	 * 模块
	 * @return
	 */
	String module() default "";

	/**
	 * 方法描述
	 * @return
	 */
	String methods() default "";

	/**
	 * 方法编号
	 * @return
	 */
	String methods_id() default "";
}

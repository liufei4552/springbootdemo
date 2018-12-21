package com.java.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @ProjectName: fishing_aw
 * @Package: com.huofeng.utils
 * @ClassName: ObjectUtils
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/18 19:29
 * @Version: 1.0
 */
public class ObjectUtils {
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof CharSequence) {
			return ((CharSequence) obj).length() == 0;
		} else if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		} else if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		} else if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		return false;
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}

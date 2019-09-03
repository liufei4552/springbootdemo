package com.java.utils;

import java.util.UUID;

public class UUIDUtils {

    /**
     * 生成32位UUID
     *
     * @return
     */
    public static String getID32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

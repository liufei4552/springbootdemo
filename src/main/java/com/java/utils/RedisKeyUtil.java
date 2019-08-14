package com.java.utils;


import com.github.pagehelper.StringUtil;

/**
 * redis key生成类
 */
public class RedisKeyUtil {

    private static final String KEY_PREFIX="springbootdemo";

    private static final String KEY_SPLIT_CHAR=":";


    /**
     * redis key生成 RedisKeyUtil.keyBuilder("dict","all")
     * @param module
     * @param args
     * @return
     */
    public static String keyBuilder(String module,String... args){
        //KEY_PREFIX 为项目前缀
        StringBuffer key = new StringBuffer(KEY_PREFIX);
        key.append(KEY_SPLIT_CHAR).append(module);
        // KEY_SPLIT_CHAR 为分割字符
        for (String arg : args) {
            if(StringUtil.isEmpty(arg)){
                continue;
            }
            if (arg.indexOf(":") > 0) {
                for (String a : arg.split(":")) {
                    key.append(KEY_SPLIT_CHAR).append(a);
                }
            } else
                key.append(KEY_SPLIT_CHAR).append(arg);
        }
        return key.toString();
    }
}

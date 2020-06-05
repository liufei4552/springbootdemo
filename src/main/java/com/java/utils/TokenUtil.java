/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.java.utils;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;


/**
 * 生成token
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component
public class TokenUtil {

    @Autowired
    private static RedisUtil redisUtil;

   /* private static TokenUtil tokenUtil;

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }
    @PostConstruct
    public void init() {
        tokenUtil = this;
        tokenUtil.redisUtil = this.redisUtil;
    }
*/
        //30天后过期
    private final static int EXPIRE = 3600 * 12 * 30;

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new RuntimeException("生成Token失败", e);
        }
    }

    public static String generateValue(String phone, String password, String uuid) {

        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            Long timeStamp =new Date().getTime();
            String param =phone+password+uuid+timeStamp;
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("生成Token失败", e);
        }


    }

    public static boolean volidateToken(String token, String uuid) {
        String key0=RedisKeys.getHeaderTokenKey(token);
        String redisPhone = (String) redisUtil.get(key0);
        if(StringUtil.isEmptyOrNull(redisPhone)){
            return false;
        }
        String key1=RedisKeys.getLoginUuidKey(redisPhone);
        String redisUuid = (String) redisUtil.get(key1);
        if(uuid.equals(redisUuid)){
            //重新设置超期时间
            redisUtil.set(key0,redisPhone,EXPIRE);
            redisUtil.set(key1,redisUuid,EXPIRE);
            return true;

        }else {
            redisUtil.del(key0);
            redisUtil.del(key1);
            return false;


        }
    }
}

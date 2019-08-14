package com.java.utils;

import java.util.Random;

/**
 * 缓存过期时间设置
 * @author 李国梁
 * @date 2019/03/13 09:55
 */
public class CacheExpiredTime {

    private CacheExpiredTime() {
    }

    /**
     * 检测缺陷项平行数据缓存时间
     */
    public static final int DEFECT_CHECK_ITEM = CacheTimeGenerate(60*60*6);

    /**
     * 品牌数据缓存时间
     */
    public static final int GroupBrands = CacheTimeGenerate(60*60*8);

    /**
     * 车系数据缓存时间
     */
    public static final int GroupSubSeries = CacheTimeGenerate(60*60*8);

    /**
     * 款型数据缓存时间
     */
    public static final int GroupCarModel = CacheTimeGenerate(60*60*8);

    /**
     * 款型配置数据缓存时间
     */
    public static final int CarModelConfig = CacheTimeGenerate(60*60*8);

    /**
     * vin码解析结果缓存时间
     */
    public static final int CarVinData = CacheTimeGenerate(60*60*8);

    /**
     * 生成缓存时间
     * @param cacheSeconds 缓存秒数
     * @return
     */
    public static int CacheTimeGenerate(int cacheSeconds) {
        return cacheSeconds + new Random().nextInt(1800);
    }
}

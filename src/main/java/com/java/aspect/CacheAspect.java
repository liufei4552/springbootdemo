package com.java.aspect;

import com.java.annotation.RedisCache;
import com.java.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ProjectName
 * @Author liufei
 * @CreateTime 2019-08-14 17:12
 * @Description
 **/
@Aspect
@Slf4j
@Component
public class CacheAspect {

    @Autowired
    private RedisUtil redisUtil;

    @Pointcut("@annotation(com.java.annotation.RedisCache))")
    private void cacheHandler() {
    }

    @Around("cacheHandler()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        log.info("RedisCache进入aop-------");
        Object[] args = pjp.getArgs();

        Class clazz = pjp.getTarget().getClass();
        Class[] params = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        String methodName = pjp.getSignature().getName();

        Method method = clazz.getMethod(methodName, params);
        RedisCache redisCache = method.getAnnotation(RedisCache.class);
        if (null == redisCache) {
            return pjp.proceed(args);
        }

        String redisKey = redisCache.redisKey();

        StringBuffer argValue = new StringBuffer();
        if (null != args && args.length > 0) {
            for (Object arg : args) {
                if (null == arg) {
                    continue;
                }
                argValue.append(arg.toString()).append("#");
            }
        }

        String argValueKey = "";
        if (argValue.length() > 1) {
            argValueKey = Md5Util.GetYMMD5Code(argValue.substring(0, argValue.length() - 1));
        }
        int expireTime = redisCache.expireTime();

        final String cacheKey = RedisKeyUtil.keyBuilder(redisKey, argValueKey);
        int expireTimeRandom = CacheExpiredTime.CacheTimeGenerate(expireTime);

        Object redisValue = redisUtil.get(cacheKey);
        if (null == redisValue) {
            Object object = pjp.proceed(args);
            if (null == object ){
                log.info("RedisCache结束aop--------，调用目标方法返回null，不设置缓存");
                return object;
            }
            if (object instanceof Result){
                Result result = (Result) object;
                if (result.isSuccess() && null != result.getData()){
                    redisUtil.set(cacheKey, object, expireTimeRandom);
                    log.info("RedisCache结束aop--------，缓存中没有，设置缓存");
                }else {
                    log.info("RedisCache结束aop--------，调用目标方法返回Result，结果为false，不设置缓存");
                }
            }else {
                redisUtil.set(cacheKey, object, expireTimeRandom);
                log.info("RedisCache结束aop--------，缓存中没有，设置缓存");
            }
            return object;
        }

        log.info("RedisCache结束aop--------，缓存中存在，直接返回");
        return redisValue;
    }
}

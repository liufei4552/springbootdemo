package com.java.controller;

import com.java.bean.User;
import com.java.service.UserService;
import com.java.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.controller
 * @ClassName: UserController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 15:37
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "用户信息api")
@Slf4j
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    @ApiOperation("登录")
    public Result<Integer> login( @ApiParam("账号") @RequestParam(value = "name", required = true) String name, @ApiParam("密码") @RequestParam(value = "pass", required = true) String pass) {
       log.info("用户登录账号密码name={},pass={}................................",name,pass);
        Result result = new Result();
        try {
            int i = service.login(name, pass);
            Map<String,String>map=new HashMap<>();
            String token= TokenUtil.generateValue(name,pass, UUID.randomUUID().toString());
            map.put("token",token);
            redisUtil.del(name);
            redisUtil.set(name,token,30);
            result.setData(map);
            return result;
        } catch (Exception e) {
            log.error("" + e);
            result = Result.fail("200", "未知错误！");
            return result;
        }
    }

    @RequestMapping(value = "getAllUser", method = RequestMethod.GET)
    @ApiOperation("查询所有的用户信息")
    public Result<Page<User>> getAllUser( @ApiParam("页数") @RequestParam(value = "page", required = false) String page, @ApiParam("每页数目") @RequestParam(value = "pageSize", required = false) String pageSize) {
        log.info("查询所有用户信息page={},pageSize={}",page,pageSize);
        if(StringUtile.isEmpty(page)|| StringUtile.isEmpty(pageSize)){
            return Result.fail("500","参数不能为空");
        }
        return service.findAll(Integer.parseInt(page),Integer.parseInt(pageSize));
    }
}

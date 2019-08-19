package com.java.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @projectName: springbootdemo
 * @package: com.java.bean
 * @className: Student
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/16  14:44
 * @version: 1.0
 */
@Data
@ToString
@ApiModel("学生信息")
public class Student {
    /**
     * 索引
     */
    @ApiModelProperty("id")
    private int id;
    /**
     * 用户名
     */
    @ApiModelProperty("学生姓名")
    private String studentName;
    /**
     * 用户密码
     */
    @ApiModelProperty("学生密码")
    private String password;
    /**
     * 生日
     */
    @ApiModelProperty("出生日期")
    private String birth;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String gender;
    /**
     * 邮件
     */
    @ApiModelProperty("邮箱")
    private String email;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String status;
    /**
     * 注册时间
     */
    @ApiModelProperty("注册时间")
    private String regTime;

}

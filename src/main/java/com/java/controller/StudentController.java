package com.java.controller;

import com.java.bean.Student;
import com.java.service.StudentService;
import com.java.utils.Result;
import com.java.utils.StringUtile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: springbootdemo
 * @package: com.java.controller
 * @className: StudentController
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/19  15:48
 * @version: 1.0
 */
@RestController
@RequestMapping("/student")
@Api(value = "/student", description = "学生信息")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation("插入信息")
    public Result<Object> insert(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiModelProperty("删除学生信息")
    public Result<Object> deletect(@ApiParam("学生ID") @RequestParam(value = "studentId", required = false) String studentId) {
        if (StringUtile.isNotEmpty(studentId)) {
            return studentService.delete(studentId);
        } else {
            return Result.fail("500", "参数不能为空！");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("修改学生信息")
    public Result<Object> update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation("查询学生信息")
    public Result<Object> query(@ApiParam("学生ID") @RequestParam(value = "studentId", required = false) String studentId) {
        if(StringUtile.isNotEmpty(studentId)){
            return studentService.query(studentId);
        }else {
            return Result.fail("500","参数不能为空!");
        }
    }

}

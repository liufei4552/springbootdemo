package com.java.service;

import com.java.bean.Student;
import com.java.utils.Result;

/**
 * @projectName: springbootdemo
 * @package: com.java.service
 * @className: StudentService
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/16  17:44
 * @version: 1.0
 */
public interface StudentService {

    public Result<Object> insert(Student student);

    public Result<Object>delete(String studentId);

    public Result<Object>update(Student student);

    public Result<Object>query(String studentId);
}

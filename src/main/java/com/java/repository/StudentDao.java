package com.java.repository;

import com.java.bean.Student;
import com.java.bean.User;
import com.java.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @projectName: springbootdemo
 * @package: com.java.dao
 * @className: Student
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/16  14:47
 * @version: 1.0
 */
public interface StudentDao {
    public Result<Object> insert(Student student);

    public Result<Object>delete(String studentId);

    public Result<Object>update(Student student);

    public Result<Object>query(String studentId);
}

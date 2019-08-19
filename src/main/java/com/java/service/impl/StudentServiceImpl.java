package com.java.service.impl;

import com.java.bean.Student;
import com.java.repository.StudentDao;
import com.java.service.StudentService;
import com.java.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: springbootdemo
 * @package: com.java.service.impl
 * @className: StudentServiceImpl
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/16  17:45
 * @version: 1.0
 */
@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    @Override
    public Result<Object> insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public Result<Object> delete(String studentId) {
        return studentDao.delete(studentId);
    }

    @Override
    public Result<Object> update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Result<Object> query(String studentId) {
        return studentDao.query(studentId);
    }
}

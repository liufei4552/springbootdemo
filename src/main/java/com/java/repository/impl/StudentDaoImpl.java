package com.java.repository.impl;

import com.java.bean.Student;
import com.java.bean.User;
import com.java.repository.StudentDao;
import com.java.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @projectName: springbootdemo
 * @package: com.java.repository.impl
 * @className: StudentDaoImpl
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/16  14:59
 * @version: 1.0
 */
@Repository("StudentDaoImpl")
@Slf4j
public class StudentDaoImpl implements StudentDao {
    /**
     * 表名
     */
    private static final String collectionName = "student";
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Result<Object> insert(Student student) {
        Result<Object> result = new Result<>();
        try {
            mongoTemplate.insert(student);
            result.setSuccess(true);
            result.setCode("200");
            result.setMsg("成功");
        } catch (Exception e) {
            log.error(e.toString());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<Object> delete(String studentId) {
        Result<Object> result = new Result<>();
        try {
            Query query = Query.query(Criteria.where("_id").is(Integer.parseInt(studentId)));
            mongoTemplate.remove(query, collectionName);
            result.setSuccess(true);
            result.setCode("200");
            result.setMsg("成功");
        } catch (Exception e) {
            log.error(e.toString());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<Object> update(Student student) {
        Result<Object>result=new Result<>();
        try {
            Query query=Query.query(Criteria.where("_id").is(student.getId()));
            Update update=new Update();
            update.set("email",student.getEmail());
            update.set("gender",student.getGender());
            update.set("password",student.getPassword());
            update.set("status",student.getStatus());
            mongoTemplate.updateFirst(query,update,collectionName);
            result.setCode("200");
            result.setMsg("成功");
            result.setSuccess(true);
        } catch (Exception e) {
            log.error(e.toString());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<Object> query(String studentId) {
        Result<Object>result=new Result<>();
        try {
            Query query=Query.query(Criteria.where("_id").is(Integer.parseInt(studentId)));
            List<Student> studentList=mongoTemplate.find(query,Student.class);
            result.setSuccess(true);
            result.setCode("200");
            result.setMsg("成功");
            result.setData(studentList);
        } catch (Exception e){
            log.error(e.toString());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
}

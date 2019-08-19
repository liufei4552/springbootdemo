/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MongoDB
 Source Server Version : 40010
 Source Host           : 127.0.0.1:27017
 Source Schema         : runoob

 Target Server Type    : MongoDB
 Target Server Version : 40010
 File Encoding         : 65001

 Date: 19/08/2019 17:53:54
*/


// ----------------------------
// Collection structure for col
// ----------------------------
db.getCollection("col").drop();
db.createCollection("col");

// ----------------------------
// Documents of col
// ----------------------------
db.getCollection("col").insert([ {
    _id: ObjectId("5d564bc050f7885d9fec1564"),
    title: "MongoDB 教程",
    description: "MongoDB 是一个 Nosql 数据库",
    by: "菜鸟教程",
    url: "http://www.runoob.com",
    tags: [
        "mongodb",
        "database",
        "NoSQL"
    ],
    likes: 100
} ]);

// ----------------------------
// Collection structure for runoob
// ----------------------------
db.getCollection("runoob").drop();
db.createCollection("runoob");

// ----------------------------
// Collection structure for student
// ----------------------------
db.getCollection("student").drop();
db.createCollection("student");

// ----------------------------
// Documents of student
// ----------------------------
db.getCollection("student").insert([ {
    _id: NumberInt("3"),
    studentName: "刘飞2",
    password: "147258",
    birth: "1995-08-09",
    gender: "女",
    email: "2889064658@qq.com",
    status: "0",
    regTime: "string",
    _class: "com.java.bean.Student"
} ]);
db.getCollection("student").insert([ {
    _id: NumberInt("4"),
    studentName: "刘飞2",
    password: "123456",
    birth: "1995-08-09",
    gender: "男",
    email: "304265966@qq.com",
    status: "2",
    regTime: "string",
    _class: "com.java.bean.Student"
} ]);

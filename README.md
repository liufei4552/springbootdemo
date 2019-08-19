# springbootdemo
### 1、springbootdemo初成  
### 2、集成了SSM框架  
### 3、集成mybatis分页工具
### 4、集成logback日志,使用debug级别可以打印sql语句便于查询
### 5、集成swagger  访问地址为：http://localhost:8080/swagger-ui.html
### 6、集成druid并配置监控sql页面，在此特别注意一定要整合springboot和druid数据源配置否则查询不到  项目启动直接访问 http://localhost:8080/druid 账号密码都是admin
### 7、集成redis,且自定义一个注解只需要在service层的方法上加上此注解即可
### 8、集成MongoDB数据库，且做一个增删改查的demo。启动项目打开http://localhost:8080/swagger-ui.html可以直接操作，使用MongoDB时实体类id会自动加载一个_如果操作时还是按照不加_的id会操作无效。logback.xml中关闭打印MongoDB的debug日志否则会很影响性能，一定要注意
自己会持续更新。。。。。。。。。。

# 涉及工具
1. mysql
2. Spring Boot
3. thymeleaf
4. Swagger UI

    ~~访问 http://localhost:8080/swagger-ui.html~~  -- 已经废弃
    现在用的是 第三方 swagger-bootstrap-ui  
    访问地址 http://localhost:8080/doc.html
    
5. spring data jpa

6.半自动生成数据库文档 
    
    SQLReportTest.testGenerateMYSQLReport
        
7.console界面打印表格

    JUnitTest.DataTableSawTest.testTableSaw6
    
8.利用mockmvc测试controller
    
    JUnitTest/jpa/JpaCommonQueryTest.java.   whenQuerySuccess
9.Protocol Buffers

[参考教程](https://zhuanlan.zhihu.com/p/25174418)

10.aop 做controller拦截

见AopConfig.java,目前的效果是，打印获得请求参数，请求发送数据，返回数据等

11.scope测试

ScopeTest.java


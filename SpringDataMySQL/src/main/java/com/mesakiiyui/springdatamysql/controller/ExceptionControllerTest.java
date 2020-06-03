package com.mesakiiyui.springdatamysql.controller;

import com.mesakiiyui.springdatamysql.Utils.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ExceptionControllerTest {
    @RequestMapping("/helloException")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

}
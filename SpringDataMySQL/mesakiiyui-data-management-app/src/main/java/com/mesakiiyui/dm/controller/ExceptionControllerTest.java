package com.mesakiiyui.dm.controller;

import com.mesakiiyui.dm.common.utils.Exception.MyException;
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
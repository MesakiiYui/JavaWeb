<<<<<<< HEAD
package com.mesakiiyui.springdatamysql.controller;

import com.mesakiiyui.springdatamysql.Exception.MyException;
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
=======
package com.mesakiiyui.springdatamysql.controller;

import com.mesakiiyui.springdatamysql.Exception.MyException;
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
>>>>>>> 88753f20a8c6141a51d913abc17cf0994eb3a2b4

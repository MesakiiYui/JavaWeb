package com.mesakiiyui.springdatamysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ErrorController {
    @GetMapping(value="/error")
    public String getCityTable(){
        return "city-single-table";
    }
}

package com.mesakiiyui.springdatamysql.controller;

import com.mesakiiyui.springdatamysql.Entity.Student;
import com.mesakiiyui.springdatamysql.service.StudentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/Student")
public class StudentController {
    @Autowired
    StudentManageService studentManageService;

    // 全量查询
    @GetMapping(value="/data")
    public String getCityTable(Model model){
        Iterable<Student> studentList = studentManageService.findStudentNoCriteria(0,4);
        model.addAttribute("studentList", studentList);

        return "pages/tables/data";
    }

    @RequestMapping("/findStudentNoQuery")
    public String findStudentNoQuery(ModelMap modelMap, @RequestParam(value = "https://my.oschina.net/wangxincj/blog/page", defaultValue = "https://my.oschina.net/wangxincj/blog/0") Integer page,
                                     @RequestParam(value = "https://my.oschina.net/wangxincj/blog/size", defaultValue = "https://my.oschina.net/wangxincj/blog/5") Integer size){
        Page<Student> datas = studentManageService.findStudentNoCriteria(page, size);
        modelMap.addAttribute("datas", datas);
        return "index1";
    }

    @RequestMapping(value = "/findStudentQuery",method = {RequestMethod.GET,RequestMethod.POST})
    public String findStudentQuery(ModelMap modelMap, @RequestParam(value = "https://my.oschina.net/wangxincj/blog/page", defaultValue = "https://my.oschina.net/wangxincj/blog/0") Integer page,
                                @RequestParam(value = "https://my.oschina.net/wangxincj/blog/size", defaultValue = "https://my.oschina.net/wangxincj/blog/5") Integer size, Student student){
            Page<Student> datas = studentManageService.findStudentCriteria(page, size, student);
        modelMap.addAttribute("datas", datas);
        return "index2";
    }

}

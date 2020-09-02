package com.mesakiiyui.test.com.mesakiiyui.springdatamysql.JUnitTest.jpa;

import com.SpringdatamysqlApplication;
import com.alibaba.fastjson.JSON;
import com.mesakiiyui.springdatamysql.common.entity.Student;
import com.mesakiiyui.springdatamysql.common.repo.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: jintienan
 * @Date: 2020/8/19 14:09
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringdatamysqlApplication.class }) // 开启bean的初始化扫描
public class JpaNativeTest {

    @Autowired
    StudentRepository studentRepository;

    /**
     * insert
     * 新增一个数据
     */
    @Test
    public void testSaveStudent(){
        java.sql.Date sqlDate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String time =  format.format(new Date());
            Date date = format.parse(time.concat(" 00:00:00"));
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlDate = new java.sql.Date(new java.util.Date().getTime());
        Student student = new Student();
        student.setName("HeartMan");
        student.setAddress("USA");
        student.setBirth(sqlDate);
        student.setSex("1");
        student.setDepartment("doctor");
        studentRepository.save(student);
    }

    /**
     * delete
     * 删除一条数据
     * 物理删除
     */
    @Test
    public void testDeleteStudent(){
        Integer deleteId = 8;
        studentRepository.deleteById(deleteId);
        Optional<Student> student = studentRepository.findById(deleteId);
        System.out.println(student.isPresent()?JSON.toJSONString(student.get().getName()): "没有数据");
    }

    /**
     * count
     * 计数
     */
    @Test
    public void testCountStudent(){
        Long count = studentRepository.count();
        log.info("count:{}", count);
    }

    /**
     * exist
     * 校验是否存在
     */
    @Test
    public void testExist(){
        boolean exist = studentRepository.existsById(8);
        log.info("exist:{}", exist);
    }

    /**
     * findAll
     * 全量查询
     */
    @Test
    public void testQueryAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        log.info(JSON.toJSONString(studentList));
    }

    /**
     * 修改
     * native modify
     */
    @Test
    public void testModifyStudent(){
        int ans = studentRepository.modifyById("Sum", 9);
        log.info("ans: {}", ans);
    }

    /**
     * 自定义条件查询
     */
    @Test
    public void testFindByName(){
        List<Student> studentList = studentRepository.findByName("Sum");
        log.info(JSON.toJSONString(studentList));
    }


}

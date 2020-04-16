package com.mesakiiyui.springdatamysql.service;

import com.mesakiiyui.springdatamysql.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentManageService {
    Page<Student> findStudentById(Integer page, Integer size, Integer id);
    Page<Student> findStudentNoCriteria(Integer page, Integer size);
    Page<Student> findStudentCriteria(Integer page, Integer size, Student student);
}

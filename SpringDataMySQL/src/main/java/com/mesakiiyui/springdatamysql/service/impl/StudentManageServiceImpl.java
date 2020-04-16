package com.mesakiiyui.springdatamysql.service.impl;

import com.mesakiiyui.springdatamysql.Entity.Student;
import com.mesakiiyui.springdatamysql.Repo.StudentRepository;
import com.mesakiiyui.springdatamysql.service.StudentManageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
@Transactional
public class StudentManageServiceImpl implements StudentManageService {
    @Resource
    StudentRepository studentRepository;

    @Override
    public Page<Student> findStudentById(Integer page, Integer size, Integer id){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<Student> pageStudent = studentRepository.findStudentById(id ,pageable);
        return pageStudent;
    }

    @Override
    public Page<Student> findStudentNoCriteria(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<Student> pageStudent = studentRepository.findAll(pageable);
        return pageStudent;
    }

    @Override
    public Page<Student> findStudentCriteria(Integer page, Integer size, Student student){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<Student> studentPage = studentRepository.findAll(new Specification<Student>(){
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = criteriaBuilder.equal(root.get("name").as(String.class), student.getName());
                Predicate p2 = criteriaBuilder.equal(root.get("sex").as(String.class), student.getSex());
                Predicate p3 = criteriaBuilder.equal(root.get("birth").as(String.class), student.getBirth());
                query.where(criteriaBuilder.and(p1,p2,p3));
                return query.getRestriction();
            }
        },pageable);
        return studentPage;
    }
}

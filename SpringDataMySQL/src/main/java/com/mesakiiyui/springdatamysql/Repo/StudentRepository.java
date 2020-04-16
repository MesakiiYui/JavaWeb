package com.mesakiiyui.springdatamysql.Repo;

import com.mesakiiyui.springdatamysql.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> , JpaSpecificationExecutor<Student> {
    Page<Student> findStudentById(int id, Pageable pageable);

}

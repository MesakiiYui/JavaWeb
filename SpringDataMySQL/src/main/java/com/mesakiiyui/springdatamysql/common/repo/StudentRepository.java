package com.mesakiiyui.springdatamysql.common.repo;

import com.mesakiiyui.springdatamysql.common.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

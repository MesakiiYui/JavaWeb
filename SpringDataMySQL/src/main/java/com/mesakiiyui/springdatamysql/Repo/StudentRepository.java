package com.mesakiiyui.springdatamysql.Repo;

import com.mesakiiyui.springdatamysql.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

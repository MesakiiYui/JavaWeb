package com.mesakiiyui.dm.repo;

import com.mesakiiyui.dm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>{

    // 返回值为受影响的行数
    @Transactional(timeout = 10)
    @Modifying
    @Query("update Student set name = ?1 where id = ?2")
    int modifyById(String userName, Integer id);

    @Query("select u from Student u where u.name = ?1")
    List<Student> findByName(String name);
}

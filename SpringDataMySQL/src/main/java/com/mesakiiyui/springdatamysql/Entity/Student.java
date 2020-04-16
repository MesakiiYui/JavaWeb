package com.mesakiiyui.springdatamysql.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.Year;
@Entity
@Table(name="student")
public class Student {
//    实体类:注意注解的应用(重点),其中如果并不是表中的字段用 @Transient注解进行标识，否则会出现错误
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "department")
    private String department;

    @Column(name = "address")
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Student(String name, String sex, Date birth, String department, String address) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.department = department;
        this.address = address;
    }

    public Student() {
    }
}

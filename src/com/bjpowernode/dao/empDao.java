package com.bjpowernode.dao;

import com.bjpowernode.domain.Emp;
import com.bjpowernode.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * Author:学员--陈义华
 * 2019/10/18 0018:
 */
public interface empDao {
    List<Emp> empfind();

    List<Emp> getById(int i);

    List<Emp> getByEmp(Map<String, Object> map);

    List<Student> select01(Student s);

    List<Student> getByArray(String[] arr);
}

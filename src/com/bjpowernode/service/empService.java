package com.bjpowernode.service;

import com.bjpowernode.domain.Emp;

import java.util.List;
import java.util.Map;

/**
 * Author:学员--陈义华
 * 2019/10/18 0018:
 */
public interface empService {

    String empfind();


    List<Emp> getByDeptno(int i);

    List<Emp> getByEmp(Map<String, Object> map);
}

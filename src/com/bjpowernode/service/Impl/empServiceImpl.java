package com.bjpowernode.service.Impl;

import com.bjpowernode.Utils.SqlSessionUtil;
import com.bjpowernode.dao.empDao;
import com.bjpowernode.domain.Emp;
import com.bjpowernode.service.empService;

import java.util.List;
import java.util.Map;

/**
 * Author:学员--陈义华
 * 2019/10/18 0018:
 */
public class empServiceImpl implements empService {

    private empDao empDao = SqlSessionUtil.getsession().getMapper(empDao.class);

    private StringBuilder builder =new StringBuilder();

    @Override
    public String empfind() {
        //这里负责员工查询业务逻辑
        List<Emp> empList= empDao.empfind();

        builder.append("[");

        for (Emp emp : empList) {
            //{"empno":1111,"ename":"史密斯"},{"empno":2222,"ename":"张三"}

            builder.append("{\"empno\":"+emp.getEmpno()+",\"ename\":\""+emp.getEname()+"\"},");

        }

        String jsonStr=builder.substring(0,builder.length()-1)+"]";

      return jsonStr;
    }

    @Override
    public List<Emp> getByDeptno(int i) {

       List<Emp> list =empDao.getById(i);

        return list;
    }

    @Override
    public List<Emp> getByEmp(Map<String, Object> map) {

        List<Emp> list =empDao.getByEmp(map);

        return list;
    }
}

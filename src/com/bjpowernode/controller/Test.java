package com.bjpowernode.controller;

import com.bjpowernode.Utils.SqlSessionUtil;
import com.bjpowernode.Utils.transactionInvocationHandler;
import com.bjpowernode.dao.empDao;
import com.bjpowernode.domain.Emp;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.Impl.empServiceImpl;
import com.bjpowernode.service.empService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:学员--陈义华
 * 2019/10/18 0018:
 */
public class Test {
    public static void main(String[] args) {

        /*transactionInvocationHandler proxyobj=new transactionInvocationHandler(new empServiceImpl());
        empService proxy=(empService)proxyobj.proxy();*/


        /*List<Emp> empList= proxy.getByDeptno(20);

        for (Emp emp : empList) {
            System.out.println(emp);
        }*/


        /*Map<String,Object> map=new HashMap<>();

        map.put("deptno", 30);
        map.put("job", "SALESMAN");

        List<Emp> emos= proxy.getByEmp(map);
        for (Emp emo : emos) {
            System.out.println(emo);
        }
        */


        //17.测试：动态SQL where标签+if标签
        //需求：以姓名和为条件，进行模糊查询，得到学生信息列表
        /*Student s = new Student();
        s.setName("y");
        s.setAddress("a");*/

        empDao empDao =SqlSessionUtil.getsession().getMapper(empDao.class);
       /* Student s=new Student();
        s.setAddress("asd");
        s.setName("l");
        List<Student> slist = empDao.select01(s);
        for (Student student : slist) {
            System.out.println(student);
        }*/

        //18.测试：动态SQL foreach标签
        /*

            如果我们要在sql语句中使用foreach标签
            那么我们就可以为sql语句传递数组类型

         */

        String[] arr={"900","300","500"};

         List<Student> slist =empDao.getByArray(arr);
        for (Student student : slist) {
            System.out.println(student);
        }



    }
}

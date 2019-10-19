package com.bjpowernode.controller;

import com.bjpowernode.Utils.transactionInvocationHandler;
import com.bjpowernode.service.Impl.empServiceImpl;
import com.bjpowernode.service.empService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:学员--陈义华
 * 2019/10/18 0018:
 */
public class empController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //负责业务的调控

        //获取参数---当前没有参数

        //通过代理对象来调用service
        transactionInvocationHandler proxyobj=new transactionInvocationHandler(new empServiceImpl());
        empService proxy=(empService)proxyobj.proxy();
        String emps=proxy.empfind();

        //返回结果
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(emps);




    }
}

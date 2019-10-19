package com.bjpowernode.Utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:学员--陈义华
 * 2019/10/18 0018:
 */
public class transactionInvocationHandler implements InvocationHandler {


    //获取目标对象
    private Object target;

    public transactionInvocationHandler(Object target) {
        this.target = target;
    }



    //代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession session=null;
        Object obj=null;

        try {
            session=SqlSessionUtil.getsession();

            //目标方法
            obj=method.invoke(target, args);

            //提交事务

            session.commit();


        } catch (Exception e) {
            e.printStackTrace();
            if (session!=null){
                session.rollback();
            }
        } finally {
            SqlSessionUtil.close(session);
        }

        return obj;

    }


    //获取代理对象

    public Object proxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}

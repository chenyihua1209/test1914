package com.bjpowernode.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author:学员--陈义华
 * 2019/10/18 0018:
 */
public class SqlSessionUtil {

    //注册驱动
    private  static SqlSessionFactory sqlSessionFactory;

    static{

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

    }

    //将连接对象与线程池绑定
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();

    //获取连接对象
    public static SqlSession getsession(){

        SqlSession session = threadLocal.get();

        if (session==null){

            session=sqlSessionFactory.openSession();

            threadLocal.set(session);
        }

        return session;

    }

    //关闭

    public static void close(SqlSession session){
        if (session!=null){
            session.close();

            //同时移除线程池中的连接对象
            threadLocal.remove();
        }
    }

}

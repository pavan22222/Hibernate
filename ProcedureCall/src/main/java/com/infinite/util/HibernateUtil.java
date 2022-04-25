package com.infinite.util;

import com.infinite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileNotFoundException;

public class HibernateUtil {

    private static SessionFactory factory;
    private static Session session;

    static {
        Configuration cfg=new Configuration();
        //cfg.configure("com/infinite/cfgs/hibernate.cfg.xml");
         cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
        cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:orcl");
        cfg.setProperty("hibernate.connection.username","System");
        cfg.setProperty("hibernate.connection.password","Pavan");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");
        cfg.setProperty("hibernate.show_sql","true");
        cfg.setProperty("hibernate.format_sql","true");

       // cfg.addFile("src/main/java/com/infinite/entity/Student.hbm.xml");
        cfg.addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
    }


    public static  Session getSession(){
        if(session == null) {
            session = factory.openSession();
            return  session;
        }
        else
            return  session;
    }

    public static  void closeSession(Session ses){
        ses.close();
    }

    public static  void closeSessionFactory(){
        factory.close();
    }
}

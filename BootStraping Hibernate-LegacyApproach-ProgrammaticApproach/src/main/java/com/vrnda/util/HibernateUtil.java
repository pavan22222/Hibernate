package com.vrnda.util;
import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vrnda.entity.Employee;

public class HibernateUtil {
	
	private static SessionFactory factory;
	private static Session session;
	static {
		
		try {
			Configuration cfg=new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:orcl");
			cfg.setProperty("hibernate.connection.username", "System");
			cfg.setProperty("hibernate.connection.password", "Pavan");
			
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.setProperty("hibernate.format_sql", "true");
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
			//cfg.addFile("src/main/java/com/vrnda/entity/Product.hbm/xml");
			cfg.addAnnotatedClass(Employee.class);
			factory=cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		return factory != null ? factory.openSession():null;
	}
	
	public static  void closeSession(Session ses) {
		if(ses != null)
			ses.close();
	}
	
	public static void closeSessionFactory() {
		if(factory != null)
			factory.close();
	}

}

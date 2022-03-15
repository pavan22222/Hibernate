package com.vrnda.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vrnda.entity.Employee;

@Component
public class HibernateUtil {
	private static SessionFactory factory;
	private static Session session;
	public HibernateUtil() {
		System.out.println("HibernateUtil.HibernateUtil()");
		org.hibernate.cfg.Configuration cfg=new org.hibernate.cfg.Configuration();
		cfg.configure("com/vrnda/cfgs/hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		factory=cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		if(session == null)
			session=factory.openSession();
			//session=factory.getCurrentSession();
		return session;
	}
	
	public static void closeSession(Session ses) {
		System.out.println("HibernateUtil.closeSession()");
		if(ses != null)
			ses.close();
	}
	
	public static void closeSession() {
		System.out.println("HibernateUtil.closeSession()");
		if(session != null)
			session.close();
	}
	
	public static void closeSessionFactory() {
		System.out.println("HibernateUtil.closeSessionFactory()");
		if(factory != null)
			factory.close();
	}
	
	
}

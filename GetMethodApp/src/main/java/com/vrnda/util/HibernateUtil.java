package com.vrnda.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static Session session;

	static {
		System.out.println("HibernateUtil.HibernateUtil()");
		try {
			Configuration cfg = new Configuration();
			cfg.configure("com/vrnda/cfgs/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Session getSession() {
		if(session != null) {
			return session;
		}else {
			return factory.openSession();
		}
	}
	
	public static void  closeSession(Session ses) {
		System.out.println("HibernateUtil.closeSession()");
		if(ses != null) 
			ses.close();	
	}
	
	public static void  closeSessionFactory() {
		System.out.println("HibernateUtil.closeSessionFactory()");
		if(factory != null) 
			factory.close();	
	}

}

package com.vrnda.util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	private static Session session;
	static {
		
		try {
			Configuration cfg=new Configuration();
			cfg.configure("com/vrnda/cfgs/hibernate.cfg.xml");
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

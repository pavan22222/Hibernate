package com.vrnda.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vrnda.entity.Custmer;

public class HibernateUtil {
	private static SessionFactory factory;
	private static Session session;
	
	static {
		Configuration cfg=new Configuration();
		cfg.addAnnotatedClass(Custmer.class);
		cfg.configure("com/vrnda/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		if(session == null)
			return factory.openSession();
		else
			return session;
	}
	
	
}

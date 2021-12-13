package com.vrnda.util;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Logger logger=Logger.getLogger(HibernateUtil.class);
	private static SessionFactory factory;
	private static Session ses;
	
	static {
		SimpleLayout layout=new SimpleLayout();
		ConsoleAppender appender=new ConsoleAppender(layout);
		logger.addAppender(appender);
		logger.setLevel(Level.DEBUG);
		Configuration cfg=new Configuration();
		try {
			cfg.configure("com/vrnda/configs/hibernate.cfg.xml");
			logger.info("Configuration Object is Created");
			factory=cfg.buildSessionFactory();
			logger.info("Session Factory Object is Created");
		}catch (HibernateException e) {
			e.printStackTrace();
			logger.error(e);
		}catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e);
		}
		
	}
	
	public static Session getSession() {
		if(factory != null) 
			return factory.openSession();
		else 
			return null;
		
	}
	
	public static void closeSession(Session session) {
		if(session != null) 
			session.close();
		
		logger.debug("closeSession() is excuted");
		
	}
	
	public static void closeSessionFactory() {
		if(factory != null) 
			factory.close();
	}
}

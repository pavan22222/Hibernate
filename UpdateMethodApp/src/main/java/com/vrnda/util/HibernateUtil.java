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
	private static Session session;
	static {
		SimpleLayout layout=new SimpleLayout();
		ConsoleAppender appender=new ConsoleAppender(layout);
		logger.addAppender(appender);
		logger.setLevel(Level.DEBUG);
		logger.info("Logger obj is created");
		try {
			Configuration cfg=new Configuration();
			cfg.configure("com/vrnda/cfgs/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
		} catch (HibernateException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.fatal(e);
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

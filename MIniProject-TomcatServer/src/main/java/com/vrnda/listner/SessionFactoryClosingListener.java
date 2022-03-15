package com.vrnda.listner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.vrnda.util.HibernateUtil;

@WebListener
public class SessionFactoryClosingListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("SessionFactoryClosingListener.contextDestroyed()");
		HibernateUtil.closeSessionFactory();
	}
}

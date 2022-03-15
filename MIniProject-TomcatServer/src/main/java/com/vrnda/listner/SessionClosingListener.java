package com.vrnda.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.vrnda.util.HibernateUtil;

@WebListener
public class SessionClosingListener implements ServletRequestListener {
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("SessionClosingListener.requestDestroyed()");
		HibernateUtil.closeSession();
	}
}

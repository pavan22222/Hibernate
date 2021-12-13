package com.vrnda.test;

import java.util.Date;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class SaveMethodTest {
	private static Logger logger=Logger.getLogger(SaveMethodTest.class);
	static {
		
		  SimpleLayout layout=new SimpleLayout(); 
		  ConsoleAppender appender=new ConsoleAppender(layout);
		  logger.addAppender(appender);
		  logger.setLevel(Level.DEBUG);
		 
		
	}
	
	public static void main(String[] args) {
		//Employee emp=new Employee(105, "Pavan", 20, 60000.0f, null);
		
		  Employee emp=new Employee(); 
		  emp.setName("Pavan J");
		  emp.setDoj(new Date("2020/12/12"));
		  logger.warn("Deprecated Class java.util.Date is used");
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=true;
		try {
			 tx=ses.beginTransaction();
			 ses.persist(emp);
			// int retVal=(int) ses.save(emp);
			//System.out.println("Returned Value is::"+retVal);
		}catch (Exception e) {
			logger.fatal(e);
			flag=false;
		}finally {
			if(flag) 
				tx.commit();
			else
				tx.rollback();
			if(ses != null) {
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();	
			}
		}
		
		
	}

}

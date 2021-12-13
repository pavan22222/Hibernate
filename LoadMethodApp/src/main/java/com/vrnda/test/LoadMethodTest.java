package com.vrnda.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class LoadMethodTest {
	public static void main(String[] args) {
		System.out.println("GetMethodTest.main()");
		Employee emp=null;
		Transaction tx=null;
		Session ses=null;
		ses=HibernateUtil.getSession();
		try {
			emp=ses.load(Employee.class, 72);
			System.out.println(emp.getClass().getName());
			System.out.println(emp.getName());
			System.out.println(emp.getClass().getName());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(ses!= null) {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}

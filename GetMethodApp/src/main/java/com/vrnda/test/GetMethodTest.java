package com.vrnda.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class GetMethodTest {
	public static void main(String[] args) {
		System.out.println("GetMethodTest.main()");
		Employee emp=null;
		Transaction tx=null;
		Session ses=null;
		ses=HibernateUtil.getSession();
		emp=ses.get(Employee.class, 70);
		System.out.println(emp);
		if(ses!= null) {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}

package com.vrnda.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class DBToEntityObjSyncTest {

	public static void main(String[] args) {
		Employee emp=null;
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			emp=ses.get(Employee.class, 1);
			System.out.println(emp);
			Thread.sleep(15000);
			ses.refresh(emp);
			System.out.println(emp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ses != null) {
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}
		}
		
	}
}

package com.vrnda.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class UpdateMethodApprocahTest3 {

	public static void main(String[] args) {
		Employee emp=null;
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			emp=ses.get(Employee.class, 1);
			if(emp != null) {
				System.out.println(emp);
				tx=ses.beginTransaction();
				emp.setName("Pavan J");
				flag=true;
			} else {
				System.out.println("Record Not Found");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				if(tx != null)
					tx.commit();
				System.out.println("Record Updated");
			}
			else {
				if(tx != null)
					tx.rollback();
				System.out.println("Record Not Updated");
			}
			if(ses != null) {
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}
		}
		
	}
}

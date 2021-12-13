package com.vrnda.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class UpdateMethodApprocahTest1 {

	public static void main(String[] args) {
		Employee emp=new Employee(11222,"Pavan",23,60000.0f,new Date("2021/01/10"));
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=true;
		try {
			tx=ses.beginTransaction();
			ses.update(emp);
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		} finally {
			if(flag) {
				tx.commit();
				System.out.println("Record Found and Updated");
			}
			else {
				tx.rollback();
				System.out.println("Record Not Found");
			}
			if(ses != null) {
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}
		}
		
	}
}

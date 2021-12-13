package com.vrnda.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class DeleteMethodTest2 {

	public static void main(String[] args) {
		Employee emp = null;
		Transaction tx = null;
		Boolean flag = false;
		Session ses = null;
		ses = HibernateUtil.getSession();
		try {
			tx = ses.beginTransaction();
			emp = ses.get(Employee.class, 720);
			if(emp != null) {
				ses.delete(emp);
				flag = true;
			} else {
				System.out.println("Employee Not Found");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
			} else {
				tx.rollback();
			}
			if (ses != null) {
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}

		}

	}

}

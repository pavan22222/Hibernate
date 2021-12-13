package com.vrnda.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class DeleteMethodTest1 {

	public static void main(String[] args) {
		Employee emp = new Employee(720, null, null, null, null);
		Transaction tx = null;
		Boolean flag = false;
		Session ses = null;
		ses = HibernateUtil.getSession();
		try {
			tx = ses.beginTransaction();
			ses.delete(emp);
			flag = true;
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

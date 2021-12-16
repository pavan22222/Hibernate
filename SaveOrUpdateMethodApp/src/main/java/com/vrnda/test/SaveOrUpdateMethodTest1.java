package com.vrnda.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class SaveOrUpdateMethodTest1 {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setName("Pavan Janapati");
		emp.setAge(23);
		emp.setSalary(20000f);
		emp.setDoj(new Date("2020/12/12"));
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			ses.saveOrUpdate(emp);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				System.out.println("Record Saved Or Updated");
				tx.commit();
			}else {
				System.out.println("Record Not Saved Or Updated");
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}

package com.vrnda.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class MergeMethodTest {

	public static void main(String[] args) {
		Employee emp1=null;
		Employee emp2=new Employee(10,"Naveen",23,23000f,new Date("2020/10/10"));
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			emp1=ses.get(Employee.class, 10);
			System.out.println(emp1);
			//ses.saveOrUpdate(emp2);
			//ses.save(emp2);
			//ses.update(emp2);
			//ses.delete(emp2);
			Employee emp3=(Employee)ses.merge(emp2);
			System.out.println(emp3);
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

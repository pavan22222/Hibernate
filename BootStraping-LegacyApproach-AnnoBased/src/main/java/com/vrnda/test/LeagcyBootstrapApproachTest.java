package com.vrnda.test;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

public class LeagcyBootstrapApproachTest {
	public static void main(String[] args) {
		Employee emp=new Employee("Pavan",23,23000.0d,LocalDateTime.now());
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=true;
		Integer id=null;
		emp.setId(33);
		try {
			tx=session.beginTransaction();
			//id=(Integer)session.save(emp);
			emp=session.get(Employee.class, 35);
			session.evict(emp);
			session.clear();
			emp=session.get(Employee.class, 35);
			//emp.setName("Pavan Janapati");
			//session.update(emp);
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Record Saved With the Product id::"+id);
				tx.commit();
			} else {
				System.out.println("Record Not Saved");
				tx.rollback();
			}
		}
		
	}
}

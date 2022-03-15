package com.vrnda.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee emp=null;
		Session ses=HibernateUtil.getSession();
		Session ses1=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			emp=ses.get(Employee.class,id);
			System.out.println(ses.hashCode()+"......"+ses1.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//tx.commit();
		return emp;
	}

}

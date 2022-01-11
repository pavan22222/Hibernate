package com.vrnda.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;


public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Override
	public Employee getEmployeeById(Integer id) {
//		Employee emp=null;
//		Session ses=HibernateUtil.getSession();
//		Transaction tx=null;
//		try {
//			tx=ses.beginTransaction();
//			emp=ses.load(Employee.class,id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return emp;
		
		Session ses=HibernateUtil.getSession();
		Query<Employee> query=ses.createQuery("FROM com.vrnda.entity.Employee where id=:id");
		query.setParameter("id", id);
//		Employee emp=query.uniqueResult();
		Optional<Employee> optional=query.uniqueResultOptional();
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new IllegalArgumentException("Invalid Id");
		}
	}

	@Override
	public List<Employee> retrieveAllEmployees() {
		Session ses=HibernateUtil.getSession();
		Query query=ses.createQuery("FROM com.vrnda.entity.Employee");
		List<Employee> list=query.list();
		return list;
	}

	@Override
	public Integer saveEmployee(Employee emp) {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		tx=ses.beginTransaction();
		Integer retVal=(Integer) ses.save(emp);
		tx.commit();
		return  retVal;
	}

	@Override
	public List<Employee>  retrieveAllEmployeesByDesignations(String desg1,String desg2){
		Session session=HibernateUtil.getSession();
		Query<Employee> query=session.createQuery("SELECT id,name,designation,version FROM com.vrnda.entity.Employee where designation=?1 and designation=?2");
		query.setString(1, desg1);
		query.setString(2,desg2);
		return  (List<Employee>)query.list();
	}

	@Override
	public Iterator<Employee> retrieveAllEmployeesByDesignationsAsIterable(String desg1, String desg2) {
		Session ses=HibernateUtil.getSession();
		//Query<Employee> query=ses.createQuery("SELECT emp.id,emp.name,emp.version,emp.lastUpdationDate FROM com.vrnda.entity.Employee emp where designation IN(:desg1,:desg2)");
		Query<Employee> query=ses.createQuery("SELECT emp FROM com.vrnda.entity.Employee emp where designation IN(:desg1,?1)");
//		query.setString("desg1", desg1);
//		query.setString("desg2", desg2);
		query.setParameter("desg1", desg1);
		query.setParameter(1, desg2);
		return query.iterate();
	}

	@Override
	public List<Object[]> retrieveMultipleSpecificCols() {
		Session ses=HibernateUtil.getSession();
		Query query=ses.createQuery("select id,name,version FROM com.vrnda.entity.Employee where name='Srikanth'");
		return query.getResultList();
	}

	@Override
	public List<String> retrieveSpecificCol() {
		Session ses=HibernateUtil.getSession();
		Query query=ses.createQuery("SELECT name FROM com.vrnda.entity.Employee");
		return query.list();
	}

	@Override
	public Integer updateEmployeesDesignation() {
		Session ses=HibernateUtil.getSession();
		Query query=ses.createQuery("update com.vrnda.entity.Employee set designation='Developer' where designation is null");
		Integer count=null;
		Transaction tx=null;
		Boolean flag=false;
		try {
			tx=ses.beginTransaction();
			count = query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSessionFactory();
		}
		
		return count;
	}

	@Override
	public Integer insertEmployees(List<Employee> employees) {
		Session ses=HibernateUtil.getSession();
		Query query=ses.createQuery("INSERT INTO com.vrnda.entity.Employee(id,name,age,salary) SELECT id,name,age,salary FROM com.vrnda.entity.Employee where id=:id");
		Integer count=null;
		Transaction tx=null;
		Boolean flag=false;
		try {
			tx=ses.beginTransaction();
			query.setParameter("id", 35);
			count = query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSessionFactory();
		}
		
		return count;
	}

}

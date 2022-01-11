package com.vrnda.repository;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.vrnda.entity.Employee;
import com.vrnda.util.HibernateUtil;


public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Override
	public List<Object[]> retrieveAllEmployeesWithoutMapping() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			ses.beginTransaction();
		SQLQuery sqlQuery=ses.createSQLQuery("SELECT * FROM EMPLOYEE");
		List<Object[]> list=sqlQuery.list();
		return list;
	}

	@Override
	public List<Employee> retrieveAllEmployeesWithMapping() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			ses.beginTransaction();
		NativeQuery<Employee> sqlQuery=ses.createSQLQuery("SELECT * FROM EMPLOYEE");
		sqlQuery.addEntity(Employee.class);
		List<Employee> list=sqlQuery.getResultList();
		return list;
	}

	@Override
	public Integer updateEmployeeSalary(Integer id, Float salary) {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		Integer retVal=null;
		boolean flag=false;
		NativeQuery query=ses.createSQLQuery("UPDATE EMPLOYEE SET SALARY=:SALARY WHERE ID=:ID");
		query.setParameter("ID", id);
		query.setParameter("SALARY", salary);
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			else {
				tx=ses.getTransaction();
			}
			retVal=query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
		}
		return retVal;
	}

	@Override
	public Integer insertEmployee(Employee emp) {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		Integer retVal=null;
		boolean flag=false;
		//NativeQuery query=ses.createSQLQuery("UPDATE EMPLOYEE SET SALARY=:SALARY WHERE ID=:ID");
		NativeQuery query=ses.getNamedNativeQuery("INSERT_EMPLOYEE");
		query.addScalar("ID", StandardBasicTypes.INTEGER);
		query.addScalar("NAME", StandardBasicTypes.STRING);
		query.addScalar("AGE", StandardBasicTypes.INTEGER);
		query.addScalar("SALARY", StandardBasicTypes.FLOAT);
//		query.addScalar("VERSION", StandardBasicTypes.INTEGER);
//		query.addScalar("DESIGNATION", StandardBasicTypes.STRING);
//		query.addScalar("DOJ", StandardBasicTypes.TIMESTAMP);
//		query.addScalar("CREATIONDATE", StandardBasicTypes.TIMESTAMP);
//		query.addScalar("LASTUPDATIONDATE", StandardBasicTypes.TIMESTAMP);
		query.setParameter(1, emp.getName());
		query.setParameter(2, emp.getAge());
		query.setParameter(3, emp.getSalary());
//		query.setParameter(4, emp.getVersion());
//		query.setParameter(5, emp.getDesignation());
//		query.setParameter(6, emp.getCreationDate());
//		query.setParameter(7, emp.getLastUpdationDate());
//		query.setParameter(8, emp.getDoj());
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			else {
				tx=ses.getTransaction();
			}
			retVal=query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
		}
		return retVal;
	}

	@Override
	public Integer deleteEmployee(Long id) {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		Integer retVal=null;
		boolean flag=false;
		NativeQuery query=ses.getNamedNativeQuery("DELETE_EMPLOYEE");
		query.setParameter("ID", id);
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			else {
				tx=ses.getTransaction();
			}
			retVal=query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
		}
		return retVal;
	}

	@Override
	public Integer checkCredentials(String username, String password) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		ProcedureCall call=ses.createStoredProcedureCall("AUTHENTICATE");
		call.registerParameter(1,String.class,ParameterMode.IN).bindValue(username);;
		call.registerParameter(2, String.class,ParameterMode.IN).bindValue(password);
		call.registerParameter(3,Integer.class,ParameterMode.OUT);
		Integer result=(Integer) call.getOutputParameterValue(3);
		return result;
	}

	
}

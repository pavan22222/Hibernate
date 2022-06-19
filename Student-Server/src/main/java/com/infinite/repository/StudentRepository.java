package com.infinite.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.infinite.beans.Department;
import com.infinite.beans.Student;

@Repository
public class StudentRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private final String STUDENT_BY_ID="* FROM com.infinite.beans.Student where id=:id";
	
	private Student getStudentById(Integer id) {
		Query query= entityManager.createQuery(STUDENT_BY_ID, Student.class);
		query.setParameter("id", id);
		List<Student> students=query.getResultList();
		if(students !=null && students.size()>0) 
			return students.get(0);
		else
			return null;
	}
	
	public List<Student> getAllStudents(Integer startIndex,Integer lastIndx){
		Query query=entityManager.createQuery("from com.infinite.beans.Student", Student.class);
		query.setFirstResult(startIndex);
		query.setMaxResults(lastIndx);
		List<Student> list= query.getResultList();
		return list;
	}
	
	public String saveDepartment(Department dept) {
		Department d=entityManager.merge(dept);
		return d!=null?d.getDeptId():null;	
	}
	
	
}

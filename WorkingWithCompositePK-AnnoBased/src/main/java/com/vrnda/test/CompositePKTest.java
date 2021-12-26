package com.vrnda.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.ProgProjIDDetails;
import com.vrnda.entity.Programmer;
import com.vrnda.util.HibernateUtil;

public class CompositePKTest {
	public static void main(String[] args) {
		ProgProjIDDetails id=new ProgProjIDDetails(2, 103);
		Programmer programmer=new Programmer(id, "Srikanth", "Syscon", 23000.0,LocalDate.now(),LocalDateTime.now(),LocalTime.now());
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=true;
		ProgProjIDDetails retVal=null;
		try {
			tx=session.beginTransaction();
			retVal=(ProgProjIDDetails) session.save(programmer);		
			//Programmer prog=session.get(Programmer.class, id);
			System.out.println(retVal);
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

package com.vrnda.test;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Product;
import com.vrnda.util.HibernateUtil;

public class GeneratorsTest {
	public static void main(String[] args) {
		Product product1=new Product("Colgate Paste",30.0,LocalDateTime.now(),LocalDateTime.of(2022, 8, 12, 0, 0, 0));
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=true;
		Integer id=null;
		try {
			tx=session.beginTransaction();
			id=(Integer) session.save(product1);		
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

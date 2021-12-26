package com.vrnda.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vrnda.entity.Product;
import com.vrnda.util.HibernateUtil;

public class VersionTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=true;
		Integer id=null;
		try {
			tx=session.beginTransaction();
			Product product=session.get(Product.class, 31);
			product.setPname("Close UP Paste");
			session.update(product);
			System.out.println(session.get(Product.class, 31));
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

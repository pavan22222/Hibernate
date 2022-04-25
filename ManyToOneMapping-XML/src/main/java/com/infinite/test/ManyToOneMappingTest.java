package com.infinite.test;


import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infinite.entity.Pant;
import com.infinite.entity.Shirt;
import com.infinite.util.HibernateUtil;

public class ManyToOneMappingTest {
	
	private static Transaction tx;
	private static Session session=HibernateUtil.getSession();
	
	public static void main(String[] args) {
		//saveShirt();
		//retriveShirt();
		deletShirt();
	}
	
	public static void saveShirt() {
		Pant pant=new Pant(null,"Polo","Black");
		Shirt shirt=new Shirt(null,null,"Highlander","Blue",pant);		
		tx=session.beginTransaction();
		//session.save(pant);
		session.save(shirt);
		tx.commit();
		
	}
	
	public static void retriveShirt() {
		Query query=session.createQuery("select s from Shirt s ");
		List<Shirt> list=query.getResultList();
		list.forEach(System.out::println);
	}
	
	public static void deletShirt() {
		tx=session.beginTransaction();
		Shirt s=session.get(Shirt.class, new BigDecimal(4));
		session.delete(s);
		tx.commit();
	}
	
	
}

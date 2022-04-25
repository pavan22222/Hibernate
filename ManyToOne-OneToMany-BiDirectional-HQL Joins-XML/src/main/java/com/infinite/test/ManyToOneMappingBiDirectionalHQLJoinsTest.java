package com.infinite.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infinite.entity.Pant;
import com.infinite.util.HibernateUtil;

public class ManyToOneMappingBiDirectionalHQLJoinsTest {

	private static Transaction tx;
	private static Session session = HibernateUtil.getSession();

	public static void main(String[] args) {
		//loadChildToParentUsingHQLJoins();
		//loadParentToChildUsingHQLJoins();
		loadPatenrandChilds();
	}

	public static void loadChildToParentUsingHQLJoins() {
		Query query = session.createQuery("select s.shirtId,p.pantId from Shirt s inner join s.pant p");
		List<Object[]> list = query.getResultList();
		for (Object[] array : list) {
			for (Object obj : array) {
				System.out.println(obj);
			}
		}
	}

	public static void loadParentToChildUsingHQLJoins() {
		//Query query=session.createQuery("select s.shirtId,p.pantId from Pant p inner join p.shirts s");
		//Query query=session.createQuery("select s.shirtId,p.pantId from Pant p left join p.shirts s");
		//Query query=session.createQuery("select s.shirtId,p.pantId from Pant p right join p.shirts s");
		Query query = session.createQuery("select s.shirtId,p.pantId from Pant p full join p.shirts s");
		List<Object[]> list = query.getResultList();
		for (Object[] array : list) {
			for (Object obj : array) {
				System.out.println(obj);
			}
		}
	}

	public static void loadPatenrandChilds() {
		Query query = session.createQuery("select p from Pant p");
		List<Pant> list = query.getResultList();
		System.out.println(list);
	}

}

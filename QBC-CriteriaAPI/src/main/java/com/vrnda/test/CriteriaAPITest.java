package com.vrnda.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.vrnda.entity.Custmer;
import com.vrnda.util.HibernateUtil;

public class CriteriaAPITest {
	
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		else
			tx=ses.getTransaction();
		
		Criteria criteria=ses.createCriteria(Custmer.class);
//		Criterion c1=Restrictions.ge("cid", 0);
//		Criterion c2=Restrictions.le("cid", 10);
//		Order order=Order.desc("cid");
//		criteria.addOrder(order);
//		criteria.add(c1);
//		criteria.add(c2);
//		Projection proj1=Projections.property("cname");
//		Projection proj2=Projections.property("price");
//		criteria.setProjection(proj1);
//		criteria.setProjection(proj2);
		criteria.setFirstResult(1);
		criteria.setMaxResults(2);
		List<Object> list=criteria.list();
		list.forEach(System.out::println);
	}
}

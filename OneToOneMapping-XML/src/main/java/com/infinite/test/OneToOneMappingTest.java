package com.infinite.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infinite.entity.Apartment;
import com.infinite.entity.Flat;
import com.infinite.util.HibernateUtil;

public class OneToOneMappingTest {
	
	private static Session ses=HibernateUtil.getSession();
	
	public static void main(String[] args) throws IOException {
		//selectOperation();
		addChild();
		//addParent();
		//deleteParent();
		//deleteAllChilds();
		//deleteOneChild();	
		
	}
	
	public static void selectOperation() {
		Query query=ses.createQuery(" from com.infinite.entity.Apartment where apartmentId=:apartmentId");
		query.setParameter("apartmentId", 69l);
		Transaction tx=ses.beginTransaction();
		List<Apartment> apartments=query.getResultList();
		apartments.forEach(aprt->{
			Map<String,Flat> flats=aprt.getFlats();
			//flats.add(new Flat(null, null,null, "2-132", 32000d));
		});
		tx.commit();
	}
	
	public static void addChild() {
		Query query=ses.createQuery(" from com.infinite.entity.Apartment where apartmentId=:apartmentId");
		query.setParameter("apartmentId", 82l);
		Transaction tx=ses.beginTransaction();
		List<Apartment> apartments=query.getResultList();
		if(apartments != null && apartments.size()>0) {
			System.out.println(apartments);
			apartments.forEach(apartment->{
				Map<String,Flat> flats=apartment.getFlats();
				flats.put("phone1",new Flat(null,null,null,"3-123",12000d));
				
			});
		}
		tx.commit();
	}
	
	public static void addParent() {

		Transaction tx = null;
		Flat flat = null;
		Apartment apartment = null;
		boolean flag = true;

		try {
			flat = new Flat(null,null, null, "1-123", 20000d);
			apartment = new Apartment(null, "XYZ", "Hyd", new Date("2016/12/12"), Map.of("phone1",flat));
			tx = ses.beginTransaction();
			ses.save(apartment);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Record Saved");
			} else {
				tx.rollback();
				System.out.println("Record Not Saved");
			}
		}
		 
	}
	
	public static void deleteParent() {
		Query query=ses.createQuery("from com.infinite.entity.Apartment where apartmentId=:apartmentId");
		query.setParameter("apartmentId", 69l);
		Transaction tx=ses.beginTransaction();
		List<Apartment> apartments=query.getResultList();
		System.out.println(apartments);
		if(apartments != null && apartments.size()>0) {			
			apartments.forEach(apartment->{
				if(apartment.getApartmentId() == 69l) {
					ses.delete(apartment);
				}
				
			});
		}
		tx.commit();
	}
	
	public static void deleteAllChilds() {
		Query query=ses.createQuery(" from com.infinite.entity.Apartment where apartmentId=:apartmentId");
		query.setParameter("apartmentId", 84l);
		Transaction tx=ses.beginTransaction();
		List<Apartment> apartments=query.getResultList();
		if(apartments != null && apartments.size()>0) {
			System.out.println(apartments);
			apartments.forEach(apartment->{
				Map<String,Flat> flats=apartment.getFlats();
				//flats.removeAll(flats);
			});
		}
		tx.commit();
	}
	
	public static void deleteOneChild() {
		Query query=ses.createQuery(" from com.infinite.entity.Apartment where apartmentId=:apartmentId");
		query.setParameter("apartmentId", 82l);
		Transaction tx=ses.beginTransaction();
		List<Apartment> apartments=query.getResultList();
		if(apartments != null && apartments.size()>0) {
			Flat child=ses.get(Flat.class, 86);
			apartments.forEach(apartment->{
				Map<String,Flat> childs=apartment.getFlats();
				childs.remove(child);
			});
		}
		tx.commit();
	}

}

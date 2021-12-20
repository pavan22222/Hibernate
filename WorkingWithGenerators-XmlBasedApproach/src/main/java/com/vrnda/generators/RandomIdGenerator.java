package com.vrnda.generators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIdGenerator implements IdentifierGenerator{
	private static Integer id=103;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {			
		System.out.println(object.getClass().getName());
		return id++;
	}

}

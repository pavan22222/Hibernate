package com.infinite.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AddressGenerator implements IdentifierGenerator{
	
	private final String  PREFIX="stux-dd-34cd-cdx";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {		
		return PREFIX+""+new Random().nextLong();
	}

}

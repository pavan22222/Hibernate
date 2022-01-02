package com.vrnda.connectionprovider;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

/**
 we can create and develop custom connection provider class by extending from UserSuppliedConnectionProviderImpl class also 
 *
 * @author Pavan
 *
 */
public class ApacheDBCP2ConnectionProvider implements ConnectionProvider{
	private BasicDataSource bds;
	public ApacheDBCP2ConnectionProvider() {
		System.out.println("ApacheDBCP2ConnectionProvider Constructor");
		bds=new BasicDataSource();
		bds.setUsername("System");
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		bds.setPassword("Pavan");
		bds.setMinIdle(30000);
		bds.setMaxTotal(20);
	}
	
	@Override
	public Connection getConnection() throws SQLException{
		System.out.println("ApacheDBCP2ConnectionProvider.getConnection()");
		return bds.getConnection();
		
	}
	
	@Override
	public void closeConnection(Connection con) throws SQLException{
		System.out.println("ApacheDBCP2ConnectionProvider.closeConnection()");
		con.close();
	}

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}
}

package com.ranjan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.ranjan.bo.CustomerBO;

public final class CustomerDAOImpl implements ICustomerDAO {
	
	private static final String CUSTOMER_INSERT_QUERY="INSERT INTO REALTIMEDI_CUSTOMER VALUES(CUST_NO_SEQ.NEXTVAL,?,?,?,?)";
	private DataSource ds;
	
	public CustomerDAOImpl(DataSource ds) {
		System.out.println("CustomerDAOImpl : 1 Param Constructor");
		this.ds = ds;
	}

	@Override
	public int insert(CustomerBO custBO) throws Exception {
		System.out.println("CustomerDAOImpl.insert()");
		int count = 0;
		//get Pooled JDBC Connection
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(CUSTOMER_INSERT_QUERY); //PASSING QUERY
				){
			if(ps!=null) {
				ps.setString(1, custBO.getCname());
				ps.setString(2, custBO.getCadd());
				ps.setDouble(3, custBO.getPamt());
				ps.setDouble(4, custBO.getIntramt());
				//execute query
				count = ps.executeUpdate();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return count;
	}

}

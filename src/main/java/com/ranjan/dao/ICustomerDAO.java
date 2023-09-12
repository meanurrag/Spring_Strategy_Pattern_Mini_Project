package com.ranjan.dao;

import com.ranjan.bo.CustomerBO;

public interface ICustomerDAO {

	public int insert(CustomerBO custBO) throws Exception;
}

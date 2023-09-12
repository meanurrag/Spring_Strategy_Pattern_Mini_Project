package com.ranjan.service;

import com.ranjan.dto.CustomerDTO;

public interface ICustomerMgmtService {
	
	public String registerCustomer(CustomerDTO dto)throws Exception;
}

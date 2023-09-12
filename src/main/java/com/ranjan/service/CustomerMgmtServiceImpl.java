package com.ranjan.service;

import com.ranjan.bo.CustomerBO;
import com.ranjan.dao.ICustomerDAO;
import com.ranjan.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	private ICustomerDAO dao;

	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl 1 param const");
		this.dao = dao;
	}

	@Override
	public String registerCustomer(CustomerDTO dto) throws Exception {

		System.out.println("CustomerMgmtServiceImpl.registerCustomer()");
		//In service class we write business Logic 
		double intramt = ((dto.getPamt()*dto.getRate()*dto.getTime())/100.0);
		//and create and initialize bo class object
		CustomerBO custBO = new CustomerBO();
		custBO.setCname(dto.getCname());
		custBO.setCadd(dto.getCadd());
		custBO.setPamt(dto.getPamt());
		custBO.setIntramt(intramt);
		//pass BO object to DAO
		int count = dao.insert(custBO);
		//Process result and revert back to cust with feedback
		return count==0?"Registration Failed":"Registration Succeded : Int Amt is : "+intramt;
	}
}

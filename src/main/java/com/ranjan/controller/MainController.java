package com.ranjan.controller;

import com.ranjan.dto.CustomerDTO;
import com.ranjan.service.ICustomerMgmtService;
import com.ranjan.vo.CustomerVO;

public final class MainController {

	private ICustomerMgmtService service;

	public MainController(ICustomerMgmtService service) {
		System.out.println("MainController : 1 Param Constructor");
		this.service = service;
	}
	public String processCustomer(CustomerVO vo) throws Exception{
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setPamt(Double.parseDouble(vo.getPamt()));
		dto.setRate(Double.parseDouble(vo.getRate()));
		dto.setTime(Double.parseDouble(vo.getTime()));
		//give dto to service class and recieve the msg 
		String resultMsg = service.registerCustomer(dto);
		return resultMsg;
	}
}

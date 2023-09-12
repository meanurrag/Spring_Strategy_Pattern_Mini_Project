package com.ranjan.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.ranjan.controller.MainController;
import com.ranjan.vo.CustomerVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name =null, add = null, pamt = null, rate = null, time = null;
		if(sc!=null) {
			System.out.println("Enter Customer name : ");
			name=sc.next();
			System.out.println("Enter Customer address : ");
			add=sc.next();
			System.out.println("Enter principle amount : ");
			pamt=sc.next();
			System.out.println("Enter rate of interest : ");
			rate=sc.next();
			System.out.println("Enter time in months : ");
			time=sc.next();
			
		}
		//Create VO object to pass.
		CustomerVO vo = new CustomerVO();
		vo.setCname(name); vo.setCadd(add); vo.setPamt(pamt);
		vo.setRate(rate); vo.setTime(time);
		//create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/ranjan/cfgs/applicationContext.xml");
		//get controller class object
		MainController controller = factory.getBean("controller",MainController.class);
		try {
			String resultMsg = controller.processCustomer(vo);
			System.out.println(resultMsg);
		}catch(Exception e) {
			System.out.println("Problem in registration : "+e.getMessage());
			e.printStackTrace();
		}
	}
}

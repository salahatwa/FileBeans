package com.salahatwa.main;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.salahatwa.beans.Person;
import com.salahatwa.filesBean.XLSBean;

public class App {
	public static void main(String[] args) {
		
//		LOGGER.info("start descripe");
//		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Person person=(Person)context.getBean("person");

		
		System.out.println(person.getAge());
		
//		XLSBean readXLSX = new XLSBean();
//
//		List<Person> list =  readXLSX.readFile("D://Test.xlsx",X);
//
//		System.out.println(list.size());
//		for (Person xLSBean : list) {
//			System.out.println(
//					xLSBean.getName() + "\t" + xLSBean.getAge());
//		}
		
//		System.out.println(rec(0));
		
	}
	

	public static int rec(int num)
	{
		if(num==100)
			return 100;
		else 
		{
			System.out.println(num);
			num++;
			return rec(num);
		}
		
	}
}

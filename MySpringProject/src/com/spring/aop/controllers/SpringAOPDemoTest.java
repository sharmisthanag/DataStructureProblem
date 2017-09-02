package com.spring.aop.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;
import com.spring.aop.services.ShapeService;
import com.spring.aop.services.ShapeServiceImpl;

public class SpringAOPDemoTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("application-config_foraop.xml");
		System.out.println("-------------------");
/*		ShapeService shapeServiceImpl = (ShapeService)ctx.getBean("shapeServiceImpl",ShapeService.class);
		System.out.println(shapeServiceImpl.shape(ctx.getBean("triangle")));
		Triangle t = ctx.getBean("triangle",Triangle.class);
		System.out.println(t.getName());
		Circle c = ctx.getBean("circle",Circle.class);
		System.out.println(c.getName());
		System.out.println("-------------------");

		Triangle t1 = ctx.getBean("triangle",Triangle.class);
		t1.setName("sharmistha");
		System.out.println(t1.getName());
		Circle c1 = ctx.getBean("circle",Circle.class);
		c1.setName("ritam");
		System.out.println(c1.getName());
		
		System.out.println("-------------------");
		
		Triangle t11 = ctx.getBean("triangle",Triangle.class);
		t11.setName("sharmistha1");
		System.out.println(t11.getName());
		Circle c11 = ctx.getBean("circle",Circle.class);
		c11.setName("ritam1");
		System.out.println(c11.getName());
		
		System.out.println("-------------------");
		Triangle t111 = ctx.getBean("triangle",Triangle.class);
			t111.adviceMethod(10);
		try{
			t111.adviceMethodThrowsException(10);
		}
		catch(Exception e){
			System.err.println("catched for adviceMethodThrowsException ");
		}
		
		//Exception catched in Advice methods using around
		t111.adviceMethodThrowsException1(200);
		*/
		ShapeService shapeServiceImpl = (ShapeService)ctx.getBean("shapeServiceImpl",ShapeService.class);
		shapeServiceImpl.shapeLoggingCustomAspect(ctx.getBean("triangle",Triangle.class));
		
		
		

		
	}

}

package com.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP
{
    @SuppressWarnings("resource")
    public static void main(String[] args) {
 
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorldCRUD manager = context.getBean(HelloWorldCRUD.class);
 
        manager.getAllHelloWorld();
        manager.createHelloWorld(new HelloWorld());
    }
}

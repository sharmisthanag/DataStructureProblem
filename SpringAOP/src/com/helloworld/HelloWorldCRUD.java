package com.helloworld;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldCRUD {
	public HelloWorld getHelloWorldByCount(Integer count) {
        System.out.println("Method getHelloWorldByCount() called");
        return new HelloWorld();
    }
 
    public List<HelloWorld> getAllHelloWorld() {
        System.out.println("Method getAllHelloWorld() called");
        return new ArrayList<HelloWorld>();
    }
 
    public void createHelloWorld(HelloWorld helloWorld) {
        System.out.println("Method createHelloWorld() called");
    }
 
    public void deleteHelloWorld(Integer count) {
        System.out.println("Method deleteHelloWorld() called");
    }
 
    public void updateHelloWorld(HelloWorld helloWorld) {
        System.out.println("Method updateHelloWorld() called");
    }

}

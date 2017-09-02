package com.springcore.circulardependency;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {
 /*
    private CircularDependencyB circB;
 
    @Autowired
    public CircularDependencyA(CircularDependencyB circB) {
    	System.out.println("In A const");
        this.circB = circB;
    }
    
    @Autowired
    public void setCircB(CircularDependencyB circB) {
    	System.out.println("in A setter");
        this.circB = circB;
    }
 
    public CircularDependencyB getCircB() {
        return circB;
    }*/
	
	//For@PostConstruct 
	public CircularDependencyA(){
		System.out.println("in Aconst");
	}
	private CircularDependencyB circB;
    
    private String message = "Hi!";
 
    public void setCircB(CircularDependencyB circB) {
        this.circB = circB;
    }
     
    public String getMessage() {
        return message;
    }
    @PostConstruct
    public void init(){
    	System.out.println("in int of A post construct ");
    }
    public void customInit(){
    	System.out.println("in customInit of A");
    }

	public void setMessage(String message) {
		this.message = message;
	}
}

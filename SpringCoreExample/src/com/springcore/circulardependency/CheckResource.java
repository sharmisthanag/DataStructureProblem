package com.springcore.circulardependency;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
@Resource(name="checkResourceInResource")

public class CheckResource {
	public String g="Hello";
	public CheckResource(){
		System.out.println("in const of CheckResource");
	}

}

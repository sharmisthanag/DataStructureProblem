package com.springcore.ResourceAndAutowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springcore.circulardependency.CheckResource;
import com.springcore.circulardependency.CircularDependencyA;

/*
Autowiring (link from Dunes comment) happens after the construction of an object. Therefore they will not be set until after the constructor has completed.

If you need to run some initialization code, you should be able to pull the code in the constructor into a method, and annotate that method with @PostConstruct
@Autowired and @Inject

    Matches by Type
    Restricts by Qualifiers
    Matches by Name

@Resource

    Matches by Name
    Matches by Type
    Restricts by Qualifiers (ignored if match is found by name)

 */
@Component
public class ResourceCheck {
	@Resource
	CheckResource checkResourceInResource;
	@Autowired 
	CheckResource autowired;
	@Inject
	CheckResource inject;
	
	public ResourceCheck(){
		System.out.println("in const of ResourceCheck");
	}
	/*//@Autowired(required=true)
	@Resource
	private CheckResource abc;
	
	public ResourceCheck(){
		System.out.println("in const of ResourceCheck=>"+abc.g);
	}*/
	 @PostConstruct
	 public void checkResourceCheck(){
		 System.out.println("in post construct of ResourceCheck :autowired=>"+autowired);
		 System.out.println("in post construct of ResourceCheck :Resource =>"+checkResourceInResource);
		 System.out.println("in post construct of ResourceCheck :Inject :=>"+inject);
	 }

}

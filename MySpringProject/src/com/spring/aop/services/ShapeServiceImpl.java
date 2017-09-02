package com.spring.aop.services;

import com.spring.aop.aspects.CustomLogging;
import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

public class ShapeServiceImpl implements ShapeService{
	public ShapeServiceImpl(){
		System.out.println("set ShapeServiceImpl");
	}
	
	private Triangle triangle;
	private Circle circle;
	public Triangle getTriangle() {
		System.out.println("get t");

		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		System.out.println("set t");
		this.triangle = triangle;
	}
	public Circle getCircle() {
		System.out.println("get c");

		return circle;
	}
	public void setCircle(Circle circle) {
		System.out.println("set c");

		this.circle = circle;
	}

	@Override
	public String shape(Object obj) {
		if(obj instanceof Triangle){
			return triangle.getName();
		}
		else if(obj instanceof Circle){
			return circle.getName();
		}
		return null;
	}
	@CustomLogging
	public String shapeLoggingCustomAspect(Object obj) {
		if(obj instanceof Triangle){
			return triangle.getName();
		}
		else if(obj instanceof Circle){
			return circle.getName();
		}
		return null;
	}
	
}

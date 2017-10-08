package com.interfaceprb;

public class ClassImplementsSameVariableNameInterface 
implements InterfaceWithSameVariableName,InterfaceWithSameVariableName1{
	static int i=30;
	public static void main(String[] args) {
		System.out.println(i);

	}

}

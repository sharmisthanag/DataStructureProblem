package com.java8.test.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*public class ExceptionHierarchy {
public static void main(String args[]) {
FileInputStream fis = null;
try {
fis = new FileInputStream("file.txt");
fis.close();
}
catch (IOException e) {
System.out.println("IOException");
}
catch (NullPointerException e) {
System.out.println("file not found");
}
}
}*/

import java.io.*;
public class ExceptionHierarchy {
	static FileInputStream players, coach;
	public static void main(String args[]) {
		try {
			players = new FileInputStream("players.txt");
			System.out.println("players.txt found");
			try {
				coach.close();
			} catch (IOException e) {
				System.out.println("coach.txt not found");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("players.txt not found");
		} catch (NullPointerException ne) {
			System.out.println("NullPointerException");
		}
	}
}
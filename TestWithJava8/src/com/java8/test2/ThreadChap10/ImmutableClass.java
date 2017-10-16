package com.java8.test2.ThreadChap10;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*
 *     Declare the class as final so it can’t be extended.
    Make all fields private so that direct access is not allowed.
    Don’t provide setter methods for variables
    Make all mutable fields final so that it’s value can be assigned only once.
    Initialize all the fields via a constructor performing deep copy.
    Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 */
public class ImmutableClass {

	public static void main(String[] args) {
		Date d=new BirthDate(new Date()).getBirthDate();
		System.out.println(d);
		d=new Date();
	}

}

final class BirthDate {
	private final Date birth;
	public BirthDate(Date dob) {
		birth = dob;
	}
	public Date getBirthDate() {
		//return (Date)birth.clone();
		Date d=(Date) this.birth.clone();
		System.out.println(d);
		d=new Date();
		/*Map m=new HashMap();
		new HashMap(m);*/
		return this.birth;
	}
	public boolean isOlder(Date other) {
		// calculate 'other' with 'birth'
		// return true is 'birth' < 'other'
		return true;
	}
}
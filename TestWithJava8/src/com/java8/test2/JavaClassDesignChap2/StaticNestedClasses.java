package com.java8.test2.JavaClassDesignChap2;

import com.java8.test2.JavaClassDesignChap2.DBConnection.DBConnectionCache;
import com.java8.test2.JavaClassDesignChap2.Outer.StaticNested;

/*
 * A static nested class isn’t usually referred to as an inner class,
because it isn’t associated with an object of the outer class.

When static nested
class is instantiated
within its outer class,
it doesn’t need to be
prefixed with its
outer class name
(though it can).

When static nested class is instantiated outside its outer
class, it must be prefixed with its outer class name
 */
public class StaticNestedClasses {

	public static void main(String[] args) {
		DBConnection vv=new DBConnection("","","");
		DBConnection defaultOraclezConn = DBConnection.DBConnectionCache.getDefaultOracleConnection();
		DBConnection defaultMySQLzConn = DBConnection.DBConnectionCache.getDefaultMySQLConnection();
		DBConnectionCache nn=new DBConnectionCache();//
		

		StaticNested nested1 = new StaticNested();
		Outer.StaticNested nested2 = new Outer.StaticNested();
		nested1.innerStatic = 99;
		nested1.innerInstance = 999;
		System.out.println(nested1.innerStatic + ":" +
				nested1.innerInstance);
		System.out.println(nested2.innerStatic + ":" +
				nested2.innerInstance);
	

	}

}
class Outer {
	static int outerStatic = 10;
	int outerInstance = 20;
	static class StaticNested {
		static int innerStatic = 10;
		int innerInstance = 20;
	}
	
}
class DBConnection {
	public DBConnection (String username, String pwd, String URL) {
		// code to establish a Database connection
	}
	public DBConnection OracleConnection
	(String username, String pwd, String URL) {
		DBConnection conn = DBConnectionCache.getDefaultOracleConnection();
		if (conn != null) {
			return conn;
		}
		else {
			//establish and return new DBconnection using method parameters
		}
		return conn;
	}
	/*
	 * Oversimplified version of a static nested class which uses default
	 * values to establish DB connections and store them in a static array
	 */
	static class DBConnectionCache {
		static DBConnection connections[];
		static {
			connections = new DBConnection[3];
			connections[0] = new DBConnection
					("","","");
			connections[1] = new DBConnection
					("","","");
		}
		static DBConnection getDefaultOracleConnection() {
			return connections[0];
		}
		static DBConnection getDefaultMySQLConnection() {
			return connections[1];
		}
	}
}
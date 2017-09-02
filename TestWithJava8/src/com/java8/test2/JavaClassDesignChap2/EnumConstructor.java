package com.java8.test2.JavaClassDesignChap2;

/*An enum can’t define a constructor with public or protected
access level.
*/
public enum EnumConstructor {
	VANILLA("white"),
	STRAWBERRY("pink"),
	WALNUT("brown") {
		public String toString() {
			return "WALNUT is Brown in color";
		}
		public String flavor() {
			return "great!";
		}
	},
	CHOCOLATE("dark brown");
	private String color;
	EnumConstructor(String color) {
		this.color = color;
	}
	public String toString() {
		return "MyColor:" + color;
	}
}



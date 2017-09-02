import com.google.gson.Gson;


public class TestGson {
int i;
int j;
TestGson(int i,int j){
	this.i=i;
	this.j=j;
}

	public static void main(String[] args) {
		int i=10;
		TestGson testGson=new TestGson(10,20);
		Object o=new Gson().toJson(testGson);
		System.out.println(o.toString());
		
		System.out.println(new Gson().toJson(new StatusResponse(0,"OK","Sucessfully added","")).toString());
		try {
			throwexception();
		} catch (MyAppException e) {
			System.out.println(createrGson(e));
		}		
		
	}
	public static void throwexception() throws MyAppException{
		throw new MyAppException("hello");
	}
	public  static String createrGson(Object o){
		return new Gson().toJson(o).toString();
		
	}

}

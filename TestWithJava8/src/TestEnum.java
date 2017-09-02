import java.util.HashMap;
import java.util.List;


public class TestEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String role="ADMIN";
		System.out.println(RoleFeautureCode.valueOf(role.toUpperCase()));
		List<Integer> l=null;
		HashMap m=new HashMap();
		m.put("hello", l);
		if(m.get("hello")!=null){
		for(Integer i:l){
			System.out.println(i);
		}
		}
		

	}

}

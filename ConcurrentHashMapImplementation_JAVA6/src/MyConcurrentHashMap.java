import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMap {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> cm=new ConcurrentHashMap<String, String>();
		cm.put("hh","dd");
		cm.put("hh", "changeddd");
		cm.replace("hh", "replaceddd");
		
		System.out.println(cm);

	}

}

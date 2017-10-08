import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortHashMapValuesusingJava8 {

	public static void main(String[] args) {
		Map hm=new HashMap();
		hm.put("a", 1);
		hm.put("c", 10);
		hm.put("b", 2);
		hm.put("d", 6);
		System.out.println(hm);
		
		/*Map<String,Integer> hmm=new TreeMap<String,Integer>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		hmm.putAll(hm);
		System.out.println(hmm);*/
	}

}

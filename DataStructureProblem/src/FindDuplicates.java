import java.util.HashMap;
import java.util.Map;

public class FindDuplicates {

	public static void main(String[] args) {
		String s="aabbhhttggfdgggkkkaa";
		findDuplicates(s,1);

	}

	private static void findDuplicates(String s) {
		Map<Character,Integer> m=new HashMap<>();
		
		char[] c=s.toCharArray();
		for(Character ch:c){
			if(m.containsKey(ch)){
				m.put(ch, m.get(ch)+1);
			}
			else{
				m.put(ch, 1);
			}
		}
		m.forEach((k,v)->{
			if(v>1){System.out.println(k+","+v);
				}});
			
	}
	private static void findDuplicates(String ss,int h) {
		Map<Character,Integer> m=new HashMap<>();
		char[] cc=ss.toCharArray();
		
		for(Character c: cc){
			if(m.containsKey(c)){
				m.put(c, m.get(c)+1);
			}
			else{
				m.put(c, 1);
			}
		}
		m.forEach((k,v)->{
			if(v>1){
				System.out.println(k);
			}
		});
		
	}
	
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiddleElementOfLinkedList {

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);
		
		System.out.println(findMiddleElement(l));
		String[] s=new String[]{};
		///s[0]="aa";
		s.clone();
	}

	private static Integer findMiddleElement(List<Integer> l) {
		/*l.forEach(new Consumer<Integer>(){

			@Override
			public void accept(Integer t) {
				System.out.println("t=>"+t);
				
			}
			
		});*/
		Integer midElement = null;
		int midElementposition=0;
		int length=0;
		
		Iterator<Integer> i=l.iterator();
		while(i.hasNext()){
			System.out.println("length="+length+"/midElementposition="+midElementposition);
			if(length%2!=0){
				midElement=l.get(midElementposition++);
				System.out.println("midelement=>"+midElement);
			}
			else if(length==0){
				midElement=l.get(midElementposition++);
			}
			i.next();
			length++;

		}
		
		return midElement;
	}

}

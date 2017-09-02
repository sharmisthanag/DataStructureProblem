

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FailFastDemo {

	public static void main(String[] args) {
		List l =new ArrayList();
		l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);
		//Collections.synchronizedList(l);
		Iterator i=l.iterator();
		while(i.hasNext()){
			
			int j=(int) i.next();
			System.out.println(j);
			
			i.remove();
			
		}
		System.out.println(l);
		
		/*Iterator i=l.iterator();
		while(i.hasNext()){
			int j=(int) i.next();
			System.out.println(j);
			l.remove(2);
			
		}
		System.out.println(l);
		*/
		
	}

}

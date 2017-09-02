

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeDemo {

	public static void main(String[] args) {
		List<Integer> l=new CopyOnWriteArrayList<>();
		Set s=new HashSet();
		
		
	//	ArrayList
	//	LinkedList
		l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);
		int pos=l.size()-1;
		
		Iterator<Integer> i=l.iterator();
		while(i.hasNext()){
			System.out.println("removing"+l.remove(pos--));
			i.next();
			//i.remove();
		}
		
				
		System.out.println(l);
		
		    int i1 = 0;
		    System.out.println(i1++);
		

	}

}

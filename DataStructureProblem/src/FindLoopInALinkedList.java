import java.util.List;

public class FindLoopInALinkedList {

	public static void main(String[] args) {

		LinkedList l=new LinkedList();
		l.add(10);l.add(20);l.add(30);l.add(56);l.add(49);l.add(78);
		
		//l.add(10);l.add(20);l.add(30);
		//System.out.println(l.findLoopInALinkedList(l));
		l.findmiddlePosition();
	

	}	
}
class Node{
	int value;
	Node next=null;
	 
	Node(int i){
		this.value=i;
	}
}

class LinkedList{
	Node tail;
	Node head;
	
	public void add(int i){
		Node n=new Node(i);
		if(head==null){
			head=n;
			tail=n;
		}
		else{
			tail.next=n;
			tail=n;
		}
		//tail.next=head;
	}

	/*public char findLoopInALinkedList(LinkedList l) {
		Node start=head;Node last=head;
		while(start!=null && last!=null && last.next!=null){
			start=start.next;last=last.next.next;
			if(start==last){
				return 'Y';
			}
			
		}
		
		
		return 'N';
	}*/
	public char findLoopInALinkedList(LinkedList l) {
		Node first=head;Node last=head;
		while(first!=null && last!=null && last.next!=null){
			last = last.next;
			if(first == last){
				return 'Y';
			}
			first=first.next;
		}
		return 'N';
		
	}
	public int findmiddlePosition(){
		Node first=head;Node middle=head;
		while(first!=null && first.next!=null ){
			first = first.next.next;
			if(first!=null){
				middle=middle.next;
			}
		}
		System.out.println(middle.value);
		return middle.value;
		
	}
	
	
}
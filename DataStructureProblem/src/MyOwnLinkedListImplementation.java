
public class MyOwnLinkedListImplementation {

	public static void main(String[] args) {
		MyOwnLinkedList l=new MyOwnLinkedList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		System.out.println(l);
		System.out.println(l.findMiddleElementOfTheLinkedList());
		System.out.println(l.find3rdFromLast());
		

	}

}
class MyOwnLinkedList{
	Node head;
	Node tail;
	public MyOwnLinkedList(){
		
		
	}

	
	public int find3rdFromLast() {
		Node first=head.next!=null ? head.next.next:null;
		Node back=head;
		while(first.next != null){
			first=first.next;
			back=back.next;
		}
		return back.data;
	}


	public int findMiddleElementOfTheLinkedList() {
		Node first=head;
		Node last=head;
		int length=0;
		while(last!=null){
			length++;
			last=last.next;
			if(length%2==0){
				first=first.next;
			}			
		}
		return first.data;
	}


	public void add(int i) {
		if(head ==null){
			head=new Node(i,null);
			tail=head;
		}
		else{
			Node n= new Node(i,null);
			tail.next=n;
			tail=n;
		}
		
	}
	public String toString(){
		StringBuilder s=new StringBuilder();
		Node h=head;
		
		while(h!=null){
			s.append(h.data+",");
			h=h.next;
		}
		
		return s.toString();
		
	}


	class Node{
		int data;
		Node next;
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}
}

import java.util.PriorityQueue;

public class Queuee {

	public static void main(String[] args) {
		PriorityQueue<String> pQueue =
				new PriorityQueue<String>();

		// Adding items to the pQueue
		pQueue.add("d");
		pQueue.add("r");
		pQueue.add("a");
		pQueue.add("c");

		// Printing the most priority element
		System.out.println(pQueue);
		System.out.println("Head value using peek function:"
				+ pQueue.peek());

	}

}

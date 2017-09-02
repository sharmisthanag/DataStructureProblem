import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadExecutor {

	public static void main(String[] args) {
		Executor e=Executors.newFixedThreadPool(2);
		e.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 1");
				
			}
		});
e.execute(new Runnable() {
	
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread 2");
		
	}
});
e.execute(new Runnable() {
	
	@Override
	public void run() {
		System.out.println("Thread 3");
		
	}
});
e.execute(new Runnable() {
	
	@Override
	public void run() {
		System.out.println("Thread 4");
		
	}
});

	}

}

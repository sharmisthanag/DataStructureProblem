import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong extends Thread {

	public static void main(String[] args){
		Lock lock=new ReentrantLock();
		AtomicBoolean ai=new AtomicBoolean(true);
		Thread th=new Thread(new Ping(lock,ai),"PING");
		Thread th1=new Thread(new Pong(lock,ai),"PONG");
		th1.start();th.start();
	}

}
class Ping implements Runnable{
	Lock lock;
	AtomicBoolean ai;
	public Ping(Lock lock,AtomicBoolean ai){
		this.lock = lock;
		this.ai = ai;
	}
	@Override
	public void run() {
		while(true){
			lock.lock();
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ai.get() == true){
				System.out.println("Ping by =>"+Thread.currentThread().getName());ai.set(false);
			}
			lock.unlock();
			
		}

	}

}
class Pong implements Runnable{
	Lock lock;
	AtomicBoolean ai;
	public Pong(Lock lock,AtomicBoolean ai){
		this.lock = lock;
		this.ai = ai;
	}
	@Override
	public void run() {
		while(true){
			lock.lock();
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ai.get() == false){
				System.out.println("Pong by =>"+Thread.currentThread().getName());ai.set(true);
			}
			lock.unlock();
		}

	}

}
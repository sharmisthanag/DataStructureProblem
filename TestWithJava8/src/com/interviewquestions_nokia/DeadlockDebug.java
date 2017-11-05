package com.interviewquestions_nokia;

public class DeadlockDebug {

	public static void main(String[] args) throws InterruptedException {
		Object a=new Object();
		Object b=new Object();
		Object c=new Object();
		DeadLockClass th=new DeadLockClass(a,b);
		DeadLockClass th1=new DeadLockClass(b,c);
		DeadLockClass th2=new DeadLockClass(c,a);
		th.start();th1.start();th2.start();
		
		//th.wait();
	}

}
class DeadLockClass extends Thread {
	private Object obj1;
    private Object obj2;
	public DeadLockClass(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }
	@Override
	public void run(){
		try {
			method(this.obj1,this.obj2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void method(Object obj1,Object obj2) throws InterruptedException{
		System.out.println("1 waiting to aquire lock of ob1");
		synchronized (obj1) {
			System.out.println("2 lock acquired for obj1");
			Thread.sleep(1000);
			System.out.println("3 waiting to aquire lock of ob2");
			synchronized (obj2) {
				System.out.println("4 lock acquired for obj2");
				Thread.sleep(1000);
			}
			System.out.println("5 released lock obj2");
		}
		System.out.println("5 released lock obj1");
	}
}
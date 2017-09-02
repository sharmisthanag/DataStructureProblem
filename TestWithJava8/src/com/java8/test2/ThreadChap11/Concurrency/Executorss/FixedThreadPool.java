package com.java8.test2.ThreadChap11.Concurrency.Executorss;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
 * 
 * difference between scheduleAtFixedRate and scheduleWithFixedDelay
 * Try adding a Thread.sleep(1000); call within your run() method... Basically it's the difference between scheduling something based on when the previous execution ends and when it (logically) starts.

For example, suppose I schedule an alarm to go off with a fixed rate of once an hour, and every time it goes off, I have a cup of coffee, which takes 10 minutes. Suppose that starts at midnight, I'd have:

00:00: Start making coffee
00:10: Finish making coffee
01:00: Start making coffee
01:10: Finish making coffee
02:00: Start making coffee
02:10: Finish making coffee
If I schedule with a fixed delay of one hour, I'd have:

00:00: Start making coffee
00:10: Finish making coffee
01:10: Start making coffee
01:20: Finish making coffee
02:20: Start making coffee
02:30: Finish making coffee
 */
public class FixedThreadPool {
	static ScheduledExecutorService e1=Executors.newScheduledThreadPool(3);
	protected static int count;
	public static void main(String[] args) throws InterruptedException {
		/*OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
		    method.setAccessible(true);
		    if (method.getName().startsWith("get") 
		        && Modifier.isPublic(method.getModifiers())) {
		            Object value;
		        try {
		            value = method.invoke(operatingSystemMXBean);
		        } catch (Exception e) {
		            value = e;
		        } // try
		        System.out.println(method.getName() + " = " + value);
		    } // if
		  } // for
*/		  
		ExecutorService e=Executors.newFixedThreadPool(3);
		ExecutorService ee=Executors.newCachedThreadPool();
		List<Callable<Void>> tasks=new ArrayList<>();
		tasks.add(new SendMail());
		tasks.add(new SendMail());
		tasks.add(new SendMail());
		tasks.add(new SendMail());
		e.invokeAll(tasks);
		e.shutdown();
		ee.invokeAll(tasks);
		ee.shutdown();

		//
		

		/*List<Callable<Void>> tasks1=new ArrayList<>();
		tasks1.add(new SendMail());
		tasks1.add(new SendMail());
		tasks1.add(new SendMail());
		tasks1.add(new SendMail());*/
	//	e1.schedule(new SendMail(), 1, TimeUnit.SECONDS);
	//	e1.shutdown();
		//e1.scheduleAtFixedRate(new SendMail_Run(), 0, 1, TimeUnit.SECONDS);//overlapping
		e1.scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {

				if(count>10)
					e1.shutdown();
				System.out.println("Send mail to run :"+Thread.currentThread().getName()+":"+new Date());
				count++;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}}, 1, 1, TimeUnit.SECONDS);//non overlaping
	}
	
	


}
class SendMail implements Callable<Void>{

	@Override
	public Void call() throws Exception {
		System.out.println("Send mail to :"+Thread.currentThread().getName());
		return null;
	}

}

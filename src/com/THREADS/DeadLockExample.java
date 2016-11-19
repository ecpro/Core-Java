package com.THREADS;

public class DeadLockExample {

	public static void main(String[] args) throws InterruptedException {
		
		MyClass x = new MyClass();
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				x.a();
			}
		};
		
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				x.b();
			}
		};
		
		Thread t1 = new Thread(task1);
		t1.start();
		
		Thread t2 = new Thread(task2);
		t2.start();
		
		t1.join();
		t2.join();
	}

}

class MyClass{
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void a() {
		synchronized (lock1) {
			System.out.println("inside the function a : now going to access method b");
			b();
		}
	}
	
	public void b() {
		
		synchronized(lock2) {
			System.out.println("inside the function b: now going to access method a");
			a();
		}
	}
}

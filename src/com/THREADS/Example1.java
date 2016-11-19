package com.THREADS;

public class Example1 {

	public static void main(String[] args) throws InterruptedException {
		LongWrapper a = new LongWrapper(0);
		
		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++) {
					a.incrementX();
				}
			}
		};
		
		Thread t [] = new Thread [1000];
		for(int i = 0; i < 1000; i++) {
			t[i] = new Thread(task1);
			t[i].start();
		}
		
		for(int i = 0; i< 1000; i++) {
			t[i].join();
		}
		
		System.out.println("the value of long wrapper is " + a.getX());
	}

}

class LongWrapper {
	private long x;
	
	LongWrapper(long x) {
		this.x = x;
	}
	
	public long getX() {
		return x;
	}
	
	public synchronized void  incrementX() {
		++x;
	}
}

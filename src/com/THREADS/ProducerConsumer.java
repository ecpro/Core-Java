package com.THREADS;

public class ProducerConsumer {

	private static int SIZE = 100;
	private static int [] BUFFER = new int [SIZE];
	private static int COUNT = 0;
	private static Object lock = new Object();

	static class Consumer {
		public void consume() throws InterruptedException {
			synchronized (lock) {
				while (isEmpty()) {
					lock.wait();
				}
				BUFFER[--COUNT] = 0;
				System.out.println("DATA CONSUMED FROM BUFFER : " + COUNT);
				Thread.sleep(100);
				lock.notifyAll();
			}
		}
		
		public boolean isEmpty() {
			return COUNT == 0;
		}
		
	}
	
	static class Producer {
		public void produce() throws InterruptedException {
			synchronized (lock) {
				while (isFull()) {
					lock.wait();
				}
				BUFFER[COUNT++] = 1;
				System.out.println("DATA ADD TO BUFFER" + COUNT);
				Thread.sleep(100);
				lock.notifyAll();
			}
		}
		
		public boolean isFull() {
			return COUNT == BUFFER.length;
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		
		
		
		Producer p = new Producer();
		Consumer c = new Consumer();
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 110; i++) {
					try {
						c.consume();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 110; i++) {
					try {
						p.produce();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("the # of items in buffer : " + COUNT);
		
	}

}

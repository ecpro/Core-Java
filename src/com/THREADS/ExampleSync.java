package com.THREADS;

public class ExampleSync {
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public synchronized void increment() {
		count++;
	}
	
	public void addThead() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++) {
					//count++;
					increment();
				}
				
				Thread t2 = new Thread(new Runnable() {

					@Override
					public void run() {
						for(int i = 0; i < 1000; i++) {
							//count++;
							System.out.println("inside t2");
							increment();
						}
					}

			});
				
			t2.setPriority(3);
			t2.start();
			try {
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				}
		
					
		});
		
		t1.setPriority(8);
		t1.start();
		t1.join();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExampleSync es = new ExampleSync();
		es.addThead();
		System.out.println(es.getCount());
		
	}

}

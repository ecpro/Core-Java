
public class MyThread extends Thread {
	
	
	public void printX() {
		System.out.println("this is a teset");
	}
	
	
	@Override
	public void run() {
		printX();
	}
	
	public static void main(String[] args) {
		
		Thread t = new MyThread();
		((MyThread) t).run();
		t.start();
	}
}

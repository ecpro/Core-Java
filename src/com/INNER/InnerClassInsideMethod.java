package com.INNER;

public class InnerClassInsideMethod {
	
	
	public Destination getDestination(String s) {
		
		class PDestination implements Destination {
			String x;
			
			private PDestination(String x) {
				this.x = x;
			}
			
			@Override
			public void readLabel() {
				System.out.println("printed readLabel()" + x);
			}
		}
		
		return new PDestination(s);
	}

	public static void main(String[] args) {
		new InnerClassInsideMethod().getDestination("here you go").readLabel();;
	}

}

interface Destination {
	void readLabel();

}
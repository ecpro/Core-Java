package com.THREADS;

import java.io.IOException;

public class ResponsiveUI extends Thread {

	public static volatile double i = 1;
	public ResponsiveUI() {
		this.setDaemon(true);
		start();
	}
	
	@Override
	public void run() {
		while(true) {
			i = (Math.PI + Math.E) / i;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		new ResponsiveUI();
		System.in.read();
		System.out.println(i);
	}

}

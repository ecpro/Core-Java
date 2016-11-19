package com.THREADS;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ExecutorExample implements Callable<String> {
	
	private int id;
	
	public ExecutorExample(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		ArrayList<Future<String>> results = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			results.add(executorService.submit(new ExecutorExample(i)));
		}
		
		for(Future<String> f : results) {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String call() throws Exception {
		return "result of this Taskwithresult" + this.id;
	}

}

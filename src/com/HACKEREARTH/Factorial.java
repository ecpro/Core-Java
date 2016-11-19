package com.HACKEREARTH;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] x = new int [n+1];
		x[0] = 1;
		x[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			x[i] = i * x[i-1]; 
		}
		
		System.out.println(x[n]);
		
		

	}

}

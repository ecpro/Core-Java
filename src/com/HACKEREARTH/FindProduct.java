package com.HACKEREARTH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindProduct {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000000 + 7;
		String [] input = br.readLine().split(" ");
		long out = 1;
		for(int i = 0; i < N; i++) {
			out = (out * Integer.parseInt(input[i])) % mod;
		}
		
		System.out.println(out);
	}

}
